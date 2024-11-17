package goosegame;

import java.util.*;

import goosegame.boards.Board;
import goosegame.cells.*;
/**
 * class for Game
 */
public class Game {

    /** Winning cell index for this game */
    private static final int WINNINGINDEX = 63;

    /** All the players of this Game */
    protected List<Player> thePlayers;

    /** The Board of this game */
    protected Board board;

    /**
     * Build a new game with a given board, number of players
     * @param board the board of this game
     * @param nbPlayers number of players
     */
    public Game(Board board,int nbPlayers) {
        this.board = board;
        this.thePlayers = new ArrayList<Player>(nbPlayers);
        for(int i = 0; i < nbPlayers; i++) {
            this.addPlayer(new Player("Joueur " + i));
        }
    }

    /**
     * Build a new game with given board, number of players, list of player's names 
     * @param board the board of this game
     * @param nbPlayers number of players
     * @param playersNames the names of the players
     */
    public Game(Board board,int nbPlayers,List<String> playersNames) {
        this.board = board;
        this.thePlayers = new ArrayList<Player>(nbPlayers);
        for(int i = 0; i < nbPlayers; i++) {
            this.addPlayer(new Player(playersNames.get(i)));
        }
    }

    /**
     * Get all the players of this game 
     * @return the players of this game
     */
    public List<Player> getThePlayers() {
        return this.thePlayers;
    }

    /**
     * Get the Board of this Game
     * @return the Board of this game
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Add a new Player to this game
     * @param player the player to add to the game
     */
    public void addPlayer(Player player) {
        try {
            // set cell 0 to each player
            player.setCurrentCell(this.getBoard().getCell(0));
        } catch (NoSuchCellException e) {
            System.out.println("Erreur d'initialisation !!");
        }
        this.getThePlayers().add(player);
    }

    /**
     * The Dice Throw of a player
     * @param player the player who throws
     * @return the dice throw of the player
     */
    private int playerDiceThrow(Player player) {
        int playerDiceThrow = 0;
        Cell playerCell = player.getCurrentCell();
        if(playerCell.canMove()) {
            playerDiceThrow = player.twoDiceThrow();
        }
        return playerDiceThrow;
    }

    /**
     * Check when the player's throw exceeds the limit
     * @param nextCellIndex the index of the cell to land in
     * @return the landing cell
     * @throws NoSuchCellException no such cell
     */
    private Cell nextCell(int nextCellIndex) throws NoSuchCellException {
        Cell landingCell;
        try {
            landingCell = this.getBoard().getCell(nextCellIndex);
        } catch (NoSuchCellException e) {
            // nextCellIndex >= this.getBoard().getNbOfCells()
            int extra = nextCellIndex - Game.WINNINGINDEX;
            landingCell = this.getBoard().getCell(Game.WINNINGINDEX - extra);
        }
        return landingCell;
    }

    /**
     * Display when next Cell is Busy or not
     * @param nextCell the nexcell of the player 
     * @return display what happen 
     * @throws NoSuchCellException no such cell
     */
    private Boolean nextCellIsBusy(Cell nextCell) throws NoSuchCellException {

        if(this.getBoard().getCell(nextCell.getIndex()).isBusy()) 
            return true;
        // else
        return false;
    } 

    /**
     * Set a player on his nextCell on the board 
     * @param player the player to set on the board 
     * @param nextCell the cell of the player
     */
    private void setPlayerOnBoard(Player player,Cell nextCell) {
        try {
            this.getBoard().getCell(nextCell.getIndex()).setCurrentPlayer(player);
            player.setCurrentCell(nextCell);
        } catch (NoSuchCellException e) {
            System.out.println("Cannot set player on Board !!");
        }
    }

    /**
     * A Player play th game 
     * @param currentTurn the current Turn 
     * @param player the player who plays
     * @throws NoSuchCellException no such cell
     */
    private String playerPlays(Player player) throws NoSuchCellException{
        String display = "";
        String nextCellBusy = "";
        String finalCellBusy = "";
        Cell nextCell;
        Cell finalCell;
        int nextCellIndex;
        int playerDiceThrow = 0;
        int finalCellIndex = 0;
        
        if(!this.GameOver()) {
            // le joueur lance ses dés 
            playerDiceThrow = this.playerDiceThrow(player);
            // on determine ou il vas atterir
            nextCellIndex = player.getCurrentCell().getIndex() + playerDiceThrow;
            // display throws
            display = player + player.getName() + " throws " + playerDiceThrow;
            // supprimer le player de sa case actuelle sur le board avant qu'il ne la quitte 
            this.getBoard().getCell(player.getCurrentCell().getIndex()).setCurrentPlayer(null);
            // verifier s'il reste sur cette case ou pas 
            if(player.getCurrentCell().getIndex() == player.getCurrentCell().bouncePlayer(playerDiceThrow)) {
                // on calcule a prochaine case
                nextCell = this.nextCell(nextCellIndex);
                // verifier si la prochaine case est occupée ou pas 
                if(this.nextCellIsBusy(nextCell)) {
                    nextCellBusy = nextCellBusy + " cell is busy, " + nextCell.getCurrentPlayer().getName() + " is sent to cell " + player.getCurrentCell();
                    // on permute les joueurs de cases
                    this.setPlayerOnBoard(nextCell.getCurrentPlayer(), player.getCurrentCell());
                    this.setPlayerOnBoard(player, nextCell);
                    display = display + " and reaches cell " + player.getCurrentCell() + nextCellBusy + "\n";
                }
                else {
                    this.setPlayerOnBoard(player, nextCell);
                    display = display + " and reaches cell " + player.getCurrentCell() + "\n";
                }
            }
            if(player.getCurrentCell().getIndex() != player.getCurrentCell().bouncePlayer(playerDiceThrow)){
                // supprimer le player de sa case actuelle du board avant de rebondir  
                this.getBoard().getCell(player.getCurrentCell().getIndex()).setCurrentPlayer(null);
                // on fait rebondir le joueur 
                finalCellIndex = player.getCurrentCell().bouncePlayer(playerDiceThrow);
                // on calcule sa nouvelle cellule
                finalCell = this.nextCell(finalCellIndex);
                // verifier si la derniere case est occupée ou pas 
                if(this.nextCellIsBusy(finalCell)) {
                    finalCellBusy = finalCellBusy + " cell is busy, " + finalCell.getCurrentPlayer().getName() + " is sent to cell " + player.getCurrentCell();
                    this.setPlayerOnBoard(finalCell.getCurrentPlayer(), player.getCurrentCell());
                    this.setPlayerOnBoard(player, finalCell);
                    display = display.replace("\n", " ") + " and jumps to cell " + player.getCurrentCell() + finalCellBusy + "\n";
                }
                else {
                    this.setPlayerOnBoard(player, finalCell);
                    display = display.replace("\n", " ") + " and jumps to cell " + player.getCurrentCell() + "\n";
                }
            }
        }
        return display;
    }

    /**
     * Play a Turn of the Game, all the players have to play
     * @throws NoSuchCellException no such cell
     */
    private String playATurn() throws NoSuchCellException {
        String displayATurn = "";
        for(Player player : this.getThePlayers()) {
            displayATurn = displayATurn + this.playerPlays(player);
        }
        return displayATurn;
    }

    /**
     * Tells when the game end 
     * @return true if game over, false if not
     * @throws NoSuchCellException no such cell
     */
    private Boolean GameOver() throws NoSuchCellException {
        return this.getBoard().getCell(Game.WINNINGINDEX).isBusy();
    }

    /**
     * Play Game of GooseGame
     * @throws NoSuchCellException no such cell
     */
    public void play() throws NoSuchCellException {
        Player Winner;
        int currentTurn = 1;
        while (!this.GameOver()) {
            System.out.println("Tour " + currentTurn + "\n");
            System.out.println(this.playATurn());
            currentTurn++;
        }
        Winner = this.getBoard().getCell(Game.WINNINGINDEX).getCurrentPlayer();
        System.out.println("GAME OVER\n\n" + Winner.getName() + " Wins !!"); 
    }
}

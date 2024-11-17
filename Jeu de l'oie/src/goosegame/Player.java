package goosegame;

import java.util.Random;

import goosegame.cells.Cell;
/**
 * A Player in the "jeu de l'oie" game
 */
public class Player {

    /** random instance for random number */
    private static Random random = new Random();

    /** current cell of the player */
    protected Cell currentCell;

    /** name of the player */
    protected String name;

    /**
     * Build a Player with a given name
     * @param name the name of this player
     */
    public Player(String name) {
        this.name = name;
        this.currentCell = null;
    }

    /**
     * Get the name of this player
     * @return name of this player
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the current cell of the player
     * @return the current cell of the player
     */
    public Cell getCurrentCell() {
        return this.currentCell;
    }

    /**
     * changes the cell of the player
     * @param newCell the new cell
     */
    public void setCurrentCell(Cell newCell) {
        this.currentCell = newCell;
    }

    /**
     * The result of the throw of a Dice
     * @return random result of a 1d6 throw
     */
    private int oneDieThrow() {
        return Player.random.nextInt(6) + 1;
    }

    /**
     * The result of the throw of two Dices
     * @return random result of a 2d6 throw
     */
    public int twoDiceThrow() {
        int result = this.oneDieThrow() + this.oneDieThrow();
        return result;
    }

    /**
     * Two Players are equals if same name 
     * @param o player
     * @return true if equals, false if not
     */
    public boolean equals(Object o) {
        try {
            Player Other = (Player)o;
            return this.getName().equals(Other.getName());
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Get a description of the current cell of the player
     * @return a description
     */
    public String toString() {
        return this.getName() + " is in Cell " + this.getCurrentCell().getIndex() + ", "; 
    }
}
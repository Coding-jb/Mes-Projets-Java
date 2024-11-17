package goosegame.cells;

import goosegame.*;
/**
 * class for Cell
 */
public class Cell {
    
    /** the index of this Cell */
    protected int index;

    /** the player on this cell */
    protected Player currentPlayer;

    /**
     * Build a new cell with given index
     * @param index   the index of this cell
     */
    public Cell(int index) {
        this.index = index;
        // a Cell has no player on it at creation
        this.currentPlayer = null;
    }

    /**
     * get the index of this Cell
     * @return index of this Cell
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * get the current player on the cell
     * @return the current player on the cell 
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Tells if we the Cell, a cell is busy if a players on it
     * @return true if busy, false if not
     */
    public boolean isBusy() {
        return this.getCurrentPlayer() != null;
    }

    /**
     * set a player on this cell
     * @param currentPlayer the player to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Tell if Player can move on this cell
     * @return true 
     */
    public boolean canMove() {
        return true;
    }

    /**
     * Bounce the player to a cell
     * @param playerDiceThrow the dice throw of the player 
     * @return index of the cell
     */
    public int bouncePlayer(int playerDiceThrow) {
        return this.getIndex();
    }
    
    /**
     * two Cell are equals if same index
     * @param o cell
     * @return true if equals, false if not
     */
    public boolean equals(Object o) {
        try {
            Cell Other = (Cell)o;
            return this.getIndex() == Other.getIndex();
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Description of this Cell
     * @return description of this cell
     */
    public String toString() {
        return "" + this.getIndex();
    }
}

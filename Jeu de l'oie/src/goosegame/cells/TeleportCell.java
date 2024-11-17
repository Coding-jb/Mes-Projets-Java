package goosegame.cells;

/**
 * class for TeleportCell
 */
public class TeleportCell extends Cell {
    
    /** the index of the Cell to be teleported on */
    private Cell landingCell;

    /**
     * Build a new Teleport Cell with given index 
     * @param index of this Goose Cell
     * @param landingCell the cell to land on 
     */
    public TeleportCell(int index,Cell landingCell) {
        super(index);
        this.landingCell = landingCell;
    }

    /**
     * Get the cell to be teleported on of this teleport cell
     * @return the cell to be teleport on
     */
    public Cell getLandingCell() {
        return this.landingCell;
    }
 
    /**
     * Teleport all of the player on this cell to another cell
     */
    public int bouncePlayer(int playerDiceThrow) {
        return this.getLandingCell().getIndex();
    }

    /**
     * description of the game after reaching a Teleport cell
     * @return descritpion of the game after landing in a Teleport cell
     */
    public String toString() {
        return this.getIndex() + " (teleport to " + this.getLandingCell().getIndex() + ")";
    }
}

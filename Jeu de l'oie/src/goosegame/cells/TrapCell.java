package goosegame.cells;

/**
 * class for TrapCell
 */
public class TrapCell extends Cell {
    
    /**
     * Build a Trap Cell with given index 
     * @param index if the Trap Cell
     */
    public TrapCell(int index) {
        super(index);
    }

    /**
     * Tell if Player can move on this cell
     * @return false
     */
    public boolean canMove() {
        return !super.canMove();
    }

    /**
     * description of the game after reaching a trap cell
     * @return descritpion of the game after landing in a trap cell
     */
    public String toString() {
        return this.getIndex() + " (trap)";
    }
}

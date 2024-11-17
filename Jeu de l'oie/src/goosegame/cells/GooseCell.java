package goosegame.cells;

/**
 * class for GooseCell
 */
public class GooseCell extends Cell {
    
    /**
     * Build a new Goose Cell with given index 
     * @param index of this Goose Cell
     */
    public GooseCell(int index) {
        super(index);
    }

    /**
     * Bounce the player present on this cell to another cell with their DiceThrow
     * @param playerDiceThrow the dicethrow of the player when reaching this cell
     */
    public int bouncePlayer(int playerDiceThrow) {
        return super.bouncePlayer(playerDiceThrow) + playerDiceThrow;
    }

    /**
     * description of the game after reaching a goose cell
     * @return descritpion of the game after landing in a goose cell
     */
    public String toString() {
        return this.getIndex() + " (goose)";
    }

}

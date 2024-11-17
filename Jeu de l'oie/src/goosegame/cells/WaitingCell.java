package goosegame.cells;

/**
 * class for WaitingCell
 */
public class WaitingCell extends Cell {
    
    /** number of turn during which we can't play */
    protected int nbTurnsToWait;

    /** number of turn remaining after one turn */
    protected int nbTurnRemaining;
    
    /**
     * Build a Waiting Cell with given index 
     * @param index if the Trap Cell
     * @param nbTurnsToWait turns to wait
     */
    public WaitingCell(int index,int nbTurnsToWait) {
        super(index);
        this.nbTurnsToWait = nbTurnsToWait;
        this.nbTurnRemaining = nbTurnsToWait;
    }

    /**
     * Get number of turn to wait
     * @return number turns to wait
     */
    public int getNbTurnsToWait() {
        return this.nbTurnsToWait;
    }
    
    /**
     * Get the number if turn remaining
     * @return the landing Turn 
     */
    public int getNbTurnRemaining(){
        return this.nbTurnRemaining;
    }

    /**
     * Set the number if turn remaining
     * @param nbTurnRemaining turns remaining
     */
    public void setNbTurnRemaining(int nbTurnRemaining){
        this.nbTurnRemaining = nbTurnRemaining;
    }

    /**
     * temporarely make all this cell's players to wait until number of turns remaining finishes 
     * @return tell if player can move on this cell
     */
    public boolean canMove() {
        if(this.getNbTurnRemaining() > 0) {
            this.nbTurnRemaining--;
            return !super.canMove();
        }
        else {
            this.setNbTurnRemaining(this.getNbTurnsToWait());
            return super.canMove();
        }
    }

    /**
     * description of the game after reaching a waiting cell
     * @return descritpion of the game after landing in a waiting cell
     */
    public String toString() {
        return this.getIndex() + " (waiting for " + this.getNbTurnRemaining() + ")";
    }
}

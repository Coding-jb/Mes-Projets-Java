package battleship;
/**
 * class for Cell
 * 
 * @author JB
 */
public class Cell {
    
    /** the ship on this Cell */
    private Ship ship;

    /** Tells if the Cell has been shot */
    private Boolean shot;

    /**
     * Build an empty Cell
     */
    public Cell() {
        this.ship = null;
        this.shot = false;
    }


    /**
     * Check if the cell is empty, A cell is empty when his ship is null
     * 
     * @return true if the cell is empty else return false
     */
    public Boolean empty(){
        return this.ship == null;
    }

    /** 
     * Get the Ship on this Cell
     * 
     * @return the Ship of this Cell 
    */
    public Ship getShip(){
        return this.ship;   
    }

    /** 
     * Set a Ship on this Cell
     * 
     * @param ship to set on this Cell 
    */
    public void setShip(Ship ship){
        if (this.empty()){
            this.ship = ship;
        }
    }

    /**
     * Check if this cell has been shot 
     * 
     * @return true if this cell has been shot , else return false
     */
    public boolean hasBeenShot(){
        return this.shot;
    }

    /**
     * shot this cell
     * 
     * @return the answer of this shot
     */
 
    public Answer shot(){
        if (this.empty()){
            this.shot = true;
            return Answer.MISSED;
        }
        if (!this.hasBeenShot()){
            this.shot = true;
            this.ship.beenHitting();
            if (this.ship.hasBeenSunk()){
                return Answer.SUNK;
            }
            else{
                return Answer.HIT;
            }
        }
        else{
            return Answer.MISSED;
        }
    }

    /**
     * give a character that inform of this cell's condition.
     * The result is according to the defender or attacker
     * @param defender true if we place of defender'viewpoint
     * @return character accoding to the viewpoint 
     */
    public char toCharacter(boolean defender){
        if (defender){
            if (this.ship == null){
                return '~';
            }
            if (this.hasBeenShot() == false){
                return 'B';
            }
            return '*';
        }       
        else {
            if (this.hasBeenShot() == false){
                return '.';
            }
            if (this.ship == null){
                return '~';
            }
            return '*';
        }
    }

}

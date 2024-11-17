package battleship;
/**
 * class for Ship
 * 
 * @author JB
 */
public class Ship {
    
    /** number of lifepoints of this Ship */
    private int lifePoints;

    /**
     * Build a Ship with given lifePoints
     * 
     * @param length, the length of this Ship also the lifePoints of this Ship
     */
    public Ship(int length) {
        this.lifePoints = length;
    }

    /**
     * check if the ship has been sunk
     *   
     * @return true if the life points equal to 0, else return false
     */
    public boolean hasBeenSunk(){
        return this.lifePoints == 0;
    }

    /**
     *  remove one LifePoint of this Ship
     */
    public void beenHitting(){
        if (!this.hasBeenSunk()){
            this.lifePoints--;
        }
    }

    /**
     * Get this Ship's Remainin LifePoints
     * 
     * @return lifePoints of this Ship
     */
    public int getLifePoints(){
        return this.lifePoints;
    }

    /**
     * Give a string representation for this Ship
     * 
     * @return a string representation for this Ship
     */
    public String toString(){
        return "This Ship has " + this.lifePoints + " lifePoints.";
    }
    
}

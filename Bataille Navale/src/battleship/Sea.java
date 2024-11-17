package battleship;
import battleship.util.Position;
/**
 * class for Sea
 * 
 * @author JB
 */
public class Sea {
    
    /** the board representing this sea */
    private Cell[][] boardCells;

    /* Total life points of ship on this sea  */
    private int LifePoints;

    /**
     * Build a Sea with given Width and height 
     * 
     * @param width, the width of this sea 
     * @param height, the height of this sea
     */
    public Sea(int width, int height) {
        this.boardCells = new Cell[width][height];
        for(int j = 0; j < this.getHeight(); j++){
            for(int i = 0; i < this.getWidth(); i++){
                this.boardCells[i][j] = new Cell();
            }
        }
        this.LifePoints = 0;
    }

    /**
     * Get this Sea Width
     * 
     * @return this Sea's width
     */
    public int getWidth() {
        return this.boardCells[0].length;
    }

    /**
     * Get this Sea length
     * 
     * @return this Sea's length
     */
    public int getHeight() {
        return this.boardCells.length;
    }

    /**
     * Add a ship on the position 
     * @param ship the ship that we want to add
     * @param position the position where we want to add the ship     
     * @throws InvalidShootException if position is invalid
     */
    public void addShip(Ship ship, Position position) throws InvalidShootException{
        Cell cell = this.getCell(position);           
        cell.setShip(ship);
        this.LifePoints = this.LifePoints + ship.getLifePoints(); 
    }

    /**
    * Shot a cell at a position 
    * @param position the position of the cell that we want to shot
    * @return the Answer of the shot
    * @throws InvalidShootException if the position isn't valid
    */
    public Answer Shoot(Position position) throws InvalidShootException{
        try {
            return this.getCell(position).shot();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidShootException("Error : Invalid Position !!");
        }
    }

    /**
     * Get the current Total LifePoints of all Ships on this Sea
     * @return Total lifepoints of Ships on this Sea
     * @throws InvalidShootException if position is invalid
     */
    public int getRemainingLifePoints() throws InvalidShootException{
        int totalLifePoints = 0;
        for (int i = 0; i < this.getHeight(); i++){
            for(int j = 0; j < this.getWidth(); j++){
                if(this.getCell(new Position(i, j)).getShip() != null)
                    totalLifePoints += this.getCell(new Position(i, j)).getShip().getLifePoints();
            }
        }
        return totalLifePoints;
    }

    /**
     * Get the cell at the p position
     * @param position the position of the cell that we want get
     * @return the cell at position p
     * @throws InvalidShootException if the position is invalid
     */
    public Cell getCell(Position position) throws InvalidShootException{
        try {
            return this.boardCells[position.getX()][position.getY()];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidShootException("Error : Invalid Position, the Ship cannot be add at that Position !!");
        } 
    }
    
    /** 
     * display the game board line by line and cell by cell, on standard output,
     * the display is different for the defender or the attacker, according to parameter
     * @param defender true iff display is for defender, false if for opponent
     * @throws InvalidShootException if position is invalid
     */
    public void display(boolean defender) throws InvalidShootException {
        String res = " ";
        char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < this.getWidth(); i++){
            res = res + "  " + alpha[i];
        }
        for (int j = 0; j < this.getHeight(); j++){
            for(int i = 0; i < this.getWidth(); i++){
                if(i == 0 && j < 10){
                    res = res + "\n" + " " + j + " " + this.getCell(new Position(i, j)).toCharacter(defender);
                }
                else if (i == 0 && j >= 10){
                    res = res + "\n" + j + " " + this.getCell(new Position(i, j)).toCharacter(defender);
                }
                else if (i >= 1) {
                    res = res + "  " + this.getCell(new Position(i, j)).toCharacter(defender);
                }
            }
        }
        System.out.println(res);
    }

    /**
     * test if a ship can be placed vertically from position p on the sea
     * @param shipToPlace the ship that want to place
     * @param position the position where we want to place the ship
     * @throws IllegalStateException If we can't place the ship Vertically
     */
    private void testIfShipCanBePlacedVertically(Ship shipToPlace, Position position) throws IllegalStateException{
        if (position.getX() >= this.getWidth() || position.getY() >= this.getHeight() || this.getHeight() - position.getY() < shipToPlace.getLifePoints()){
            throw new IllegalStateException();
        }
    }

    /**
     * test if a ship can be placed horizontally from position p on the sea
     * @param shipToPlace the ship that want to place
     * @param position the position where we want to place the ship
     * @throws IllegalStateException If we can't place the ship Horizontally
     */
    private void testIfShipCanBePlacedHorizontally(Ship shipToPlace, Position position)  throws IllegalStateException{
        if(position.getX() >= this.getWidth() || position.getY() >= this.getHeight() || this.getWidth() - position.getX() < shipToPlace.getLifePoints()){
            throw new IllegalStateException();
        }
    }

    /** 
     * add the ship b to this game’s sea. Ship is added vertically down from position p.
     * The number of cells is determined by the ship life points.
     * @param shipToPlace the ship to add
     * @param position the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     * @throws InvalidShootException if addShip cannot be done
     */
    public void addShipVertically(Ship shipToPlace, Position position) throws IllegalStateException, InvalidShootException {
        try {
            testIfShipCanBePlacedVertically(shipToPlace, position);
            addShip(shipToPlace, position, 0, 1);
        } catch (IllegalStateException e) {
            addShip(shipToPlace, position, 1, 0);
        }
    }

    /** 
     * add the ship b to this game’s sea. Ship is added vertically down from position p.
     * The number of cells is determined by the ship life points.
     * @param shipToPlace the ship to add
     * @param position the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     * @throws InvalidShootException if addShip cannot be done 
     */
    public void addShipHorizontally(Ship shipToPlace, Position position) throws IllegalStateException, InvalidShootException{
        try {
            testIfShipCanBePlacedHorizontally(shipToPlace, position);
            addShip(shipToPlace, position, 1, 0);
        } catch (IllegalStateException e) {
            addShip(shipToPlace, position, 0, 1);
        }
    }
  
    /**
     * add the ship to this sea from the position p if it's possible 
     * @param shipToPlace the ship that want to place
     * @param position the position where we want to place the ship 
     * @param dx the coordinate x 
     * @param dy the coordinate y 
     * @throws IllegalStateException If the ship can't be placed Horizontally or Verticaly from position p
     * @throws InvalidShootException
     */
    private void addShip(Ship shipToPlace, Position position, int dx, int dy) throws IllegalStateException, InvalidShootException{
        if (dx == 1 && dy == 0){
            int positionX = position.getX();
            for (int life = 0 ; life < shipToPlace.getLifePoints(); life++){
                this.addShip(shipToPlace, new Position(positionX, position.getY()));
                positionX++;
            }
        }
        else if(dx == 0 && dy == 1){
            int positionY = position.getY();
            for (int life = 0 ; life < shipToPlace.getLifePoints(); life++){
                this.addShip(shipToPlace, new Position(position.getX(), positionY));
                positionY++;
            }
        }
        else {
            throw new IllegalStateException();
        }
    }
}

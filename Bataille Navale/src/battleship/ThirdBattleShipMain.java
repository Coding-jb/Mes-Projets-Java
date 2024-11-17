package battleship;

import battleship.util.Position;

/**
 * class for ThirdBattleShipMain
 */
public class ThirdBattleShipMain {
    /**
     * Default constructor of ThirdBattleShipMain
     */
    public ThirdBattleShipMain(){}

    /**
     * Main method of ThirdBattleShipMain 
     * @param args no param
     * @throws InvalidShootException Exception raise by addShip and Shoot
     */
    public static void main(String[] args) throws InvalidShootException {
        
        Sea sea = new Sea(10, 10);
        Ship ship1 = new Ship(4);
        Ship ship2 = new Ship(2);
        Ship ship3 = new Ship(3);
        Ship ship4 = new Ship(2);
        Position positionShip1 = new Position(5, 5);
        Position positionShip2 = new Position(1, 3);
        Position positionShip3 = new Position(6, 1);
        Position positionShip4 = new Position(8, 9);
        
        sea.addShipVertically(ship1,positionShip1);
        sea.addShipHorizontally(ship2,positionShip2);
        sea.addShipHorizontally(ship3,positionShip3);
        sea.addShipHorizontally(ship4, positionShip4);

        sea.display(true);
        System.out.println("----------------------------------------------------");
        
        Game game = new Game(sea);
        game.play();
    }
}

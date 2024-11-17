package battleship;

import battleship.util.Position;

/**
 * class for SecondBattleShipMain
 */
public class SecondBattleShipMain {
    /**
     * Default constructor of class FirstBattleShipMain
     */
    public SecondBattleShipMain(){}
    
    /**
     * Main method of SecondBattleShipMain class
     * @param args no param
     * @throws InvalidShootException Exception raise by addShip 
     */
    public static void main(String[] args) throws InvalidShootException {
        
        Sea sea = new Sea(10, 10);
        Ship ship1 = new Ship(1);
        Position positionShip1 = new Position(5, 5);
        Ship ship2 = new Ship(1);
        Position positionShip2 = new Position(9, 9);

        sea.addShip(ship1,positionShip1);
        sea.addShip(ship2, positionShip2);

        sea.display(true);
        System.out.println("----------------------------------------------------");
        
        Game game = new Game(sea);
        game.play();
    }

}

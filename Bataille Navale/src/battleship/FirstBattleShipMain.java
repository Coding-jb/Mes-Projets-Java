package battleship;

import battleship.util.Position;

/**
 * class for FirstBattleShipMain
 */
public class FirstBattleShipMain {
    /**
     * Default constructor of class FirstBattleShipMain
     */
    public FirstBattleShipMain(){}

    /**
     * Main method of FirstBattleShipMain class
     * @param args, no params
     * @throws InvalidShootException Exception raise by addShip and Shoot
     */
    public static void main(String[] args) throws InvalidShootException {

        Sea sea = new Sea(10, 10);
        Ship ship1 = new Ship(1);
        Position positionShip1 = new Position(3, 2);
        Ship ship2 = new Ship(2);
        Position positionShip2 = new Position(4, 5);

        sea.addShip(ship1,positionShip1);
        sea.addShip(ship2,positionShip2);
        
        System.out.println("\nVision of defender : ");
        System.out.println("\n---------------------------");
        sea.display(true);
        
        System.out.println("\nVision of attacker : ");
        System.out.println("\n---------------------------");
        sea.display(false);
        

        sea.Shoot(positionShip2);
        System.out.println("\nAfter one shot : ");
        
        System.out.println("\nVision of defender : ");
        System.out.println("---------------------------");
        sea.display(true);
        
        
        System.out.println("\nVision of attacker : ");
        System.out.println("---------------------------");
        sea.display(false); 
    }   
}

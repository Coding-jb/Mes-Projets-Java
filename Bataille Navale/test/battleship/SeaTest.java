package battleship;
/**
 * class for SeaTest
 */
import org.junit.jupiter.api.*;

import battleship.util.Position;

import static org.junit.jupiter.api.Assertions.*;

public class SeaTest{
    
    private Sea sea;
    private Ship ship;
    private Position position;

    @BeforeEach
    public void init() {
        sea = new Sea(10, 10);
        ship = new Ship(3);
        position = new Position(3, 2);
    }

    @Test
    public void initialisationIsOK() throws InvalidShootException {
        sea.addShip(ship, position);
        assertEquals(sea.getRemainingLifePoints(),3);
    }

    @Test
    public void  CheckIfShipOnSeaIsHIT() throws InvalidShootException {
        //Add ship to the Sea
        sea.addShip(ship, position);
        //The ship on sea is HIT
        assertEquals(Answer.HIT, sea.Shoot(position));
    }

    @Test
    public void CheckIfShipOnSeaIsMISSED() throws InvalidShootException {
        //Add ship to the Sea
        sea.addShip(ship, position);
        //The ship on sea is HIT
        assertEquals(Answer.MISSED, sea.Shoot(new Position(4, 0)));
    }

    @Test
    public void CheckIfShipOnSeaIsMISSEDWhenAlreadyShoot() throws InvalidShootException {
        //Add ship to the Sea
        sea.addShip(ship, position);
        //shoot the ship
        sea.Shoot(position);
        //Alraedy HIT ship so MISSED
        assertEquals(Answer.MISSED, sea.Shoot(position));
    }

    @Test
    public void checkIfShipOnSeaIsSUNK() throws InvalidShootException {
        //new ship with 1 lifepoints
        Ship ship = new Ship(1);
        //Add ship to the Sea
        sea.addShip(ship, position);
        //Ship  is SUNK
        assertEquals(Answer.SUNK,sea.Shoot(position));
    }

    @Test
    public void CheckIfShootOnInvalidPosition() throws InvalidShootException {
        Position position1 = new Position(-1, -4);
        //Exception raise
        assertThrows(InvalidShootException.class, () -> sea.Shoot(position1));
    }
}
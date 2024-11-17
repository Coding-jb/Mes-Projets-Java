package battleship;
/**
 * class for ShipTest
*/
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest{
    
    @Test 
    public void initiliizationIsOk(){
        Ship s1 = new Ship(5);
        assertTrue(s1.getLifePoints()==5);
    }

    @Test
    public void CheckifAshipCanSunk(){
        Ship s1 =new Ship(2);
        s1.beenHitting();
        s1.beenHitting();
        assertTrue(s1.hasBeenSunk());
    }

    @Test
    public void CheckifAshipCantSunkWhileItRemainsLifePoints(){
        Ship s1 =new Ship(5);
        s1.beenHitting();
        s1.beenHitting();
        assertFalse(s1.hasBeenSunk());
    }

    @Test
    public void CheckifAShipCanBeHit(){
        Ship s1 =new Ship(5);
        s1.beenHitting();
        s1.beenHitting();
        assertEquals(3,s1.getLifePoints());
    }

    @Test
    public void CheckifAshipCantBeHitIfIsSunk(){
        Ship s1 =new Ship(2);
        s1.beenHitting();
        s1.beenHitting();
        assertTrue(s1.hasBeenSunk());
        s1.beenHitting();
        assertFalse(s1.getLifePoints() == -1);
    }

}
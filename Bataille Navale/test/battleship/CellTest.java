package battleship;
/**
 * class for CellTest
 */
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell cell;
    private Ship ship;

    @BeforeEach
    public void init() {
        cell = new Cell();
        ship = new Ship(1);
    }

    @Test
    public void initiliizationIsOk() {
        assertEquals(cell.getShip(), null);
        assertFalse(cell.hasBeenShot());
    }

    @Test 
    public void CheckIfCellIsEmpty() {
        // The cell is empty
        assertTrue(cell.empty());
    }

    @Test
    public void checkIfShipIsSetOnCell() {
        cell.setShip(ship);
        // The cell is not empty
        assertFalse(cell.empty());
    }

    @Test
    public void CheckIfCellHasBeenShot() {
        cell.shot();
        // The Cell has been Shot
        assertTrue(cell.hasBeenShot());
    }

    @Test
    public void ChectoCharacterForDefenderWhenCellIsEmpty() {
        char car = cell.toCharacter(true);
        assertEquals('~',car);   
    }

    @Test
    public void ChecktoCharacterForDefenderWhenCellIsNotEmptyAndHasNottBeenShot() {
        cell.setShip(ship);
        char car = cell.toCharacter(true);
        assertEquals('B',car);
    }

    @Test
    public void ChecktoCharacterForDefenderWhenCellIsNotEmptyAndHasBeenShot() {
        cell.setShip(ship);
        cell.shot();
        char car = cell.toCharacter(true);
        assertEquals('*',car);
    }

    @Test
    public void ChecktoCharacterForAttackerWhenCellisEmpty() {
        char car = cell.toCharacter(false);
        assertEquals('.',car);
    }

    @Test
    public void ChecktoCharacterForAttackerWhenCellIsEmptyAndHasBeenShot() {
        cell.shot();
        char car = cell.toCharacter(false);
        assertEquals('~',car);
    }

    @Test
    public void ChecktoCharacterForAttackerWhenCellIsNotEmptyAndHasBeenShot() {
        cell.setShip(ship);
        cell.shot();
        char car = cell.toCharacter(false);
        assertEquals('*',car);
    }
}

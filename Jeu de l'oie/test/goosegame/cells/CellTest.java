package goosegame.cells;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import goosegame.Player;

public class CellTest {
    
    private Cell cell;

    @BeforeEach
    public void init() {
        cell = new Cell(10);
    }

    @Test
    public void intialisationIsOK() {
        assertEquals(10, cell.getIndex());
        assertNull(cell.getCurrentPlayer());
    }

    @Test
    public void checkIsBusy() {
        Player player = new Player("Jean");
        cell.setCurrentPlayer(player);
        assertTrue(cell.isBusy());
    }

    @Test
    public void checkSetANewPlayer() {
        Player player = new Player("Jean");
        cell.setCurrentPlayer(player);
        assertEquals(player,cell.getCurrentPlayer());
    }

    @Test
    public void checkCanMoveOnThisCell() {
        // verifier 'qu'on peut bouger sur la cell
        assertTrue(cell.canMove());
    }

    @Test
    public void checkBouncePlayer() {
        assertEquals(cell.getIndex(), cell.bouncePlayer(0));
    }

    @Test
    public void checkTwoCellsAreEquals() {
        assertTrue(new Cell(10).equals(cell));
    }
}

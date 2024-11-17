package goosegame.cells;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WaitingCellTest {

    private WaitingCell waitingCell;

    @BeforeEach
    public void init() {
        waitingCell = new WaitingCell(30, 4);
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(30,waitingCell.getIndex());
        assertNull(waitingCell.getCurrentPlayer());
        assertEquals(4, waitingCell.getNbTurnsToWait());
        assertEquals(4, waitingCell.getNbTurnRemaining());
    }

    @Test
    public void chechCanMove() {
        assertFalse(waitingCell.canMove());
        assertFalse(waitingCell.canMove());
        assertFalse(waitingCell.canMove());
        assertFalse(waitingCell.canMove());
        assertTrue(waitingCell.canMove());
    }

}

package goosegame.cells;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrapCellTest {
    
    private TrapCell trapCell;

    @BeforeEach
    public void init() {
        trapCell = new TrapCell(15);
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(15, trapCell.getIndex());
        assertNull(trapCell.getCurrentPlayer());
    }

    @Test
    public void checkCanMove() {
        assertFalse(trapCell.canMove());
    }
}

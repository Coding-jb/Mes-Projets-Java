package goosegame.cells;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TeleportCellTest {
    
    private TeleportCell teleportCell;

    @BeforeEach
    public void init() {
        teleportCell = new TeleportCell(10, new Cell(40));
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(10, teleportCell.getIndex());
        assertNull(teleportCell.getCurrentPlayer());
        assertEquals(new Cell(40), teleportCell.getLandingCell());
    }

    @Test
    public void checkBouncePlayer() {
        assertEquals(40, teleportCell.bouncePlayer(0));
    }
}

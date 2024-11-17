package goosegame.boards;

import org.junit.jupiter.api.*;

import goosegame.NoSuchCellException;
import goosegame.cells.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClassicalBoardTest {
    
    private ClassicalBoard classicalBoard;

    @BeforeEach
    public void init() {
        classicalBoard = new ClassicalBoard(ClassicalBoard.NBCELLS);
    }

    @Test
    public void initialisationIsOK() throws NoSuchCellException {
        assertEquals(new GooseCell(45), classicalBoard.getCell(45));
        assertEquals(new TrapCell(31), classicalBoard.getCell(31));
        assertEquals(new WaitingCell(19, 2), classicalBoard.getCell(19));
        assertEquals(new TeleportCell(42, classicalBoard.getCell(30)), classicalBoard.getCell(42));
    }
}

package goosegame;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import goosegame.boards.ClassicalBoard;
import goosegame.cells.Cell;

public class GameTest {
    
    private Game game;
    private ClassicalBoard classicalBoard;

    @BeforeEach
    public void init() {
        classicalBoard = new ClassicalBoard(ClassicalBoard.NBCELLS);
    }

    @Test
    public void FirstInitialisationIsOK() {
        game = new Game(classicalBoard, 2);
        int i = 0;
        for(Player player : game.getThePlayers()) {
            assertEquals("Joueur " + i, player.getName());
            assertEquals(new Cell(0), player.getCurrentCell());
            i++;
        }
    }

    @Test
    public void SecondInitialisationIsOK() {
        List<String> names = new ArrayList<String>(2);
        names.add("Timoleon");
        names.add("Achille");
        game = new Game(classicalBoard, 2, names);
        assertEquals("Timoleon", game.getThePlayers().get(0).getName());
        assertEquals(new Cell(0), game.getThePlayers().get(0).getCurrentCell());
        assertEquals("Achille", game.getThePlayers().get(1).getName());
        assertEquals(new Cell(0), game.getThePlayers().get(1).getCurrentCell());
    }
}

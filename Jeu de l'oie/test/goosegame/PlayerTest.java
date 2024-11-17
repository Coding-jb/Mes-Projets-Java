package goosegame;

import goosegame.cells.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    
    private Player player;

    @BeforeEach
    public void init() {
        player = new Player("bilbo");
    }

    @Test
    public void intialisationIsOK() {
        assertEquals("bilbo", player.getName());
        assertNull(player.getCurrentCell());
    }

    @Test 
    public void checkSetCell() {
        player.setCurrentCell(new Cell(6));
        assertNotNull(player.getCurrentCell());
    }
    
    @Test
    public void checkDiceThrow() {
        assertNotNull(player.twoDiceThrow());
    }
    
    @Test
    public void checkTwoPlayersAreEquals() {
        assertTrue(new Player("bilbo").equals(player));
    }
}

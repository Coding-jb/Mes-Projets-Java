package goosegame.cells;

import org.junit.jupiter.api.*;

import goosegame.Player;

import static org.junit.jupiter.api.Assertions.*;

public class GooseCellTest {
    
    private GooseCell gooseCell;
    private Player player;

    @BeforeEach
    public void init() {
        gooseCell = new GooseCell(5);
    }

    @Test
    public void intialisationIsOK() {
        assertEquals(5, gooseCell.getIndex());
        assertNull(gooseCell.getCurrentPlayer());
    }

    @Test
    public void checkBouncePlayer() {
        int playerDiceThrow = 0;
        player = new Player("JB");
        playerDiceThrow = player.twoDiceThrow();
        assertEquals(gooseCell.getIndex() + playerDiceThrow, gooseCell.bouncePlayer(playerDiceThrow));
    }
}

package battleship;
/**
 * class for GameTest
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;
    private Sea sea;

    @BeforeEach
    public void init() {
        this.sea = new Sea(10, 10);
        this.game = new Game(sea);
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(sea, this.game.getSea());
    }
}

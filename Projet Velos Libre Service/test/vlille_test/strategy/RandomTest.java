package vlille_test.strategy;

import vlille.strategy.Random;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {
    
    private Random random;

    @BeforeEach
    public void init() {
        this.random = new Random();
    }

    @Test
    public void toStringTest() {
        assertEquals(this.random.toString(), "Random");
    }

}

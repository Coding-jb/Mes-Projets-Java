package vlille_test.strategy;

import vlille.strategy.RoundRobin;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RoundRobinTest {
    
    private RoundRobin roundRobin;

    @BeforeEach
    public void init() {
        this.roundRobin = new RoundRobin();
    }

    @Test
    public void toStringTest() {
        assertEquals(this.roundRobin.toString(), "Round-robin");
    }
}
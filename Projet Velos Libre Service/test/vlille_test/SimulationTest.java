package vlille_test;

import vlille.controlcenter.ControlCenter;
import vlille.Simulation;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {

    protected Simulation simulation;

    @BeforeEach
    public void setUp() {
        this.simulation = new Simulation(new ControlCenter(2), 15, 10);
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(2, simulation.getControlCenter().getNbStations());
        assertEquals(15, simulation.getRenters().size());
        assertEquals(10, simulation.getThieves().size());
        assertNotNull(simulation.getRepairer());
    }
}

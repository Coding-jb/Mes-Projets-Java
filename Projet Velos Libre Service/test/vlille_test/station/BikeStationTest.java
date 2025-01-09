package vlille_test.station;

import vlille.station.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BikeStationTest extends StationTest {

    @Override
    protected Station createStation() {
        return new BikeStation("BikeStation");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("BikeStation", this.station.getStationId());
        assertTrue(this.station.getCapacity() >= 10 && this.station.getCapacity() <= 20);
        assertNotNull(this.station.getVehicles());
    }
}

package vlille_test.vehicle;

import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ElectricBikeTest extends ClassicBikeTest {

    @Override
    protected Vehicle createVehicle() {
        return new ElectricBike("ElectricBike");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("ElectricBike", this.vehicle.getVehicleId());
        assertEquals(0, this.vehicle.getUsageAmount());
        assertEquals("Available", this.vehicle.getState().toString());
        assertNull(this.vehicle.getCurrentUser());
    }
}

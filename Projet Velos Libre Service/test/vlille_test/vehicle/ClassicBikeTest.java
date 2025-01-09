package vlille_test.vehicle;

import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClassicBikeTest extends VehicleTest {

    @Override
    protected Vehicle createVehicle() {
        return new ClassicBike("ClassicBike");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("ClassicBike", this.vehicle.getVehicleId());
        assertEquals(0, this.vehicle.getUsageAmount());
        assertEquals("Available", this.vehicle.getState().toString());
        assertNull(this.vehicle.getCurrentUser());
    }
}

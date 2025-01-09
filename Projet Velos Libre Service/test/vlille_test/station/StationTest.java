package vlille_test.station;

import vlille.station.*;
import vlille.vehicle.ClassicBike;
import vlille.vehicle.Vehicle;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public abstract class StationTest {

    protected Station station;

    protected abstract Station createStation();

    @BeforeEach
    public void init() {
        this.station = this.createStation();
    }

    @Test
    public void addVehicleTest() {
        Vehicle vehicle = new ClassicBike("ClassicBike");
        this.station.addVehicle(vehicle);
        assertTrue(this.station.getVehicles().contains(vehicle));
    }

    @Test
    public void removeVehicleTest() {
        Vehicle vehicle = new ClassicBike("ClassicBike");
        this.station.addVehicle(vehicle);
        this.station.removeVehicle(vehicle);
        assertFalse(this.station.getVehicles().contains(vehicle));
    }
}

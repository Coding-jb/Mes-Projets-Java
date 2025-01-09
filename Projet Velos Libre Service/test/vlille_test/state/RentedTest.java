package vlille_test.state;

import vlille.vehicle.*;
import vlille.state.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RentedTest extends VehicleStateTest {

    private Vehicle vehicle;

    @Override
    protected VehicleState createVehicleState() {
        this.vehicle = new ClassicBike("classicBike");
        this.vehicle.setState(new Rented(this.vehicle));
        return new Rented(this.vehicle);
    }

    @Test
    public void rentTest() {
        this.vehicleState.rent();
        assertEquals("Rented", this.vehicle.getState().toString());
    }

    @Test
    public void availableTest() {
        this.vehicleState.available();
        assertEquals("Available", this.vehicle.getState().toString());
    }

    @Test
    public void stealTest() {
        this.vehicleState.steal();
        assertEquals("Rented", this.vehicle.getState().toString());
    }

    @Test
    public void toStringTest() {
        assertEquals("Rented", this.vehicleState.toString());
    }
}

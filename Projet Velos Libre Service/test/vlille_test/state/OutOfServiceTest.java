package vlille_test.state;

import vlille.vehicle.*;
import vlille.state.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class OutOfServiceTest extends VehicleStateTest {

    private Vehicle vehicle;

    @Override
    protected VehicleState createVehicleState() {
        this.vehicle = new ClassicBike("classicBike");
        this.vehicle.setState(new OutOfService(this.vehicle));
        return new OutOfService(this.vehicle);
    }

    @Test
    public void outOfServiceTest() {
        this.vehicleState.outOfService();
        assertEquals("OutOfService", this.vehicle.getState().toString());
    }

    @Test
    public void availableTest() {
        this.vehicleState.available();
        assertEquals("Available", this.vehicle.getState().toString());
    }

    @Test
    public void rentTest() {
        this.vehicleState.rent();
        assertEquals("OutOfService", this.vehicle.getState().toString());
    }

    @Test
    public void stealTest() {
        this.vehicleState.steal();
        assertEquals("OutOfService", this.vehicle.getState().toString());
    }

    @Test
    public void toStringTest() {
        assertEquals("OutOfService", this.vehicleState.toString());
    }
}

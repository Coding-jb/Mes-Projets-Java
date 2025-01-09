package vlille_test.state;

import vlille.vehicle.*;
import vlille.state.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StolenTest extends VehicleStateTest {

    private Vehicle vehicle;

    @Override
    protected VehicleState createVehicleState() {
        this.vehicle = new ClassicBike("classicBike");
        this.vehicle.setState(new Stolen(this.vehicle));
        return new Stolen(this.vehicle);
    }

    @Test
    public void stealTest() {
        this.vehicleState.steal();
        assertEquals("Stolen", this.vehicle.getState().toString());
    }

    @Test
    public void rentTest() {
        this.vehicleState.rent();
        assertEquals("Stolen", this.vehicle.getState().toString());
    }

    @Test
    public void availableTest() {
        this.vehicleState.available();
        assertEquals("Stolen", this.vehicle.getState().toString());
    }

    @Test
    public void outOfServiceTest() {
        this.vehicleState.outOfService();
        assertEquals("Stolen", this.vehicle.getState().toString());
    }

    @Test
    public void toStringTest() {
        assertEquals("Stolen", this.vehicleState.toString());
    }
}

package vlille_test.decorator;

import vlille.decorator.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FlashLightTest extends VehicleDecoratorTest {

    private Vehicle vehicle;

    @Override
    protected VehicleDecorator createVehicleDecorator() {
        this.vehicle = new ElectricBike("ElectricBike");
        return new FlashLight(this.vehicle);
    }

    @Test   
    public void toStringTest() {
        assertEquals(this.vehicleDecorator.toString(), this.vehicle.toString() + "\nWith Flash Light");
    }
}

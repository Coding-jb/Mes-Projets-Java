package vlille_test.decorator;

import vlille.decorator.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LuggageRackTest extends VehicleDecoratorTest {

    private Vehicle vehicle;

    @Override
    protected VehicleDecorator createVehicleDecorator() {
        this.vehicle = new ClassicBike("ClassicBike");
        return new LuggageRack(this.vehicle);
    }

    @Test
    public void toStringTest() {  
        assertEquals(this.vehicleDecorator.toString(), this.vehicle.toString() + "\nWith Luggage Rack");
    }
}

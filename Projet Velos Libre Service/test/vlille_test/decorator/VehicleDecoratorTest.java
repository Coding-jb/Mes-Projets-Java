package vlille_test.decorator;

import vlille.decorator.VehicleDecorator;

import org.junit.jupiter.api.*;

public abstract class VehicleDecoratorTest {

    protected VehicleDecorator vehicleDecorator;
    
    protected abstract VehicleDecorator createVehicleDecorator();

    @BeforeEach
    public void init() {
        this.vehicleDecorator = this.createVehicleDecorator();
    }
}

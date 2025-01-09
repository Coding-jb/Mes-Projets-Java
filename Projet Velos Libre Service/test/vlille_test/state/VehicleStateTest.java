package vlille_test.state;

import vlille.state.VehicleState;

import org.junit.jupiter.api.*;

public abstract class VehicleStateTest {

    protected VehicleState vehicleState;

    protected abstract VehicleState createVehicleState();

    @BeforeEach
    public void init() {
        this.vehicleState = this.createVehicleState();
    }

}   

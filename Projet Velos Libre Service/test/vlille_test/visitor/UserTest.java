package vlille_test.visitor;

import vlille.visitor.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public abstract class UserTest {

    protected User user;

    protected abstract User createUser();

    @BeforeEach
    public void init() {
        this.user = this.createUser();
    }

    @Test
    public void setVehicleTest() {
        Vehicle electricBike = new ElectricBike("electricBike");
        this.user.setVehicle(electricBike);
        assertEquals(electricBike, this.user.getVehicle());
    }
}

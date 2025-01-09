package vlille_test.vehicle;

import vlille.vehicle.*;
import vlille.visitor.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public abstract class VehicleTest {

    protected Vehicle vehicle;

    protected abstract Vehicle createVehicle();

    @BeforeEach
    public void init() {
        this.vehicle = this.createVehicle();
    }

    @Test
    public void incrementUsageAmountTest() {
        this.vehicle.incrementUsageAmount();
        this.vehicle.incrementUsageAmount();
        assertEquals(2, this.vehicle.getUsageAmount());
    }

    @Test
    public void setUsageAmountTest() {
        this.vehicle.setUsageAmount(5);
        assertEquals(5, this.vehicle.getUsageAmount());
    }

    @Test
    public void setCurrentUserTest() {
        User user = new Renter("renter");
        this.vehicle.setCurrentUser(user);
        assertEquals(user, this.vehicle.getCurrentUser());
    }
}

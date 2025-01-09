package vlille_test.visitor;

import vlille.visitor.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RenterTest extends UserTest {

    @Override
    protected User createUser() {
        return new Renter("renter");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("renter", this.user.getName());
        assertNull(this.user.getVehicle());
    }

    @Test
    public void visitTest() {
        Vehicle classicBike = new ClassicBike("classicBike");
        this.user.visit(classicBike);
        assertEquals(1, classicBike.getUsageAmount());
        assertEquals("Rented", this.user.getVehicle().getState().toString());
    }

    @Test
    public void twoRenterAreEqualsTest() {
        User anotherRenter = new Renter("renter");
        assertEquals(this.user, anotherRenter);
    }

    @Test
    public void twoRenterAreNotEqualsTest() {
        User anotherRenter = new Renter("anotherRenter");
        assertNotEquals(this.user, anotherRenter);
    }
}
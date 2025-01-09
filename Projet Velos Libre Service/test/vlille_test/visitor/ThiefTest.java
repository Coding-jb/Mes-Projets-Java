package vlille_test.visitor;

import vlille.visitor.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ThiefTest extends UserTest {

    @Override
    protected Thief createUser() {
        return new Thief("Thief");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("Thief", this.user.getName());
        assertNull(this.user.getVehicle());
    }

    @Test
    public void visitTest() {
        Vehicle classicBike = new ClassicBike("classicBike");
        this.user.visit(classicBike);
        assertEquals(1, classicBike.getUsageAmount());
        assertEquals("Stolen", classicBike.getState().toString());
    }

    @Test
    public void twoThiefAreEqualsTest() {
        User anotherThief = new Thief("Thief");
        assertEquals(this.user, anotherThief);
    }

    @Test
    public void twoThiefAreNotEqualsTest() {
        User anotherThief = new Thief("anotherThief");
        assertNotEquals(this.user, anotherThief);
    }
}

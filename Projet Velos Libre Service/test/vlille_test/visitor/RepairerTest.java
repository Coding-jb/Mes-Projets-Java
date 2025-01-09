package vlille_test.visitor;

import vlille.visitor.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RepairerTest extends UserTest {

    @Override
    protected User createUser() {
        return new Repairer("repairer");
    }

    @Test
    public void initialisationIsOK() {
        assertEquals("repairer", this.user.getName());
        assertNull(this.user.getVehicle());
    }

    @Test
    public void visitTest() {
        Vehicle classicBike = new ClassicBike("classicBike");
        this.user.visit(classicBike);
        assertEquals(0, classicBike.getUsageAmount());
        assertEquals("Available", classicBike.getState().toString());
    }

    @Test
    public void twoRepairerAreEqualsTest() {
        User anotherRepairer = new Repairer("repairer");
        assertEquals(this.user, anotherRepairer);
    }

    @Test
    public void twoRepairerAreNotEqualsTest() {
        User anotherRepairer = new Repairer("anotherRepairer");
        assertNotEquals(this.user, anotherRepairer);
    }
}

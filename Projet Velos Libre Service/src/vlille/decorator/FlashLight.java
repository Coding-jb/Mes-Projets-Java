package vlille.decorator;

import vlille.vehicle.Vehicle;
import vlille.visitor.User;
/**
 * FlashLight is a decorator that represents a vehicle with a flash light
 */
public class FlashLight extends VehicleDecorator {

    /**
     * Build a FlashLight decorator
     * @param vehicle the vehicle to decorate
     */
    public FlashLight(Vehicle vehicle) {
        super(vehicle);
    }

    /**
     * Accept the visitor
     * @param user the visitor
     */
    @Override
    public void accept(User user) {
        user.visit(this);
    }

    /**
     * Get a description of the vehicle
     * @return the description
     */
    @Override
    public String toString() {
        return this.vehicle.toString() + "\nWith Flash Light";
    }
}

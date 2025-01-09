package vlille.decorator;

import vlille.vehicle.Vehicle;
import vlille.visitor.User;
/**
 * Basket is a decorator that represents a vehicle with a basket
 */
public class Basket extends VehicleDecorator {

    /**
     * Build a basket decorator
     * @param vehicle the vehicle to decorate
     */
    public Basket(Vehicle vehicle) {
        super(vehicle);
    }

    /**
     * Accept the visitor
     * @param user the visitor
     */
    public void accept(User user) {
        user.visit(this);
    }

    /**
     * Get a description of the vehicle
     * @return the description
     */
    @Override
    public String toString() {
        return this.vehicle.toString() + "\nWith a Basket";
    }
}

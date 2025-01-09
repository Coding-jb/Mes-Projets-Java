package vlille.decorator;

import vlille.vehicle.Vehicle;
import vlille.visitor.User;
/**
 * LuggageRack is a decorator that represents a vehicle with a luggage rack
 */
public class LuggageRack extends VehicleDecorator {

    /**
     * Build a LuggageRack decorator
     * @param vehicle the vehicle to decorate
     */
    public LuggageRack(Vehicle vehicle) {
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
        return this.vehicle.toString() + "\nWith Luggage Rack";
    }
}

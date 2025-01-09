package vlille.visitor;

import vlille.vehicle.Vehicle;
/**
 * Renter class
 */
public class Renter extends User {

    /**
     * Build a new renter
     * @param name the name of the renter
     */
    public Renter(String name) {
        super(name);
    }

    /**
     * Visit method of a renter
     * @param vehicle the vehicle to visit
     */
    public void visit(Vehicle vehicle) {
        vehicle.incrementUsageAmount();
        vehicle.rent();
        this.setVehicle(vehicle);
    }

    /**
     * description of the renter
     * @return the description
     */
    @Override
    public String toString() {
        String description = "";
        description += "Renter name : " + this.getName() + super.toString();
        return description;
    }
}

package vlille.visitor;

import vlille.vehicle.Vehicle;
/**
 * Thief class
 */
public class Thief extends User {

    /**
     * Build a new repairer
     * @param name the name of the repairer
     */
    public Thief(String name) {
        super(name);
    }

    /**
     * Visit method of a renter
     * @param vehicle the vehicle to visit
     */
    public void visit(Vehicle vehicle) {
        vehicle.incrementUsageAmount();
        vehicle.steal();
        this.setVehicle(vehicle);
    }

    /**
     * description of the repairer
     * @return the description
     */
    @Override
    public String toString() {
        String description = "";
        description += "Thief name : " + this.getName() + super.toString();
        return description;
    }
}

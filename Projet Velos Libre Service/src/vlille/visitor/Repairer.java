package vlille.visitor;

import vlille.vehicle.Vehicle;
/**
 * Repairer class
 */
 public class Repairer extends User {

    /**
     * Build a new repairer
     * @param name the name of the repairer
     */
    public Repairer(String name) {
        super(name);
    }

    /**
     * Visit method of a renter
     * @param vehicle the vehicle to visit
     */
    public void visit(Vehicle vehicle) {
        vehicle.setUsageAmount(0);;
        vehicle.available();
    }

    /**
     * description of the repairer
     * @return the description
     */
    @Override
    public String toString() {
        String description = "";
        description += "Repairer name : " + this.getName() + super.toString();
        return description;
    }
}


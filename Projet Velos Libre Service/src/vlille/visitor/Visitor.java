package vlille.visitor;

import vlille.vehicle.Vehicle;
/**
 * Visit interface
 */
public interface Visitor {

    /**
     * visit method
     * @param vehicle the vehicle to visit
     */
    public void visit(Vehicle vehicle);
}

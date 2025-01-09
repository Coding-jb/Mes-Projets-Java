package vlille.vehicle;

import vlille.visitor.User;
/**
 * ElectricBike class
 */
 public class ElectricBike extends Vehicle {

    /**
     * Build an ElectricBike
     * @param electricBikeId the id of the ElectricBike
     */
    public ElectricBike(String electricBikeId) {
        super(electricBikeId);
    }

    /**
     * Accept a visitor
     * @param user the user
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
        String description = "";
        description +=  "\nType of the vehicle : ElectricBike" + super.toString();
        return description;
    }
}

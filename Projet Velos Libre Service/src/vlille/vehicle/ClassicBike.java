package vlille.vehicle;

import vlille.visitor.User;
/**
 * ClassicBike class
 */
public class ClassicBike extends Vehicle {

    /**
     * Build a ClassicBike
     * @param classicBikeId the id of the ClassicBike
     */
    public ClassicBike(String classicBikeId) {
        super(classicBikeId);
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
        String description = "";
        description +=  "\nType of the vehicle : ClassicBike" + super.toString();
        return description;
    }
}

package vlille.visitor;

import vlille.vehicle.*;
/**
 * user class
 */
public class User implements Visitor {

    /** the name of the user */
    protected String name;

    /** the vehicle of the user */
    protected Vehicle vehicle;

    /**
     * Build a new User
     * @param name the name of the user
     */
    public User(String name) {
        this.name = name;
        this.vehicle = null;
    }

    /**
     * Get the name of the user
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Get the vehicle of the user
     * @return the vehicle of the user
     */
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    /**
     * Set the vehicle of the user
     * @param vehicle the vehicle of the user
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * two users are equals if they have the same name
     * @param o the user
     * @return true if the name of the user is the same
     */
    @Override
    public boolean equals(Object o) {
        try {
            User user = (User) o;
            return this.getName().equals(user.getName());
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Visit method of the user
     * @param vehicle the vehicle to visit
     */
    public void visit(Vehicle vehicle) {
        vehicle.accept(this);
    }

    /**
     * Description of the VehicleVisitor
     * @return the description
     */
    public String toString() {
        String description = "";
        description +=  ", Has the Vehicle : " + this.getVehicle().toString() + "\n\n";
        return description;
    }
}

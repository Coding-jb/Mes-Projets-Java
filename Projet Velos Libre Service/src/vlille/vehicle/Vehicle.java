package vlille.vehicle;

import vlille.state.*;
import vlille.visitor.User;
/**
 * Vehicle class
 */
public abstract class Vehicle {

    /** the vehicle id */
    protected String vehicleId;

    /** the current user of the vehicle */
    protected User currentUser;

    /** number of usage of the vehicle */
    protected int usageAmount;

    /** the state of the vehicle */
    protected VehicleState state;


    /**
     * Build a new vehicle
     * @param vehicleId the vehicle id
     */
    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
        this.usageAmount = 0;
        this.state = new Available(this);
        this.currentUser = null;
    }

    /**
     * the vehicle id
     * @return the vehicle id
     */
    public String getVehicleId() {
        return this.vehicleId;
    }

    /**
     * the current user of the vehicle
     * @return the current user
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * the number of usage of the vehicle
     * @return the number of usage
     */
    public int getUsageAmount() {
        return this.usageAmount;
    }

    /**
     * the state of the vehicle
     * @return the state
     */
    public VehicleState getState() {
        return this.state;
    }

    /**
     * set the state of the vehicle
     * @param state the state
     */
    public void setState(VehicleState state) {
        this.state = state;
    }
    
    /**
     * increment usage number of the vehicle
     */
    public void incrementUsageAmount() {
        this.usageAmount += 1;
    }

    /**
     * set the usage amount of the vehicle
     * @param usageAmount the usage number
     */
    public void setUsageAmount(int usageAmount) {
        this.usageAmount = usageAmount;
    }

    /**
     * set the current user of the vehicle
     * @param user the current user
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    /**
     * two vehicles are equals if they have the same id
     * @param o the vehicle
     */
    @Override
    public boolean equals(Object o) {
        try {
            Vehicle vehicle = (Vehicle) o;
            return this.getVehicleId().equals(vehicle.getVehicleId());
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Change the state of the vehicle to rented
     */
    public void rent() {
        this.getState().rent();
    }

    /**
     * Change the state of the vehicle to available
     */
    public void available() {
        this.getState().available();
    }

    /**
     * Change the state of the vehicle to stolen
     */
    public void steal() {
        this.getState().steal();
    }

    /**
     * Change the state of the vehicle to out of service
     */
    public void outOfService() {
        this.getState().outOfService();
    }

    /**
     * Accept the visitor
     * @param user the visitor
     */
    public abstract void accept(User user);

    /**
     * Get a description of the vehicle
     * @return the description
     */
    public String toString() {
        String description = "";
        description +=  "\nIdentifier : " + this.getVehicleId() + "\nUsage Amount : " + this.getUsageAmount() + "\nState : " + this.getState().toString();
        return description;
    }
}

package vlille.state;

import vlille.vehicle.Vehicle;
/**
 * VehicleState is the abstract class for the state of a vehicle
 */
public abstract class VehicleState {

    /** the vehicle of the state */
    protected Vehicle vehicle;

    /**
     * Build a state for the vehicle
     * @param vehicle the vehicle of the state
     */
    public VehicleState(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Change the state of the vehicle to rented
     */
    public abstract void rent();

    /**
     * Change the state of the vehicle to available
     */
    public abstract void available();

    /**
     * Change the state of the vehicle to stolen
     */
    public abstract void steal();

    /**
     * Change the state of the vehicle to out of service
     */
    public abstract void outOfService();
}

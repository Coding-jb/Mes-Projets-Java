package vlille.state;

import vlille.vehicle.Vehicle;
/**
 * StolenState is the state of a vehicle when it is stolen
 */
public class Stolen extends VehicleState {

    /**
     * Build a new StolenState
     * @param vehicle the vehicle of the StolenState
     */
    public Stolen(Vehicle vehicle) {
        super(vehicle);
    }

    /**
     * Change the state of the vehicle to rented
     */
    public void rent() {
        return ;
    }

    /**
     * Change the state of the vehicle to available
     */
    public void available() {
        return ;
    }

    /**
     * Change the state of the vehicle to stolen
     */
    public void steal() {
        return ;
    }

    /**
     * Change the state of the vehicle to out of service
     */
    public void outOfService() {
        return ;
    }

    /**
     * Get the name of the state
     * @return the name of the state
     */
    public String toString() {
        return "Stolen";
    }
    
}

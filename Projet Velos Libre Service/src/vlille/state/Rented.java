package vlille.state;

import vlille.vehicle.Vehicle;
/**
 * Rented is the state of a vehicle when it is rented
 */
public class Rented extends VehicleState {

    /**
     * Build a new RentedState
     * @param vehicle the vehicle of the RentedState
     */
    public Rented(Vehicle vehicle) {
        super(vehicle);
    }

    /**
     * Change the state of the vehicle to rented
     */
    public void rent() {
        return ;
    }

    /**
     * Changhe the state of the vehicle to available
     */
    public void available() {
        this.vehicle.setState(new Available(this.vehicle));
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
        return "Rented";
    }

}

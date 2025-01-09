package vlille.state;

import vlille.vehicle.Vehicle;
/**
 * OutOfService is the state of a vehicle when it is out of service
 */
public class OutOfService extends VehicleState {

    /**
     * Build a new OutOfServiceState
     * @param vehicle the vehicle of the OutOfServiceState
     */
    public OutOfService(Vehicle vehicle) {
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
        return "OutOfService";
    }

}

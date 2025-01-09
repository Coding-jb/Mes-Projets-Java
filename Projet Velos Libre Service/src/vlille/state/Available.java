package vlille.state;

import vlille.vehicle.Vehicle;
/**
 * Availabe is the state of a vehicle when it is available
 */ 
public class Available extends VehicleState {

    /**
     * Build a new AvailableState
     * @param vehicle the vehicle of the AvailableState
     */
    public Available(Vehicle vehicle) {
        super(vehicle);
    }

    /**
     * Change the state of the vehicle to rented
     */
    public void rent() {
        this.vehicle.setState(new Rented(this.vehicle));
    }

    /**
     * Change the state of the vehicle to available
     */
    public void available() {
        return ;
    }

    /**
     * Ch ange the state of the vehicle to stolen
     */
    public void steal() {
        this.vehicle.setState(new Stolen(this.vehicle));
    }

    /**
     * Change the state of the vehicle to out of service
     */
    public void outOfService() {
        this.vehicle.setState(new OutOfService(this.vehicle));
    }

    /**
     * Get the name of the state
     * @return the name of the state
     */
    public String toString() {
        return "Available";
    }

}

package vlille.decorator;

import vlille.vehicle.Vehicle;
/**
 * VehicleDecorator is an abstract class that represents a vehicle with equipment
 */
public abstract class VehicleDecorator extends Vehicle{

    /** the vehicle decorate with the equipment */
    protected Vehicle vehicle;

    /**
     * Build a vehicle decorator 
     * @param vehicle the vehicle to decorate
     */
    public VehicleDecorator(Vehicle vehicle) {
        super(vehicle.getVehicleId());
        this.vehicle = vehicle;
    }
}

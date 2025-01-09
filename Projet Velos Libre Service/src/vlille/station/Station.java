package vlille.station;

import java.util.*;
import vlille.vehicle.Vehicle;
import vlille.visitor.User;
/**
 * Station class
 */
public abstract class Station {

    /** the station id */
    protected String stationId;

    /** the capacity of the station */
    protected final int capacity;

    /** the vehicles in the station */
    protected List<Vehicle> vehicles;

    /**
     * Build a station
     * @param stationId the station id
     */
    public Station(String stationId) {
        this.stationId = stationId;
        this.capacity = this.generateCapacity();
        this.vehicles = new ArrayList<Vehicle>(this.capacity);
        this.initStation();
    }
    
    /**
     * Get the station id
     * @return the station id
     */
    public String getStationId() {
        return this.stationId;
    }

    /**
     * Get the vehicles in the station
     * @return the vehicles
     */
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Get a vehicle in the station
     * @param index the index of the vehicle
     * @return the vehicle
     */
    public Vehicle getVehicle(int index) {
        return this.getVehicles().get(index);
    }

    /**
     * Get the capacity of the station
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Initialize the station
     */
    protected abstract void initStation();

    /**
     * random capacity of the station
     * @return the capacity
     */
    protected abstract int generateCapacity();

    /**
     * Add a vehicle to the station
     * @param vehicle the vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        this.getVehicles().add(vehicle);
    }

    /** 
     * removes vehicle from the station 
     * @param vehicle the vehicle to remove
     */
    public void removeVehicle(Vehicle vehicle) {
        this.getVehicles().remove(vehicle);
    }

    /**
     * Rent a vehicle from the station
     * @param user the user which rents the vehicle
     * @param vehicle the vehicle to rent
     */
    public void rentVehicle(User user, Vehicle vehicle) {
        // only rent an available vehicle
        if (vehicle.getState().toString().equals("Available")) {
            // remove the vehicle from the station
            this.removeVehicle(vehicle);
            // set the user of the vehicle
            vehicle.setCurrentUser(user);
            // visit the vehicle
            user.visit(vehicle);
        }
    }

    /**
     * Steal a vehicle from the station
     * A vehicle is stolen when available and time is greater than 2 time intervals
     * @param user the user which steals the vehicle
     * @param vehicle the vehicle to steal
     */
    public void stealVehicle(User user, Vehicle vehicle) {
        // check if user has a vehicle and if it has the Available state
        if (vehicle.getState().toString().equals("Available")) {
            // remove the vehicle from the station
            this.removeVehicle(vehicle);
            // set the user of the vehicle
            vehicle.setCurrentUser(user);
            // visit the vehicle
            user.visit(vehicle);
        }
    }

    /**
     * Return a vehcile to the station
     * @param user the user which returns the vehicle
     */
    public void returnVehicle(User user) {
        // check if user has a vehicle and if it has the Rented state
        if (user.getVehicle().getState().toString().equals("Rented")) {
            Vehicle vehicleToReturn = user.getVehicle();
            // set the state of the vehicle to available
            vehicleToReturn.available();
            // remove the user from the vehicle
            vehicleToReturn.setCurrentUser(null);
            // remove the vehicle from the user
            user.setVehicle(null);
            // add the vehicle to the station
            this.addVehicle(vehicleToReturn);
        }
    }

    /**
     * Repair all out of service vehicles in the station
     * @param user the user which repairs the vehicles
     */
    public void repairVehicles(User user) {
        // repair all out of service vehicles
        for (Vehicle vehicle : this.getVehicles()) {
            if (vehicle.getState().toString().equals("OutOfService")) {
                user.visit(vehicle);
            }
        }
    }

    /**
     * two stations are equals if they have the same id
     * @param o the station
     */
    public boolean equals(Object o) {
        try {
            Station station = (Station) o;
            return this.getStationId().equals(station.getStationId());
        } catch (ClassCastException e) {
            return false;
        }
    }

    /**
     * Get a description of the station
     * @return the description
     */
    public String toString() {
        String description = "";
        description +=  "\tCapacity : " + this.getCapacity() + "\tWith : " + this.getVehicles().size() + " vehicles\n";
        for (Vehicle vehicle : this.getVehicles()) {
            description += vehicle.toString() + "\n";
        }
        return description;
    }
    
}

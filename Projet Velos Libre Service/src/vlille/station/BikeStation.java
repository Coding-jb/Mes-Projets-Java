package vlille.station;

import java.util.Random;
import vlille.vehicle.*;
/**
 * BikeStation class
 */
public class BikeStation extends Station {

    /**
     * Build a BikeStation
     * @param bikeStationId the bike station id
     */
    public BikeStation(String bikeStationId) {
        super(bikeStationId);
    }

    /**
     * Initialize the BikeStation
     */
    @Override
    public void initStation() {
        for (int i = 0; i < this.getCapacity()/2; i++) {
            // add an electricbike with a flashlight and a luggage rack
            this.addVehicle((new ElectricBike(this.getStationId() + "-" + " ElectricBike " + i)));         
        }
    }

    /**
     * random capacity of the station between 10 and 20
     * @return the capacity
     */
    public int generateCapacity() {
        int min = 10;
        int max = 20;
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    /**
     * Get a description of the bike station
     * @return a description of the bike station
     */
    public String toString() {
        String description = "";
        description += "BikeStation :" + this.getStationId() + super.toString();
        return description;
    }

}

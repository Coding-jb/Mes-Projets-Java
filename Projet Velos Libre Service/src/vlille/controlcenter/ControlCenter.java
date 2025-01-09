package vlille.controlcenter;

import java.util.*;
import vlille.station.*;
import vlille.strategy.*;
import vlille.vehicle.Vehicle;
import vlille.observer.Observer;
/**
 * The control center of the V'Lille system
 */
public class ControlCenter implements Observer {

    /** The usage limit of a bike */
    public static final int BIKE_USAGE_LIMIT = 1;

    /** The stations managed by the control center */
    protected List<Station> stations;

    /** The redistribution strategy of the control center */
    private RedistributionStrategy strategy;

    /**
     * Build a control center
     * @param nbStations the number of stations to manage
     */
    public ControlCenter(int nbStations) {

        this.stations = new ArrayList<Station>(nbStations);

        for (int i = 0; i < nbStations; i++) {
            this.getStations().add(new BikeStation("BikeStation " + i));
        }

        this.strategy = new RoundRobin();
    }

    /**
     * Get the number of stations managed by the control center
     * @return the number of stations
     */
    public int getNbStations() {
        return this.getStations().size();
    }

    /**
     * Get all the stations managed by the control center
     * @return the stations
     */
    public List<Station> getStations() {
        return this.stations;
    }

    /**
     * Get a station managed by the control center
     * @param index the index of the station
     * @return the station
     */
    public Station getStation(int index) {
        return this.getStations().get(index);
    }

    /**
     * Get the redistribution strategy of the control center
     * @return the redistribution strategy
     */
    public RedistributionStrategy getStrategy() {
        return this.strategy;
    }

    /**
     * Set the redistribution strategy of the control center
     * @param strategy the redistribution strategy
     */
    public void setStrategy(RedistributionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Set the stations of the control center
     * @param stations the stations to set
     */
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    /**
     * Add a station to the control center
     * @param station the station to add
     */
    public void addStation(Station station) {
        this.getStations().add(station);
    }

    /**
     * Redistribution vehicles in the stations
     * If a station is empty or full for more than two interval of time, the control center will redistribute the vehicles in the stations
     */ 
    public void redistribute() {
    
        // create a copy of the stations to avoid concurrent modification exception
        List<Station> stationsCopy = new ArrayList<Station>(this.getStations());
        
        List<Station> redistributedStations = this.getStrategy().redistribute(stationsCopy);
        
        this.setStations(redistributedStations);
    }
    

    /**
     * Update the states of the vehicles in the stations
     * If the usage amount of a vehicle is greater than the usage limit, the vehicle will be out of service
     */
    public void update() {
        for (Station station : this.getStations()) {
            for (Vehicle vehicle : station.getVehicles()) {
                if (vehicle.getUsageAmount() >= BIKE_USAGE_LIMIT) {
                    vehicle.outOfService();
                }
            }
        }
    }

    /**
     * Get a description of the control center
     * @return a description of the control center
     */
    public String toString() {
        String description = "ControlCenter with " + this.getStations().size() + " stations" + "\nRedistribution strategy : " + this.getStrategy().toString() + "\n";
        for (Station station : this.getStations()) {
            description += station.toString() + "\n";
        }
        return description;
    }

}

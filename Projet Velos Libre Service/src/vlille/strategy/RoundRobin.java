package vlille.strategy;

import java.util.*;
import vlille.station.Station;
import vlille.vehicle.Vehicle;
/**
 * A strategy to redistribute the vehicles in the stations using a round-robin algorithm.
 */
public class RoundRobin implements RedistributionStrategy {

    /**
     * A strategy to redistribute the vehicles in the stations using a round-robin algorithm.
     */
    public RoundRobin() {}
    
    /**
     * Redistribution vehicles in the stations
     * If a station is empty or full for more than two interval of time, the control center will redistribute the vehicles in the stations
     * A Round Robin redistribution algorithm is use : the first station is chosen, then the second, then the third, and so on
     * until there is no more vehicle to distribute
     * @param stations the stations to redistribute
     */ 
    public List<Station> redistribute(List<Station> stations) {

        // all the vehicles from all the stations
        List<Vehicle> allVehicles = new ArrayList<Vehicle>();
        for (Station station : stations) {
            List<Vehicle> vehicles = station.getVehicles();
            allVehicles.addAll(vehicles);
            station.getVehicles().removeAll(vehicles);
        }
        // shuffle the vehicles
        Collections.shuffle(allVehicles);
        // distribute the vehicles in the stations
        for(int i = 0; i < allVehicles.size(); i++) {
            // choose the current station
            Station station = stations.get(i % stations.size());
            // choose the current vehicle
            Vehicle vehicle = allVehicles.get(i);
            // add the vehicle to the station
            station.addVehicle(vehicle);
        }
        return stations;
    }    

    /**
     * Get a description of the round-robin redistribution strategy
     * @return a description of the round-robin redistribution strategy
     */
    public String toString() {
        return "Round-robin";
    }
}



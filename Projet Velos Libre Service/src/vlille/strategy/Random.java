package vlille.strategy;

import java.util.*;
import vlille.station.Station;
import vlille.vehicle.Vehicle;
/**
 * A strategy to redistribute the vehicles in the stations using a random algorithm.
 */
public class Random implements RedistributionStrategy {

    /**
     * A strategy to redistribute the vehicles in the stations using a random algorithm
     */
    public Random() {}

    /**
     * Redistribution vehicles in the stations
     * If a station is empty or full for more than two interval of time, the control center will redistribute the vehicles in the stations
     * A Random redistribution algorithm is use : a random station is chosen to distribute, and so on
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
       java.util.Random random = new java.util.Random();
       // redistribute a vehicle in a random station
       for (Vehicle vehicle : allVehicles) {
           // choose the current station
           Station station = stations.get(random.nextInt(stations.size()));
           // add the vehicle to the station
           station.addVehicle(vehicle);
        }
       return stations;
    }

    /**
     * Get a description of the random redistribution strategy
     * @return a description of the random redistribution strategy
     */
    public String toString() {
        return "Random";
    }
}

package vlille;

import java.util.*;
import vlille.station.*;
import vlille.vehicle.Vehicle;
import vlille.visitor.*;
import vlille.controlcenter.ControlCenter;
/**
 * Simulation class
 */
public class Simulation {

    // A ControlCenter for Bike Stations
    private ControlCenter controlCenter;

    // A list of renters
    private List<User> renters;

    // A list of thieves
    private List<User> thieves;

    // A Repairer
    private Repairer repairer;

    /**
     * Build a Simulation with a BikeStationControlCenter, 
     * @param controlCenter a BikeStationControlCenter
     * @param nbRenters the number of renters
     * @param nbThieves the number of thieves
     */
    public Simulation(ControlCenter controlCenter, int nbRenters, int nbThieves) {

        this.controlCenter = controlCenter;

        this.renters = new ArrayList<User>();
        
        for (int i = 0; i < nbRenters; i++) {
            this.renters.add(new Renter("Renter " + i));
        }

        this.thieves = new ArrayList<User>();
        for (int i = 0; i < nbThieves; i++) {
            this.thieves.add(new Thief("Thief " + i));
        }

        this.repairer = new Repairer("Repairer");
    }

    /**
     * Get the BikeStationControlCenter of this Simulation
     * @return the BikeStationControlCenter
     */
    public ControlCenter getControlCenter() {
        return this.controlCenter;
    }

    /**
     * Get the renters of this Simulation
     * @return the renters
     */
    public List<User> getRenters() {
        return this.renters;
    }

    /**
     * Get a Renter 
     * @param index the index of the renter
     * @return a Renter
     */
    public User getRenter(int index) {
        return this.getRenters().get(index);
    }

    /**
     * Get the thieves of this Simulation
     * @return the thieves
     */
    public List<User> getThieves() {
        return this.thieves;
    }

    /**
     * Get a Thief
     * @param index the index of the thief
     * @return a Thief
     */
    public User getThief(int index) {
        return this.getThieves().get(index);
    }
    
    /**
     * Get the repairer of this Simulation
     * @return the repairer
     */
    public User getRepairer() {
        return this.repairer;
    }

    /**
     * Play the Simulation
     * @return a description of the simulation
     */
    public String play() {
        String description = "**************  Initial Stations  **************\n\n";
    
        // Initial stations
        description += this.getControlCenter().toString();
    
        // Rent all vehicles in the first station
        description += "**************  Rent all vehicles in the first station  **************\n\n";
    
        Station firstStation = this.getControlCenter().getStation(0);
    
        // Créez une copie de la liste des véhicules pour éviter les problèmes de modification concurrente
        List<Vehicle> firstStationVehicles = firstStation.getVehicles();
    
        while (!firstStationVehicles.isEmpty()) {

            // choose a random vehicle to rent
            Vehicle vehicle = firstStationVehicles.get((new Random()).nextInt(firstStationVehicles.size()));
    
            // choose a random renter
            User renter = this.getRenter((new Random()).nextInt(this.getRenters().size()));
    
            // rent the vehicle
            firstStation.rentVehicle(renter, vehicle);

            description += renter.toString();
        }

        description += "**************  All stations after rentals  **************\n\n";

        description += this.getControlCenter().toString();

        // Redistribute the vehicles in the stations
        description += "**************  Redistribution of vehicles in the stations with : " + this.getControlCenter().getStrategy().toString() +  " strategy  **************\n\n";

        // Redistribute the vehicles in the stations
        this.getControlCenter().redistribute();
    
        description += this.getControlCenter().toString();

        // Steal vehicles in the first station
        description += "**************  Steal vehicles in the first station  **************\n\n";

        Station firstStation1 = this.getControlCenter().getStation(0);

        // Créez une copie de la liste des véhicules pour éviter les problèmes de modification concurrente
        List<Vehicle> firstStationVehicles1 = firstStation1.getVehicles();

        while (!firstStationVehicles1.isEmpty()) {

            // choose a random vehicle to steal
            Vehicle vehicle = firstStationVehicles1.get((new Random()).nextInt(firstStationVehicles1.size()));

            // choose a random thief
            User thief = this.getThief((new Random()).nextInt(this.getThieves().size()));

            // steal the vehicle
            firstStation1.stealVehicle(thief, vehicle);

            description += thief.toString();
        }

        description += "**************  All stations after thefts  **************\n\n";

        description += this.getControlCenter().toString();

        // Return vehicles in the first station
        description += "**************  Return vehicles in the first station  **************\n\n";

        Station firstStation2 = this.getControlCenter().getStation(0);

        for(User renter : this.getRenters()) {
            if(renter.getVehicle() != null) {
                firstStation2.returnVehicle(renter);
            }
        }

        description += this.getControlCenter().toString();

        // update the states of the vehicles in the stations
        description += "**************  Update the states of the vehicles in the stations  **************\n\n";
        
        // update the states of the vehicles in the stations
        this.getControlCenter().update();

        description += this.getControlCenter().toString();

        // Repair vehicles in the first station
        description += "**************  Repair vehicles in the first station  **************\n\n";

        Station firstStation3 = this.getControlCenter().getStation(0);

        // Repair vehicles in the first station
        firstStation3.repairVehicles(this.getRepairer());

        description += this.getControlCenter().toString();

        return description;
    }
}

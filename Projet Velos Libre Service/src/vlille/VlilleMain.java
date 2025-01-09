package vlille;

import vlille.controlcenter.ControlCenter;
/**
 * VlilleMain class
 */
public class VlilleMain {

    /**
     * Default constructor for VlilleMain 
     */
    public VlilleMain() {}

    /**
     * Main Method for VlilleMain
     * @param args the arguments
     */
    public static void main(String[] args) {
     
        ControlCenter controlCenter = new ControlCenter(2);
        Simulation simulation = new Simulation(controlCenter, 15, 10);
        System.out.println(simulation.play());
    }
}

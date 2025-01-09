package vlille.observer;
/**
 * Interface Observer
 */
public interface Observer {

    /**
     * Update the states of the vehicles in the stations 
     * If the usage amount of a vehicle is greater than the usage limit, the vehicle will be out of service
     */
    public void update();
}

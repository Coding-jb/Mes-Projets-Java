package vlille.strategy;

import java.util.List;
import vlille.station.Station;
/**
 * A strategy to redistribute the vehicles in the stations
 */
public interface RedistributionStrategy {

    /**
     * Redistribution vehicles in stations
     * @param stations the stations to redistribute
     * @return the redistributed stations
     */ 
    public List<Station> redistribute(List<Station> stations);

}

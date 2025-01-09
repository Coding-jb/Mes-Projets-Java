package vlille_test.controlcenter;

import vlille.controlcenter.ControlCenter;
import vlille.station.*;
import vlille.vehicle.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class ControlCenterTest {

    private ControlCenter controlCenter;

    @BeforeEach
    public void init() {
        this.controlCenter = new ControlCenter(3);
    }

    @Test
    public void initialisationIsOK() {
        assertEquals(3, controlCenter.getNbStations());
        assertNotNull(controlCenter.getStations());
        assertNotNull(controlCenter.getStrategy());
    } 

    @Test
    public void getStationTest() {
        assertEquals(controlCenter.getStations().get(0), controlCenter.getStation(0));
    }

    @Test
    public void addStationTest() {
        Station station = new BikeStation("BikeStation");
        controlCenter.addStation(station);
        assertEquals(controlCenter.getStation(3), station);
    }

    @Test
    public void redistributeTest() {
        controlCenter.redistribute();
        assertEquals(3, controlCenter.getNbStations());
    }

    @Test
    public void updateTest() {
        controlCenter.update();
        for (Station station : controlCenter.getStations()) {
            for (Vehicle vehicle : station.getVehicles()) {
                if (vehicle.getUsageAmount() >= ControlCenter.BIKE_USAGE_LIMIT) {
                    assertEquals("OutOfService", vehicle.getState().toString());
                }
            }
        }
    }


}

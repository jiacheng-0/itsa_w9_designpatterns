package itsa.patterns;

import org.junit.Test;

public class ObserverExampleTest {
    @Test
    public void testObserver() {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.register(new Gates());
        sensorSystem.register(new Lighting());
        sensorSystem.register(new Surveillance());

        String message = sensorSystem.soundTheAlarm();
        // System.out.println(message);
        assert message.equals("Gates are activated.Lightings are activated.Surveillance are activated.") : "Sensors not working properly";
    }
}

package itsa.patterns;

import java.util.ArrayList;

class SensorSystem {

    ArrayList<SensorInterface> sensorInterfaceList = new ArrayList<>();

    public void register(SensorInterface sensorInterface) {
        sensorInterfaceList.add(sensorInterface);
    }

    public String soundTheAlarm() {
        // when this method is called, invoke
        // the gates with output "Gates are activated."
        // the lighting with output "Lightings are activated."
        // the Surveillance with output "Surveillance are activated."

        // return "The Sensor System is activated";

        StringBuilder sb = new StringBuilder();
        for (SensorInterface s: sensorInterfaceList) {
            sb.append(s.alarm());
        }
        return sb.toString();
    }
}

interface SensorInterface {
    public String alarm();
    // {
    //     return "A Sensor is activated.";
    // }
}

class Gates implements SensorInterface {
    public String alarm() {
        System.out.println("Gates are activated.");
        return "Gates are activated.";
    }
}

class Lighting implements SensorInterface {
    public String alarm() {
        System.out.println("Lightings are activated.");
        return "Lightings are activated.";
    }
}

class Surveillance implements SensorInterface {
    public String alarm() {
        System.out.println("Surveillance are activated.");
        return "Surveillance are activated.";
    }
}

public class ObserverExample {
    public static void main(String[] args) {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.register(new Gates());
        sensorSystem.register(new Lighting());
        sensorSystem.register(new Surveillance());

        String message = sensorSystem.soundTheAlarm();
        // expected output is "Gates are activated.Lightings are activated.Surveillance are activated."
        System.out.println(message);
    }
}

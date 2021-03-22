package itsa.patterns;

import java.util.ArrayList;

class SensorSystem {

    public String soundTheAlarm() {
        // when this method is called, invoke
        // the gates with output "Gates are activated."
        // the lighting with output "Lightings are activated."
        // the Surveillance with output "Surveillance are activated."

        // new Gates().alarm();
        // new Lighting().alarm();
        // new Surveillance().alarm();
        // return "The Sensor System is activated";

        StringBuilder sb = new StringBuilder();
        for (Sensor s: sensorList) {
            sb.append(s.alarm());
        }
        return sb.toString();
    }

    ArrayList<Sensor> sensorList = new ArrayList<>();

    public void register(Sensor sensor) {
        sensorList.add(sensor);
    }
}

class Sensor {
    public String alarm() {
        return "A Sensor is activated.";
    }
}

class Gates extends Sensor {
    public String alarm() {
        System.out.println("Gates are activated.");
        return "Gates are activated.";
    }
}

class Lighting extends Sensor {
    public String alarm() {
        System.out.println("Lightings are activated.");
        return "Lightings are activated.";
    }
}

class Surveillance extends Sensor {
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

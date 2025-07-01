// Single Inheritance

class Device {
    String deviceId;
    String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
        System.out.println("Temperature: " + temperatureSetting + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("T100", "ON", 23.5);
        t.displayStatus();
    }
}

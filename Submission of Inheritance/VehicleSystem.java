// Hybrid Inheritance (with Interface)

class Vehicle {
    int maxSpeed;
    String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(model + " is charging...");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println(model + " is refueling...");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(180, "Tesla Model 3");
        PetrolVehicle pv = new PetrolVehicle(220, "Honda City");

        ev.charge();
        pv.refuel();
    }
}

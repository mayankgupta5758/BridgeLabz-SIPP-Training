import java.util.*;

class Vehicle {
    protected String brand;
    protected String model;
    protected String fuelType;

    public Vehicle(String brand, String model, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double calculateServiceCost() {
        return 0.0;
    }

    public void printServiceDetails() {
        System.out.println("Generic Vehicle Service Details");
    }
}

class Car extends Vehicle {
    public Car(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 50000.0;
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Car Service: " + getBrand() + " " + getModel() + ", Cost: ₹" + calculateServiceCost());
    }
}

class Bike extends Vehicle {

    public Bike(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 10000.0;
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Bike Service: " + getBrand() + " " + getModel() + ", Cost: ₹" + calculateServiceCost());
    }

}

class Truck extends Vehicle {

    public Truck(String brand, String model, String fuelType) {
        super(brand, model, fuelType);
    }

    @Override
    public double calculateServiceCost() {
        return 100000.0;
    }

    @Override
    public void printServiceDetails() {
        System.out.println("Truck Service: " + getBrand() + " " + getModel() + ", Cost: " + calculateServiceCost() + "Rs.");
    }

}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        List<Vehicle> garage = new ArrayList<>();

        garage.add(new Bike("Kawasaki", "Ninja H2R", "Petrol"));
        garage.add(new Bike("Yamaha", "FZ", "Petrol"));

        garage.add(new Car("Honda", "City", "Petrol"));
        garage.add(new Vehicle("BMW", "CS M5", "Diesel"));

        garage.add(new Truck("Tata", "Ultra", "Diesel"));

        System.out.println("=== Vehicle Service Details ===");
        for (Vehicle v : garage) {
            v.printServiceDetails(); // Polymorphism in action
        }
    }
}

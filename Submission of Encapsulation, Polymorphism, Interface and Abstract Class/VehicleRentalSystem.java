
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String number, String type, double rate) {
        super(number, type, rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 2000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: Rs. 2000";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, String type, double rate) {
        super(number, type, rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: Rs. 500";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String number, String type, double rate) {
        super(number, type, rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 3000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: Rs. 3000";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("MH12AB1234", "Car", 1000),
            new Bike("MH12XY4321", "Bike", 300),
            new Truck("MH12TR5678", "Truck", 1500)
        };

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getType() + ", Number: " + v.getVehicleNumber());
            System.out.println("Rental for 3 days: Rs. " + v.calculateRentalCost(3));
            System.out.println(((Insurable)v).getInsuranceDetails());
            System.out.println("Insurance: Rs. " + ((Insurable)v).calculateInsurance());
            System.out.println();
        }
    }
}
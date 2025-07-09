import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Rentable {
    List<String> calculateRent(int days);
}

abstract class Vehicle implements Rentable {
    protected int days;

    public Vehicle(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}

class Bike extends Vehicle {
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<>();

    public Bike(int days) {
        super(days);
        System.out.println("Here You Can Find Some Bikes.");
    }

    @Override
    public List<String> calculateRent(int days) {
        System.out.println("Choose Bike:");
        System.out.println("1. H2R");
        System.out.println("2. ZX10R");
        System.out.print("Enter option (1 or 2): ");
        list.add("bike");

        int baseRate = 0, subcharges = 0;
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                list.add("H2R");
                baseRate = 10;
                subcharges = 20;
            }
            case 2 -> {
                list.add("ZX10R");
                baseRate = 5;
                subcharges = 10;
            }
            default -> {
                System.out.println("Invalid option.");
                return null;
            }
        }

        System.out.println("Total Rent = " + (baseRate * days + subcharges));
        list.add("" + (baseRate * days + subcharges));
        return list;
    }
}

class Car extends Vehicle {
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<>();

    public Car(int days) {
        super(days);
        System.out.println("Here You Can Find Some Cars.");
    }

    @Override
    public List<String> calculateRent(int days) {
        List<String> list = new ArrayList<>();

        System.out.println("Choose Car:");
        System.out.println("1. Lambo Cyan");
        System.out.println("2. BMW CS M5");
        System.out.print("Enter option (1 or 2): ");
        list.add("Car");

        int baseRate = 0, subcharges = 0;
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                list.add("Lambo Cyan");
                baseRate = 10;
                subcharges = 20;
            }
            case 2 -> {
                list.add("BMW CS M5");
                baseRate = 5;
                subcharges = 10;
            }
            default -> {
                System.out.println("Invalid option.");
                return null;
            }
        }

        System.out.println("Total Rent = " + (baseRate * days + subcharges));
        list.add("" + (baseRate * days + subcharges));
        return list;
    }
}

class Truck extends Vehicle {
    Scanner sc = new Scanner(System.in);
    List<String> list = new ArrayList<>();

    public Truck(int days) {
        super(days);
        System.out.println("Here You Can Find Some Trucks.");
    }

    @Override
    public List<String> calculateRent(int days) {
        List<String> list = new ArrayList<>();

        System.out.println("Choose Truck:");
        System.out.println("1. Mahindra");
        System.out.println("2. TATA");
        System.out.print("Enter option (1 or 2): ");

        int baseRate = 0, subcharges = 0;
        int choice = sc.nextInt();
        list.add("Truck");

        switch (choice) {
            case 1 -> {
                list.add("Mahindra");
                baseRate = 10;
                subcharges = 20;
            }
            case 2 -> {
                list.add("TATA");
                baseRate = 5;
                subcharges = 10;
            }
            default -> {
                System.out.println("Invalid option.");
                return null;
            }
        }

        System.out.println("Total Rent = " + (baseRate * days + subcharges));
        list.add("" + (baseRate * days + subcharges));
        return list;
    }
}

class Customer {
    Scanner sc = new Scanner(System.in);
    List<List<String>> history = new ArrayList<>();

    public void startRental() {
        System.out.println("Welcome to the Vehicle Rental System!");
        while (true) {
            System.out.print("Do you want to rent a vehicle? (1 = Yes, 0 = No): ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Choose Vehicle Type:");
                System.out.println("1. Car");
                System.out.println("2. Bike");
                System.out.println("3. Truck");
                int type = sc.nextInt();

                System.out.print("Enter number of days to rent: ");
                int days = sc.nextInt();

                switch (type) {
                    case 1 -> {
                        Car car = new Car(days);
                        List<String> list = new ArrayList<>();
                        list = car.calculateRent(days);
                        list.add("" + days);
                        history.add(new ArrayList<>(list));
                    }
                    case 2 -> {
                        Bike bike = new Bike(days);
                        List<String> list = new ArrayList<>();
                        list = bike.calculateRent(days);
                        list.add("" + days);
                        history.add(new ArrayList<>(list));
                    }
                    case 3 -> {
                        Truck truck = new Truck(days);
                        List<String> list = new ArrayList<>();
                        list = truck.calculateRent(days);
                        list.add("" + days);
                        history.add(new ArrayList<>(list));
                    }
                    default -> System.out.println("Invalid vehicle type.");
                }
            } else {
                for (int i = 0; i < history.size(); i++) {
                    System.out.println(
                            history.get(i).get(0) + " " + history.get(i).get(1) + " " + history.get(i).get(2) + " "
                                    + history.get(i).get(3));
                }

                System.out.println("Why you come then🤬🤬🤬");
                return;
            }
        }
    }
}

public class VehicleRentalApplication {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.startRental();
    }
}
abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void printBill() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;

        System.out.println("Product: " + name);
        System.out.println("Original Price: " + price + "Rs.");
        System.out.println("Discount: " + discount + "Rs.");
        System.out.println("Final Price: " + finalPrice + "Rs.");
        System.out.println("-----------------------------");
    }
}

class Electronics extends Product {

    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; 
    }
}

class Clothing extends Product {

    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20;
    }
}

class Grocery extends Product {

    public Grocery(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        return 0; 
    }
}





public class OnlineStoreBillingSystem {
    public static void main(String[] args) {
        Product[] cart = {
            new Electronics("Laptop", 50000),
            new Clothing("T-Shirt", 1000),
            new Grocery("Rice", 800)
        };

        System.out.println("------- Bill Details -------");
        for (Product item : cart) {
            item.printBill();
        }
    }
}


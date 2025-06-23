
public class Item {
    int itemCode;
    String itemName;
    double price;

    public Item(int code, String name, double price) {
        this.itemCode = code;
        this.itemName = name;
        this.price = price;
    }

    public void displayDetails(int quantity) {
        double total = quantity * price;
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: ₹" + price);
        System.out.println("Total Cost for " + quantity + " units: ₹" + total);
    }

    public static void main(String[] args) {
        Item item = new Item(101, "Pen", 10);
        item.displayDetails(5);
    }
}

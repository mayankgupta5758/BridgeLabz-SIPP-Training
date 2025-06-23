import java.util.*;

public class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity = qty;
    }

    public double totalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {
        ArrayList<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem("Book", 250, 2));
        cart.add(new CartItem("Pen", 10, 5));

        double total = 0;
        for (CartItem item : cart) {
            System.out.println(item.itemName + " x" + item.quantity + " = ₹" + item.totalCost());
            total += item.totalCost();
        }

        System.out.println("Total Cost: ₹" + total);
    }
}

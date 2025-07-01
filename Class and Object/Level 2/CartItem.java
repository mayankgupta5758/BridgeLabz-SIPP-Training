import java.util.ArrayList;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Cart operations
    public static class Cart {
        private ArrayList<CartItem> items = new ArrayList<>();

        public void addItem(CartItem item) {
            for (CartItem ci : items) {
                if (ci.getItemName().equals(item.getItemName())) {
                    ci.setQuantity(ci.getQuantity() + item.getQuantity());
                    return;
                }
            }
            items.add(item);
        }

        public void removeItem(String itemName) {
            items.removeIf(ci -> ci.getItemName().equals(itemName));
        }

        public void displayTotalCost() {
            double total = 0;
            for (CartItem ci : items) {
                total += ci.getPrice() * ci.getQuantity();
            }
            System.out.println("Total Cost: " + total);
        }
    }
}
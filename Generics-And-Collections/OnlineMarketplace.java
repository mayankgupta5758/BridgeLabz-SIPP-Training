class BookCategory {
    private String genre;
    public BookCategory(String genre) { this.genre = genre; }
    public String getGenre() { return genre; }
}

class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setPrice(double price) { this.price = price; }
    public double getPrice() { return price; }
    public String getName() { return name; }
    public T getCategory() { return category; }
}

class MarketplaceUtils {
    public static <T> void applyDiscount(Product<T> product, double percentage) {
        double discounted = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discounted);
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 499.99, new BookCategory("Tech"));
        MarketplaceUtils.applyDiscount(book, 10);
        System.out.println("Discounted Price: " + book.getPrice());
    }
}

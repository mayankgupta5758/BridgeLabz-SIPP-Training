public class Bookl {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Bookl(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public boolean borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed: " + title);
            return true;
        } else {
            System.out.println("Book not available: " + title);
            return false;
        }
    }
} 
    

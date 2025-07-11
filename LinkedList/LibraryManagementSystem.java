class Book {
    String title, author, genre;
    int id;
    boolean isAvailable;
    Book next, prev;

    Book(String title, String author, String genre, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManagementSystem {
    Book head = null, tail = null;

    void addAtEnd(String title, String author, String genre, int id, boolean isAvailable) {
        Book b = new Book(title, author, genre, id, isAvailable);
        if (head == null) head = tail = b;
        else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;

                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;

                return;
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title + " by " + temp.author);
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + (temp.isAvailable ? "Available" : "Issued"));
            temp = temp.next;
        }
    }

    void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        lib.addAtEnd("Java", "James", "Tech", 1, true);
        lib.addAtEnd("Python", "Guido", "Tech", 2, false);
        lib.displayForward();
        lib.countBooks();
    }
}

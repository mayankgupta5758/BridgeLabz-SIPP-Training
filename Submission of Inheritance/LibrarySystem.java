// Single Inheritance

class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Published Year: " + publicationYear);
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Author author = new Author("Wings of Fire", 1999, "A.P.J. Abdul Kalam", "Former President of India and Scientist");
        author.displayInfo();
    }
}

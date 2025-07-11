class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next, prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

public class MovieManagementSystem {
    Movie head = null, tail = null;

    void addAtEnd(String title, String dir, int year, double rate) {
        Movie newMovie = new Movie(title, dir, year, rate);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    void addAtBeginning(String title, String dir, int year, double rate) {
        Movie newMovie = new Movie(title, dir, year, rate);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    void deleteByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;

                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;

                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    void searchByDirector(String dir) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(dir))
                System.out.println(temp.title + " (" + temp.year + ")");
            temp = temp.next;
        }
    }

    void searchByRating(double rate) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rate)
                System.out.println(temp.title + " - " + temp.director);
            temp = temp.next;
        }
    }

    void updateRating(String title, double newRate) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRate;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        mms.addAtEnd("Inception", "Nolan", 2010, 8.8);
        mms.addAtBeginning("Interstellar", "Nolan", 2014, 8.6);
        mms.displayForward();
        mms.updateRating("Inception", 9.0);
        mms.displayReverse();
    }
}

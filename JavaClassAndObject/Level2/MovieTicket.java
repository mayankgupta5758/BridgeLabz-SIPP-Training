public class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    public void bookTicket(String name, int seat, double cost) {
        movieName = name;
        seatNumber = seat;
        price = cost;
    }

    public void displayTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Jawan", 25, 250);
        ticket.displayTicket();
    }
}

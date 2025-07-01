public class MovieTicket {
    private String movieName;
    private int seatNumber;
    private double price;
    private boolean booked = false;

    public void bookTicket(String movieName, int seatNumber, double price) {
        if (!booked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            booked = true;
            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("Ticket already booked.");
        }
    }

    public void displayTicketDetails() {
        if (booked) {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("No ticket booked.");
        }
    }
}
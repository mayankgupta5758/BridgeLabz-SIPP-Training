class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNo;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNo, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNo = seatNo;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservationSystem {
    Ticket head = null, tail = null;

    void addTicket(int id, String cname, String mname, String seat, String time) {
        Ticket t = new Ticket(id, cname, mname, seat, time);
        if (head == null) {
            head = tail = t;
            t.next = head;
        } else {
            tail.next = t;
            tail = t;
            tail.next = head;
        }
    }

    void removeTicket(int id) {
        if (head == null) return;
        Ticket temp = head, prev = null;
        do {
            if (temp.ticketId == id) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayAll() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNo + " | " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String name) {
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("Found Ticket: " + temp.ticketId + " for " + temp.movieName);
            }
            temp = temp.next;
        } while (temp != head);
    }

    void totalTickets() {
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        trs.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        trs.addTicket(2, "Bob", "Tenet", "B2", "1:00 PM");
        trs.displayAll();
        trs.totalTickets();
    }
}

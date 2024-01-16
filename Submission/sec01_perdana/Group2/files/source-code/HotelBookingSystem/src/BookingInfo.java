import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Encapsulation: The class encapsulates the details of a booking, including room, guest, dates, and payment.
public class BookingInfo {
    
    // Composition: The class has member variables representing other classes, forming a composition.
    private Room bookedRoom;
    private Guest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Payment payment;

    // Constructor: Initializes the BookingInfo object with provided values during object creation.
    public BookingInfo(Room bookedRoom, Guest guest, LocalDate checkInDate, LocalDate checkOutDate, Payment payment) {
        // Encapsulation: Setting private fields using constructor parameters.
        this.bookedRoom = bookedRoom;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.payment = payment;
    }

    // Getter methods: Provide access to the private fields, following encapsulation principles.
    public Room getBookedRoom() {
        return bookedRoom;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    // Encapsulation: Calculates and returns the number of nights based on encapsulated date fields.
    public int getNumberOfNights() {
        return checkOutDate.compareTo(checkInDate);
    }

    public Payment getPayment() {
        return payment;
    }

    // Setter methods: Allow modification of private fields, following encapsulation principles.
    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setCheckInDate(LocalDate newCheckInDate) {
        this.checkInDate = newCheckInDate;
    }

    public void setCheckOutDate(LocalDate newCheckOutDate) {
        this.checkOutDate = newCheckOutDate;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Helper method: Formats a LocalDate into a string using a specific format.
    public String formatDate(LocalDate date) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
        return date.format(outputFormatter);
    }

    // Static method: Displays booking information without requiring an instance of BookingInfo.
    public static void displayBookingInfo(BookingInfo bookingInfo) {
        System.out.println("----- Guest: " + bookingInfo.getGuest().getName() + " Booking Information -----");
        System.out.format("\t%-19s: %d\n", "Room Number", bookingInfo.getBookedRoom().getRoomNumber());
        System.out.format("\t%-19s: %s\n", "Guest", bookingInfo.getGuest().getName());
        System.out.format("\t%-19s: %s\n", "Contact Number", bookingInfo.getGuest().getContactNumber());
        System.out.format("\t%-19s: %s\n", "Email", bookingInfo.getGuest().getEmail());
        System.out.format("\t%-19s: %s\n", "Check-in Date", bookingInfo.formatDate(bookingInfo.getCheckInDate()));
        System.out.format("\t%-19s: %s\n", "Check-out Date", bookingInfo.formatDate(bookingInfo.getCheckOutDate()));
        System.out.format("\t%-19s: %d\n", "Number of Night(s)", bookingInfo.getNumberOfNights());
        System.out.format("\t%-19s: RM%.2f\n", "Total Amount", bookingInfo.getPayment().getAmount());
        System.out.format("\t%-19s: %s\n", "Payment Type", bookingInfo.getPayment().getPaymentType());
        System.out.format("\t%-19s: %s\n", "Room Type", bookingInfo.getBookedRoom().getRoomType());
        System.out.format("\t%-19s: %s\n", "Description", String.valueOf(bookingInfo.getBookedRoom().description())); // Convert int to String using valueOf
        System.out.println("----------------------------------------------------------------------");
    }
}

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingInfo {
    private Room bookedRoom;
    private Guest guest;
    private Date checkInDate;
    private Date checkOutDate;
    private Payment payment;

    public BookingInfo(Room bookedRoom, Guest guest, Date checkInDate, Date checkOutDate, Payment payment) {
        this.bookedRoom = bookedRoom;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.payment = payment;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setCheckInDate(Date newCheckInDate) {
        this.checkInDate = newCheckInDate;
    }

    public void setCheckOutDate(Date newCheckOutDate) {
        this.checkOutDate = newCheckOutDate;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public void displayBookingInfo() {
        System.out.println("\nRoom Number: " + bookedRoom.getRoomNumber());
        System.out.println("Room Type: " + bookedRoom.getRoomType());
        System.out.println("Guest: " + guest.getName());
        System.out.println("Contact Number: " + guest.getContactNumber());
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Check-in Date: " + formatDate(checkInDate));
        System.out.println("Check-out Date: " + formatDate(checkOutDate));
        //System.out.println("Number");
        System.out.println("Room Capacity: " + bookedRoom.getCapacity());
        System.out.println("Room Price: " + bookedRoom.getPrice());
        System.out.println("Total Amount: " + payment.getAmount());
        System.out.println("Payment Type: " + payment.getPaymentType());
        System.out.println("Payment Status: " + (payment.isPaid()));
    }
}

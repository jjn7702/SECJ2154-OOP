import java.util.*;
import java.io.*;
public class Report {
    private List<BookingInfo> bookings;

    public Report(List<BookingInfo> bookings) {
        this.bookings = bookings;
    }

    public void generateReport(List<BookingInfo> bookings) throws IOException{
            
        FileWriter fw = new FileWriter("C:\\Users\\ASUS\\Desktop\\HotelBookingSystem\\src\\Report.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println("\nCustomer Booking Details:");
        for (BookingInfo booking : bookings){
            pw.println("----- Booking Information -----");
            pw.println("Room Number: " + booking.getGuest().getName());
            pw.println("Guest: " + booking.getGuest().getName());
            pw.println("Check-in Date: " + booking.getCheckInDate());
            pw.println("Check-out Date: " + booking.getCheckOutDate());
            pw.println("Total Amount: " + booking.getPayment().getAmount());
            pw.println("Payment Type: " + booking.getPayment().getPaymentType());
            pw.println("Room Type: " + booking.getBookedRoom().getRoomType());
            pw.println("Payment Status: " + (booking.getPayment().isPaid()));
            //pw.println("\n");
        }
        pw.close();
        System.out.println("The report has been successfully generated!");
 
    }
}



    


import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    UserInterface userInterface = new ConsoleScreenController();

    public void generateReport(List<BookingInfo> bookings) throws IOException {
        if (bookings.isEmpty()) {
            System.out.print("No bookings to generate. Please create a new booking! \nNavigating to the main menu");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
            return;
        }

        FileWriter fw = new FileWriter("./report/Report.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = now.format(dateFormatter);

        // Calculate the center alignment for the hotel title
        int titleLength = "Moyai Hotel Booking Information Report".length();
        int padding = (130 - titleLength) / 2;
        String titlePadding = " ".repeat(Math.max(0, padding));

        // Print the report header
        pw.printf("%s%s%s[ %3s ]%n", titlePadding, "Moyai Hotel Booking Information Report", titlePadding, currentDate);
        pw.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        pw.printf("%-2s | %-12s | %-25s | %-10s | %-16s | %-16s | %-8s | %-15s | %-17s%n",
                "#", "Room Number", "Guest Name", "Room Type", "Check-in Date", "Check-out Date","Night(s)", "Booking Amount", "Payment Type");
        pw.println("---+--------------+---------------------------+------------+------------------+------------------+----------+-----------------+--------------");

        // Sort bookings by room number
        Collections.sort(bookings, new Comparator<BookingInfo>() {
            //@Override
            public int compare(BookingInfo b1, BookingInfo b2) {
                Integer roomNumber1 = b1.getBookedRoom().getRoomNumber();
                Integer roomNumber2 = b2.getBookedRoom().getRoomNumber();
                return roomNumber1.compareTo(roomNumber2);
            }
        });

        // Print booking details
        int count = 1;
        for (BookingInfo booking : bookings) {
            pw.printf("%-2d | %-12s | %-25s | %-10s | %-15s | %-15s |    %-5s | %-15s | %-17s%n",
                    count++,
                    booking.getBookedRoom().getRoomNumber(),
                    booking.getGuest().getName(),
                    booking.getBookedRoom().getRoomType(),
                    booking.formatDate(booking.getCheckInDate()),
                    booking.formatDate(booking.getCheckOutDate()),
                    booking.getNumberOfNights(),
                    "RM " + booking.getPayment().getAmount(),
                    booking.getPayment().getPaymentType());
        }

        pw.close();

        System.out.print("The report has been successfully generated! \nNavigating to the main menu");
        userInterface.loadingAnimation();
        userInterface.clearScreen();
    }
}

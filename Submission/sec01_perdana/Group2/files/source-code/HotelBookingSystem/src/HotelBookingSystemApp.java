import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class HotelBookingSystemApp {
    private Scanner scanner;
    private List<BookingInfo> bookings;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public HotelBookingSystemApp() {
        this.scanner = new Scanner(System.in);
        this.bookings = new ArrayList<>();
    }

    public void run(){
        int choice = 0;
        do {
            displayMainMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    // Make a booking
                    handleBooking();
                    break;
                case 2:
                    // Display booking information
                    displayBookingInformation();
                    break;
                case 3:
                    // Edit booking
                    editBooking();
                    break;
                case 4:
                    // Delete booking
                    deleteBooking();
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayMainMenu() {
        System.out.println("----- Hotel Booking System -----");
        System.out.println("1. Make a Booking");
        System.out.println("2. Display Booking Information");
        System.out.println("3. Edit Booking");
        System.out.println("4. Delete Booking");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleBooking(){
        String fullName, contactNumber, email, checkInDateString, checkOutDateString;
        Date checkInDate, checkOutDate;
        double totalAmount;

        System.out.println("\n----- Make a Booking -----");
        System.out.print("\nChoose a room type \n(1 for Standard, 2 for Deluxe): ");
        
        int roomTypeChoice = getUserChoice();
        Room selectedRoom = createRoomByType(roomTypeChoice);

        scanner.nextLine(); // Clear the buffer

        System.out.print("\nEnter guest full name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter guest contact number: ");
        contactNumber = scanner.nextLine();

        System.out.print("Enter guest email: ");
        email = scanner.nextLine();

        Guest guest = new Guest(fullName, contactNumber, email);

        System.out.print("Enter check-in date (yyyy-MM-dd): ");
        checkInDateString = scanner.next();
        checkInDate = parseDate(checkInDateString);

        System.out.print("Enter check-out date (yyyy-MM-dd): ");
        checkOutDateString = scanner.next();
        checkOutDate = parseDate(checkOutDateString);

        totalAmount = calculateTotalAmount(selectedRoom, checkInDate, checkOutDate);

        // Create Payment
        System.out.println("Select payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Debit/Credit Card");
        System.out.println("3. eWallet");
        System.out.print("Enter your choice: ");

        int paymentMethodChoice = getUserChoice();
        String paymentMethod;
        switch (paymentMethodChoice) {
            case 1:
                paymentMethod = "Cash";
                break;
            case 2:
                paymentMethod = "Debit/Credit Card";
                break;
            case 3:
                paymentMethod = "eWallet";
                break;
            default:
                System.out.println("Invalid payment method. Defaulting to Cash.");
                paymentMethod = "Cash";
        }

        System.out.println("Select payment status:");
        System.out.println("1. Paid");
        System.out.println("2. Pending");
        System.out.print("Enter your choice: ");

        int paymentStatusChoice = getUserChoice();
        String paymentStatus;
        switch (paymentStatusChoice) {
            case 1:
                paymentStatus = "Paid";
                break;
            case 2:
                paymentStatus = "Pending";
                break;
            default:
                System.out.println("Invalid payment status. Defaulting to Pending.");
                paymentStatus = "Pending";
        }

        Payment payment = new Payment(paymentMethod, totalAmount, paymentStatus);

        // Create BookingInfo
        BookingInfo bookingInfo = new BookingInfo(selectedRoom, guest, checkInDate, checkOutDate, payment);

        System.out.println("Booking successful!");
        displayBookingInfo(bookingInfo);

        bookings.add(bookingInfo);
    }

    private Room createRoomByType(int roomTypeChoice) {
        Room room = null;
        do {
            switch (roomTypeChoice) {
                case 1:
                    // Standard Room
                    RoomPrice standardRoomPrice = new RoomPrice(StandardRoom.StandardRoomType.STANDARD.getBasePrice());
                    room = new StandardRoom(new RoomAvailability(), standardRoomPrice);
                    break;
                case 2:
                    // Deluxe Room
                    RoomPrice deluxeRoomPrice = new RoomPrice(DeluxeRoom.DeluxeRoomType.DELUXE.getBasePrice());
                    room = new DeluxeRoom(new RoomAvailability(), deluxeRoomPrice);
                    break;
                default:
                    System.out.println("Invalid room type. Please choose a valid choice.");
                    roomTypeChoice = getUserChoice();
            }
        } while (room == null);
        return room;
    }

    private double calculateTotalAmount(Room room, Date checkInDate, Date checkOutDate) {
        long numberOfDays = calculateNumberOfDays(checkInDate, checkOutDate);
        double roomRatePerDay = room.getPrice().getRatePerDay();
        return numberOfDays * roomRatePerDay;
    }
    
    private long calculateNumberOfDays(Date checkInDate, Date checkOutDate) {
        // Convert Date objects to LocalDate objects
        LocalDate checkInLocalDate = checkInDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate checkOutLocalDate = checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate the number of days between the check-in and check-out dates
        long daysBetween = ChronoUnit.DAYS.between(checkInLocalDate, checkOutLocalDate);
        return daysBetween;
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using the current date.");
            return new Date();
        }
    }

    private void displayBookingInfo(BookingInfo bookingInfo) {
        System.out.println("\n----- Booking Information -----");
        System.out.println("Room Number: " + bookingInfo.getBookedRoom().getRoomNumber());
        System.out.println("Guest: " + bookingInfo.getGuest().getName());
        System.out.println("Contact Number: " + bookingInfo.getGuest().getContactNumber());
        System.out.println("Email: " + bookingInfo.getGuest().getEmail());
        System.out.println("Check-in Date: " + formatDate(bookingInfo.getCheckInDate()));
        System.out.println("Check-out Date: " + formatDate(bookingInfo.getCheckOutDate()));
        System.out.println("Number of Days: " + calculateNumberOfDays(bookingInfo.getCheckInDate(), bookingInfo.getCheckOutDate()));
        System.out.println("Total Amount: " + bookingInfo.getPayment().getAmount());
        System.out.println("Payment Type: " + bookingInfo.getPayment().getPaymentType());
        System.out.println("Room Type: " + bookingInfo.getBookedRoom().getRoomType());
        System.out.println("Room Capacity: " + bookingInfo.getBookedRoom().getCapacity());
        System.out.println("Payment Status: " + (bookingInfo.getPayment().isPaid()));
    }

    private void displayBookingInformation() {
        System.out.println("\n----- All Booking Information -----");
        if (bookings != null) {
            for (BookingInfo booking : bookings) {
                booking.displayBookingInfo();
                System.out.println("----------------------");
            }
        } else {
            System.out.println("No bookings found. Please make a booking first.");
        }
    }

    private int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            // Clear the buffer
            scanner.nextLine();
            return -1;
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private void editBooking() {
        System.out.println("\n----- Edit Booking -----");

        System.out.print("Enter the room number for the booking you want to edit: ");
        int roomNumberToEdit = getUserChoice();

        BookingInfo bookingToEdit = findBookingByRoomNumber(roomNumberToEdit);

        if (bookingToEdit != null) {
            // Booking found, prompt user for what to edit
            System.out.println("Select what to edit:");
            System.out.println("1. Guest Details");
            System.out.println("2. Room Type");
            System.out.println("3. Check-in Date");
            System.out.println("4. Check-out Date");
            System.out.println("5. Payment Type");
            System.out.print("Enter your choice: ");

            int editChoice = getUserChoice();

            switch (editChoice) {
                case 1:
                    editGuestDetails(bookingToEdit);
                    break;
                case 2:
                    editRoomType(bookingToEdit);
                    break;
                case 3:
                    editCheckInDate(bookingToEdit);
                    break;
                case 4:
                    editCheckOutDate(bookingToEdit);
                    break;
                case 5:
                    editPaymentType(bookingToEdit);
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
            }
        } else {
            System.out.println("Booking not found with the specified room number.");
        }
    }

    private void editGuestDetails(BookingInfo booking) {
        String newName, newContactNumber, newEmail;

        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter new guest full name: ");
        newName = scanner.nextLine();
        booking.getGuest().setName(newName);
    
        System.out.print("Enter new guest contact number: ");
        newContactNumber = scanner.nextLine();
        booking.getGuest().setContactNumber(newContactNumber);
    
        System.out.print("Enter new guest email: ");
        newEmail = scanner.nextLine();
        booking.getGuest().setEmail(newEmail);
    
        System.out.println("Guest details updated successfully.");
    }
    
    private void editRoomType(BookingInfo booking) {
        System.out.println("Select new room type:");
        System.out.println("1. Standard Room");
        System.out.println("2. Deluxe Room");
        System.out.print("Enter your choice: ");
    
        int newRoomTypeChoice = getUserChoice();
        Room newRoom = createRoomByType(newRoomTypeChoice);
    
        if (newRoom != null) {
            booking.setBookedRoom(newRoom);
            System.out.println("Room type updated successfully.");
        } else {
            System.out.println("Invalid room type. No changes made.");
        }
    }

    private void editCheckInDate(BookingInfo booking) {
        try {
            System.out.print("Enter new check-in date (yyyy-MM-dd): ");
            String newCheckInDateString = scanner.next();
            Date newCheckInDate = dateFormat.parse(newCheckInDateString);
            booking.setCheckInDate(newCheckInDate);
            System.out.println("Check-in date updated successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. No changes made.");
        }
    }

    private void editCheckOutDate(BookingInfo booking) {
        try {
            System.out.print("Enter new check-out date (yyyy-MM-dd): ");
            String newCheckOutDateString = scanner.next();
            Date newCheckOutDate = dateFormat.parse(newCheckOutDateString);
            booking.setCheckOutDate(newCheckOutDate);
            System.out.println("Check-out date updated successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. No changes made.");
        }
    }

    private void editPaymentType(BookingInfo booking) {
        System.out.print("Enter new payment type: ");
        String newPaymentType = scanner.nextLine();
        booking.getPayment().setPaymentMethod(newPaymentType);
        System.out.println("Payment type updated successfully.");
    }

    private void deleteBooking() {
        System.out.println("\n----- Delete Booking -----");
    
        System.out.print("Enter the room number for the booking you want to delete: ");
        int roomNumberToDelete = getUserChoice();
    
        BookingInfo bookingToDelete = findBookingByRoomNumber(roomNumberToDelete);
    
        if (bookingToDelete != null) {
            // Booking found, delete it
            bookings.remove(bookingToDelete);
            System.out.println("Booking deleted successfully.");
        } else {
            System.out.println("Booking not found with the specified room number.");
        }
    }
    
    private BookingInfo findBookingByRoomNumber(int roomNumber) {
        for (BookingInfo booking : bookings) {
            if (booking.getBookedRoom().getRoomNumber() == roomNumber) {
                return booking;
            }
        }
        return null;  // Booking not found
    }
    
    public static void main(String[] args) {
        HotelBookingSystemApp hotelApp = new HotelBookingSystemApp();
        hotelApp.run();
    }
}

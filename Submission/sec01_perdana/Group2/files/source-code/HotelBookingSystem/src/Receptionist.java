import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Receptionist {
    private Scanner scanner;
    List<BookingInfo> bookings = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    private int maxStandard = 5, maxDeluxe = 5, maxSuperior = 5;
    ConsoleScreenController userInterface = new ConsoleScreenController();

    public Receptionist() {
        this.scanner = new Scanner(System.in);
        initializeRooms();
    }

    public List<BookingInfo> getBookingList(){
        return bookings;
    }

    private void initializeRooms(){
        for (int a = 0; a < maxStandard; a++){
            Room room = new StandardRoom(StandardRoom.StandardRoomType.STANDARD, true, StandardRoom.StandardRoomType.STANDARD.getBasePrice());
            room.setRoomNumber(100 + a);
            rooms.add(room);
        }
        for (int b = 0; b < maxDeluxe; b++){
            Room room = new DeluxeRoom(DeluxeRoom.DeluxeRoomType.DELUXE, true, DeluxeRoom.DeluxeRoomType.DELUXE.getBasePrice());
            room.setRoomNumber(200 + b);
            rooms.add(room);
        }
        for (int c = 0; c < maxSuperior; c++){
            Room room = new SuperiorRoom(SuperiorRoom.SuperiorRoomType.SUPERIOR, true, SuperiorRoom.SuperiorRoomType.SUPERIOR.getBasePrice());
            room.setRoomNumber(300 + c);
            rooms.add(room);
        }
    }   

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // MAIN FUNCTIONS //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void handleBooking(BookingInfo bookingInfo) {
        String fullName, contactNumber, email, checkInDateString, checkOutDateString;
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;
        double totalAmount;
    
        if (allRoomsOccupied()) {
            System.out.println("Sorry, all rooms are currently occupied. No new bookings can be made at the moment.");
            return;
        }
    
        System.out.println("----- Make New Booking -----");
        System.out.print("\nChoose a room type \n(1 for Standard, 2 for Deluxe, 3 for Superior): ");
    
        int roomTypeChoice = getUserChoice();
        
        if (roomTypeChoice == 1 && allRoomsOccupiedByType(1)) {
            System.out.println("Sorry, all Standard rooms are currently occupied. Please choose another room type.\n");
            return;
        } else if (roomTypeChoice == 2 && allRoomsOccupiedByType(2)) {
            System.out.println("Sorry, all Deluxe rooms are currently occupied. Please choose another room type.\n");
            return;
        } else if (roomTypeChoice == 3 && allRoomsOccupiedByType(3)) {
            System.out.println("Sorry, all Superior rooms are currently occupied. Please choose another room type.\n");
            return;
        } else if (roomTypeChoice < 1 || roomTypeChoice > 3){
            System.out.print("\nInvalid room type. Please try again");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
            return;
        }

        displayAvailableRoomsByType(roomTypeChoice);
    
        // Assign room number manually
        System.out.print("Enter the desired room number: ");
        int roomNumber = getUserChoice();

        userInterface.clearScreen();
    
        // Check if the chosen room number is available
        Room selectedRoom = findRoomByNumberAndType(roomNumber, roomTypeChoice);
    
        if (selectedRoom == null || !selectedRoom.getIsAvailable()) {
            System.out.println("Invalid room number or the room is not available. Please try again.");
            return;
        }
    
        scanner.nextLine(); // Clear the buffer
    
        System.out.print("\nEnter guest full name: ");
        fullName = scanner.nextLine();
        fullName = capitalizeEachWord(fullName);
    
        System.out.print("Enter guest contact number: ");

        while (true) {
            contactNumber = scanner.nextLine();
            // Regular expression for a simple phone number validation
            String contactNumberRegex = "^[0-9]{10,12}$";
            Pattern pattern = Pattern.compile(contactNumberRegex);
            Matcher matcher = pattern.matcher(contactNumber);

            if (matcher.matches()) {
                break; // Break the loop if the phone number is valid
            } else {
                System.out.print("Invalid phone number format. Please enter a valid phone number: ");
            }
        }
    
        System.out.print("Enter guest email: ");
        while (true) {
            email = scanner.nextLine();

            // Regular expression for a simple email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                break; // Break the loop if the email is valid
            } else {
                System.out.print("Invalid email format. Please enter a valid email: ");
            }
        }

        do {
            System.out.print("Enter check-in date (dd-MM-yyyy): ");
            checkInDateString = scanner.next();
            if (isValidDateFormat(checkInDateString)) {
                checkInDate = LocalDate.parse(checkInDateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } else {
                System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
            }
        } while (checkInDate == null);
    
        do {
            System.out.print("Enter check-out date (dd-MM-yyyy): ");
            checkOutDateString = scanner.next();
            if (isValidDateFormat(checkOutDateString)) {
                checkOutDate = LocalDate.parse(checkOutDateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                // Check if check-out date is before or same as check-in date
                if (checkOutDate.isBefore(checkInDate) || checkOutDate.isEqual(checkInDate)) {
                    System.out.println("Check-out date cannot be before or the same as check-in date. Please enter a valid date.");
                    checkOutDate = null;
                }
            } else {
                System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
            }
        } while (checkOutDate == null);
        
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
    
        // Create Guest and Payment objects
        Guest guest = new Guest(fullName, contactNumber, email);
        totalAmount = calculateTotalAmount(selectedRoom, checkInDate, checkOutDate);
        Payment payment = new Payment(paymentMethod, totalAmount);
    
        // Create BookingInfo
        bookingInfo = new BookingInfo(selectedRoom, guest, checkInDate, checkOutDate, payment);
    
        // Mark the booked room as unavailable
        selectedRoom.setIsAvailable(false);
    
        System.out.println("Booking successful!");
    
        System.out.print("Do you want to view the booking details? (1 - Yes/ 0 - No) : ");
        int viewBookingDetails = getUserChoice();
        userInterface.clearScreen();
    
        if (viewBookingDetails == 1) {
            BookingInfo.displayBookingInfo(bookingInfo);
            System.out.print("\nNavigating to main menu");
            
            userInterface.loadingAnimation();
            userInterface.clearScreen();
        }
    
        bookings.add(bookingInfo);
        userInterface.clearScreen();
        scanner.nextLine(); 
    }
        
    public void editBooking() {
         // Centered header
        
        String header = "----- Edit Booking -----";
        int headerPadding = (80 - header.length()) / 2;  // Assuming console width is 80 characters
        System.out.printf("%" + headerPadding + "s%s%" + headerPadding + "s%n%n", "", header, "");

        if(bookings.isEmpty()){
            System.out.print("No bookings found. Please make a booking first. Returning to main menu");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
            return;
        }
        
        System.out.println("----- List of Booked Room Number -----");
        displayListOfBookedRooms(bookings);

        System.out.println();

        System.out.print("\n\nChoose the room number for the booking details you want to edit: ");
        String roomNumber = scanner.nextLine();

        BookingInfo bookingToEdit = findBookingInfo(roomNumber);
        userInterface.clearScreen();
        
        if (bookingToEdit != null) {
            BookingInfo.displayBookingInfo(bookingToEdit);
            // Booking found, prompt user for what to edit
            System.out.println("\nSelect what to edit:");
            System.out.println("1. Guest Details");
            System.out.println("2. Check-out Date");
            System.out.println("3. Payment Type");
            System.out.println("4. Cancel");
            System.out.print("Enter your choice: ");

            int editChoice = getUserChoice();

            switch (editChoice) {
                case 1:
                    editGuestDetails(bookingToEdit);
                    break;
                case 2:
                    editCheckOutDate(bookingToEdit);
                    break;
                case 3:
                    editPaymentType(bookingToEdit);
                    break;
                case 4:
                    userInterface.clearScreen();
                    return;
                default:
                    System.out.println("Invalid choice. No changes made.");
                    userInterface.clearScreen();
            }
        } else {
            System.out.print("Booking not found with the specified room number. Please try again later");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
        }
    }

    public void editGuestDetails(BookingInfo booking) {
        String newName, newContactNumber, newEmail;

        System.out.print("Enter new guest full name: ");
        newName = scanner.nextLine();
        newName = capitalizeEachWord(newName);
        booking.getGuest().setName(newName);
    
        System.out.print("Enter new guest contact number: ");
        while (true) {
            newContactNumber = scanner.nextLine();
            // Regular expression for a simple phone number validation
            String contactNumberRegex = "^[0-9]{10,12}$";
            Pattern pattern = Pattern.compile(contactNumberRegex);
            Matcher matcher = pattern.matcher(newContactNumber);

            if (matcher.matches()) {
                break; // Break the loop if the phone number is valid
            } else {
                System.out.print("Invalid phone number format. Please enter a valid phone number: ");
            }
        }
        booking.getGuest().setContactNumber(newContactNumber);
    
        System.out.print("Enter new guest email: ");
        while (true) {
            newEmail = scanner.nextLine();
            // Regular expression for a simple email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(newEmail);

            if (matcher.matches()) {
                break; // Break the loop if the email is valid
            } else {
                System.out.print("Invalid email format. Please enter a valid email: ");
            }
        }
        booking.getGuest().setEmail(newEmail);
    
        System.out.print("Guest details updated successfully. <Press enter to continue>");
        scanner.nextLine();

        userInterface.clearScreen();
    }

    public void editCheckOutDate(BookingInfo booking) {
        try {
            System.out.print("Enter new check-out date (dd-MM-yyyy): ");
            String newCheckOutDateString = scanner.next();
            LocalDate newCheckOutDate = LocalDate.parse(newCheckOutDateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            booking.setCheckOutDate(newCheckOutDate);
            System.out.print("Check-out date updated successfully. <Press enter to continue>");
            scanner.nextLine();

        } catch (Exception e) {
            System.out.print("Invalid date format. No changes made. <Press enter to continue>");
            scanner.nextLine();
        }

        userInterface.clearScreen();
    }
    
    public void editPaymentType(BookingInfo booking){
        System.out.println("\nSelect new payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Debit/Credit Card");
        System.out.println("3. eWallet");
        System.out.print("Enter your choice: ");

        int paymentMethodChoice = getUserChoice();
        String newPaymentMethod;
        switch (paymentMethodChoice) {
            case 1:
                newPaymentMethod = "Cash";
                break;
            case 2:
                newPaymentMethod = "Debit/Credit Card";
                break;
            case 3:
                newPaymentMethod = "eWallet";
                break;
            default:
                System.out.println("Invalid payment method. Defaulting to Cash.");
                newPaymentMethod = "Cash";
        }
        booking.getPayment().setPaymentMethod(newPaymentMethod);
        System.out.print("Payment type updated successfully. <Press enter to continue>");
        scanner.nextLine();
        userInterface.clearScreen();
    }

    public void checkOutGuest() {
        String header = "----- Check Out Guest -----";
        int headerPadding = (80 - header.length()) / 2;  // Assuming console width is 80 characters
        System.out.printf("%" + headerPadding + "s%s%" + headerPadding + "s%n%n", "", header, "");

        if(bookings.isEmpty()){
            System.out.print("No bookings found. Please make a booking first. Returning to main menu");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
            return;
        }

        System.out.println("----- List of Booked Room Number -----");
        displayListOfBookedRooms(bookings);

        System.out.println();
    
        System.out.print("\n\nChoose the room number to check out: ");
        String roomNumber = scanner.next();
    
        BookingInfo bookingToDelete = findBookingInfo(roomNumber);
    
        if (bookingToDelete != null) {
            // Booking found, delete it
            Room bookedRoom = bookingToDelete.getBookedRoom();
            bookings.remove(bookingToDelete);
            bookedRoom.setIsAvailable(true);
            System.out.print("Booking deleted successfully. <Press enter to continue>");
            scanner.nextLine();
            scanner.nextLine();
        } else {
            System.out.print("Guest not found. <Press enter to continue>");
            scanner.nextLine();
            scanner.nextLine();
        }

        roomNumber = null;
        userInterface.clearScreen();
    }

    public void displayAllBookingInformation() {
        userInterface.printCenteredHeader("----- All Booking Information -----");
        if (bookings.isEmpty()) {
            System.out.print("No bookings found. Please make a booking first. Returning to main menu");
            userInterface.loadingAnimation();
            userInterface.clearScreen();
            return;
        
        } else {
            for (BookingInfo booking : bookings) {
                BookingInfo.displayBookingInfo(booking);
            }

            System.out.print("Press Enter to Continue...");
            scanner.nextLine();
            userInterface.clearScreen();
        }
    }

    public void displayAvailableRooms() {
        userInterface.printCenteredHeader("----- Room Availability -----");
    
        // Display available rooms
        List<Room> availableStandardRooms = new ArrayList<>();
        List<Room> availableDeluxeRooms = new ArrayList<>();
        List<Room> availableSuperiorRooms = new ArrayList<>();
        List<Room> bookedStandardRooms = new ArrayList<>();
        List<Room> bookedDeluxeRooms = new ArrayList<>();
        List<Room> bookedSuperiorRooms = new ArrayList<>();
    
        for (Room room : rooms) {
            if (room.getIsAvailable()) {
                switch (room.getRoomType()) {
                    case "Standard":
                        availableStandardRooms.add(room);
                        break;
                    case "Deluxe":
                        availableDeluxeRooms.add(room);
                        break;
                    case "Superior":
                        availableSuperiorRooms.add(room);
                        break;
                }
            } else {
                switch (room.getRoomType()) {
                    case "Standard":
                        bookedStandardRooms.add(room);
                        break;
                    case "Deluxe":
                        bookedDeluxeRooms.add(room);
                        break;
                    case "Superior":
                        bookedSuperiorRooms.add(room);
                        break;
                }
            }
        }
    
        // Display Available Room List
        System.out.println("--- Available Standard Rooms ---");
        for (Room room : availableStandardRooms) {
            System.out.println("[" + room.getRoomNumber() + "] - Available");
        }
    
        System.out.println("\n--- Available Deluxe Rooms ---");
        for (Room room : availableDeluxeRooms) {
            System.out.println("[" + room.getRoomNumber() + "] - Available");
        }
    
        System.out.println("\n--- Available Superior Rooms ---");
        for (Room room : availableSuperiorRooms) {
            System.out.println("[" + room.getRoomNumber() + "] - Available");
        }
    
        // Display Booked Room List
        System.out.println("\n--- Booked Standard Rooms ---");
        displayNotAvailableRoom(bookedStandardRooms);
    
        System.out.println("\n--- Booked Deluxe Rooms ---");
        displayNotAvailableRoom(bookedDeluxeRooms);
    
        System.out.println("\n--- Booked Superior Rooms ---");
        displayNotAvailableRoom(bookedSuperiorRooms);
    
        System.out.println("\n-----------------------------");
    
        System.out.print("\nPress Enter to Continue...");
        scanner.nextLine();
        userInterface.clearScreen();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // HELPER FUNCTIONS //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BookingInfo findBookingInfo(String roomNumber) {
        for (BookingInfo booking : bookings) {
            if (String.valueOf(booking.getBookedRoom().getRoomNumber()).contains(roomNumber)) {
                return booking;
            }
        }
        return null;  // Booking not found
    }

    public int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e) {
            // Clear the buffer
            int choice2;
            scanner.nextLine();
            System.out.print("Invalid input. Please enter a number: ");
            choice2 = getUserChoice();
            return choice2;
        }
    }
    
    public Room createRoomByType(int roomTypeChoice) {
        Room room = null;
    
        for (Room availableRoom : rooms) {
            // Check if the room is of the desired type and is available
            if (isRoomTypeMatch(availableRoom, roomTypeChoice) && availableRoom.getIsAvailable()) {
                room = availableRoom;
                room.setIsAvailable(false); // Mark the room as booked
    
                // Assign a room number during booking
                int roomNumber = generateRoomNumber(roomTypeChoice);
                room.setRoomNumber(roomNumber);
                break;
            }
        }
    
        if (room == null) {
            System.out.println("No available rooms of the selected type. Please choose another room type.");
            // You might want to handle this case depending on your application's logic
        }
    
        return room;
    }
    
    private int generateRoomNumber(int roomTypeChoice) {
        // Generate a unique room number based on the room type
        int baseRoomNumber = 100 * roomTypeChoice;
        int counter = 1;
    
        // Find the next available room number
        while (true) {
            int candidateRoomNumber = baseRoomNumber + counter;
    
            // Check if the room number is not already taken
            boolean roomNumberTaken = rooms.stream().anyMatch(r -> r.getRoomNumber() == candidateRoomNumber);
    
            if (!roomNumberTaken) {
                return candidateRoomNumber;
            }
    
            counter++;
        }
    }

    public double calculateTotalAmount(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        long numberOfDays = calculateNumberOfDays(checkInDate, checkOutDate);
        double roomRatePerDay = room.getPrice();
        return numberOfDays * roomRatePerDay;
    }
    
    public long calculateNumberOfDays(LocalDate checkInDate, LocalDate checkOutDate) {
        // Convert Date objects to LocalDate objects
        return checkInDate.until(checkOutDate).getDays();
    }

    public void displayListOfBookedRooms(List<BookingInfo> bookings) { //Display all available room
        List<String> roomNumbers = new ArrayList<>();
        for (BookingInfo booking : bookings) {
            roomNumbers.add(String.valueOf(booking.getBookedRoom().getRoomNumber()));
        }

        Collections.sort(roomNumbers);

        for (String roomNumber : roomNumbers) {
            System.out.print("[" + roomNumber + "] ");
        }
    }

    public static boolean isValidDateFormat(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void displayAvailableRoomsByType(int roomTypeChoice) { //Display available room by type when create new booking
        System.out.println("\n----- Available Rooms -----");
    
        for (Room room : rooms) {
            if (room.getIsAvailable() && isRoomTypeMatch(room, roomTypeChoice)) {
                System.out.print("[" + room.getRoomNumber() + "] ");
            }
        }
    
        System.out.println("\n-----------------------------");
    }

    
    private void displayNotAvailableRoom(List<Room> bookedRooms) {
        Collections.sort(bookedRooms, Comparator.comparing(Room::getRoomNumber));
    
        for (Room room : bookedRooms) {
            System.out.println("[" + room.getRoomNumber() + "] - Booked");
        }
    }
    
    private boolean allRoomsOccupied() {
        for (Room room : rooms) {
            if (room.getIsAvailable()) {
                return false; // At least one room is available
            }
        }
        return true; // All rooms are occupied
    }

    private boolean allRoomsOccupiedByType(int roomType) {
        for (Room room : rooms) {
            if (room.getIsAvailable() && isRoomTypeMatch(room, roomType)) {
                return false; // At least one room is available
            }
        }
        return true; // All rooms are occupied
    }

    // Helper method to check if the room type matches the user's choice
    private boolean isRoomTypeMatch(Room room, int roomTypeChoice) {
        if (roomTypeChoice == 1 && room instanceof StandardRoom) {
            return true;
        } else if (roomTypeChoice == 2 && room instanceof DeluxeRoom) {
            return true;
        } else if (roomTypeChoice == 3 && room instanceof SuperiorRoom) {
            return true;
        }
        return false;
    }
    
    private String capitalizeEachWord(String input) {
        String[] words = input.split(" ");
        StringBuilder capitalizedString = new StringBuilder();
    
        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1).toLowerCase();
                capitalizedString.append(firstChar).append(restOfWord).append(" ");
            }
        }
    
        return capitalizedString.toString().trim();
    }

    private Room findRoomByNumberAndType(int roomNumber, int roomType) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.getIsAvailable()) {
                // Check if the room type matches the desired type
                if ((roomType == 1 && room instanceof StandardRoom)
                        || (roomType == 2 && room instanceof DeluxeRoom)
                        || (roomType == 3 && room instanceof SuperiorRoom)) {
                    return room;
                }
            }
        }
        return null; // Room not found or not available
    }
}

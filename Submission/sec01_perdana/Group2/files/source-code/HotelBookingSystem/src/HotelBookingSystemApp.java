import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HotelBookingSystemApp { //Encapsulation!!!
    private Scanner scanner;

    private HotelBookingSystemApp() {
        this.scanner = new Scanner(System.in);
    }

    private void displayMainMenu() {
        System.out.println("                   __       __   ______   __      __  ______   ______        __    __   ______   ________  ________  __                                     \r\n" + //
                "                  /  \\     /  | /      \\ /  \\    /  |/      \\ /      |      /  |  /  | /      \\ /        |/        |/  |                                    \r\n" + //
                "                  $$  \\   /$$ |/$$$$$$  |$$  \\  /$$//$$$$$$  |$$$$$$/       $$ |  $$ |/$$$$$$  |$$$$$$$$/ $$$$$$$$/ $$ |                                    \r\n" + //
                "                  $$$  \\ /$$$ |$$ |  $$ | $$  \\/$$/ $$ |__$$ |  $$ |        $$ |__$$ |$$ |  $$ |   $$ |   $$ |__    $$ |                                    \r\n" + //
                "                  $$$$  /$$$$ |$$ |  $$ |  $$  $$/  $$    $$ |  $$ |        $$    $$ |$$ |  $$ |   $$ |   $$    |   $$ |                                    \r\n" + //
                "                  $$ $$ $$/$$ |$$ |  $$ |   $$$$/   $$$$$$$$ |  $$ |        $$$$$$$$ |$$ |  $$ |   $$ |   $$$$$/    $$ |                                    \r\n" + //
                "                  $$ |$$$/ $$ |$$ \\__$$ |    $$ |   $$ |  $$ | _$$ |_       $$ |  $$ |$$ \\__$$ |   $$ |   $$ |_____ $$ |_____                               \r\n" + //
                "                  $$ | $/  $$ |$$    $$/     $$ |   $$ |  $$ |/ $$   |      $$ |  $$ |$$    $$/    $$ |   $$       |$$       |                              \r\n" + //
                "                  $$/      $$/  $$$$$$/      $$/    $$/   $$/ $$$$$$/       $$/   $$/  $$$$$$/     $$/    $$$$$$$$/ $$$$$$$$/                               \r\n" + //
                " _______    ______    ______   __    __  ______  __    __   ______          ______   __      __  ______   ________  ________  __       __                   \r\n" + //
                "/       \\  /      \\  /      \\ /  |  /  |/      |/  \\  /  | /      \\        /      \\ /  \\    /  |/      \\ /        |/        |/  \\     /  |                  \r\n" + //
                "$$$$$$$  |/$$$$$$  |/$$$$$$  |$$ | /$$/ $$$$$$/ $$  \\ $$ |/$$$$$$  |      /$$$$$$  |$$  \\  /$$//$$$$$$  |$$$$$$$$/ $$$$$$$$/ $$  \\   /$$ |                  \r\n" + //
                "$$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |/$$/    $$ |  $$$  \\$$ |$$ | _$$/       $$ \\__$$/  $$  \\/$$/ $$ \\__$$/    $$ |   $$ |__    $$$  \\ /$$$ |                  \r\n" + //
                "$$    $$< $$ |  $$ |$$ |  $$ |$$  $$<     $$ |  $$$$  $$ |$$ |/    |      $$      \\   $$  $$/  $$      \\    $$ |   $$    |   $$$$  /$$$$ |                  \r\n" + //
                "$$$$$$$  |$$ |  $$ |$$ |  $$ |$$$$$  \\    $$ |  $$ $$ $$ |$$ |$$$$ |       $$$$$$  |   $$$$/    $$$$$$  |   $$ |   $$$$$/    $$ $$ $$/$$ |                  \r\n" + //
                "$$ |__$$ |$$ \\__$$ |$$ \\__$$ |$$ |$$  \\  _$$ |_ $$ |$$$$ |$$ \\__$$ |      /  \\__$$ |    $$ |   /  \\__$$ |   $$ |   $$ |_____ $$ |$$$/ $$ |                  \r\n" + //
                "$$    $$/ $$    $$/ $$    $$/ $$ | $$  |/ $$   |$$ | $$$ |$$    $$/       $$    $$/     $$ |   $$    $$/    $$ |   $$       |$$ | $/  $$ |                  \r\n" + //
                "$$$$$$$/   $$$$$$/   $$$$$$/  $$/   $$/ $$$$$$/ $$/   $$/  $$$$$$/         $$$$$$/      $$/     $$$$$$/     $$/    $$$$$$$$/ $$/      $$/ ");

        System.out.println("\n\n----- Moyai Hotel Booking System -----\n");
        System.out.println(" [1] Display Room Availability");
        System.out.println(" [2] Create Booking");
        System.out.println(" [3] Display All Booking Information");
        System.out.println(" [4] Edit Booking");
        System.out.println(" [5] Check-Out Guest");
        System.out.println(" [6] Generate Report");
        System.out.println(" [7] Exit\n");
        System.out.print("Enter your choice: ");
    }

    private boolean staffLogin() {
        UserInterface userInterface = new ConsoleScreenController();
        String username, password;
        boolean loginSuccess = false;
        int loginAttempts = 3;
    
        do {
            userInterface.clearScreen();
            userInterface.printCenteredHeader("Staff Login");
            System.out.print("Username: ");
            username = scanner.next();
            System.out.print("Password: ");
            password = scanner.next();
    
            if (checkCredentials(username, password)) {
                loginSuccess = true;
                userInterface.clearScreen();
                break;
            } else {
                loginAttempts--;
                System.out.print("\nInvalid username or password. Login attempts left: " + loginAttempts);
                if (loginAttempts > 0) {
                    System.out.println("\nPlease try again.");
                    userInterface.loadingAnimation();
                    userInterface.clearScreen();
                } else {
                    System.out.println("\n\nYou have reached the limit of login attempts. Please try again later after 24 hours.");
                    break;
                }
            }
        } while (loginAttempts > 0);
    
        return loginSuccess;
    }

    private boolean checkCredentials(String username, String password) {
        try {
            File file = new File("Submission\\sec01_perdana\\Group2\\files\\source-code\\HotelBookingSystem\\credentials\\credentials.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] credentials = line.split(",");

                if (credentials.length == 2) {
                    String storedUsername = credentials[0];
                    String storedPassword = credentials[1];

                    if (username.equals(storedUsername) && password.equals(storedPassword)) {
                        fileScanner.close();
                        return true;
                    }
                } else {
                    System.out.println("Error: Invalid credentials format in the file.");
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Credentials file not found. Please create new credential file");
            System.exit(0);
        }

        return false;
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

    public static void main(String[] args) throws IOException {
        HotelBookingSystemApp hotelApp = new HotelBookingSystemApp();
        
        if(hotelApp.staffLogin() == true){
            hotelApp.run();
        }
        
    }
    
    private void run() throws IOException {
        Receptionist staff = new Receptionist();
        BookingInfo booking = new BookingInfo(null, null, null, null, null);
        UserInterface userInterface = new ConsoleScreenController();
        int choice;
        do {
            displayMainMenu();
            choice = getUserChoice();
            userInterface.clearScreen();

            switch(choice){
                case 1:
                    // Display room availability
                    userInterface.clearScreen();
                    staff.displayAvailableRooms();
                    break;
                case 2:
                    // Make a booking
                    userInterface.clearScreen();
                    staff.handleBooking(booking);
                    break;
                case 3:
                    // Display booking information
                    userInterface.clearScreen();
                    staff.displayAllBookingInformation();
                    break;
                case 4:
                    // Edit booking
                    userInterface.clearScreen();
                    staff.editBooking();
                    break;
                case 5:
                    // Check-Out Guest
                    userInterface.clearScreen();
                    staff.checkOutGuest();
                    break;
                case 6:
                    // Generate report
                    userInterface.clearScreen();
                    Report report = new Report();
                    report.generateReport(staff.getBookingList());
                    break;
                case 7:
                    // Exit the program
                    System.out.println("\nExiting the program. Thank you!");
                    break;
                default:
                    // Throw an error if the user enters an invalid choice
                    System.out.print("\nInvalid choice. Please try again later");
                    userInterface.loadingAnimation();
                    userInterface.clearScreen();
            }
        } while (choice != 7);
    }
}

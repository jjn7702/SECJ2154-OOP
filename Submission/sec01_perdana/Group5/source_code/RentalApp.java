//AMIRUL HANI BIN SYAFRIZON
//B23CS0025
// RentalApp.java

public class RentalApp {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        try {
            int choice;
            Customer customer = null;
            do {
                System.out.println("\n--- Car Rental System Menu ---");
                System.out.println("1. View available car and rental prices");
                System.out.println("2. Add customer details");
                System.out.println("3. View all customer details");
                System.out.println("4. Rent a car");
                System.out.println("5. View rental history");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1-5): ");

                choice = rentalSystem.getScanner().nextInt();
                rentalSystem.getScanner().nextLine(); 

                switch (choice) {
                    case 1:
                        // View available vehicles and rental prices
                        rentalSystem.displayAvailableCar();
                        break;
                    case 2:
                        // Add user details
                        System.out.print("\nEnter customer name: ");
                        String name = rentalSystem.getScanner().nextLine();

                        System.out.print("Enter customer license number: ");
                        String licenseNumber = rentalSystem.getScanner().nextLine();

                        System.out.print("Enter customer address: ");
                        String address = rentalSystem.getScanner().nextLine();

                        System.out.print("Enter customer email: ");
                        String email = rentalSystem.getScanner().nextLine();

                        System.out.print("Enter customer phone number: ");
                        String phoneNumber = rentalSystem.getScanner().nextLine();

                        //add Customer Details
                        customer = new Customer(name, licenseNumber, address, email, phoneNumber);
                        rentalSystem.addUserDetails(customer);
                        System.out.println("\nCustomer details added: ");
                        System.out.println("Name: " + customer.getName());
                        System.out.println("License Number: " + customer.getLicenseNumber());
                        System.out.println("Address: " + customer.getAddress());
                        System.out.println("Email: " + customer.getEmail());
                        System.out.println("Phone No: " + customer.getPhoneNumber());
                        break;

                    case 3:
                        rentalSystem.printAllCustomers();
                        break;
                    case 4:
                        // Rent a car
                        if (rentalSystem.hasUserDetails()) {
                            // Display available customers
                            rentalSystem.printAllCustomers();
                            System.out.print("Enter the index of the customer to make a reservation for: ");
                            int customerIndex = rentalSystem.getScanner().nextInt();
                            rentalSystem.getScanner().nextLine();

        
                            // Validate customer index
                            if (customerIndex >= 1 && customerIndex <= rentalSystem.getCustomers().size()) {
                                Customer selectedCustomer = rentalSystem.getCustomers().get(customerIndex - 1);
                                // Choose pickup location
                                rentalSystem.displayPickupLocations();
                                System.out.print("Enter the index of the pickup location: ");
                                int pickupIndex = rentalSystem.getScanner().nextInt();
                                rentalSystem.getScanner().nextLine();

                                Location pickupLocation = rentalSystem.getPickupLocations().get(pickupIndex - 1);

                                //Choose car to rent
                                rentalSystem.displayAvailableCar();
                                System.out.print("Enter the vehicle index to reserve (1-4): ");
                                int carIndex = rentalSystem.getScanner().nextInt();
                                rentalSystem.getScanner().nextLine();
                                Rentable selectedCar = rentalSystem.chooseCarTypeByIndex(carIndex);
            
                                // Choose return location
                                rentalSystem.displayReturnLocations();
                                System.out.print("Enter the index of the return location: ");
                                int returnIndex = rentalSystem.getScanner().nextInt();
                                rentalSystem.getScanner().nextLine();

                                Location returnLocation = rentalSystem.getReturnLocations().get(returnIndex - 1);

                                Appointment appointment = rentalSystem.scheduleAppointment();
                                System.out.print("Enter the duration of rental in days: ");
                                int rentalDays = rentalSystem.getScanner().nextInt();
                                rentalSystem.getScanner().nextLine();

                                rentalSystem.rentVehicle(customer, selectedCar, appointment, pickupLocation, returnLocation, rentalDays);   
                            } else {
                                System.out.println("Invalid customer index.");
                            }
                        } else {
                            System.out.println("Please add user details first.");
                        }
                        break;
                    case 5:
                        // View rental history
                        rentalSystem.displayRentals();
                        break;
                    case 6:
                        System.out.println("Exiting Rental System. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } while (choice != 6);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            rentalSystem.closeScanner();
        }
    }
}


//AMIRUL HANI BIN SYAFRIZON
//B23CS0025
// RentalSystem.java

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.text.*;

public class RentalSystem {
    private Scanner scanner;
    private SimpleDateFormat dateFormat;
    private ArrayList<Rental> rental;
    private List<Customer> customers;
    private boolean userDetailsAdded = false;
    private Vector<Location> pickupLocations;
    private Vector<Location> returnLocations;

    public RentalSystem() {
        scanner = new Scanner(System.in);
        userDetailsAdded = false;
        customers = new ArrayList<>();  // Initialize the customers list
        rental = new ArrayList<>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pickupLocations = new Vector<>();
        returnLocations = new Vector<>();
        initializeLocations(); // Initialize locations when the system is created
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean hasUserDetails() {
        return userDetailsAdded;
    }

    public void addUserDetails(Customer customer) {
        userDetailsAdded = true;
        customers.add(customer);
    }

    public void printAllCustomers() {
        System.out.println("\n--- All Customer Information ---");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public void displayAvailableCar() {
        System.out.println("\n--- Available Car and Rental Prices ---");
        System.out.println("\n Type" + "\t\t" + "Make" + "\t" + "Model" + "\t" + "  Year" + "\t" + "Rental Price");
        for (int i = 1; i <= 4; i++) {
            Rentable car = chooseCarTypeByIndex(i);
            System.out.println(i + ". " + car.toString() + "\t" + "RM" + car.getRentalRate() + " per day");
        }
    }

        private void initializeLocations() {
        // Add sample locations, you can modify this as needed
        pickupLocations.add(new Location("123 Main St", "City1", "State1", "12345"));
        pickupLocations.add(new Location("456 Elm St", "City2", "State2", "67890"));

        returnLocations.add(new Location("789 Oak St", "City3", "State3", "98765"));
        returnLocations.add(new Location("321 Pine St", "City4", "State4", "54321"));
    }

    public void addPickupLocation(Location location) {
        pickupLocations.add(location);
    }

    public void addReturnLocation(Location location) {
        returnLocations.add(location);
    }

    public Vector<Location> getPickupLocations() {
        return pickupLocations;
    }

    public Vector<Location> getReturnLocations() {
        return returnLocations;
    }

    public void displayPickupLocations() {
        System.out.println("\n--- Pickup Locations ---");
        for (int i = 0; i < pickupLocations.size(); i++) {
            System.out.println((i + 1) + ". " + pickupLocations.get(i));
        }
    }

    public void displayReturnLocations() {
        System.out.println("\n--- Return Locations ---");
        for (int i = 0; i < returnLocations.size(); i++) {
            System.out.println((i + 1) + ". " + returnLocations.get(i));
        }
    }
    

    public void rentVehicle(Customer customer, Rentable rentable, Appointment appointment, Location pickupLocation, Location returnLocation, int rentalDays) {
        Rental rentals = new Rental(customer, rentable, appointment, pickupLocation, returnLocation, rentalDays);
        this.rental.add(rentals);
        System.out.println(rental.toString());
    }

    public List<Rental> getRental() {
        return rental;
    }

    public void displayRentals() {
        System.out.println("\n--- Rental History ---");
        for (Rental rental : rental) {
            System.out.println(rental);
            System.out.println();
        }
        System.out.println("----------------------\n");
    }


    public void closeScanner() {
        scanner.close();
    }


    public Rentable chooseCarTypeByIndex(int carIndex) {
        // Choose a vehicle based on index
        // For illustration purposes, return the vehicle from the list
        List<Rentable> availableCar = new ArrayList<>();
        availableCar.add(new CompactCar("Compact","Perodua", "Axia", 2022));
        availableCar.add(new SportCar("Sports", "Ford", "Mustang", 2022));
        availableCar.add(new SedanCar("Sedan", "Proton", "Saga", 2022));
        availableCar.add(new MPVCar("MPV\t", "Honda", "BRV", 2022));

        if (carIndex >= 1 && carIndex <= availableCar.size()) {
            return availableCar.get(carIndex - 1);
        } else {
            throw new IllegalArgumentException("Invalid vehicle index.");
        }
    }

    public Appointment scheduleAppointment() {
        System.out.print("Enter appointment date (yyyy-MM-dd HH:mm:ss): ");
        String dateString = scanner.nextLine();

        try {
            Date appointmentDate = dateFormat.parse(dateString);
            return new Appointment(appointmentDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Defaulting to current date and time.");
            return new Appointment(new Date());
        }
    }

    public Date getReservationDate() {
        System.out.print("Enter reservation date (yyyy-MM-dd HH:mm:ss): ");
        String dateString = scanner.nextLine();

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Defaulting to current date and time.");
            return new Date();
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}


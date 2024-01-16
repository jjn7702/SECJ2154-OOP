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
    private List<Rental> rental;
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
        initializeCustomers(); // Initialize customers when the system is created
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean hasUserDetails() {
        return userDetailsAdded;
    }
    
    public void initializeCustomers(){
        customers.add(new Customer("Erfan Syabil", "021026060451", "Puchong, Selangor", "muhderfan2610@gmail.com", "0198525011"));
        customers.add(new Customer("Amirul Hani", "020814112378", "Gombak, Kuala Lumpur", "amirulhani02@gmail.com", "0173223121"));
        customers.add(new Customer("Saranya Jayarama", "010515113278", "Ipoh, Perak", "saranyaJayarama@yahoo.com.my", "0178324320"));
        customers.add(new Customer("Iswary Aish", "010715442781", "Kuantan, Pahang", "aish@email.com.my", "0132454430"));
        userDetailsAdded = true;
    }

    public void addUserDetails(Customer customer) {
        userDetailsAdded = true;
        customers.add(customer);
    }

    public void printAllCustomers() {
        System.out.println("\n--- All Customer Information ---");
        int i = 1;
        for (Customer customer : customers) {
            System.out.println("\nCustomer " + i);
            System.out.println("----------------------------");
            System.out.println("Name: " + customer.getName());
            System.out.println("License Number: " + customer.getLicenseNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone No: " + customer.getPhoneNumber());
            System.out.println("----------------------------");
            i++;
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
            //Pickup Location
            pickupLocations.add(new Location("123 BP 11", "Puchong", "Selangor", "47120"));
            pickupLocations.add(new Location("456 NP 32", "Kulai", "Johor", "81310"));
            pickupLocations.add(new Location("789 Villa", "Kuantan", "Pahang", "43543"));
            pickupLocations.add(new Location("102 Elm St", "Gombak", "Kuala Lumpur", "91232"));
            pickupLocations.add(new Location("879 Oak St", "Ipoh", "Perak", "30000"));
            pickupLocations.add(new Location("321 Pine St", "Jeli", "Kelanatan", "54321"));
        

            //Return Location
            returnLocations.add(new Location("123 BP 11", "Puchong", "Selangor", "47120"));
            returnLocations.add(new Location("456 NP 32", "Kulai", "Johor", "81310"));
            returnLocations.add(new Location("879 Villa", "Kuantan", "Pahang", "43543"));
            returnLocations.add(new Location("102 Elm St", "Gombak", "Kuala Lumpur", "91232"));
            returnLocations.add(new Location("879 Oak St", "Ipoh", "Perak", "30000"));
            returnLocations.add(new Location("321 Pine St", "Jeli", "Kelanatan", "54321"));
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
        int i = 1;
        for (Location pickupLocation : pickupLocations) {
            System.out.println(i + ". " + pickupLocation.getAddress() +  ", " + pickupLocation.getCity() + ", " + pickupLocation.getState() + ", " + pickupLocation.getZipCode());
            i++;
        }
    }

    public void displayReturnLocations() {
        System.out.println("\n--- Return Locations ---");
        int i = 1;
        for (Location returnLocation : returnLocations) {
            System.out.println(i + ". " + returnLocation.getAddress() +  ", " + returnLocation.getCity() + ", " + returnLocation.getState() + ", " + returnLocation.getZipCode());
            i++;
        }
    }
    

    public void rentVehicle(Customer customer, Rentable rentable, Appointment appointment, Location pickupLocation, Location returnLocation, int rentalDays) {
        Rental rental = new Rental(customer, rentable, appointment, pickupLocation, returnLocation, rentalDays);
        this.rental.add(rental);

        System.out.println("-------------------------------------------------");
        System.out.println("\nRental Successful for: " + customer.getName());

        System.out.println("\nName: " + customer.getName());
        System.out.println("License Number: " + customer.getLicenseNumber());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone Number: " + customer.getPhoneNumber());

        System.out.println("\nCar rented: " + rentable);
        System.out.println("Pickup date: " + rental.getAppointment().getAppointmentDate());
        System.out.println("Pickup location: " + rental.getPLocation().toString());
        System.out.println("Return location: " + rental.getPLocation().toString());
        System.out.println("Duration: " + rental.getRentalDays() + " day(s)");
        System.out.printf("\nTotal: RM%.2f", rental.calculateRentalCost());
        System.out.println("\n-------------------------------------------------");
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


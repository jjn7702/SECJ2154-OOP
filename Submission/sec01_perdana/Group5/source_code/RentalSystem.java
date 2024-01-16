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
    //variable
    private Scanner scanner;
    private SimpleDateFormat dateFormat;
    private List<Rental> rental;
    private List<Customer> customers;
    private boolean customerDetailsAdded = false;
    private Vector<Location> pickupLocations;
    private Vector<Location> returnLocations;

    //constructor
    public RentalSystem() {
        scanner = new Scanner(System.in);
        customerDetailsAdded = false;
        customers = new ArrayList<>();  // Initialize the customers list
        rental = new ArrayList<>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pickupLocations = new Vector<>();
        returnLocations = new Vector<>();
        initializeLocations(); // Initialize locations when the system is created
        initializeCustomers(); // Initialize customers when the system is created
    }

    //Scanner method for input
    public Scanner getScanner() {
        return scanner;
    }

    //Check whether is there customer detail
    public boolean hasCustomerDetails() {
        return customerDetailsAdded;
    }
    
    //Initialize customer 
    public void initializeCustomers(){
        customers.add(new Customer("Erfan Syabil", "021026060451", "Puchong, Selangor", "muhderfan2610@gmail.com", "0198525011"));
        customers.add(new Customer("Amirul Hani", "020814112378", "Gombak, Kuala Lumpur", "amirulhani02@gmail.com", "0173223121"));
        customers.add(new Customer("Saranya Jayarama", "010515113278", "Ipoh, Perak", "saranyaJayarama@yahoo.com.my", "0178324320"));
        customers.add(new Customer("Iswary Aish", "010715442781", "Kuantan, Pahang", "aish@email.com.my", "0132454430"));
        customerDetailsAdded = true;
    }

    //To add user in the Customer List
    public void addCustomerDetails(Customer customer) {
        customerDetailsAdded = true;
        customers.add(customer);
    }

    //Display all Customer in the list
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

    //Display all available Car by retrieving the list in chooseCarTypeByIndex() method
    public void displayAvailableCar() {
        System.out.println("\n--- Available Car and Rental Prices ---");
        System.out.println("\n Type" + "\t\t" + "Make" + "\t" + "Model" + "\t" + "  Year" + "\t" + "Rental Price");
        for (int i = 1; i <= 4; i++) {
            Rentable car = chooseCarTypeByIndex(i);
            System.out.println(i + ". " + car.toString() + "\t" + "RM" + car.getRentalRate() + " per day");
        }
    }

    //Initialize pickup and return location
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

    //Add pickup location into the vector location
    public void addPickupLocation(Location location) {
        pickupLocations.add(location);
    }

    //Add return location into the vector location
    public void addReturnLocation(Location location) {
        returnLocations.add(location);
    }

    //Retrieve pickup location object
    public Vector<Location> getPickupLocations() {
        return pickupLocations;
    }

    //Retrieve return location object
    public Vector<Location> getReturnLocations() {
        return returnLocations;
    }

    //Display pickup location
    public void displayPickupLocations() {
        System.out.println("\n--- Pickup Locations ---");
        int i = 1;
        for (Location pickupLocation : pickupLocations) {
            System.out.println(i + ". " + pickupLocation.getAddress() +  ", " + pickupLocation.getCity() + ", " + pickupLocation.getState() + ", " + pickupLocation.getZipCode());
            i++;
        }
    }

    //Display return location
    public void displayReturnLocations() {
        System.out.println("\n--- Return Locations ---");
        int i = 1;
        for (Location returnLocation : returnLocations) {
            System.out.println(i + ". " + returnLocation.getAddress() +  ", " + returnLocation.getCity() + ", " + returnLocation.getState() + ", " + returnLocation.getZipCode());
            i++;
        }
    }
    

    //Rent a vehicle and after that produce output containing info about customer, car rented, pickup time, pickup and return location, duration and total.
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

    //To display rental history
    public void displayRentals() {
        System.out.println("\n--- Rental History ---");
        for (Rental rental : rental) {
            System.out.println("\nName: " + rental.getCustomer().getName());
            System.out.println("License Number: " + rental.getCustomer().getLicenseNumber());
            System.out.println("Address: " + rental.getCustomer().getAddress());
            System.out.println("Email: " + rental.getCustomer().getEmail());
            System.out.println("Phone Number: " + rental.getCustomer().getPhoneNumber());

            System.out.println("\nCar rented: " + rental.getRentable());
            System.out.println("Pickup date: " + rental.getAppointment().getAppointmentDate());
            System.out.println("Pickup location: " + rental.getPLocation().toString());
            System.out.println("Return location: " + rental.getPLocation().toString());
            System.out.println("Duration: " + rental.getRentalDays() + " day(s)");
            System.out.printf("\nTotal: RM%.2f", rental.calculateRentalCost());
            System.out.println("\n-------------------------------------------------");
        }
    }

    //Close scanner to prevent resource leak
    public void closeScanner() {
        scanner.close();
    }

    //Initialize car into arrayList and return the list index
    public Rentable chooseCarTypeByIndex(int carIndex) {
        // Choose a vehicle based on index
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

    //Set appointment using appropriate format of date and time
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

    //Retrieve customer object.
    public List<Customer> getCustomers() {
        return customers;
    }
}


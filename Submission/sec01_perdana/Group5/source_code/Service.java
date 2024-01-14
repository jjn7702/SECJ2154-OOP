// Service.java
public class Service {
    private Customer customer;
    private Rentable rentable;
    private int days;
    private Appointment appointment;
    private Location pickupLocation;

    public Service(Customer customer, Rentable rentable, int days, Appointment appointment, Location pickupLocation) {
        this.customer = customer;
        this.rentable = rentable;
        this.days = days;
        this.appointment = appointment;
        this.pickupLocation = pickupLocation;
    }

    public double calculateRentalCost() {
        return rentable.getRentalRate() * days;
    }

    @Override
    public String toString() {
        return customer + " rented " + rentable + " for " + days + " days. Total cost: $" + calculateRentalCost() +
               "\n" + appointment + "\n" + pickupLocation;
    }
}

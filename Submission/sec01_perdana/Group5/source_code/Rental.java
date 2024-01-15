//SARANYA A/P JAYARAMA REDDY (B22EC3013)
public class Rental {
    private Customer customer;
    private Rentable rentable;
    private int days;
    private Appointment appointment;
    private Location pickupLocation;

    public Rental(Customer customer, Rentable rentable, int days, Appointment appointment, Location pickupLocation){
        this.customer = customer;
        this.rentable = rentable;
        this.days = days;
        this.appointment = appointment;
        this.pickupLocation = pickupLocation;
    }

     public double calculateRentalCost(){
         return rentable.getRentalRate() * days;
     }

     public String toString(){
         return customer + " rented " + rentable + " for " + days + " days. Total cost: RM " + calculateRentalCost() + "\n" + appointment + "\n" + pickupLocation;
     }
}

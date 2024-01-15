public class Reservation {
    private Customer customer;
    private Rentable reservedVehicle;
    private Location pickupLocation;
    private Date reservationDate;

    public Reservation(Customer customer, Rentable reservedVehicle, Location pickupLocation, Date reservationDate) {
        this.customer = customer;
        this.reservedVehicle = reservedVehicle;
        this.pickupLocation = pickupLocation;
        this.reservationDate = reservationDate;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return customer + " reserved " + reservedVehicle + " at " + sdf.format(reservationDate) + "\n" + locationpickup;
    }
}


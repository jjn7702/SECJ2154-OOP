public class Reservation {
    private Customer customer;
    private Rentable reservedVehicle;
    private Location locationPickup;
    private Date reservationDate;

    public Reservation(Customer customer, Rentable reservedVehicle, Location locationPickup, Date reservationDate) {
        this.customer = customer;
        this.reservedVehicle = reservedVehicle;
        this.locationPickup = locationPickup;
        this.reservationDate = reservationDate;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return customer + " reserved " + reservedVehicle + " at " + sdf.format(reservationDate) + "\n" + locationPickup;
    }
}


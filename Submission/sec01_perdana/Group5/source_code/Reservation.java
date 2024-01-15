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
        SimpleDateFormatReservation DateFormat = new SimpleDateFormatReservation("HH:mm:ss yyyy-MM-dd");
        return customer + " will be reserved " + reservedVehicle + " at " + DateFormat.format(reservationDate) + "\n" + locationPickup;
    }
}


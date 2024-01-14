public class CarRentalLocation {
    private String locationPickup;

    public CarRentalLocation(String locationPickup) {
        this.locationPickup = locationPickup;
    }

    public String toString() {
        return "Rental Location: " + locationPickup;
    }
}

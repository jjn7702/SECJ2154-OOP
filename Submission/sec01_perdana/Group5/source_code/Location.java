public class Location {
    private String locationPickup;

    public Location(String locationPickup) {
        this.locationPickup = locationPickup;
    }

    public String toString() {
        return "Rental Location: " + locationPickup;
    }
}

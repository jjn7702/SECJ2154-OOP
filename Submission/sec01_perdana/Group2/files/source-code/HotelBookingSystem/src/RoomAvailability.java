public class RoomAvailability {
    private AvailabilityStatus availabilityStatus;

    public RoomAvailability() {
        // Default to AVAILABLE when a new instance is created
        this.availabilityStatus = AvailabilityStatus.AVAILABLE;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void markUnavailable() {
        this.availabilityStatus = AvailabilityStatus.UNAVAILABLE;
    }

    public void markAvailable() {
        this.availabilityStatus = AvailabilityStatus.AVAILABLE;
    }

    // Other methods related to room availability...

    // Enum to represent availability status
    public enum AvailabilityStatus {
        AVAILABLE,
        UNAVAILABLE
    }
}

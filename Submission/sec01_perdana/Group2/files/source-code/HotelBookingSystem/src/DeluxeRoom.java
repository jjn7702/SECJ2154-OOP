public class DeluxeRoom extends Room {
    private static int deluxeRoomCounter = 200; // Start room number for Standard Room
    private RoomAvailability availability;
    private RoomPrice roomPrice;

    // Enum for Standard Room Type and Base Price
    public enum DeluxeRoomType {
        DELUXE(200.0); // The start room number is now managed separately

        private final double basePrice;

        DeluxeRoomType(double basePrice) {
            this.basePrice = basePrice;
        }

        public double getBasePrice() {
            return basePrice;
        }
    }

    public DeluxeRoom(RoomAvailability availability, RoomPrice roomPrice) {
        super(deluxeRoomCounter++, 6, "Deluxe", roomPrice, availability);
        this.availability = availability;
        this.roomPrice = roomPrice;
    }    

    public RoomAvailability getAvailability() {
        return availability;
    }

    public RoomPrice getRoomPrice() {
        return roomPrice;
    }
}
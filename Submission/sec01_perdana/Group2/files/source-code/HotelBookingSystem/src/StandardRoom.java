public class StandardRoom extends Room {
    private static int standardRoomCounter = 100; // Start room number for Standard Room
    private RoomAvailability availability;
    private RoomPrice roomPrice;

    // Enum for Standard Room Type and Base Price
    public enum StandardRoomType {
        STANDARD(100.0); // The start room number is now managed separately

        private final double basePrice;

        StandardRoomType(double basePrice) {
            this.basePrice = basePrice;
        }

        public double getBasePrice() {
            return basePrice;
        }
    }

    public StandardRoom(RoomAvailability availability, RoomPrice roomPrice) {
        super(standardRoomCounter++, 2, "Standard", roomPrice, availability);
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

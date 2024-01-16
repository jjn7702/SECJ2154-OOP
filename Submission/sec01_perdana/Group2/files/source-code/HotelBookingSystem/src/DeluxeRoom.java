// Inheritance: DeluxeRoom extends the Room class, inheriting its attributes and methods.
public class DeluxeRoom extends Room {

    // Enum for DeluxeRoomType with associated base price.
    public enum DeluxeRoomType {
        DELUXE(200.0); // The start room number is now managed separately

        private final double basePrice;

        DeluxeRoomType(double basePrice) {
            this.basePrice = basePrice;
        }

        // Encapsulation: Provides access to the private basePrice field.
        public double getBasePrice() {
            return basePrice;
        }
    }

    // Constructor: Initializes DeluxeRoom with specific DeluxeRoomType, availability, and room price.
    public DeluxeRoom(DeluxeRoomType roomType, boolean availability, double roomPrice) {
        // Constructor chaining: Calls the superclass constructor to initialize common attributes.
        super(0, 6, "Deluxe", roomPrice, availability);
    }

    // Polymorphism and Method Override: Overrides the description method in the base class Room.
    @Override
    public String description() {
        return "Deluxe Room with capacity of " + getCapacity() + " guest.";
    }
}
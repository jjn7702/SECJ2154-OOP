// Inheritance: StandardRoom extends the Room class, inheriting its attributes and methods.
public class StandardRoom extends Room {

    // Enum for StandardRoomType with associated base price.
    public enum StandardRoomType {
        STANDARD(100.0); // The start room number is now managed separately

        private final double basePrice;

        StandardRoomType(double basePrice) {
            this.basePrice = basePrice;
        }

        // Encapsulation: Provides access to the private basePrice field.
        public double getBasePrice() {
            return basePrice;
        }
    }

    // Constructor: Initializes StandardRoom with specific StandardRoomType, availability, and room price.
    public StandardRoom(StandardRoomType roomType, boolean availability, double roomPrice) {
        // Constructor chaining: Calls the superclass constructor to initialize common attributes.
        super(0, 2, "Standard", roomPrice, availability);
    }    

    // Polymorphism and Method Override: Overrides the description method in the base class Room.
    @Override
    public String description() {
        return "Standard Room with capacity of " + getCapacity() + " guest.";
    }
}
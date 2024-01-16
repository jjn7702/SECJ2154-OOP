// Inheritance: SuperiorRoom extends the Room class, inheriting its attributes and methods.
public class SuperiorRoom extends Room {

    // Enum for SuperiorRoomType with associated base price.
    public enum SuperiorRoomType {
        SUPERIOR(300.0); // The start room number is now managed separately

        private final double basePrice;

        SuperiorRoomType(double basePrice) {
            this.basePrice = basePrice;
        }

        // Encapsulation: Provides access to the private basePrice field.
        public double getBasePrice() {
            return basePrice;
        }
    }

    // Constructor: Initializes SuperiorRoom with specific SuperiorRoomType, availability, and room price.
    public SuperiorRoom(SuperiorRoomType roomType, boolean availability, double roomPrice) {
        // Constructor chaining: Calls the superclass constructor to initialize common attributes.
        super(0, 4, "Superior", roomPrice, availability);
    }    

    // Polymorphism and Method Override: Overrides the description method in the base class Room.
    @Override
    public String description() {
        return "Superior Room with capacity of " + getCapacity() + " guest.";
    }
}

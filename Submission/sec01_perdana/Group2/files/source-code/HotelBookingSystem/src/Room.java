// Abstraction: Declares an abstract class named Room, serving as a base class for specific types of rooms.
abstract class Room {
    
    // Encapsulation: Protected fields to encapsulate the internal state, accessible to subclasses.
    protected int roomNumber;
    protected int capacity;
    protected String roomType;  // Added roomType
    protected double price;
    protected boolean isAvailable;

    // Encapsulation and Constructor: Initializes the common attributes of a room during object creation.
    public Room(int roomNumber, int capacity, String roomType, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomType = roomType;  // Set roomType in the constructor
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getter methods: Provide access to the private/protected fields, following encapsulation principles.
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    // Setter methods: Allow modification of protected fields, following encapsulation principles.
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Abstraction: Declares an abstract method without implementation details, to be defined by subclasses.
    public abstract String description();
}

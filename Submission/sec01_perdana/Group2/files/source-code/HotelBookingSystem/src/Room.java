// Room.java
public class Room {
    protected int roomNumber;
    protected int capacity;
    protected String roomType;  // Added roomType
    protected RoomPrice price;
    protected RoomAvailability isAvailable;

    public Room(int roomNumber, int capacity, String roomType, RoomPrice price, RoomAvailability isAvailable) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomType = roomType;  // Set roomType in the constructor
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public RoomPrice getPrice() {
        return price;
    }

    public RoomAvailability getIsAvailable() {
        return isAvailable;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(RoomPrice price) {
        this.price = price;
    }

    public void setIsAvailable(RoomAvailability isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber=" + roomNumber + ", capacity=" + capacity + ", roomType=" + roomType + ", price=" + price + ", isAvailable=" + isAvailable + '}';
    }
}

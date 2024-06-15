import java.util.*;

public class Hotel {
    private String hotelName, address, roomSize;
    private String checkInTime = "3:00 pm";
    private String checkOutTime = "12:00 pm";
    private Object[][] roomSizeAvailable = {
            { "Singel Room", 150 },
            { "Double Room", 200 },
            { "Twin Room", 200 },
            { "King Room", 500 },
            { "Junior Suite", 1000 },
            { "Suite", 5000 },
            { "Presidential Suite", 7500 }
    };

    private int noRoom;

    // Untuk jemaah purpose
    public Hotel(String hotelName, String address, String roomSize, int noRoom) {
        this.hotelName = hotelName;
        this.address = address;
        this.roomSize = roomSize;
        this.noRoom = noRoom;
    }

    // untuk hotel purpose
    public Hotel(String hotelName, String address, int noRoom) {
        this.hotelName = hotelName;
        this.address = address;
        this.noRoom = noRoom;
    }

    public void display_Hotel_Info() {
        System.out.println("========= HOTEL INFO ==========");
        System.out.println("Hotel: " + hotelName);
        System.out.println("Address: " + address);
        System.out.println("=========Standard check in time and check out time========== ");
        System.out.println("Check in time: " + checkInTime);
        System.out.println("Check out time: " + checkOutTime);
        System.out.println("Room size and price available: ");
        for (int i = 0; i < roomSizeAvailable.length; i++) {
            for (int j = 0; j < roomSizeAvailable[i].length; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + ")");
                    System.out.print(roomSizeAvailable[i][j]);
                } else if (j == 1) {
                    System.out.print(" RM " + roomSizeAvailable[i][j]);
                }

            }
            System.out.println();
        }
        System.out.println("No of room available: " + noRoom);
    }

}
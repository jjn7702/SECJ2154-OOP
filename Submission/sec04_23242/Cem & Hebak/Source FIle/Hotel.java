// import java.util.*;

import java.util.Scanner;

public class Hotel {
    private String hotelName, address, roomSize;
    private double price, distance_MasjidilHaram, distance_MasjidilNabawi;
    private String checkInTime = "3:00 pm";
    private String checkOutTime = "12:00 pm";
    private int totalRoom;
    Scanner inp = new Scanner(System.in);

    // // constructor untuk hotel di madinah and mekah
    // public Hotel(String hotelName, String address, double price, double
    // distance_MasjidilHaram,
    // double distance_MasjidilNabawi) {
    // this.hotelName = hotelName;
    // this.address = address;
    // this.price = price;
    // this.roomSize = "Double Room";
    // }

    // kenapa ada constructor ni?????
    public Hotel(String hotelName, String address, double price, int totalRoom, double distance_MasjidilHaram,
            double distance_MasjidilNabawi) {
        this.hotelName = hotelName;
        this.address = address;
        this.price = price;
        this.totalRoom = totalRoom;
        this.roomSize = "Double Room";
        this.distance_MasjidilHaram = distance_MasjidilHaram;
        this.distance_MasjidilNabawi = distance_MasjidilNabawi;
    }

    // constructor untuk hotel selain mekah dan madinah
    public Hotel(String hotelName, String address, int totalRoom) {
        this.hotelName = hotelName;
        this.address = address;
        this.roomSize = "";
        this.price = 0;
        this.totalRoom = totalRoom;
    }

    public double getPrice() {
        return price;
    }

    public void chooseRoomSize() {
        Object[][] jenisBilik = { { "Single Room", 200.00 },
                { "Double Room", 135.00 },
                { "Twin Room", 135.0 },
                { "Queen Room", 175.0 },
                { "King Room", 210.0 },
                { "Studio Room", 250.0 },
                { "Junior Suite", 350.0 },
                { "Suite", 625.0 },
                { "Presidential Suite", 3000.0 },
                { "Penthouse Suite", 6000.0 } };
        int choice = 0;
        System.out.println("Choose your preferred room: ");
        System.out.printf("%-20s%1s%n", "Room", "Price");
        for (int i = 0; i < jenisBilik.length; i++) {
            System.out.print((i + 1) + ") ");
            System.out.printf("%-20sRM %.2f%n", jenisBilik[i][0], jenisBilik[i][1]);
        }
        System.out.println("=========================================================");
        System.out.print("[1 - 10] Choose your room\nYour choice: ");
        choice = (inp.nextInt() - 1);

        roomSize = (String) jenisBilik[choice][0];
        price += (double) jenisBilik[choice][1];

    }

    public void display_Hotel_Ibadah_Info() {
        // System.out.println("================== HOTEL INFO ===================");
        System.out.printf("%-35s: %20s%n", "Hotel", hotelName);
        System.out.printf("%-35s: %20s%n", "Address", address);
        System.out.printf("%-35s: %20.2f%n", "Price", price);
        System.out.printf("%-35s: %20s%n", "Room Size", roomSize);
        System.out.printf("%-35s: %20.2f km%n", "Distance from Masjidil Haram", distance_MasjidilHaram);
        System.out.printf("%-35s: %20.2f km%n", "Distance from Masjidil Nabawi", distance_MasjidilNabawi);
        System.out.println("Standard check-in and check-out times:");
        System.out.printf("%-35s: %20s%n", "Check-in time", checkInTime);
        System.out.printf("%-35s: %20s%n", "Check-out time", checkOutTime);
        System.out.printf("%-35s: %20d%n", "Number of rooms", totalRoom);
    }

    public void display_Hotel_Info() {
        System.out.printf("%-35s: %20s%n", "Hotel", hotelName);
        System.out.printf("%-35s: %20s%n", "Address", address);
        System.out.printf("%-35s: %20s%n", "Room Size", roomSize);
        System.out.printf("%-35s: %20.2f%n", "Room Price (RM)", price);
        System.out.println("Standard check-in and check-out times:");
        System.out.printf("%-35s: %20s%n", "Check-in time", checkInTime);
        System.out.printf("%-35s: %20s%n", "Check-out time", checkOutTime);
        System.out.printf("%-35s: %20d%n", "Number of rooms", totalRoom);
    }
}

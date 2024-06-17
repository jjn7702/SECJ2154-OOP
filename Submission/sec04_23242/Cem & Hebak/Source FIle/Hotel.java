// import java.util.*;

public class Hotel {
    private String hotelName, address;
    private double price, distance_MasjidilHaram, distance_MasjidilNabawi;
    private String checkInTime = "3:00 pm";
    private String checkOutTime = "12:00 pm";
    private int noRoom;

    public Hotel(String hotelName, String address, double price, double distance_MasjidilHaram,
            double distance_MasjidilNabawi) {
        this.hotelName = hotelName;
        this.address = address;
        this.price = price;
        this.distance_MasjidilHaram = distance_MasjidilHaram;
        this.distance_MasjidilNabawi = distance_MasjidilNabawi;
    }

    public void display_Hotel_Info() {
        // System.out.println("========= HOTEL INFO ==========");
        System.out.println("Hotel: " + hotelName);
        System.out.println("Address: " + address);
        System.out.println("Price: " + price);
        System.out.println("Distance from Masjidil Haram: " + distance_MasjidilHaram);
        System.out.println("Distance from Masjididl Nabawi: " + distance_MasjidilNabawi);
        System.out.println("Standard check in time and check out time");
        System.out.println("Check in time: " + checkInTime);
        System.out.println("Check out time: " + checkOutTime);
        System.out.println("No of room: " + noRoom);
    }

}
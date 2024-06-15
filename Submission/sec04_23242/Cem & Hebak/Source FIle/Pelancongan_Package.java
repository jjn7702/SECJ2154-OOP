import java.util.*;

public enum Pelancongan_Package {

    Packej1(new Vector<>(List.of("Turki", "Istanbul")), "Uso", 2500.00,
            new Vector<>(List.of(new Flight("D23", "14/6/2024", "20/6/2024", "0500", "1300", "Mekah", "Jeddah"))),
            new Vector<>(List.of(new Hotel("Hotel Istana", "73nruhhhhhhh", "Wilayah Persekutuan", 500))));
    // new Vector<>(Vector.of(new Flight("D23", "14/6/2024", "20/6/2024", "0500",
    // "1300", "Mekah", "Jeddah"))),
    // new Vector<>(Vector.of(new Hotel("Hotel Istana", "73nruhhhhhhh", "Wilayah
    // Persekutuan", 500))));

    private Vector<String> places;
    private String tour_Guide;
    private double price_Pelancongan;
    private Vector<Hotel> hotel_Pelancongan;
    private Vector<Flight> flight_Pelancongan;

    private Pelancongan_Package(Vector<String> places, String tour_Guide, double price_Pelancongan,
            Vector<Flight> flights, Vector<Hotel> hotels) {
        this.places = places;
        this.tour_Guide = tour_Guide;
        this.price_Pelancongan = price_Pelancongan;
        this.flight_Pelancongan = flights;
        this.hotel_Pelancongan = hotels;
    }

    public void display_Pelancongan_info() {

    }

    public void add_Hotel_Pelancongan(Hotel h) {

    }

}
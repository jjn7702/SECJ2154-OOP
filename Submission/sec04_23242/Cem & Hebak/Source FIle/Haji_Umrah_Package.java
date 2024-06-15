import java.util.List;
import java.util.Vector;

public enum Haji_Umrah_Package {
    // package 1 = haji ifrad (haji pastu umrah)
    IFRAD("Haji", "Umrah",
        new Vector<>(List.of(new Flight("AA", "22 May 2024", "22 July 2024", "0000", "1730", "KLIA", "Jeddah"))),
        new Vector<>(List.of(new Hotel("Hotel Oyo", "Mekkah", 219))), // use 3-arg hotel constructor
        new Vector<>(List.of(new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"))),
        15000),
    // package 2 = haji qiran (haji dan umrah serentak)
    QIRAN("Haji dan Umrah",
        new Vector<>(List.of(new Flight("MAS", "30 May 2024", "30 Jun 2024", "0000", "1730", "KLIA", "Jeddah"))),
        new Vector<>(List.of(new Hotel("Hotel Oyo", "Mekkah", 219))), // use 3-arg hotel constructor
        new Vector<>(List.of(new Kursus("0002", "12:00 PM", "12 May 2024", "DSI", "Don"))),
        20000),
    // package 3 = haji tamattuk (umrah dan haji)
    TAMATTUK("Haji", "Umrah",
        new Vector<>(List.of(new Flight("AA", "22 May 2024", "10 Jun 2024", "0320", "1120", "KLIA", "Jeddah"))),
        new Vector<>(List.of(new Hotel("Hotel Oyo", "Mekkah", 219))), // use 3-arg hotel constructor 
        new Vector<>(List.of(new Kursus("0003", "3:30 PM", "12 May 2024", "DSI", "Kazim"))),
        15000),
    // package 4 = haji sahaja
    HAJI("Haji", null,
        new Vector<>(List.of(new Flight("AA", "22 May 2024", "22 July 2024", "0415", "1215", "KLIA", "Jeddah"))),
        new Vector<>(List.of(new Hotel("Hotel Oyo", "Mekkah", 219))), // use 3-arg hotel constructor
        new Vector<>(List.of(new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"))),
        10000),
    // package 5 = umrah sahaja
    UMRAH(null, "Umrah",
        new Vector<>(List.of(new Flight("AA", "22 May 2024", "22 July 2024", "0045", "0545", "KLIA", "Jeddah"))),
        new Vector<>(List.of(new Hotel("Hotel Oyo", "Mekkah", 219))), // use 3-arg hotel constructor
        new Vector<>(List.of(new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji")),
        5000);
    // buat lagi 2 pakej, untuk haji ifrad, qiran, tamattuk pastu ko comment kan
    // package 1 = haji ifrad (haji pastu umrah)
    // package 2 = haji qiran (haji dan umrah serentak)
    // package 3 = haji tamattuk (umrah dan haji)

    // contoh nak buat dalam enum ada vector. macam ni
    // Packej1(new Vector<>(List.of("Turki", "Istanbul")), "Uso", 2500.00,
    // new Vector<>(List.of(new Flight("D23", "14/6/2024", "20/6/2024", "0500",
    // "1300", "Mekah", "Jeddah"))),
    // new Vector<>(List.of(new Hotel("Hotel Istana", "73nruhhhhhhh", "Wilayah
    // Persekutuan", 500))));

    // contoh consstructor enum dalam tu ada vector
    // private Pelancongan_package(Vector<String> places, String tour_Guide, double
    // price_Pelancongan,
    // Vector<Flight> flights, Vector<Hotel> hotels) {
    // this.places = places;
    // this.tour_Guide = tour_Guide;
    // this.price_Pelancongan = price_Pelancongan;
    // this.flight_Pelancongan = flights;
    // this.hotel_Pelancongan = hotels;
    // }
    private String Haji;
    private String Umrah;
    private String Haji_Umrah;
    //private Flight depart;
    private Vector<Flight> flight_Ibadah;
    //private Hotel h1;
    private Vector<Hotel> hotel_Ibadah;
    //private Kursus kursus;
    private Vector<Kursus> kursus_Ibadah;
    private Pelancongan_Package plgPkg;
    private double price;

    private Haji_Umrah_Package(String Haji, String Umrah, Vector<Flight> flight_Ibadah, Vector<Hotel> hotel_Ibadah, Vector<Kursus> kursus_Ibadah, double price) {
        this.Haji = Haji;
        this.Umrah = Umrah;
        this.flight_Ibadah = flight_Ibadah;
        this.hotel_Ibadah = hotel_Ibadah;
        this.kursus_Ibadah = kursus_Ibadah;
        this.price = price;
    }

    private Haji_Umrah_Package(String Haji_Umrah, Vector<Flight> flight_Ibadah, Vector<Hotel> hotel_Ibadah, Vector<Kursus> kursus, double price) {
        this.Haji_Umrah = Haji_Umrah;
        this.flight_Ibadah = flight_Ibadah;
        this.hotel_Ibadah = hotel_Ibadah;
        this.kursus_Ibadah = kursus_Ibadah;
        this.price = price;
    }

    public void add_Pelancongan_Package(Pelancongan_Package p){
        
    }

    public void Display_Pakej_Info() {

    }
}

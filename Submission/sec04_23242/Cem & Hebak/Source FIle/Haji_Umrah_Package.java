import java.util.Vector;

public enum Haji_Umrah_Package {
    // package 1 = haji ifrad (haji pastu umrah)
    PACKAGE1("Haji", "Umrah",
            new Flight("AA", "22 May 2024", "22 July 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"),
            new Hotel("Hotel Oyo", "Mekkah", "2 person", 219),
            new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji")),
    // package 2 = haji qiran (haji dan umrah serentak)
    PACKAGE2("Haji dan Umrah",
            new Flight("MAS", "30 May 2024", "30 Jun 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"),
            new Hotel("Hotel Oyo", "Mekkah", "2 person", 219),
            new Kursus("0002", "12:00 PM", "12 May 2024", "DSI", "Don")),
    // package 3 = haji tamattuk (umrah dan haji)
    PACKAGE3("Umrah", new Flight("AA", "22 May 2024", "10 Jun 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"),
            new Hotel("Hotel Oyo", "Mekkah", "2 person", 219),
            new Kursus("0003", "3:30 PM", "12 May 2024", "DSI", "Kazim"), "Haji"),
    // package 4 = haji sahaja
    PACKAGE4("Haji", null,
            new Flight("AA", "22 May 2024", "22 July 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"),
            new Hotel("Hotel Oyo", "Mekkah", "2 person", 219),
            new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji")),
    // package 5 = umrah sahaja
    PACKAGE5(null, "Umrah",
            new Flight("AA", "22 May 2024", "22 July 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"),
            new Hotel("Hotel Oyo", "Mekkah", "2 person", 219),
            new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"));
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
    private Flight depart;
    private Vector<Flight> flight_Ibadah;
    private Hotel h1;
    private Vector<Hotel> hotel_Ibadah;
    private Kursus kursus;
    private Vector<Kursus> kursus_Ibadah;
    private double price;

    private Haji_Umrah_Package(String Haji, String Umrah, Flight depart, Hotel h1, Kursus kursus) {
        this.Haji = Haji;
        this.Umrah = Umrah;
        this.depart = depart;
        this.h1 = h1;
        this.kursus = kursus;
        flight_Ibadah = new Vector<>();
        hotel_Ibadah = new Vector<>();
        kursus_Ibadah = new Vector<>();
    }

    private Haji_Umrah_Package(String Umrah, Flight depart, Hotel h1, Kursus kursus, String Haji) {
        this.Haji = Haji;
        this.Umrah = Umrah;
        this.depart = depart;
        this.h1 = h1;
        this.kursus = kursus;
        flight_Ibadah = new Vector<>();
        hotel_Ibadah = new Vector<>();
        kursus_Ibadah = new Vector<>();
    }

    private Haji_Umrah_Package(String Haji_Umrah, Flight depart, Hotel h1, Kursus kursus) {
        this.Haji_Umrah = Haji_Umrah;
        this.depart = depart;
        this.h1 = h1;
        this.kursus = kursus;
        flight_Ibadah = new Vector<>();
        hotel_Ibadah = new Vector<>();
        kursus_Ibadah = new Vector<>();
    }

    public void Display_Pakej_Info() {

    }
}

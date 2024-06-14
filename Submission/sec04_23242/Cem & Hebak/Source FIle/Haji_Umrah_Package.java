import java.util.Vector;

public enum Haji_Umrah_Package {
    PACKAGE1("Haji", "Umrah", new Flight("AA", "22 May 2024", "22 July 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"), new Hotel("Hotel Oyo", "Mekkah", "2 person", 219), new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji")),
    PACKAGE2("Haji", null, new Flight("MAS", "30 May 2024", "30 Jun 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"), new Hotel("Hotel Oyo", "Mekkah", "2 person", 219), new Kursus("0002", "12:00 PM", "12 May 2024", "DSI", "Don")),
    PACKAGE3(null, "Umrah", new Flight("AA", "22 May 2024", "10 Jun 2024", "12:00 AM", "5:30 PM", "Mekkah", "Malaysia"), new Hotel("Hotel Oyo", "Mekkah", "2 person", 219), new Kursus("0003", "3:30 PM", "12 May 2024", "DSI", "Kazim"));
    
    private String Haji;
    private String Umrah;
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

    public void Display_Pakej_Info(){
        
    }
}

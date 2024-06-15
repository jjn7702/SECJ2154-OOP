import java.util.List;
import java.util.Vector;

public enum Pelancongan_Package {

        Package_1(new Vector<>(List.of("Turki", "Istanbul")), "Uso", 2500.00,
                new Vector<>(List.of(new Flight("D23", "14/6/2024", "20/6/2024", "0500","1300", "Mekah", "Jeddah"))),
                new Vector<>(List.of(new Hotel("Hotel Istana", "Dizambug,Turki", "King room",419)))),

        PACKAGE_2(new Vector<>(List.of("Riyadh", "Dammam")),"Arabia Package",3000.00,
                new Vector<>(List.of(new Flight("A12", "15/6/2024", "21/6/2024", "0600","1400", "Riyadh", "Dammam"))),
                new Vector<>(List.of(new Hotel("Riyadh Hotel", "Riyadh Street", "StandardRoom", 550)))),

        PACKAGE_3(new Vector<>(List.of("Doha", "Dubai")),"Gulf Tour", 3500.00,
                new Vector<>(List.of(new Flight("B34", "16/6/2024", "22/6/2024", "0700","1500", "Doha", "Dubai"))),
                new Vector<>(List.of(new Hotel("Doha Hotel", "Qatar Road", "Deluxe Room",600)))),

        PACKAGE_4(new Vector<>(List.of("Abu Dhabi", "Sharjah")),"UAE Special",2800.00,
                new Vector<>(List.of(new Flight("C56", "17/6/2024", "23/6/2024", "0800","1600", "Abu Dhabi", "Sharjah"))),
                new Vector<>(List.of(new Hotel("Abu Dhabi Grand", "Sheikh Zayed", "Suite Room", 700)))),

        PACKAGE_5(new Vector<>(List.of("Kuwait City", "Manama")),"Kuwait to Bahrain",4000.00,
                new Vector<>(List.of(new Flight("D78", "18/6/2024", "24/6/2024", "0900","1700", "Kuwait City", "Manama"))),
                new Vector<>(List.of(new Hotel("Kuwait Palace", "Kuwait Avenue","Presidential Suite", 900))));

        private Vector<String> places;
        private String tour_Guide;
        private double price_Pelancongan;
        private Vector<Flight> flight_Pelancongan;
        private Vector<Hotel> hotel_Pelancongan;

        private Pelancongan_Package(Vector<String> places, String tour_Guide, double
        price_Pelancongan,Vector<Flight> flight_Pelancongan, Vector<Hotel>
        hotel_Pelancongan) {
        this.places = places;
        this.tour_Guide = tour_Guide;
        this.price_Pelancongan = price_Pelancongan;
        this.flight_Pelancongan = flight_Pelancongan;
        this.hotel_Pelancongan = hotel_Pelancongan;
        }

        public void display_Pelancongan_info() {

        }

        public void add_Hotel_Pelancongan(Hotel h) {

        }

}
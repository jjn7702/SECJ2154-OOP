import java.util.List;
import java.util.Vector;

public enum Pelancongan_Package {

        Package_1(new Vector<>(List.of("Turki", "Istanbul")), "Ahmad Kamarul", 2500.00,
                new Vector<>(List.of(new Flight("D23", "14/6/2024", "20/7/2024", "0500","1300", "Istanbul International Airport", "KLIA"))),
                new Vector<>(List.of(new Hotel("Hotel Istana", "Dizambug,Turki", "King room",419)))),

        PACKAGE_2(new Vector<>(List.of("Riyadh", "Dammam")),"Badri Bakhtiar",3000.00,
                new Vector<>(List.of(new Flight("A12", "15/6/2024", "22/7/2024", "0600","1400", "King Khalid Internatiinal Airport", "KLIA"))),
                new Vector<>(List.of(new Hotel("Riyadh Hotel", "Riyadh Street", "StandardRoom", 550)))),

        PACKAGE_3(new Vector<>(List.of("Doha", "Dubai")),"Aiman Hadi", 3500.00,
                new Vector<>(List.of(new Flight("B34", "16/6/2024", "25/7/2024", "0700","1500", "Hamad International Airport", "KLIA"))),
                new Vector<>(List.of(new Hotel("Doha Hotel", "Qatar Road", "Deluxe Room",600)))),

        PACKAGE_4(new Vector<>(List.of("Abu Dhabi", "Sharjah")),"Azhar Azfar",2800.00,
                new Vector<>(List.of(new Flight("C56", "17/6/2024", "15/8/2024", "0800","1600", "Zayed International Airport", "KLIA"))),
                new Vector<>(List.of(new Hotel("Abu Dhabi Grand", "Sheikh Zayed", "Suite Room", 700)))),

        PACKAGE_5(new Vector<>(List.of("Kuwait City", "Manama")),"Hafiz Haziq",4000.00,
                new Vector<>(List.of(new Flight("D78", "18/6/2024", "17/8/2024", "0900","1700", "Kuwait International Airport", "KLIA"))),
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
                System.out.println("========= HOTEL INFO ==========");
                System.out.println("Package: " + this.name());
                System.out.println("Tour Guide: " + this.tour_Guide);
                System.out.printf("Price: RM %.2f", this.price_Pelancongan);
                System.out.println("Places: " + this.places);
                
                System.out.println("\nFlights:");
                for (Flight flight : this.flight_Pelancongan) {
                    flight.display_Flight_Info();
                }
                
                System.out.println("\nHotels:");
                for (Hotel hotel : this.hotel_Pelancongan) {
                    hotel.display_Hotel_Info();
                }
                
                System.out.println("===============================");
        }

        public void add_Hotel_Pelancongan(Hotel h) {
                this.hotel_Pelancongan.add(h);
        }

}
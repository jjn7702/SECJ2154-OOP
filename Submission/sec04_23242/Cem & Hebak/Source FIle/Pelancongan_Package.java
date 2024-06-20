import java.util.List;
import java.util.Vector;

public enum Pelancongan_Package {

        PACKAGE_1(new Vector<>(List.of("Turki", "Istanbul")), "Ahmad Kamarul", 2500.00,
                        new Vector<>(List.of(new Flight("Q32","19/7/2024","19/7/2024","0915","1315","King Abdul Aziz Airport","Istanbul International Airport"),
                                             new Flight("D23", "26/7/2024", "26/7/2024", "0500", "1300","Istanbul International Airport", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Hotel Istana", "Dizambug,Turki", 200)))),

        PACKAGE_2(new Vector<>(List.of("Riyadh", "Dammam")), "Badri Bakhtiar", 3000.00,
                        new Vector<>(List.of(new Flight("K87","19/7/2024","19/7/2024","1400","1800","King Abdul Aziz Airport","King Khalid Internatiinal Airport"),
                                             new Flight("A12", "26/7/2024", "27/7/2024", "2200", "0700","King Khalid Internatiinal Airport", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Riyadh Hotel", "Riyadh Street", 300)))),

        PACKAGE_3(new Vector<>(List.of("Doha", "Dubai")), "Aiman Hadi", 3500.00,
                        new Vector<>(List.of(new Flight("N52","19/7/2024","20/7/2024","2330","0330","King Abdul Aziz Airport","Hamad International Airport"),
                                             new Flight("B34", "26/6/2024", "27/7/2024", "2230", "0730","Hamad International Airport", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Doha Hotel", "Qatar Road", 250)))),

        PACKAGE_4(new Vector<>(List.of("Abu Dhabi", "Sharjah")), "Azhar Azfar", 2800.00,
                        new Vector<>(List.of(new Flight("Q32","19/7/2024","20/7/2024","2200","0200","King Abdul Aziz Airport","Zayed International Airport"),
                                             new Flight("C56", "26/7/2024", "26/7/2024", "0800", "1600","Zayed International Airport", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Abu Dhabi Grand", "Sheikh Zayed", 150)))),

        PACKAGE_5(new Vector<>(List.of("Kuwait City", "Manama")), "Hafiz Haziq", 4000.00,
                        new Vector<>(List.of(new Flight("Q32","19/7/2024","19/7/2024","1300","1700","King Abdul Aziz Airport","Kuwait International Airport"),
                                             new Flight("D78", "26/7/2024", "26/7/2024", "0900", "1700","Kuwait International Airport", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Kuwait Palace", "Kuwait Avenue", 350))));

        private Vector<String> places;
        private String tour_Guide;
        private double price_Pelancongan;
        private Vector<Flight> flight_Pelancongan;
        private Vector<Hotel> hotel_Pelancongan;

        private Pelancongan_Package(Vector<String> places, String tour_Guide, double price_Pelancongan,
                        Vector<Flight> flight_Pelancongan, Vector<Hotel> hotel_Pelancongan) {
                this.places = places;
                this.tour_Guide = tour_Guide;
                this.price_Pelancongan = price_Pelancongan;
                this.flight_Pelancongan = flight_Pelancongan;
                this.hotel_Pelancongan = hotel_Pelancongan;
        }

        public void display_Pelancongan_info(int counterFlight) {
                
                System.out.println("========= HOTEL INFO ==========");
                System.out.println("Package: " + this.name());
                System.out.println("Tour Guide: " + this.tour_Guide);
                System.out.printf("Price: RM %.2f\n", this.price_Pelancongan);
                System.out.println("Places: " + this.places);

                System.out.println("\nFlights:");
                for (Flight flight : flight_Pelancongan) {
                        System.out.println("========================= Flight " + counterFlight + " =========================");
                        flight.display_Flight_Info();
                        counterFlight++;
                }

                System.out.println("\nHotels:");
                for (Hotel hotel : this.hotel_Pelancongan) {
                        hotel.display_Hotel_Info();
                }

                System.out.println("===============================");
        }
        // public void display_FlightsPelancongan(int counterFlight){
                
        //         for (Flight flight : flight_Pelancongan) {
        //                 System.out.println("========================= Flight " + counterFlight
        //                                 + " =========================");
        //                 flight.display_Flight_Info();
        //                 counterFlight++;
        //         }
        // }

        public void add_Hotel_Pelancongan(Hotel h) {
                this.hotel_Pelancongan.add(h);
        }

}
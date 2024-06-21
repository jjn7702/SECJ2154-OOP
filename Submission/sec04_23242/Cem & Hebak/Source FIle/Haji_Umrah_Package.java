import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public enum Haji_Umrah_Package {
        // try from pc faiz
        // try 2
        // package 1 = haji ifrad (haji pastu umrah)
        IFRAD("HAJI IFRAD",

                        new Vector<>(List.of(
                                        new Flight("AA", "31 May 2024", "31 May 2024", "0000", "0850", "KLIA",
                                                        "King Abdul Aziz International Airport"),
                                        new Flight("AA", "17 July 2024", "18 July 2024", "0000", "1115", "Prince Mohammed Bin Abdulaziz International Airport",
                                                        "KLIA"))),
                        new Vector<>(List.of(new Hotel("Elaf Ajyad Hotel", "Mekkah", 350, 354, 0.62, 0.58), // use
                                                                                                            // 5-arg
                                                                                                            // hotel
                                                                                                            // constructor
                                        new Hotel("Al-Andalus Palace Hotel", "Medinah", 290, 623, 0.32, 0.54))), // distance
                                                                                                                 // always
                                                                                                                 // in
                                                                                                                 // km

                        "A01", "9:00 AM", "12 May 2024", "DSI", "Panji",
                        15000),

        // package 2 = haji qiran (haji dan umrah serentak)
        QIRAN("HAJI QIRAN",
                        new Vector<>(List.of(
                                        new Flight("M302", "1 Jun 2024", "2 Jun 2024", "2250", "0740", "KLIA",
                                                        "King Abdul Aziz International Airport"),
                                        new Flight("A107", "18 July 2024", "18 July 2024", "0020", "1135", "Prince Mohammed Bin Abdulaziz International Airport",
                                                        "KLIA"))),
                        new Vector<>(List.of(new Hotel("Elaf Ajyad Hotel", "Mekkah", 350, 354, 0.62, 0.58), // use
                                                                                                            // 5-arg
                                                                                                            // hotel
                                                                                                            // constructor
                                        new Hotel("Al-Andalus Palace Hotel", "Medinah", 290, 623, 0.32, 0.54))),
                        "A02", "12:00 PM", "12 May 2024", "DSI", "Don",
                        20000),

        // package 3 = haji tamattuk (umrah dan haji)
        TAMATTUK("HAJI TAMATTUK",
                        new Vector<>(List.of(
                                        new Flight("A129", "2 Jun 2024", "3 Jun 2024", "2220", "0710", "KLIA",
                                                        "Prince Mohammed Bin Abdulaziz International Airport"),
                                        new Flight("A315", "17 July 2024", "18 July 2024", "2350", "1105", "King Abdulaziz International Airport",
                                                        "KLIA"))),
                        new Vector<>(List.of(new Hotel("Al-Andalus Palace Hotel", "Medinah", 290, 623, 0.32, 0.54), // use
                                                                                                                    // 5-arg
                                                                                                                    // hotel
                                                                                                                    // constructor
                                        new Hotel("Elaf Ajyad Hotel", "Mekkah", 350, 354, 0.62, 0.58))),
                        "A03", "3:30 PM", "12 May 2024", "DSI", "Kazim",
                        15000),

        // package 4 = haji sahaja
        HAJI("Haji",
                        new Vector<>(List.of(
                                        new Flight("A268", "3 Jun 2024", "3 Jun 2024", "0415", "1215", "KLIA",
                                                        "King Abdulaziz International Airport"),
                                        new Flight("M231", "18 July 2024", "19 July 2024", "2350", "1105", "Prince Mohammed Bin Abdulaziz International Airport",
                                                        "KLIA"))),
                        new Vector<>(List.of(new Hotel("Elaf Ajyad Hotel", "Mekkah", 350, 354, 0.62, 0.58),
                                        new Hotel("Al-Andalus Palace Hotel", "Medinah", 290, 623, 0.32, 0.54))), // use
                                                                                                                 // 5-arg
                                                                                                                 // hotel
                                                                                                                 // constructor
                        "A04", "9:00 AM", "12 May 2024", "DSI", "Panji",
                        10000),

        // package 5 = umrah sahaja
        UMRAH("Umrah",
                        new Vector<>(List.of(
                                        new Flight("M478", "4 Dec 2024", "5 Dec 2024", "0045", "0545", "KLIA",
                                                        "Makkah Private Airport"),
                                        new Flight("A315", "21 Dec 2024", "22 Dec 2024", "2350", "1105", "Prince Mohammed Bin Abdulaziz International Airport",
                                                        "KLIA"))),
                        new Vector<>(List.of(new Hotel("Elaf Ajyad Hotel", "Mekkah", 350, 354, 0.62, 0.58), // use
                                                                                                            // 5-arg
                                                                                                            // hotel
                                                                                                            // constructor
                                        new Hotel("Al-Andalus Palace Hotel", "Medinah", 290, 623, 0.32, 0.54))),
                        "A05", "9:00 AM", "12 May 2024", "DSI", "Panji",
                        5000);

        private String ibadah;
        // private Flight depart; nak buang
        private Vector<Flight> flight_Ibadah;
        // private Hotel h1;
        private Vector<Hotel> hotel_Ibadah;
        // private Kursus kursus;
        private Kursus kursus_Ibadah;

        private double price;
        Scanner inp = new Scanner(System.in);

        private Haji_Umrah_Package(String ibadah, Vector<Flight> flight_Ibadah, Vector<Hotel> hotel_Ibadah,
                        String kursusID, String time, String date, String kursusPlace, String nameUstaz, double price) {
                this.ibadah = ibadah;
                this.flight_Ibadah = flight_Ibadah;
                this.hotel_Ibadah = hotel_Ibadah;
                kursus_Ibadah = new Kursus(kursusID, time, date, kursusPlace, nameUstaz);
                this.price = price;
        }

        public void Display_Pakej_Info() {
                System.out.println("========================= Package " + ibadah
                                + " =========================");
                System.out.println("Ibadah: " + ibadah);
                System.out.printf("Price: RM %.2f\n", price);
                int counterFlight = 1;
                int counterHotel = 1;

                for (Hotel hotel : hotel_Ibadah) {
                        System.out.println("========================= Hotel " + counterHotel
                                        + " =========================");
                        hotel.display_Hotel_Ibadah_Info();
                        counterHotel++;
                }
                System.out.println("========================= Kursus Haji =========================");
                kursus_Ibadah.Display_Kursus_info();

                for (Flight flight : flight_Ibadah) {
                        System.out.println("========================= Flight " + counterFlight
                                        + " =========================");
                        flight.display_Flight_Info();
                        counterFlight++;
                }
        }

        public Vector<Flight> getFlight() {
                return flight_Ibadah;
        }
}
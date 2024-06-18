import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public enum Haji_Umrah_Package {
        // try from pc faiz
        // try 2
        // package 1 = haji ifrad (haji pastu umrah)
        IFRAD("Haji and Umrah",
                        new Vector<>(List.of(new Flight("AA", "31 May 2024", "31 May 2024", "0000", "0850", "KLIA", "Jeddah"),
                                             new Flight("AA", "15 July 2024", "16 July 2024", "0000", "1115", "Medinah", "KLIA"))),
                        new Vector<>(List.of(new Hotel("Hilton Makkah Convention Hotel", "Mekkah", 219, 300.0, 500.0), // use 3-arg hotel constructor
                                             new Hotel("Al Meknan Hotel", "Medinah", 219, 300.0, 500.0))),
                        new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"),
                        15000),

        // package 2 = haji qiran (haji dan umrah serentak)
        QIRAN("Haji and Umrah simultaneously",
                new Vector<>(List.of(new Flight("MAS", "15 Jun 2024", "16 Jun 2024", "2250", "0740", "KLIA", "Jeddah"),
                                   new Flight("AA", "1 August 2024", "1 August 2024", "0020", "1135", "Medinah", "KLIA"))),
                new Vector<>(List.of(new Hotel("Hilton Makkah Convention Hotel", "Mekkah", 219, 300.0, 500.0), // use 3-arg hotel constructor
                                     new Hotel("Al Meknan Hotel", "Medinah", 219, 300.0, 500.0))),
                new Kursus("0002", "12:00 PM", "12 May 2024", "DSI", "Don"),
                20000),

        // package 3 = haji tamattuk (umrah dan haji)
        TAMATTUK("Umrah and Haji",
                new Vector<>(List.of(new Flight("AA", "5 Jun 2024", "6 Jun 2024", "2220", "0710", "KLIA", "Jeddah"),
                                     new Flight("AA", "20 July 2024", "21 July 2024", "2350", "1105", "Medinah", "KLIA"))),
                new Vector<>(List.of(new Hotel("Hilton Makkah Convention Hotel", "Mekkah", 219, 300.0, 500.0), // use 3-arg hotel constructor
                                     new Hotel("Al Meknan Hotel", "Medinah", 219, 300.0, 500.0))),
                new Kursus("0003", "3:30 PM", "12 May 2024", "DSI", "Kazim"),
                15000),

        // package 4 = haji sahaja
        HAJI("Haji",
                new Vector<>(List.of(new Flight("AA", "22 May 2024", "22 July 2024", "0415", "1215", "KLIA", "Jeddah"))),
                new Vector<>(List.of(new Hotel("Hilton Makkah Convention Hotel", "Mekkah", 219, 300.0, 500.0))), // use 3-arg hotel constructor
                new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"),
                10000),

        // package 5 = umrah sahaja
        UMRAH("Umrah",
                new Vector<>(List.of(new Flight("AA", "22 May 2024", "22 July 2024", "0045", "0545", "KLIA","Jeddah"))),
                new Vector<>(List.of(new Hotel("Hilton Makkah Convention Hotel", "Mekkah", 219, 300.0, 500.0), // use 3-arg hotel constructor
                                     new Hotel("Al Meknan Hotel", "Medinah", 219, 300.0, 500.0))),
                new Kursus("0001", "9:00 AM", "12 May 2024", "DSI", "Panji"),
                5000);

        private String ibadah;
        // private Flight depart;
        private Vector<Flight> flight_Ibadah;
        // private Hotel h1;
        private Vector<Hotel> hotel_Ibadah;
        protected String RoomSize, HotelPrice;
        // private Kursus kursus;
        private Kursus kursus_Ibadah;
        private Pelancongan_Package plgPkg;
        private double price;
        Scanner inp = new Scanner(System.in);

        private Haji_Umrah_Package(String ibadah, Vector<Flight> flight_Ibadah, Vector<Hotel> hotel_Ibadah,
                        Kursus kursus_Ibadah, double price) {
                this.ibadah = ibadah;
                this.flight_Ibadah = flight_Ibadah;
                this.hotel_Ibadah = hotel_Ibadah;
                this.kursus_Ibadah = kursus_Ibadah;
                this.price = price;
        }

        public void add_Pelancongan_Package(Pelancongan_Package p) {
                plgPkg = p;
                plgPkg.display_Pelancongan_info();      
                // tengok jemaah punya class camne pilih package haji umrah
        }

        public void Display_Pakej_Info() {
                System.out.println("FROM CLASS HAJI UMRAH PACKAGE");
                System.out.println("Ibadah: " + ibadah);
                int counterFlight = 1;
                int counterHotel = 1;

                for (Flight flight : flight_Ibadah) {
                        System.out.println("========================= Flight " + counterFlight
                                        + " =========================");
                        flight.display_Flight_Info();
                        counterFlight++;
                }
                for (Hotel hotel : hotel_Ibadah) {
                        System.out.println("========================= Hotel " + counterHotel
                                        + " =========================");
                        hotel.display_Hotel_Ibadah_Info();
                        counterHotel++;
                }
                System.out.println("========================= Kursus Haji =========================");
                kursus_Ibadah.Display_Kursus_info();
                System.out.println("Jumlah: " + price);

        }
}
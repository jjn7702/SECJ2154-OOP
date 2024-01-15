public class SkyReserve{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Airline> airlines = new ArrayList<>();
        airlines.add(new Airline("AirAsia"));
        airlines.add(new Airline("MAS"));

        List<Flight> availableFlightsAirAsia = new ArrayList<>();
        availableFlightsAirAsia.add(new Flight("KLIA", "SENAI", "10:00 AM"));
        availableFlightsAirAsia.add(new Flight("KLIA", "TAWAU", "12:00 PM"));
        availableFlightsAirAsia.add(new Flight("SENAI", "KLIA", "2:00 PM"));
        availableFlightsAirAsia.add(new Flight("SENAI", "TAWAU", "4:00 PM"));

        availableFlightsAirAsia.add(new Flight("TAWAU", "KLIA", "4:00 PM"));
        availableFlightsAirAsia.add(new Flight("TAWAU", "SENAI", "6:00 PM"));


        List<Seat> availableSeatsAirAsia = new ArrayList<>();
        for (char seatChar = 'A'; seatChar <= 'J'; seatChar++) {
            availableSeatsAirAsia.add(new Seat(String.valueOf(seatChar)));
        }

        List<Flight> availableFlightsMAS = new ArrayList<>();
        availableFlightsMAS.add(new Flight("KLIA", "SENAI", "11:00 AM"));
        availableFlightsMAS.add(new Flight("KLIA", "TAWAU", "1:00 PM"));
        availableFlightsMAS.add(new Flight("SENAI", "KLIA", "3:00 PM"));
        availableFlightsMAS.add(new Flight("SENAI", "TAWAU", "6:00 PM"));
        availableFlightsMAS.add(new Flight("TAWAU", "SENAI", "5:00 PM"));
        availableFlightsMAS.add(new Flight("TAWAU", "KLIA", "8:00 PM"));

        List<Seat> availableSeatsMAS = new ArrayList<>();
        for (char seatChar = 'Q'; seatChar <= 'Z'; seatChar++) {
            availableSeatsMAS.add(new Seat(String.valueOf(seatChar)));
        }

        List<Booking> bookings = new ArrayList<>();

        boolean continueBooking = true;
        while (continueBooking) {
            try {
                System.out.print("Enter passenger name: ");
                String passengerName = scanner.nextLine();

                System.out.print("Enter contact information: ");
                String contactInfo = scanner.nextLine();

                Passenger passenger = new Passenger(passengerName, contactInfo);

                System.out.println("\nChoose Airline:");
                for (int i = 0; i < airlines.size(); i++) {
                    System.out.println((i + 1) + ". " + airlines.get(i).getName());
                }
                System.out.print("Enter the number of your chosen airline: ");
                int airlineChoice = scanner.nextInt();
                scanner.nextLine();

                if (airlineChoice < 1 || airlineChoice > airlines.size()) {
                    System.out.println("Invalid choice. Defaulting to AirAsia.");
                    airlineChoice = 1;
                }

                Airline selectedAirline = airlines.get(airlineChoice - 1);

                List<Flight> availableFlights;
                List<Seat> availableSeats;
                if (selectedAirline.getName().equals("AirAsia")) {
                    availableFlights = availableFlightsAirAsia;
                    availableSeats = availableSeatsAirAsia;
                } else {
                    availableFlights = availableFlightsMAS;
                    availableSeats = availableSeatsMAS;
                }

                System.out.println("\nOrigin:");
                System.out.println("1. KLIA");
                System.out.println("2. SENAI");
                System.out.println("3. TAWAU");
                System.out.print("Choose your origin: ");
                int originChoice = scanner.nextInt();
                scanner.nextLine();

                String origin;
                switch (originChoice) {
                    case 1:
                        origin = "KLIA";
                        break;
                    case 2:
                        origin = "SENAI";
                        break;
                    case 3:
                        origin = "TAWAU";
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to KLIA.");
                        origin = "KLIA";
                        break;
                }
    }
}
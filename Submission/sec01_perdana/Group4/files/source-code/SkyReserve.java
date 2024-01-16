import java.util.*;

public class SkyReserve {
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

                System.out.println("\nDestination:");
                System.out.println("1. KLIA");
                System.out.println("2. SENAI");
                System.out.println("3. TAWAU");
                System.out.print("Choose your destination: ");
                int destinationChoice = scanner.nextInt();
                scanner.nextLine();

                String destination;
                switch (destinationChoice) {
                    case 1:
                        destination = "KLIA";
                        break;
                    case 2:
                        destination = "SENAI";
                        break;
                    case 3:
                        destination = "TAWAU";
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to KLIA.");
                        destination = "KLIA";
                        break;
                }

                System.out.println("\nAvailable flights from " + origin + " to " + destination + " with "
                        + selectedAirline.getName() + ":");
                for (int i = 0; i < availableFlights.size(); i++) {
                    Flight flight = availableFlights.get(i);
                    if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                        System.out.println((i + 1) + ". Origin: " + flight.getOrigin() +
                                ", Destination: " + flight.getDestination() +
                                ", Boarding Time: " + flight.getBoardingTime());
                    }
                }

                System.out.print("Choose a flight number: ");
                int flightNumber = scanner.nextInt();
                scanner.nextLine();

                Flight selectedFlight;
                if (selectedAirline.getName().equals("AirAsia")) {
                    selectedFlight = availableFlightsAirAsia.get(flightNumber - 1);
                } else {
                    selectedFlight = availableFlightsMAS.get(flightNumber - 1);
                }

                List<Seat> availableSeatsForFlight = new ArrayList<>(availableSeats);

                for (Booking booked : bookings) {
                    if (booked.getFlight().equals(selectedFlight) && booked.getAirline().equals(selectedAirline)) {
                        availableSeatsForFlight.remove(booked.getSeat());
                    }
                }

                System.out.println("\nAvailable seats:");
                for (int i = 0; i < availableSeatsForFlight.size(); i++) {
                    Seat seat = availableSeatsForFlight.get(i);
                    System.out.println((i + 1) + ". Seat: " + seat.getSeatName());
                }

                System.out.print("Choose a seat number: ");
                int seatNumber = scanner.nextInt();
                scanner.nextLine();
                Seat selectedSeat = availableSeatsForFlight.remove(seatNumber - 1);

                Booking booking = new Booking(passenger, selectedFlight, selectedSeat, selectedAirline);
                bookings.add(booking);

                System.out.println("\nBooking details:");
                System.out.println("Passenger: " + booking.getPassenger().getName());
                System.out.println("Contact Info: " + booking.getPassenger().getContactInfo());
                System.out.println("Airline: " + booking.getAirline().getName());
                System.out.println("Flight: Flight " + flightNumber + " - Origin: " + booking.getFlight().getOrigin() +
                        ", Destination: " + booking.getFlight().getDestination() +
                        ", Boarding Time: " + booking.getFlight().getBoardingTime());
                System.out.println("Seat: " + booking.getSeat().getSeatName());

                System.out.print("\nDo you want to book another ticket? (yes/no): ");
                String choice = scanner.nextLine();
                continueBooking = choice.equalsIgnoreCase("yes");
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                scanner.nextLine();
            }
        }

        System.out.println("\nAll Bookings:");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            System.out.println("Booking " + (i + 1));
            System.out.println("Passenger: " + booking.getPassenger().getName());
            System.out.println("Contact Info: " + booking.getPassenger().getContactInfo());
            System.out.println("Airline: " + booking.getAirline().getName());
            System.out.println("Flight: Flight " + (i + 1) + " - Origin: " + booking.getFlight().getOrigin() +
                    ", Destination: " + booking.getFlight().getDestination() +
                    ", Boarding Time: " + booking.getFlight().getBoardingTime());
            System.out.println("Seat: " + booking.getSeat().getSeatName());
            System.out.println("--------------------");
        }
        scanner.close();
    }
}

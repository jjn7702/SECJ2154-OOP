public class Booking {
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    private Airline airline;

    public Booking(Passenger passenger, Flight flight, Seat seat, Airline airline) {
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.airline = airline;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}

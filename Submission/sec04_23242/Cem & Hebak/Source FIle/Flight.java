// import java.util.*;

public class Flight {
    private String flightID, dateDeparture, dateArrival, departureTime, arrivalTime, departurePlace, arrivalPlace;

    public Flight(String flightID, String dateDeparture, String dateArrival, String departureTime, String arrivalTime,
            String departurePlace, String arrivalPlace) {
        this.flightID = flightID;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
    }

    public void display_Flight_Info() {

        System.out.println("FLight ID: " + flightID);
        System.out.println("Date of departure: " + dateDeparture);
        System.out.println("Date of arrival: " + dateArrival);
        System.out.println("Departure time: " + departureTime);
        System.out.println("Arrival time: " + arrivalTime);
        System.out.println("Departure Location: " + departurePlace);
        System.out.println("Arrival Location: " + arrivalPlace);
    }
}
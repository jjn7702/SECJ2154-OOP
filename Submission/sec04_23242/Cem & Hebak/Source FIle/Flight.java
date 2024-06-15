import java.util.*;

public class Flight {
    private String flightID, dateGo, dateBack, departureTime, arrivalTime, departurePlace, arrivalPlace;

    public Flight(String flightID, String dateGo, String dateBack, String departureTime, String arrivalTime,
            String departurePlace, String arrivalPlace) {
        this.flightID = flightID;
        this.dateGo = dateGo;
        this.dateBack = dateBack;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
    }

    public void display_Flight_Info() {
        System.out.println("FLight ID: " + flightID);
        System.out.println("Date of departure: " + dateGo);
        System.out.println("Date of arrival: " + dateBack);
        System.out.println("Departure time: " + departureTime);
        System.out.println("Arrival time: " + arrivalTime);
    }
}
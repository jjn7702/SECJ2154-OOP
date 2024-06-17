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

        System.out.printf("%-35s: %20s%n", "Flight ID", flightID);
        System.out.printf("%-35s: %20s%n", "Date of Departure", dateDeparture);
        System.out.printf("%-35s: %20s%n", "Date of Arrival", dateArrival);
        System.out.printf("%-35s: %20s%n", "Departure Time", departureTime);
        System.out.printf("%-35s: %20s%n", "Arrival Time", arrivalTime);
        System.out.printf("%-35s: %20s%n", "Departure Location", departurePlace);
        System.out.printf("%-35s: %20s%n", "Arrival Location", arrivalPlace);

    }
}
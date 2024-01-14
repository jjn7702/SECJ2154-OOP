import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager() {
        this.reservations = new ArrayList<>();
    }

    public boolean makeReservation(Table table, Date reservationTime) {
        // Check if the table is available at the specified time
        if (isTableAvailable(table, reservationTime)) {
            Reservation reservation = new Reservation(table, reservationTime);
            reservations.add(reservation);
            return true;
        } else {
            System.out.println("Table is not available at the specified time. Please choose another time or table.");
            return false;
        }
    }

    private boolean isTableAvailable(Table table, Date reservationTime) {
        // Check if the table is available (e.g., not reserved) at the specified time
        for (Reservation reservation : reservations) {
            if (reservation.getReservedTable().equals(table) && reservation.getReservationTime().equals(reservationTime)) {
                return false; // Table is already reserved at the specified time
            }
        }
        return true; // Table is available
    }
}
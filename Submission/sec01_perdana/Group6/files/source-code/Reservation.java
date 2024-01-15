import java.time.LocalDateTime;

public class Reservation {
    private Table table;
    private LocalDateTime reservationTime;

    public Reservation(Table table, LocalDateTime reservationTime) {
        this.table = table;
        this.reservationTime = reservationTime;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public boolean isAvailable(LocalDateTime requestedTime) {
        return reservationTime.isBefore(requestedTime) || reservationTime.isEqual(requestedTime);
    }
}

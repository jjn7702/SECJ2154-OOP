import java.util.Date;

public class Reservation {
    private Table table;
    private Date reservationTime;

    public Reservation(Table table, Date reservationTime) {
        this.table = table;
        this.reservationTime = reservationTime;
    }

    public Table getTable() {
        return table;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public boolean isAvailable(Date otherTime) {
        // Check if the reservation is available at the specified time
        // This is a placeholder, you may implement your logic here
        return reservationTime.equals(otherTime);
    }
}

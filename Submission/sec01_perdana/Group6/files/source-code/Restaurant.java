import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Restaurant {
    private Menu menu;
    private List<Table> tables;
    private List<Reservation> reservations;

    public Restaurant() {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
        this.reservations = new ArrayList<>();
        initializeTables();
    }

    public void addMenuItem(FoodItem item) {
        menu.addItem(item);
    }

    public Menu getMenu() {
        return menu;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    public boolean makeReservation(Table table, Date reservationTime) {
        if (isTableAvailable(table, reservationTime)) {
            Reservation reservation = new Reservation(table, reservationTime);
            reservations.add(reservation);
            return true;
        }
        return false;
    }

    private boolean isTableAvailable(Table table, Date reservationTime) {
        for (Reservation reservation : reservations) {
            if (reservation.getTable() == table && !reservation.isAvailable(reservationTime)) {
                return false;
            }
        }
        return true;
    }

    private void initializeTables() {
        for (int i = 1; i <= 5; i++) {
            addTable(new Table(i));
        }
    }
}

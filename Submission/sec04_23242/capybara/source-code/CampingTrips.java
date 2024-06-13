
import java.util.Vector;

class CampingTrips {
    private String name;
    private String location;
    private DateAndTime dateTime;
    private Vector<Budget> budget = new Vector<Budget>();
    private Item items;

    public CampingTrips() {
    };

    public CampingTrips(String name, String location, Vector<Budget> tripBudgets) {
        this.name = name;
        this.location = location;
    };

}

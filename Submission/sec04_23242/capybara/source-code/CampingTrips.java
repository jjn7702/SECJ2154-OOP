
import java.util.Vector;

class CampingTrips {
    private String name;
    private String location;
    private DateAndTime dateTime;
    private Vector<Budget> budget = new Vector<Budget>();
    private Vector<Item> item = new Vector<Item>();

    public CampingTrips() {
    };

    public CampingTrips(String name, String location, DateAndTime dateTime, Vector<Budget> tripBudgets,
            Vector<Item> item) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
        this.budget = tripBudgets;
        this.item = item;
    };

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public DateAndTime getDateTime() {
        return dateTime;
    }

    public Vector<Budget> getBudgets() {
        return budget;
    }

    public Vector<Item> getItems() {
        return item;
    }
}

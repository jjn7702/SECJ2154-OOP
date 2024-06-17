import java.util.Vector;

class CampingTrips {
    private String name;
    private DateAndTime dateTime;
    private Vector<Budget> budget = new Vector<Budget>();
    private Vector<Item> item = new Vector<Item>();
    private Campground campground = new Campground();

    public CampingTrips(String name, DateAndTime dateTime, Vector<Budget> tripBudgets,
            Vector<Item> item, Campground campground) {
        this.name = name;
        this.dateTime = dateTime;
        this.budget = tripBudgets;
        this.item = item;
        this.campground = campground;
    };

    public Campground getCampground() {
        return campground;
    }

    public String getName() {
        return name;
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
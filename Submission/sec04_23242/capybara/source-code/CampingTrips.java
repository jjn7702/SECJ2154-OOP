import java.util.Vector;

class CampingTrips {
    private String name;
    private DateAndTime dateTime;
    private Vector<Budget> budget = new Vector<Budget>();
    private Vector<Item> item = new Vector<Item>();
    private Location campground = new Campground();

    public CampingTrips(String name, DateAndTime dateTime, Vector<Budget> tripBudgets,
            Vector<Item> item, String campName, String campDescription, int campSites) {
        this.name = name;
        this.dateTime = dateTime;
        this.budget = tripBudgets;
        this.item = item;
        this.campground = new Campground(campName, campDescription, campSites);
    };

    public Campground getCampground() {
        return (Campground) campground;
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
class Campground extends Location {
    private int sitesAvailable;

    // Constructor
    public Campground(String name, String description, int sitesAvailable) {
        super(name, description);
        this.sitesAvailable = sitesAvailable;
    }

    public Campground() {
        super();
    };

    public int getSitesAvailable() {
        return sitesAvailable;
    }

    @Override
    public String displayLocationInfo() {
        String str = String.format("Campground Name: %s\nDescription: %s\nSites Available: %d", getName(),
                getDescription(), sitesAvailable);

        return str;
    }
}
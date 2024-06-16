abstract class Location {
    private String name;
    private String description;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String displayLocationInfo();
}
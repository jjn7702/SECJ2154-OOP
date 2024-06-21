package event_management;

public class Event {
    private String eventId;
    private String title;
    private String description;
    private String date;
    private String location;

    public Event(String eventId, String title, String description, String date, String location) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}

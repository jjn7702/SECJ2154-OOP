package event_management;

public class OnlineEvent extends Event {
    private String link;

    public OnlineEvent(String eventId, String title, String description, String date, String location, String link) {
        super(eventId, title, description, date, location);
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}

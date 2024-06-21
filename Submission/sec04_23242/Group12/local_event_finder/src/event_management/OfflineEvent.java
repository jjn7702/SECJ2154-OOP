package event_management;

public class OfflineEvent extends Event {
    private String venue;

    public OfflineEvent(String eventId, String title, String description, String date, String location, String venue) {
        super(eventId, title, description, date, location);
        this.venue = venue;
    }

    public String getVenue() {
        return venue;
    }
}

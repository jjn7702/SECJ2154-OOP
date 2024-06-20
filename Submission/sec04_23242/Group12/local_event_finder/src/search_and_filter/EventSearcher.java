package search_and_filter;

import event_management.Event;
import java.util.ArrayList;
import java.util.List;

public class EventSearcher {
    private List<Event> events;

    public EventSearcher() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> searchByTitle(String title) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(title)) {
                result.add(event);
            }
        }
        return result;
    }

    public List<Event> searchByDate(String date) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }

    public List<Event> searchByLocation(String location) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getLocation().equalsIgnoreCase(location)) {
                result.add(event);
            }
        }
        return result;
    }
}

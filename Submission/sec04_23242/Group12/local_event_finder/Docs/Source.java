// User.java
package user_management;

public class User {
    private String userId;
    private String name;
    private String email;
    private String password;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}

// RegularUser.java
package user_management;

public class RegularUser extends User {
    public RegularUser(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }
}

// PremiumUser.java
package user_management;

public class PremiumUser extends User {
    private boolean premiumFeaturesEnabled;

    public PremiumUser(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.premiumFeaturesEnabled = true;
    }

    public boolean hasPremiumFeatures() {
        return premiumFeaturesEnabled;
    }
}

// Event.java
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

// OnlineEvent.java
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

// OfflineEvent.java
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

// EventSearcher.java
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
            if (event.getDate().equalsIgnoreCase(date)) {
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

// Notification.java
package notifications;

public class Notification {
    private String notificationId;
    private String userId;
    private String message;
    private String date;

    public Notification(String notificationId, String userId, String message, String date) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.date = date;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}

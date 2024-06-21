import user_management.*;
import event_management.*;
import search_and_filter.*;
import notifications.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        User user1 = new RegularUser("U1", "Alice", "alice@example.com", "password123");
        User user2 = new PremiumUser("U2", "Bob", "bob@example.com", "password456");

        // Create events
        Event event1 = new OnlineEvent("E1", "Java Workshop", "Learn Java", "2024-06-25", "Online", "www.javaworkshop.com");
        Event event2 = new OfflineEvent("E2", "Music Concert", "Live music", "2024-06-26", "City Park", "Central Stage");

        
        EventSearcher eventSearcher = new EventSearcher();
        eventSearcher.addEvent(event1);
        eventSearcher.addEvent(event2);

        List<Event> eventsOn25th = eventSearcher.searchByDate("2024-06-25");
        for (Event event : eventsOn25th) {
            System.out.println("Event on 2024-06-25: " + event.getTitle());
        }

        Notification notification1 = new Notification("N1", "U1", "Java Workshop is tomorrow!", "2024-06-24");

        System.out.println("Notification for User U1: " + notification1.getMessage());
    }
}

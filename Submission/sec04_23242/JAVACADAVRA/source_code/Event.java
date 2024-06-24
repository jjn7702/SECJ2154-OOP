import java.util.*

class Event {
    private String eventName, venue, date;
    private double time;
    private ArrayList<Sport> sports; // com

    public Event(String eventName, String venue, String date, double time) {
        this.eventName = eventName;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.sports = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public String toString() {
        String sportsDetails = "";
        for (Sport s : sports) {
            sportsDetails += s.toString() + "\n";
        }
        
        return "\nEvent Name: " + eventName +
                "\nVenue: " + venue +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nSports:\n" + sportsDetails;
    }

}

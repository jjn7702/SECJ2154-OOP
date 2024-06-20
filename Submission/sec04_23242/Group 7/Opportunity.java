import java.util.ArrayList;

public class Opportunity {
    private String title;
    private String description;
    private String date;
    private String location;
    private String organizationName;
    private ArrayList<Application> applications;

    public Opportunity(String title, String description, String date, 
    String location, String organizationName) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.organizationName = organizationName;
        this.applications = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }

    public String getDate(){
        return date;
    }

    public String toString() {
        return "\n\tTitle: " +title + "\n\tDescription: " + 
        description +"\n\tDate: " + date + "\n\tLocation: " + 
        location + "\n\tOrganized By: " + organizationName;
    }
}


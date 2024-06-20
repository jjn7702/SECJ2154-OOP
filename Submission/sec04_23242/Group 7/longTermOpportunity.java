public class longTermOpportunity extends Opportunity {
    private String schedule;

    public longTermOpportunity(String title, String description, 
    String schedule, String location, String organizationName) {
        super(title, description, schedule, location, organizationName);
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }
    
}

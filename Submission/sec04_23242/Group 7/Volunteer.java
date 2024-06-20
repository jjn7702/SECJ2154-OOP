import java.util.ArrayList;

public class Volunteer extends User {
  private String skills;
  private String availability;
  private ArrayList<Application> applications;

public Volunteer(String name,String email,String password,String skills,String availability){
  super(name,email,password);
  this.skills = skills;
  this.availability = availability;
  this.applications = new ArrayList<>();
}

public void applyForOpportunity(Opportunity opportunity) {
  Application application = new Application(this,opportunity);
  applications.add(application);
  opportunity.addApplication(application);
  System.out.println(getName() + " applied for opportunity: " +opportunity.getTitle());
}

public void updateAvailability(String availability){
  this.availability = availability;
}

public String toString(){
  return "Name: " +getName() + "\n  skills: " +skills + "\n  Availability: " +availability + " \n";
}

}

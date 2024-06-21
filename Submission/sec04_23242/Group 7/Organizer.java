import java.util.ArrayList;

public class Organizer extends User{
  private String organizationName;
  private ArrayList<Opportunity> opportunities;

  public Organizer(String name, String email, String password, String organizationName){
      super(name, email, password);
      this.organizationName = organizationName;
      this.opportunities = new ArrayList<>();
  }

  public void createShortTermOpportunity(String title, String description, String date, String location){
    try{
      Opportunity opportunity = new shortTermOpportunity(title, description, date, location, organizationName);
      opportunities.add(opportunity);
      System.out.println("Created new Short Term Opportunity: " + opportunity.getTitle());
    }
    catch(Exception e){
      System.out.println("Error creating short term opportunity" + e.getMessage());
    }
  }

  public void createLongTermOpportunity(String title, String description, String schedule, String location){
    try{
      Opportunity opportunity = new longTermOpportunity(title, description, schedule, location, organizationName);
      opportunities.add(opportunity);
      System.out.println("Created new Long Term Opportunity: " + opportunity.getTitle());
    }
    catch(Exception e){
      System.out.println("Error creating long term opportunity" + e.getMessage());
    }
  }

  public void reviewApplications(){
    try{
      for(Opportunity opportunity: opportunities){
        System.out.println("Opportunity: " + opportunity.getTitle());
        for(Application application: opportunity.getApplications()){
          System.out.println("Application from: " + application.getVolunteer().getName());
        }
      }
    } catch(Exception e){
      System.out.println("Error reviewing applications: " + e.getMessage());
    }
  }

  public String getOrganizationName(){
    return organizationName;
  }

  public String toString(){
    return "Name: " + getName() + "\n  Organization Name: " + organizationName + "\n";
      }
  
}

public class Application{

  private Volunteer volunteer;
  private Opportunity opportunity;

  public Application(Volunteer volunteer, Opportunity opportunity){
    this.volunteer = volunteer;
    this.opportunity = opportunity;
  }

  public Volunteer getVolunteer(){
    return volunteer;
  }

  public Opportunity getOpportunity(){
    return opportunity;
  }
}

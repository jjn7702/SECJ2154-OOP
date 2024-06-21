public class Review {
  private Application application;
  private String feedback;

public Review(Application application ,String feedback){
  this.application = application;
  this.feedback = feedback;
}

public void printFeedback() {
  if(feedback == null){
    System.out.println("Feedback still not given.");
  }
  else{
    System.out.println("Added feedback for " + application.getVolunteer().getName() + ": " + feedback);
  }
}

public String getFeedback() {
  return feedback;
}
}

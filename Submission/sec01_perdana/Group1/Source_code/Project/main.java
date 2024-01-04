import java.util.*;

class main {
  public static void main (String[] args){
    String fileName = job.txt;
    List<Job> jobs = JobReader.readJob(fileName);
    
    System.out.println("JOB PORTAL");

    System.out.println("Hiring");
    for(Job j : jobs){
      System.out.println("Job Title: " + j.getJobTitle() + "\nPay: RM " j.getPay());
    }    
  }
}

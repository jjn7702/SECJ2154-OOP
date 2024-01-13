import java.util.*;
import java.io.*;

import employer.Employer;
import job_application.JobApplication;
import job_posting.JobPosting;
import jobseeker.JobSeeker;
import portal_exception.PortalException;
import sign_in.SignIn;
import sign_up.SignUp;
import user.User;

public class JobPortal {
  private List<User> users;
  private List<JobPosting> jobPostings;
  private List<JobApplication> jobApplications;

  private static final String USER_FILE_PATH = "UserList.txt";
  private static final String JOB_FILE_PATH = "JobList.txt";

  private SignIn signIn;
  private SignUp signUp;

  public JobPortal() {
    this.users = readUsersFromFile();
    this.jobPostings = readJobsFromFile();
    this.jobApplications = new ArrayList<>();
    this.signIn = new SignIn(users);
    this.signUp = new SignUp(users);
  }

  public void postJob(JobPosting jobPosting) {
    jobPostings.add(jobPosting);
    writeJobsToFile();
    System.out.println("Job posted successfully!");
  }

  public void applyForJob(JobSeeker jobSeeker, JobPosting jobPosting) {
    JobApplication application = new JobApplication(jobSeeker jobPosting, "Pending");
    jobApplications.add(appllication);
    Sysytem.out.println("Job application submitted successfully");
  }
  
  private List<User> readUsersFromFile() {
    List<User> userList = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
      String username, password, userType;
      while((username = reader.readLine()) != null) {
        password = reader.readLine();
        userType = reader.readLine();
        if("JobSeeker".equals(userType)) {
          String resume = reader.readLine();
          userList.add(new JobSeeker(username, password, resume));
        } else if ("Employer".equals(userType)) {
          String company = reader.readLine();
          userList.add(new Employer(username,password, company));
        } else {
          userList.add(new User(username, password));
        }
      }
    } catch (IOException e) {
      System.out.println("Error reader users from file: " + e.getMessage());
    }
    return userList;
  }

  private List<JobPosting> readJobsFromFile() {
    List<JobPosting> jobs = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
      String jobTitle, jobPay, jobDescription;
      while((jobTitle = reader.readLine()) != null){
        jobPay = reader.readLine();
        jobDescription = reader.readLine();
        jobs.add(new JobPosting(jobTitle, jobPay, jobDescription));
        reader.readLine();
      }
    } catch (IOException e) {
      System.out.println("Error reader jobs from file: " + e.getMessage());
    }
    return jobs;
  }

  private void writeJobsToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOB_FILE_PATH, true))) {
      JobPosting latestJob = jobPosting.get(jobPosting.size() - 1);
      writer.write(latestJob.getJobTitle());
        writer.newLine();
        writer.write(latestJob.getJobPay());
        writer.newLine();
        writer.write(latestJob.getJobDescription());
        writer.newLine();
    } catch (IOException e) {
        System.out.println("Error writing job to file: " + e.getMessage());
    }
  }

  public void displayJobs() {
    System.out.println("\nAvailable Jobs:\n");
    for (JobPosting job : jobPostings) {
      System.out.printf("Title: %s%n", job.getJobTitle());
        System.out.printf("Pay: %s%n", job.getJobPay());
        System.out.printf("Description: %s%n", job.getJobDescription());
        System.out.println("--------------\n");
      }
    }
      

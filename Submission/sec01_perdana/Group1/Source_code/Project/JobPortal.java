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
      
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome To KerjaMY!");
    JobPortal jobPortal = new jobPortal();
    User currentUser = null;

    while (true) {
      System.out.println("1. Sign Up");
      System.out.println("2. Sign In");
      System.out.println("3. Exit");
      System.out.println("Your option: ");
      int choice = sc.nextInt();
      System.out.println("");
      sc.nextLine();

      if (choice == 1) {
        //Sign Up
        System.out.println("Enter username: ");
        String resume = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();

        System.out.println("\nAre you a Job Seeker or Employer? (1. Job Seeker, 2. Employer)");
        int userType = sc.nextInt();
        sc.nextLine();

        if (userType == 1) {
          System.out.println("Enter your resume: ");
          String resume = sc.nextLine();
          JobSeeker jobSeeker = new JobSeeker(username, password, resume);
          jobPortal.signUp.registerUser(jobSeeker);
        } else if (userType == 2) {
            System.out.println("Enter your company: ");
            String company = sc.nextLine();
            Employer employer = new Employer(username, password, company);
            jobPortal.signUp.registerUser(employer);
        }
      } else if (choice == 2) {
          //Sign Up
          System.out.println("Enter your username: ");
          String username = sc.nextLine();
          System.out.println("Enter your password: ");
          String password = sc.nextLine();

          currentUser = jobPortal.signIn.signIn(username, password);
          if (currentUser != null) {
            System.out.println("Logged in successfully");
            break;
          }
      } else if (choice == 3) {
        //Exit
        System.out.println("Exiting. Goodbye");
        System.exit(0);
      }
    }

    //Display job after sign in
    jobPortal.displayJobs();

    while (true) {
      System.out.println("Main Menu:");
      System.out.println("1. Apply for a Job");
      System.out.println("2. Post a Job");
      System.out.println("3. Exit");
      System.out.print("Select an option: ");
      int mainPageChoice = scanner.nextInt();
      scanner.nextLine();

      if (mainPageChoice == 1) {
        //Apply job
        if (curentUser != null && currentUser instanceof JoobSeeker) {
          jobPortal.displayJobs();
          System.out.println("Enter the title of the job you want to apply for:");
          String jobTitle = sc.nextLine();

          JobPosting selectedJob = null;
          for (JobPosting job : jobPortal.jobPostings) {
            if (job.getJobTitle().equals(jobTitle)) {
              selectedJob = job;
              break;
            }
          }

          if (selectedJob != null) {
            jobPortal.applyForJob((JobSeeker) currentUser, selectedJob);
            System.out.println("Job application submitted successfully!\n");
          } else {
              System.out.println("Job not found!\n");
          }
        } else {
            System.out.println("You must be logged in as a Job Seeker to apply for a job.");
        }
      } else if (mainPageChoice == 2) {
        //Post Job
        if (currentUser != null && currentUser instanceof Employer) {
          System.out.println("Enter job title:");
          String jobTitle = scanner.nextLine();
          System.out.println("Enter job pay:");
          String jobPay = scanner.nextLine();
          System.out.println("Enter job description:");
          String jobDescription = scanner.nextLine();

          JobPosting newJob = new JobPosting (jobTitle, jobPay, jobDescription);
          jobPortal.postJob(newJob);
        } else {
            System.out.println("You must be logged in as an Employer to post a job.");
        }
      } else if (mainPageChoice == 3) {
        //Exit
        System.out.println("exiting. Goodbye");
        break;
      }
    }
    sc.close();
  }
}
    

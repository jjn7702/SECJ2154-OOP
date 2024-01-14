import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employer.Employer;
import job_application.JobApplication;
import job_posting.JobPosting;
import jobseeker.JobSeeker;
import user.User;
import sign_in.SignIn;
import sign_up.SignUp;

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

    public void registerUser(User user) {
        users.add(user);
        writeUsersToFile();
        System.out.println("User registered successfully!");
    }

    public User signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Sign in successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password. Sign in failed.");
        return null;
    }

    public void postJob(JobPosting jobPosting) {
        jobPostings.add(jobPosting);
        writeJobsToFile();
        System.out.println("Job posted successfully!");
    }

    public void applyForJob(JobSeeker jobSeeker, JobPosting jobPosting) {
        JobApplication application = new JobApplication(jobSeeker, jobPosting, "Applied");
        jobApplications.add(application); 
        System.out.println("Job application submitted successfully!");
    }

    private List<User> readUsersFromFile() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
            String username;
            String password;
            String userType;
            while ((username = reader.readLine()) != null) {
                password = reader.readLine();
                userType = reader.readLine();
                if ("JobSeeker".equals(userType)) {
                    String resume = reader.readLine();
                    userList.add(new JobSeeker(username, password, resume));
                } else if ("Employer".equals(userType)) {
                    String company = reader.readLine();
                    userList.add(new Employer(username, password, company));
                } else {
                    userList.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users from file: " + e.getMessage());
        }
        return userList;
    }

    private List<JobPosting> readJobsFromFile() {
        List<JobPosting> jobs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(JOB_FILE_PATH))) {
            String jobTitle;
            String jobPay;
            String jobDescription;
            while ((jobTitle = reader.readLine()) != null) {
                jobPay = reader.readLine();
                jobDescription = reader.readLine();
                jobs.add(new JobPosting(jobTitle, jobPay, jobDescription));
                
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading jobs from file: " + e.getMessage());
        }
        return jobs;
    }

    private void writeUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH, true))) {
            User latestUser = users.get(users.size() - 1);
            writer.write(latestUser.getUsername());
            writer.newLine();
            writer.write(latestUser.getPassword());
            writer.newLine();

            if (latestUser instanceof JobSeeker) {
                writer.write("JobSeeker");
                writer.newLine();
                writer.write(((JobSeeker) latestUser).getResume());
                writer.newLine();
            } else if (latestUser instanceof Employer) {
                writer.write("Employer");
                writer.newLine();
                writer.write(((Employer) latestUser).getCompany());
                writer.newLine();
            }

            writer.newLine(); 
        } catch (IOException e) {
            System.out.println("Error writing user to file: " + e.getMessage());
        }
    }

    private void writeJobsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOB_FILE_PATH, true))) {
            JobPosting latestJob = jobPostings.get(jobPostings.size() - 1);
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

    public void displayJobApplications() {
        System.out.println("\nJob Applications:\n");
        for (JobApplication application : jobApplications) {
            System.out.printf("Applicant: %s%n", application.getApplicant().getUsername());
            System.out.printf("Job Title: %s%n", application.getJob().getJobTitle());
            System.out.printf("Status: %s%n", application.getStatus());
            System.out.println("--------------\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Job Portal System!");
        JobPortal jobPortal = new JobPortal();
        User currentUser = null;

        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            System.out.println("");
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.println("Enter your username:");
                String username = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();

                System.out.println("\nAre you a Job Seeker or Employer? (1. Job Seeker, 2. Employer)");
                int userType = scanner.nextInt();
                scanner.nextLine(); 

                if (userType == 1) {
                    System.out.println("Enter your resume:");
                    String resume = scanner.nextLine();
                    JobSeeker jobSeeker = new JobSeeker(username, password, resume);
                    jobPortal.signUp.registerUser(jobSeeker);
                } else if (userType == 2) {
                    System.out.println("Enter your company name:");
                    String company = scanner.nextLine();
                    Employer employer = new Employer(username, password, company);
                    jobPortal.signUp.registerUser(employer);
                }
            } else if (choice == 2) {
                System.out.println("Enter your username:");
                String username = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();

                currentUser = jobPortal.signIn.signIn(username, password);
                if (currentUser != null) {
                    System.out.println("Logged in successfully!");
                    break;
                }
            } else if (choice == 3) {
                
                System.out.println("Exiting. Goodbye!");
                System.exit(0);
            }
        }

        jobPortal.displayJobs();

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Apply for a Job");
            System.out.println("2. Post a Job");
            System.out.println("3. Display Job Applications");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int mainPageChoice = scanner.nextInt();
            scanner.nextLine(); 

            if (mainPageChoice == 1) {
                
                if (currentUser != null && currentUser instanceof JobSeeker) {
                    jobPortal.displayJobs();
                    System.out.println("Enter the title of the job you want to apply for:");
                    String jobTitle = scanner.nextLine();

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
                
                if (currentUser != null && currentUser instanceof Employer) {
                    System.out.println("Enter job title:");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Enter job pay:");
                    String jobPay = scanner.nextLine();
                    System.out.println("Enter job description:");
                    String jobDescription = scanner.nextLine();

                    JobPosting newJob = new JobPosting(jobTitle, jobPay, jobDescription);
                    jobPortal.postJob(newJob);
                } else {
                    System.out.println("You must be logged in as an Employer to post a job.");
                }
            } else if (mainPageChoice == 3) {
                
                jobPortal.displayJobApplications();
            } else if (mainPageChoice == 4) {
                
                System.out.println("Exiting. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}

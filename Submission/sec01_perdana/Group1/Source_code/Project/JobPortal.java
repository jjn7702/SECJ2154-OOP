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

    public void postJob(JobPosting jobPosting) {
        jobPosting.postJob(jobPostings);
    }

    public void applyForJob(JobSeeker jobSeeker, JobPosting jobPosting) {
        JobApplication application = new JobApplication(jobSeeker, jobPosting, "Applied");
        jobApplications.add(application);
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
            System.out.println("\n\t\t\t\tError reading users from file: " + e.getMessage());
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
            System.out.println("\n\t\t\t\tError reading jobs from file: " + e.getMessage());
        }
        return jobs;
    }

    public void displayJobs() {
        System.out.println("\n\t\t\t\t   +================== AVAILABLE JOBS ===================+");
        for (JobPosting job : jobPostings) {
            System.out.printf("\t\t\t\t   | Title: %-40s \n", job.getJobTitle());
            System.out.printf("\t\t\t\t   | Pay: %-42s \n", job.getJobPay());
            System.out.printf("\t\t\t\t   | Description: %-36s \n", job.getJobDescription());
            System.out.println("\t\t\t\t   +-------------------------------------------------------+");
        }
    }

    public void displayJobApplications() {
        System.out.println("\n\t\t\t\t   +================== JOB APPLICATIONS ===================+");
        for (JobApplication application : jobApplications) {
            System.out.printf("\t\t\t\t   | Applicant: %-35s \n", application.getApplicant().getUsername());
            System.out.printf("\t\t\t\t   | Job Title: %-36s \n", application.getJob().getJobTitle());
            System.out.printf("\t\t\t\t   | Status: %-38s \n", application.getStatus());
            System.out.println("\t\t\t\t   +--------------------------------------------------------+");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t\t\t   Welcome to the Job Portal System!");
        JobPortal jobPortal = new JobPortal();
        User currentUser = null;

        while (true) {
            System.out.println("\n\t\t\t\t   +================== JOB PORTAL ====================+");
            System.out.println("\t\t\t\t   +1. \t\tSign Up" + "\t\t\t\t      +");
            System.out.println("\t\t\t\t   +2. \t\tSign In" + "\t\t\t\t      +");
            System.out.println("\t\t\t\t   +3. \t\tExit" + "\t\t\t\t      +");
            System.out.println("\t\t\t\t   +==================================================+");
            System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("");
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("\t\t\t\t\t\tEnter your username: ");
                String username = scanner.nextLine();
                System.out.print("\n\t\t\t\t\t\tEnter your password: ");
                String password = scanner.nextLine();

                System.out.print("\n\t\t\t\t\t\tAre you a Job Seeker or Employer? (1. Job Seeker, 2. Employer): ");
                int userType = scanner.nextInt();
                scanner.nextLine();

                if (userType == 1) {
                    System.out.print("\n\t\t\t\t\t\tEnter your resume: ");
                    String resume = scanner.nextLine();
                    JobSeeker jobSeeker = new JobSeeker(username, password, resume);
                    jobPortal.signUp.registerUser(jobSeeker);
                } else if (userType == 2) {
                    System.out.print("\n\t\t\t\t\t\tEnter your company name: ");
                    String company = scanner.nextLine();
                    Employer employer = new Employer(username, password, company);
                    jobPortal.signUp.registerUser(employer);
                }
            } else if (choice == 2) {
                System.out.print("\t\t\t\t\t\tEnter your username: ");
                String username = scanner.nextLine();
                System.out.print("\n\t\t\t\t\t\tEnter your password: ");
                String password = scanner.nextLine();

                currentUser = jobPortal.signIn.signIn(username, password);
                if (currentUser != null) {
                    System.out.println("\n\n\t\t\t\t\t\tLogged in successfully!");
                    break;
                }
            } else if (choice == 3) {

                System.out.println("\n\n\t\t\t\t\t\tExiting. Goodbye!");
                System.exit(0);
            }
        }

        jobPortal.displayJobs();

        while (true) {
            System.out.println("\n\t\t\t\t   +================== MAIN MENU =====================+");
            System.out.println("\t\t\t\t   1. \t\tApply for a Job");
            System.out.println("\t\t\t\t   2. \t\tPost a Job");
            System.out.println("\t\t\t\t   3. \t\tDisplay Job Applications");
            System.out.println("\t\t\t\t   4. \t\tExit");
            System.out.println("\t\t\t\t   +==================================================+");
            System.out.print("\n\n\t\t\t\t\t\tEnter your choice: ");
            int mainPageChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainPageChoice == 1) {

                if (currentUser != null && currentUser instanceof JobSeeker) {
                    jobPortal.displayJobs();
                    System.out.print("\n\n\t\t\t\t\t\tEnter the title of the job you want to apply for: ");
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
                        System.out.println("\n\n\t\t\t\t\t\tJob application submitted successfully!\n");
                    } else {
                        System.out.println("\n\n\t\t\t\t\t\tJob not found!\n");
                    }
                } else {
                    System.out.println("\n\n\t\t\t\t\t\tYou must be logged in as a Job Seeker to apply for a job.");
                }
            } else if (mainPageChoice == 2) {

                if (currentUser != null && currentUser instanceof Employer) {
                    System.out.print("\t\t\t\t\t\tEnter job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("\t\t\t\t\t\tEnter job pay: ");
                    String jobPay = scanner.nextLine();
                    System.out.print("\t\t\t\t\t\tEnter job description: ");
                    String jobDescription = scanner.nextLine();

                    JobPosting newJob = new JobPosting(jobTitle, jobPay, jobDescription);
                    jobPortal.postJob(newJob);
                } else {
                    System.out.println("\n\n\t\t\t\t\t\tYou must be logged in as an Employer to post a job.");
                }

            } else if (mainPageChoice == 3) {
                jobPortal.displayJobApplications();

            } else if (mainPageChoice == 4) {
                System.out.println("\n\n\t\t\t\t\t\tExiting. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}



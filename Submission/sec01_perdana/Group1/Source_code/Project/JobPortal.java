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


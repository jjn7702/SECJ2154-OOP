package job_posting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JobPosting {
    private String jobTitle;
    private String jobPay;
    private String jobDescription;

    private static final String JOB_FILE_PATH = "JobList.txt";

    public JobPosting(String jobTitle, String jobPay, String jobDescription) {
        this.jobTitle = jobTitle;
        this.jobPay = jobPay;
        this.jobDescription = jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobPay() {
        return jobPay;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void postJob(List<JobPosting> jobPostings) {
        jobPostings.add(this);
        writeJobToFile();
        System.out.println("\n\t\t\t\tJob posted successfully!");
    }

    private void writeJobToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOB_FILE_PATH, true))) {
            writer.write(getJobTitle());
            writer.newLine();
            writer.write(getJobPay());
            writer.newLine();
            writer.write(getJobDescription());
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.out.println("\n\t\t\t\tError writing job to file: " + e.getMessage());
        }
    }
}

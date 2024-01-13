package job_posting;
public class JobPosting {
    private String jobTitle;
    private String jobPay;
    private String jobDescription;

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
}


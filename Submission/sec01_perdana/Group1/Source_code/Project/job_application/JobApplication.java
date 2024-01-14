package job_application;
import job_posting.JobPosting;
import jobseeker.JobSeeker;

public class JobApplication {
    private JobSeeker applicant;
    private JobPosting job;
    private String status;

    public JobApplication(JobSeeker applicant, JobPosting job, String status) {
        this.applicant = applicant;
        this.job = job;
        this.status = status;
    }

        public JobSeeker getApplicant(){
        return applicant;
    }

    public JobPosting getJob(){
        return job;
    }

    public String getStatus(){
        return status;
    }
}

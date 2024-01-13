package jobseeker;
import user.User;

public class JobSeeker extends User {
    private String resume;

    public JobSeeker(String username, String password, String resume) {
        super(username, password);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }
}


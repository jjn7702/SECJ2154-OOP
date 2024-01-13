package employer;
import user.User;

public class Employer extends User {
    private String company;

    public Employer(String username, String password, String company) {
        super(username, password);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}


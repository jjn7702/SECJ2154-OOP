import java.util.ArrayList;

public class Administrator extends User {
    // Private attributes
    public String username;
    private String job;
    private ArrayList<Student> stud;
    private Scholarship scholar;
    private Apply application;

    // Public constructor

    public Administrator(){}
    
    public Administrator(String fn, String ln, int a, String em, Address add, String username, String job,
            ArrayList<Student> stud, Scholarship scholar, Apply application) {
        super(fn, ln, a, em, add);
        this.username = username;
        this.job = job;
        stud = new ArrayList<>();
        this.scholar = scholar;
        this.application = application;
    }

    public void setAdminId(String aid) {
        username = aid;
    }

    public void setJob(String j) {
        job = j;
    }

    public String getusername() {
        return username;
    }

    public String getJob() {
        return job;
    }

    public void evaluateStudent(Student st) {
        stud.add(st);
    }

    @Override
    public String toString() {
        return super.toString() + " Admin username: " + username + " Job: " + job;
    }
}

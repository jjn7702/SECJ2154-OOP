import java.util.ArrayList;

public class Administrator extends User {
    // Private attributes
    public String adminID;
    private String job;
    private ArrayList<Student> stud;
    private Scholarship scholar;
    private Apply application;

    // Public constructor
    public Administrator(String fn, String ln, int a, String em, Address add, String adminId, String job,
            ArrayList<Student> stud, Scholarship scholar, Apply application) {
        super(fn, ln, a, em, add);
        this.adminID = adminId;
        this.job = job;
        this.stud = stud;
        this.scholar = scholar;
        this.application = application;
    }

    public void setAdminId(String aid) {
        adminID = aid;
    }

    public void setJob(String j) {
        job = j;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getJob() {
        return job;
    }

    public void evaluateStudent(Student st) {
        stud.add(st);
    }

    @Override
    public String toString() {
        return super.toString() + " Admin ID: " + adminID + " Job: " + job;
    }
}

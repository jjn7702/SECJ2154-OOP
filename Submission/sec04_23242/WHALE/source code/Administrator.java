import java.util.ArrayList;

public class Administrator extends User {
    // Private attributes
    public String username;
    private String position;
    private ArrayList<Student> stud;
    // private Scholarship scholar;
    public Apply application;

    // Public constructor

    public Administrator() {
    }

    public Administrator(String fn, String ln, int a, String em, Address add, String username, String position) {
        super(fn, ln, a, em, add);
        this.username = username;
        this.position = position;
        stud = new ArrayList<>();
        // this.scholar = sc ;
        this.application = new Apply();
    }

    public void setUsername(String aid) {
        username = aid;
    }

    public void setJob(String j) {
        position = j;
    }

    /*
     * public void setScholarshipAdmin(Scholarship sd){
     * //scholar = sd ;
     * }
     */

    public String getusername() {
        return username;
    }

    public String getJob() {
        return position;
    }

    public boolean evaluateStudent(Student st, Scholarship scholar) {
        if (scholar.isEligible(st) == true) {
            stud.add(st);
            return true;
        }

        else
            return false;
    }

    public ArrayList<Student> getStudent() {
        return stud;
    }

    public Student getStudent(int i) {
        return stud.get(i);
    }

    @Override
    public String toString() {
        return super.toString() + " Admin username: " + username + "\nPosition: " + position;
    }

    @Override
    public void display() {
        System.out.println("Full Name: " + super.fName + " " + super.lName);
        System.out.println("Position: " + position);
        System.out.println("Age: " + super.getAge());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Address: " + super.add.toString());
    }
}

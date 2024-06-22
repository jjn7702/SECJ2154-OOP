import java.util.ArrayList;

public class Administrator extends User {
    // Private attributes
    public String username;
    private String position;
    private ArrayList<Student> studaprove ;
    private ArrayList<Student> studrej ;
    // private Scholarship scholar;
    public Apply application;

    // Public constructor

    public Administrator() {
    }

    public Administrator(String fn, String ln, int a, String em, Address add, String username) {
        super(fn, ln, a, em, add);
        this.username = username;
        studaprove = new ArrayList<>();
        studrej = new ArrayList<>();
        // this.scholar = sc ;
        this.application = new Apply();
    }

    public void setUsername(String aid) {
        username = aid;
    }

    public void setJob(String j) {
        position = j;
    }

    public String getusername() {
        return username;
    }

    public String getJob() {
        return position;
    }

    public boolean evaluateStudent(Student st, Scholarship scholar) {
        if (scholar.isEligible(st) == true) {
            studaprove.add(st);
            return true;
        }

        else{
            studrej.add(st) ;
            return false;
        }
    }

    public ArrayList<Student> getStudentApro() {
        return studaprove;
    }
    public ArrayList<Student> getStudentRej() {
        return studrej;
    }

    @Override
    public String toString() {
        return super.toString() + " Admin username: " + username ;
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

public class Student extends User {
    // private attributes
    private String matricsNumber;
    private String major;
    private double CGPA;
    private Scholarship scholarship;
    private Programs prog;
    private StudentHistory studhist;
    private double threshold ;

    // constructor
    public Student(String fn, String ln, int a, String em, Address add, String matricsNumber/*
                                                                                             * String major, double
                                                                                             * CGPA,
                                                                                             * Scholarship scholarship,
                                                                                             * Programs prog,
                                                                                             * StudentHistory studhist
                                                                                             */) {
        super(fn, ln, a, em, add);
        this.matricsNumber = matricsNumber;
        // this.major = major;
        // this.CGPA = CGPA;
        // this.scholarship = scholarship;
        // this.prog = prog;
        // this.studhist = studhist;
    }

    // getters and setters
    public void setMajor(String major) {
        this.major = major;
    }

    public void setCgpa(double CGPA) {

    }

    public String getMatricsNumber() {
        return matricsNumber;
    }

    public String getMajor() {
        return major;
    }

    public double getCgpa() {
        return CGPA;
    }

    public double getThreshold(){
        return threshold ;
    }

    @Override
    public String toString() {
        return super.toString() + " Matrics Number: " + matricsNumber + " Major: " + major + " CGPA: " + CGPA
                + " Scholarship: " + scholarship + " Program: " + prog + " Student History: " + studhist;
    }

    public void display(){
        System.out.println("Full Name: " + super.fName + " " + super.lName);
        System.out.println("Age: " + super.getAge());
        System.out.println("Email: " + super.getEmail());    
        System.out.println("Address: " + super.add.toString());
    }

    public void displayAllDetails() {
        display();
        System.out.println("Matrics Number: " + matricsNumber);
        System.out.println("Major: " + major);
        System.out.println("CGPA: " + CGPA);
        System.out.println("Program: " + prog);

        if (scholarship != null) {
            System.out.println("Scholarship Details:");
            scholarship.display();
        } else {
            System.out.println("No Scholarship");
        }

        if (studhist != null) {
            System.out.println("Student History Details:");
            studhist.display();
        } else {
            System.out.println("No Student History");
        }
    }

}

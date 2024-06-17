public class StudentHistory {
    private Programs lastprog;
    private double cgpa;
    private String majors;

    public StudentHistory(Programs lastprog, double cgpa, String majors) {
        this.lastprog = lastprog;
        this.cgpa = cgpa;
        this.majors = majors;
    }

    public void display() {
        System.out.println("Last Program: " + lastprog);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Majors: " + majors);
    }

    
}
package users.qualification;

public class Qualification{
    private String major, university;
    private double cgpa;

    public Qualification(String major, String university, double cgpa){
        this.major = major;
        this.university = university;
        this.cgpa = cgpa;
    }

    public String getMajor(){
        return major;
    }

    public String getUniversity(){
        return university;
    }

    public double getCgpa(){
        return cgpa;
    }

    public void displayQualificationDetails(){}
    
}
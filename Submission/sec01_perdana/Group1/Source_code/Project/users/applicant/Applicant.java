package users.applicant;
import users.address.Address;
import users.qualification.*;

public class Applicant{
    private String name, email, phone, gender;
    private Address address;
    private Qualification qualify;

    public Applicant(String name, String email, String phone, Address add, String gender, String major, String university, double cgpa){
        this.name = name;
        this.email = email;
        this.phone = phone;
        address = add;
        this.gender = gender;
        qualify = new Qualification(major,university,cgpa);
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public Address getAddress(){
        return address;
    }

    public String getGender(){
        return gender;
    }

    public Qualification getQualification(){
        return qualify;
    }

    public void display(){}
}

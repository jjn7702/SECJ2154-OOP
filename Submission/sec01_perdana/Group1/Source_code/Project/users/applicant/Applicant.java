package users.applicant;
import users.address.*;
import users.qualification.*;

public class Applicant{
    private String name, email, phone, gender;
    private Address address;
    private Qualification qualification;
    
    public Applicant(String name, String email, String phone, Address add, String gender, Qualification qualify){
        this.name = name;
        this.email = email;
        this.phone = phone;
        address = add;
        this.gender = gender;
        qualification = qualify;

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
        return qualification;
    }

    public void display(){}

}
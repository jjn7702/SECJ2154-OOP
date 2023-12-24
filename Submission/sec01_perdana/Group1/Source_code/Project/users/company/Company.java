package users.company;
import users.address.*;

public class Company{
    private String companyName, companyID;
    private Address address;

    public Company(String companyName, String companyID, Address add){
        this.companyName = companyName;
        this.companyID = companyID;
        address = add;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getCompanyID(){
        return companyID;
    }

    public Address getAddress(){
        return address;
    }

    public void displayCompanyDetails(){}
    
}
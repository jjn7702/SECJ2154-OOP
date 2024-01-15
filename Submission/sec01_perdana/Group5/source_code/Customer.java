//SARANYA A/P JAYARAMA REDDY (B22EC3013)

public class Customer {
    private String name;
    private String licenseNumber;
    private String address;
    private String email;
    private String phoneNumber;

    public Customer(String name, String licenseNumber, String address, String email, String phoneNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}


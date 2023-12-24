package users.address;

public class Address{
    private String street, city, state;
    private int postCode;

    public Address(String street, String city, String state, int postCode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public String getAddress(){
        return street + ", " + postCode + " " + state + ", " + city;
    }
}
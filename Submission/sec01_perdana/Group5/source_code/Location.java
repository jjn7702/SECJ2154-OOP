//ISWARY:B22EC3004

public class Location {
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Location(String address, String city, String state, String zipCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getter methods
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    //toString method to get location as a String
    public String toString(){
        return getAddress() + ", " + getCity() + ", " + getState() + ", " + getZipCode();
    }
}



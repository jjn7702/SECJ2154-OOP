public class Address {
    private String street;
    private String state;
    private String zipcode;

    public Address(String street, String state, String zipcode, String country) {
        this.street = street;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return street + ", " + zipcode + ", " + state + ", " + country;
    }

}


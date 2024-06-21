public class Address {
    private String street;
    private String state;
    private String town;
    private String country;

    public Address(String street, String state, String zipcode, String country) {
        this.street = street;
        this.state = state;
        this.town = zipcode;
        this.country = country;
    }

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

    public String getTown() {
        return town;
    }

    public void setTown(String zipcode) {
        this.town = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return street + ", " + town + ", " + state + ", " + country;
    }

}

public class Address {
    private String street;
    private String city;

    public Address(String street, String city ) {
        this.street = street;
        this.city = city;
    }
    public String getAddress(){
			return street + ", " + " "+ city;
	}
}
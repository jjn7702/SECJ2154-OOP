package users.address;

public class Address{
	private String street, city, state;
	private int postCode;

	public Address(String st, String c, int p, String s){
		street = st;
		city = c;
		postCode = p;
		state= s;
	}

	public String getAddress(){
		return street + ", " + postCode + " " + state + ", " + city;
	}
}

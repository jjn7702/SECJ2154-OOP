class Address {
	private String street, city, state;
	private int postcode;

	public Address(String st, String c, int p, String s) {
		street = st;
		city = c;
		postcode = p;
		state = s;
	}

	public String getAddress() {
		return street + ", " + postcode + " " + state + ", " + city;
	}
}
class Name {
	private String firstName, lastName;

	public Name(String f, String l) {
		firstName = f;
		lastName = l;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}
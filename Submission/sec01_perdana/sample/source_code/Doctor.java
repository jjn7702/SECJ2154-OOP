class Doctor {
	private Name name; //shows composition
	private String staffId;

	public Doctor(String first, String last, String id) {
		name = new Name(first, last); //shows composition
		staffId = id;
	}

	public String getFullName() {
		return name.getFullName();
	}
}
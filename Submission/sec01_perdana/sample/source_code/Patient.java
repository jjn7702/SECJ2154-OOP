class Patient {
	private String patientID, gender;
	private Name name; //shows composition
	private Address address; //shows aggregation
	private HealthInfo pHealth; //shows composition
	private Doctor doctor; //shows association

	public Patient(String id, String g, String first, String last, Address add, int h, int w) {
		name = new Name(first, last); //shows composition
		pHealth = new HealthInfo(h, w); //shows composition
		address = add; //shows aggregation
		doctor = null;
		patientID = id;
		gender = g;
		System.out.println("Patient: " + getFullName() + " has been added");
	}

	public String getPatientID() {
		return patientID;
	}

	public int getWeight() {
		return pHealth.getWeight();
	}

	public int getHeight() {
		return pHealth.getHeight();
	}

	public String getFullName() {
		return name.getFullName();
	}

	public String getGender() {
		return gender;
	}

	public Address getAddress() {
		return address;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	void attendBy(Doctor d) { //shows association
		doctor = d;
	}
}
public class Patient extends Person {
	private static int lastPatientID = 0;
    private String patientID;
    private int age;
    private String gender;
    private Address address;
    private MedicalRecord medicalRecord;


    public Patient(String firstName, String lastName,  int age,String phoneNum, String gender, Address address,MedicalRecord medicalRecord) {
        super(new Name(firstName, lastName), phoneNum);
          lastPatientID++;
        this.patientID = "P00" + lastPatientID;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.medicalRecord = medicalRecord;
    }



     public String getPatientID() {
           return patientID;
       }

    public int getAge(){
        return age;
    }

    public String getGender() {
        return gender;
    }

    public MedicalRecord getMedicalRecord() {
	        return medicalRecord;
    }

    public Address getAddress(){
			return address;
	}

}
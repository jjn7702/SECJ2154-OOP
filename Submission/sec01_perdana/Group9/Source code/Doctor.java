public class Doctor extends Person {
    private String doctorID;
    private String specialization;

    public Doctor(Name name, String doctorID, String phoneNum,  String specialization) {
        super(name, phoneNum);
        this.doctorID = doctorID;
        this.specialization = specialization;
    }

    public Name getName(){
		return super.getName();
	}

    public String getDoctorId() {

		 return doctorID;
    }

    public String getSpecialization() {
        return specialization;
    }

}
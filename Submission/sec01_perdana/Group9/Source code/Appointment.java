public class Appointment {
    private String appointmentID;
    private String patientID;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;

    public Appointment(String appointmentID, String patientID, String date, String time, Doctor doctor) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getAppointmentID() {
        for (int i = 1; i <= 100; i++) {
				     return "A00" + i;
				 }
		 return appointmentID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String patientID() {
	        return patientID;
    }

    public String getDoctorId() {
        return doctor.getDoctorId();
    }


}
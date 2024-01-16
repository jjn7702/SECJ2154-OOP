public class Appointment {
	private static int lastAppID = 0;
    private String appointmentID;
    private String patientID;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;

    public Appointment(String appointmentID, String patientID, String date, String time, Doctor doctor) {
        lastAppID++;
        this.appointmentID = "P00" +  lastAppID;
        this.patientID = patientID;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getAppointmentID() {
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
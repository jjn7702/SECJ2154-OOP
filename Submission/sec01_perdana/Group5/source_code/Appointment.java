import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    private Date appointmentDate;

    public Appointment(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Appointment Date: " + sdf.format(appointmentDate);
    }
}

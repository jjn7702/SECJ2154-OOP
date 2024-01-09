// NAME : MUHAMMAD AIMAN HAIQAL BIN SALEHUDDIN
class Attendance {
    private int attendanceID;
    private Employee employee;
    private String date;
    private double hoursWorked;
    private final double REGULARHOURS =  8.0;

    public Attendance(int aID, Employee employee, String dt, double hW){
        this.attendanceID = aID;
        this.employee = employee;
        this.date = dt;
        this.hoursWorked = hW;
    }

    public double calculateOvertime() {
        double overtimeHours = Math.max(0, hoursWorked - REGULARHOURS);
        return overtimeHours;
    }
}

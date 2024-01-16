class Attendance {
    private int attendanceID;
    private Employee employee;
    private int daysAttended;
    private int daysOnLeave;

    public Attendance(int attendanceID, Employee employee, int daysAttended, int daysOnLeave) {
        this.employee = employee;
        this.daysAttended = daysAttended;
        this.daysOnLeave = daysOnLeave;
        this.attendanceID = attendanceID;
    }

    public int getDaysAttended() {
        return daysAttended;
    }

    public void setDaysAttended(int daysAttended) {
        this.daysAttended = daysAttended;
    }

    public int getDaysOnLeave() {
        return daysOnLeave;
    }

    public void setDaysOnLeave(int daysOnLeave) {
        this.daysOnLeave = daysOnLeave;
    }

    public String getEmployeeFullName() {
        return employee.getFullName();
    }

    public void updateAttendance(int daysAttended, int daysOnLeave) {
        this.daysAttended = daysAttended;
        this.daysOnLeave = daysOnLeave;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getAttendDays() {
        return daysAttended;
    }
}
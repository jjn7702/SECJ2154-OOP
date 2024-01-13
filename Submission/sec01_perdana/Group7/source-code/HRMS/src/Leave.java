class Leave {
    private int leaveID;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String reason;

    public Leave(int lID, Employee employee, String sDate, String eDate, String rn) {
        this.leaveID = lID;
        this.employee = employee;
        this.startDate = sDate;
        this.endDate = eDate;
        this.reason = rn;
    }

    public boolean validateLeaveRequest() {
        return startDate.compareTo(endDate) <= 0;
    }

    public int getLeaveID() {
        return leaveID;
    }

    public Employee getEmployee(){
        return employee;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public String getEmployeeFirstName() {
        return employee.getFirstName();
    }

    public String getEmployeeLastName() {
        return employee.getLastName();
    }
}
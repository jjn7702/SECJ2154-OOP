class Leave {
    private int leaveID;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String reason;

    public Leave(int leaveID, Employee employee, String startDate, String endDate, String reason) {
        this.leaveID = leaveID;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public boolean validateLeaveRequest() {
        // Assuming a simple validation: Leave is valid if the start date is before the
        // end date
        return startDate.compareTo(endDate) <= 0;
    }
}
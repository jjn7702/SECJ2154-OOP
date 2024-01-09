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
}
class Leave {
    private Employee employee;
    private int leaveDays;

    public Leave(Employee employee, int leaveDays) {
        this.leaveDays = leaveDays;
        this.employee = employee;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public void updateLeaveDays(int newLeaveDays) {
        this.leaveDays = newLeaveDays;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getEmployeeFullName() {
        return employee.getFullName();
    }
}
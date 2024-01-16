class Salary {
    private int salaryID;
    private double amount;
    private double deductions;
    private Employee employee;

    public Salary(int salaryID, double amount, double deductions, Employee employee) {
        this.salaryID = salaryID;
        this.amount = amount;
        this.deductions = deductions;
        this.employee = employee;
    }

    public double calculateNetSalary() {
        return amount - deductions;
    }

    public int getSalaryID() {
        return salaryID;
    }

    public double getAmount() {
        return amount;
    }

    public double getDeductions() {
        return deductions;
    }

    public Employee getEmployee() {
        return employee;
    }
}
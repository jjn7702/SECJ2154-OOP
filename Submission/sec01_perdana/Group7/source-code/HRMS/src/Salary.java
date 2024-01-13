class Salary {
    private int salaryID;
    private double amount;
    private double deductions;
    private double bonuses;

    public Salary(int salaryID, double amount, double deductions, double bonuses) {
        this.salaryID = salaryID;
        this.amount = amount;
        this.deductions = deductions;
        this.bonuses = bonuses;
    }

    public double calculateNetSalary() {
        return amount - deductions + bonuses;
    }

    public int getSalaryID() {
        return salaryID;
    }
}
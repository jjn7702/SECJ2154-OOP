class Salary {
    public int salaryID;
    public double amount;
    public double deductions;
    public double bonuses;

    public Salary(int salaryID, double amount, double deductions, double bonuses) {
        this.salaryID = salaryID;
        this.amount = amount;
        this.deductions = deductions;
        this.bonuses = bonuses;
    }

    public double calculateNetSalary() {
        return amount - deductions + bonuses;
    }
}
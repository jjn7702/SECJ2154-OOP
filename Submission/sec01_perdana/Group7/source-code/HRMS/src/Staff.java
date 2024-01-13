class Staff extends Employee {
    private Position position;

    public Staff(int employeeID, String firstName, String lastName, String dateOfBirth, String gender, String contactInfo, Position position) {
        super(employeeID, firstName, lastName, dateOfBirth, gender, contactInfo);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void displayEmployeeInfo() {
        // Polymorphism
        System.out.println("Staff Member Information:");
        super.displayEmployeeInfo();
        System.out.println("Position: " + position.getTitle());
    }
}
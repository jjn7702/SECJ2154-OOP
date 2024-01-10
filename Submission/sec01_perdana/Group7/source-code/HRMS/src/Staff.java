public Staff(Position position){
	this.position=position;
}
class Staff extends Employee {
	private Position position;
    public Staff(int employeeID, String firstName, String lastName, String dateOfBirth, String gender, String contactInfo, Position position) {
    super(employeeID, firstName, lastName, dateOfBirth, gender, contactInfo, position);
}
	public void setPosition(Position newPosition){
	this.position= newPosition;
}

	public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
    }
}

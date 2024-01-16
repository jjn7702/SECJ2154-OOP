class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactInfo;
    private String email;
    private Department assignedDepartment;
    private Position assignedPosition;
    private Leave leave;
    private Attendance attendance;

    public Employee(int empID, String fn, String ln, String dob, String gr, String ci, String em) {
        this.employeeID = empID;
        this.firstName = fn;
        this.lastName = ln;
        this.dateOfBirth = dob;
        this.gender = gr;
        this.contactInfo = ci;
        this.email = em;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public Department getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedDepartment(Department assignedDepartment) {
        this.assignedDepartment = assignedDepartment;
    }

    public Position getAssignedPosition() {
        return assignedPosition;
    }

    public void setAssignedPosition(Position assignedPosition) {
        this.assignedPosition = assignedPosition;
    }

    public Leave getLeave() {
        return leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    public void updateLeaveDays(int newLeaveDays) {
        if (leave == null) {
            leave = new Leave(this, 0);
        }
        leave.setLeaveDays(newLeaveDays);
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + getFullName());
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Email: " + email);
    }
}
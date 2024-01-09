class Employee{
    private int employeeID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactInfo;

    public Employee(int empID, String fn, String ln, String DOB, String gr, String CI) {
        this.employeeID = empID;
        this.firstName = fn;
        this.lastName = ln;
        this.dateOfBirth = DOB;
        this.gender = gr;
        this.contactInfo = CI;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Encapsulation and data hiding
    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Info: " + contactInfo);
    }
}
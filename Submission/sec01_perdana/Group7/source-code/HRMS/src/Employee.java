class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String contactInfo;

    public Employee(int empID, String fn, String ln, String dob, String gr, String ci) {
        this.employeeID = empID;
        this.firstName = fn;
        this.lastName = ln;
        this.dateOfBirth = dob;
        this.gender = gr;
        this.contactInfo = ci;
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

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getGender(){
        return gender;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Info: " + contactInfo);
    }
}
class Student extends User {
    private String matricsNumber, role;

    public Student(String name, String email, String mat_No, String r) {
        super(name, email);
        matricsNumber = mat_No;
        role = r;
    }

    public String getMatricsNum() {
        return matricsNumber;
    }

    public String getRole() {
        return role;
    }

    public void setMatricsNum (String matricsNumber) {
        this.matricsNumber = matricsNumber;
    }

    public void setRole (String role) {
        this.role = role;
    } 

    @Override
    public void display() {
        System.out.println("Student Info:");


        // System.out.println("ID: " + getUserID());
        // System.out.println("Name: " + getName());
        // System.out.println("Email: " + getEmail());
    }
}
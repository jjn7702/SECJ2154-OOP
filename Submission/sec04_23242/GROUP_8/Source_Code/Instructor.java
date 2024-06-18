class Instructor extends User {
    private String empNumber;

    public Instructor(String name, String email, String emp_no) {
        super(name, email);
        empNumber = emp_no;
    }

    public String getEmpNum() {
        return empNumber;
    }
    
    public void display() {
        super.display();
        System.out.println("Instructor Employee No: " + empNumber);
    }
}
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
        System.out.printf("\n╔═%-40s═╗", "══════════════════════════════════════════");
        System.out.printf("\n║  %-40s  ║", "Instructor Info");       
        System.out.printf("\n╠═%-40s═╣", "══════════════════════════════════════════");
        System.out.printf("\n║  %-11s: %-27s  ║", "Name", getName());       
        System.out.printf("\n║  %-11s: %-27s  ║", "Email", getEmail());     
        System.out.printf("\n║  %-11s: %-27s  ║", "Employee No", empNumber);     
        System.out.printf("\n╚═%-40s═╝", "══════════════════════════════════════════");

        // System.out.println("Name: " + getName());
        // System.out.println("Email: " + getEmail());
        // System.out.println("Instructor Employee No: " + empNumber);
    }
}
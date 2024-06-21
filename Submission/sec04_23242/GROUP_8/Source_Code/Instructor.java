class Instructor extends User {
    private String empNumber;

    public Instructor(String name, String email, String emp_no) {
        super(name, email);
        empNumber = emp_no;
    }

    public String getEmpNum() {
        return empNumber;
    }

    public void setEmpNum(String eN) {
        empNumber = eN;
    }
    
    public void display() {
        System.out.printf("\n╔═%-40s═╗", "══════════════════════════════════════════");
        System.out.printf("\n║  %-40s  ║", "Instructor Info");       
        System.out.printf("\n╠═%-40s═╣", "══════════════════════════════════════════");
        System.out.printf("\n║  %-11s: %-27s  ║", "Name", getName());       
        System.out.printf("\n║  %-11s: %-27s  ║", "Email", getEmail());     
        System.out.printf("\n║  %-11s: %-27s  ║", "Instructor ID", empNumber);     
        System.out.printf("\n╚═%-40s═╝", "══════════════════════════════════════════");
    }
}
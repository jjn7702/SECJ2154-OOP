class Student extends User {
    private String matricsNumber, role;

    public Student(String mat_No ,String name, String email, String r) {
        super(name, email);
        matricsNumber = mat_No;
        role = r;
    }

    //Basic Getter
    public String getMatricsNum() {
        return matricsNumber;
    }

    public String getRole() {
        return role;
    }
    //------------

    //Basic Setter
    public void setMatricsNum(String mN) {
        matricsNumber = mN;
    }

    public void setRole(String r) {
        role = r;
    }
    //-------------

    @Override
    public void display() {
        System.out.printf("\n╔═%-40s═╗", "══════════════════════════════════════════");
        System.out.printf("\n║  %-40s  ║", "Student Info");       
        System.out.printf("\n╠═%-40s═╣", "══════════════════════════════════════════");
        System.out.printf("\n║  %-10s: %-28s  ║", "Name", getName());       
        System.out.printf("\n║  %-10s: %-28s  ║", "Email", getEmail());     
        System.out.printf("\n║  %-10s: %-28s  ║", "Matrics No", matricsNumber);     
        System.out.printf("\n║  %-10s: %-28s  ║", "Role", role);     
        System.out.printf("\n╚═%-40s═╝", "══════════════════════════════════════════");
    }
}
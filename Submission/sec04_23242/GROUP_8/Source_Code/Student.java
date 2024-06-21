class Student extends User {
    private String matricsNumber, role;
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if (this.team!= null) {
            this.team.removeMember(this);
        }
        this.team = team;
        if (team!= null) {
            team.addMember(this);
        }
    }

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
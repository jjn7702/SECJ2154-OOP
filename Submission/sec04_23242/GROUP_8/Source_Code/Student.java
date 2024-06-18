class Student extends User {
    private String matricsNumber, role;
    private Team team;

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

    public void setRole(String role) {
        this.role = role;
    }

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
        System.out.println("Name: " + getName().toUpperCase());
        System.out.println("Email: " + getEmail());
        System.out.println("Student Matrics No: " + matricsNumber);
        System.out.println("Student Role: " + role);
    }
}
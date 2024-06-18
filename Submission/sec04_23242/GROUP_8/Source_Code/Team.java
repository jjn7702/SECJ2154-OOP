import java.util.Vector;

class Team {
    private String teamName;
    private Vector<Student> members;

    public Team(String teamName) {
        this.teamName = teamName;
        members = new Vector<>();
    }

    public void addMember(Student s) {
        if (s.getTeam()!= null) {
            s.getTeam().removeMember(s);
        }
        members.add(s);
        s.setTeam(this);
    }

    public void removeMember(Student s) {
        members.remove(s);
        s.setTeam(null);
    }

    public String getTeamName() {
        return teamName;
    }

    public Vector<Student> getMembers() {
        return members;
    }
}
import java.util.Vector;

class Team {
    private String teamName;
    private Vector<Student> members;

    public Team(String teamName) {
        this.teamName = teamName;
        members = new Vector<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String tN) {
        teamName = tN;
    }

    public void addMember(Student s) {
        members.add(s);
    }

    public void removeMember(Student s) {
        members.remove(s);
    }

    public Vector<Student> getMembers() {
        return members;
    }
}
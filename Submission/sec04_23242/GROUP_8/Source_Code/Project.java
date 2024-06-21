import java.util.*;

class Project {
    private String projectID;
    private String title;
    private String description;

    private Vector<Milestone> milestone;
    private Report report;
    private Team team;
    private Instructor instructor;

    public Project() { 
        this.milestone = new Vector<>();
    }

    public Project(String projectID, String title, String desc, Report report, Team team, Instructor instructor) {
        this.projectID = projectID;
        this.title = title;
        this.description = desc;
        this.milestone = new Vector<>();
        this.report = report;
        this.team = team; // Composition: Project "has a" Team
        this.instructor = instructor;
    }

    public String getProjectID() {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setProjectID(String pID) {
        projectID = pID;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void addMilestone(Milestone m) {
        milestone.add(m);
    }

    public void removeMilestone(Milestone m) {
        milestone.remove(m);
    }

    public Vector<Milestone> getMilestone() {
        return milestone;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Team getTeam() {
        return team;
    }

    public void addTeamMember(Student s) {
        team.addMember(s);
    }

    public void removeTeamMember(Student s) {
        team.removeMember(s);
    }

    public void printProjectDetails() {
        System.out.printf("\n╔═%s═╗", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ╔═%107s═╗ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %-1s: %-101s ║ ║", projectID, title); 
        
        System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %-107s ║ ║", description);
        System.out.printf("\n║ ╚═%s═╝ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");

        System.out.printf("\n╠═%s═╣", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ %111s ║", "");
    
        // Team Info
        System.out.printf("\n║ ╔═%s═╗ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %-107s ║ ║", "");
        System.out.printf("\n║ ║ %-107s ║ ║", "Team Information");
        System.out.printf("\n║ ║ %-107s ║ ║", "");
        System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Team Name", team.getTeamName());
        System.out.printf("\n║ ║ %-107s ║ ║", "                                                                      ");
        
        System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Instructor Name", instructor.getName());
        System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Instructor ID", instructor.getEmpNum());
        System.out.printf("\n║ ║ %-107s ║ ║", "                                                                      ");
        System.out.printf("\n║ ║ %-107s ║ ║", "Team Members: ");
        System.out.printf("\n║ ║ ╔═%s═╗ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ ║  %-30s ║ %-12s ║ %-35s ║ %-16s ║ ║ ║", "Name", "Matrics No.", "Email", "Role");
        System.out.printf("\n║ ║ ╠═%s═╣ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
    
        // Loop through team members
        for (Student member : team.getMembers()) {
            System.out.printf("\n║ ║ ║  %-30s ║ %-12s ║ %-35s ║ %-16s ║ ║ ║", 
                member.getName(), 
                member.getMatricsNum(), 
                member.getEmail(), 
                member.getRole());
        }
    
        System.out.printf("\n║ ║ ╚═%s═╝ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ╚═%s═╝ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ %111s ║", ""); //Whitespace
    
        // Milestone Info
        System.out.printf("\n╠=%111s=╣", "===============================================================================================================");
        System.out.printf("\n║ %111s ║", ""); //Whitespace
        System.out.printf("\n║ ╔═%s═╗ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %-107s ║ ║", "");
        System.out.printf("\n║ ║ %-107s ║ ║", "Milestones Information");
        System.out.printf("\n║ ║ %-107s ║ ║", "");
        System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ║ %107s ║ ║", "");

        int milestoneCount = 1;
        for (Milestone ms : milestone) {
            System.out.printf("\n║ ║ ╔═%s═╗ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ ║ Milestone #%-92d ║ ║ ║", milestoneCount++);
            System.out.printf("\n║ ║ ╠═%s═╣ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ ║ %-17s: %-84s ║ ║ ║", "ID", ms.getMilestoneID());
            System.out.printf("\n║ ║ ║ %-17s: %-84s ║ ║ ║", "Name", ms.getMilestoneName());
            System.out.printf("\n║ ║ ║ %-17s: %-84s ║ ║ ║", "Description", ms.getMilestoneDescription());
            System.out.printf("\n║ ║ ║ ╔═%s═╗ ║ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ ║ ║  %-98s ║ ║ ║ ║", "Tasks");
            System.out.printf("\n║ ║ ║ ╠═%s═╣ ║ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════");
    
            int taskCount = 1;
            for (Task task : ms.getTask()) {
                System.out.printf("\n║ ║ ║ ║  %-1d) %-79s ║  %-12s ║ ║ ║ ║", 
                    taskCount++, 
                    task.getName(), 
                    task.getStatus());
            }
    
            System.out.printf("\n║ ║ ║ ╚═%s═╝ ║ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ ╚═%s═╝ ║ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════");
        }
    
        System.out.printf("\n║ ║ %107s ║ ║", "");
        System.out.printf("\n║ ╚═%s═╝ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
    
        // Report Info
        if (report != null) {
            System.out.printf("\n║ %111s ║", "");
            System.out.printf("\n║ ╔═%s═╗ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ %-107s ║ ║", "");
            System.out.printf("\n║ ║ %-107s ║ ║", "Report Information");
            System.out.printf("\n║ ║ %-107s ║ ║", "");
            System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Report ID", report.getReportID());
            System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Title", report.getTitle());
            System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Submission Date", report.getSubmissionDate());
            System.out.printf("\n║ ║ %-107s ║ ║", "Content:");
            System.out.printf("\n║ ║ %-107s ║ ║", report.getContent());
    
            // Review Info
            Review review = report.getReview();
            if (review != null) {
                System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
                System.out.printf("\n║ ║ %-107s ║ ║", "");
                System.out.printf("\n║ ║ %-107s ║ ║", "Review Information");
                System.out.printf("\n║ ║ %-107s ║ ║", "");
                System.out.printf("\n║ ╠═%s═╣ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
                System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Review ID", review.getReviewID());
                System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Comments", review.getComments());
                System.out.printf("\n║ ║ %-17s: %-88s ║ ║", "Rating", review.getRating());
            }
    
            System.out.printf("\n║ ╚═%s═╝ ║", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        }
    
        System.out.printf("\n║ %111s ║", "");
        System.out.printf("\n╚═%s═╝", "═══════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
}
    
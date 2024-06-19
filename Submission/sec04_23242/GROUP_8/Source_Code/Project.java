import java.util.*;

class Project {
    private int projectID;
    private String title;
    private String description;

    private Vector<Milestone> milestone;
    private Report report;
    private Team team;

    public Project(int id, String title, String desc, Report report, Team team) {
        this.projectID = id;
        this.title = title;
        this.description = desc;
        this.milestone = new Vector<>();
        this.report = report;
        this.team = team; // Composition: Project "has a" Team
    }

    public int getProjectID() {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

<<<<<<< Updated upstream
    public void setDescription(String description) {
        this.description = description;
    }

    public void addTask(Task task) {
        tasks.add(task);
=======
    public void addMilestone(Milestone m) {
        milestone.add(m);
>>>>>>> Stashed changes
    }

    public void removeTask(Milestone m) {
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
        int taskCount = 1;
        int milestoneCount = 1;

        System.out.printf("\n╔═%-70s═╗", "══════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║  %-1s: %-67s  ║", projectID, title);  
        System.out.printf("\n╠═%-70s═╣", "══════════════════════════════════════════════════════════════════════════");
        System.out.printf("\n║ ╔═%-63s═╗ ║", "════════════════════════════════════════════════════════════════════");

        for(Milestone m: getMilestone()){
            System.out.printf("\n║ ╔═%-63s═╗ ║", "════════════════════════════════════════════════════════════════════");
            System.out.printf("\n║ ║  %-1s %d: %-52s  ║ ║", "Milestone", milestoneCount, m.getName());
            System.out.printf("\n║ ╠═%-66s═╣ ║", "════════════════════════════════════════════════════════════════════");
            for(Task t: m.getTask()){
                System.out.printf("\n║ ║  %-1s %d: %-52s  ║ ║", "Task", taskCount, t.getName());
            }  
        }
             
        System.out.printf("\n║  %-10s: %-67s  ║", "Email", getEmail());     
        System.out.printf("\n║  %-10s: %-67s  ║", "Matrics No", matricsNumber);     
        System.out.printf("\n║  %-10s: %-67s  ║", "Role", role);     
        System.out.printf("\n╚═%-40s═╝", "══════════════════════════════════════════");

        // System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        // System.out.println("║ Project ID: " + projectID);
        // System.out.println("║ Title: " + title);
        // System.out.println("║ Description: " + description + "\n");
        // System.out.println("║ Tasks:");
        // for (Milestone task : tasks) {
        //     System.out.println("║   Milestone No: " + task.getTaskID() + " Milestone Name: " + task.getTaskName() + " Status: "
        //             + task.getStatus());
        //     if (task.getDeadline() != null) {
        //         System.out.println("║   Deadline: " + task.getDeadline().getDueDate() + "\n");
        //     }
        // }
        // if (report != null) {
        //     System.out.println("║ Report ID: " + report.getReportID());
        //     System.out.println("║ Content: " + report.getContent());
        //     List<Review> reviews = report.getReviews();
        //     if (!reviews.isEmpty()) {
        //         System.out.println("\n║ Reviews:");
        //         for (Review review : reviews) {
        //             System.out.println("║   " + review);
        //         }
        //     } else {
        //         System.out.println("║ No reviews yet.");
        //     }
        // }
        // if (team != null) {
        //     System.out.println("\n║ Team: " + team.getTeamName());
        //     for (Student member : team.getMembers()) {
        //         System.out.printf("║   Member Name: %-9sEmail: %20s\n" ,member.getName(), member.getEmail());
        //     }
        // }
        // System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }
}

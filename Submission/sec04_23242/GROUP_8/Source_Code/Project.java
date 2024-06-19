import java.util.*;

class Project {
    private int projectID;
    private String title;
    private String description;
    private Vector<Task> tasks;
    private Report report;
    private Team team;

    public Project(int id, String title, String desc, Report report, Team team) {
        this.projectID = id;
        this.title = title;
        this.description = desc;
        this.tasks = new Vector<>();
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public Vector<Task> getTasks() {
        return tasks;
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
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Project ID: " + projectID);
        System.out.println("║ Title: " + title);
        System.out.println("║ Description: " + description + "\n");
        System.out.println("║ Tasks:");
        for (Task task : tasks) {
            System.out.println("║   Task No: " + task.getTaskID() + " Task Name: " + task.getTaskName() + " Status: "
                    + task.getStatus());
            if (task.getDeadline() != null) {
                System.out.println("║   Deadline: " + task.getDeadline().getDueDate() + "\n");
            }
        }
        if (report != null) {
            System.out.println("║ Report ID: " + report.getReportID());
            System.out.println("║ Content: " + report.getContent());
            List<Review> reviews = report.getReviews();
            if (!reviews.isEmpty()) {
                System.out.println("\n║ Reviews:");
                for (Review review : reviews) {
                    System.out.println("║   " + review);
                }
            } else {
                System.out.println("║ No reviews yet.");
            }
        }
        if (team != null) {
            System.out.println("\n║ Team: " + team.getTeamName());
            for (Student member : team.getMembers()) {
                System.out.printf("║   Member Name: %-9sEmail: %20s\n" ,member.getName(), member.getEmail());
            }
        }
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
    }
}

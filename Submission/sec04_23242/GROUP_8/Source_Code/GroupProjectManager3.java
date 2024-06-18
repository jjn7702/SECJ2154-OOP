import java.util.*;

public class GroupProjectManager3 {
    public static void main(String[] args) {
        System.out.println("\tWELCOME TO GROUP MANAGEMENT SYSTEM");

        try {
            Student std1 = new Student("A22EC0178", "Kugen", "kugen@graduate.utm.my");
            Student std2 = new Student("A22EC0123", "Idham", "idham@graduate.utm.my");
            Student std3 = new Student("A22EC0234", "Firzanah", "nana@graduate.utm.my");
            Student std4 = new Student("A22EC0456", "Habiel", "habiel@graduate.utm.my");
            Student std5 = new Student("A22EC0678", "Ben", "ben@graduate.utm.my");

            std1.display();
            System.out.println();

            Instructor inst1 = new Instructor("Ms.Lizawati", "msliza@utm.my", "A12345");
            inst1.display();
            System.out.println();

            Task task1 = new Task(1, "Design Phase", "Completed");
            Task task2 = new Task(2, "Development Phase", "In Progress");
            Deadline deadline = new Deadline("2023-12-31");
            task2.setDeadline(deadline);

            Report report = new Report("R101", "Initial Project Report", null); // Pass project as null initially

            Team team = new Team("Development Team");
            team.addMember(std1);
            team.addMember(std2);
            team.addMember(std3);
            team.addMember(std4);
            team.addMember(std5);

            

            Project project = new Project(101, "New Website", "Development of a new company website", report, team);
            project.addTask(task1);
            project.addTask(task2);

            // Adding reviews to the report
            Review review1 = new Review("UTM", "Great job!");
            Review review2 = new Review("UKM", "Needs more details.");
            report.addReview(review1);
            report.addReview(review2);

            project.printProjectDetails();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

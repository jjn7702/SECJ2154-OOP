import java.util.Scanner;

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

            Scanner inp = new Scanner(System.in);

            int choice;
            System.out.println("List of Actions\n");
            System.out.println("1)View Project\n2)Add Project\n3)Edit Project\n4)Delete Project\n");
            System.out.print("Select your choice : ");
            choice = inp.nextInt();

            switch (choice) {
                case 1: 

                    break;
                
                case 2: 
                
                System.out.print("Enter project ID: ");
                int projectId = inp.nextInt();
                inp.nextLine(); // Consume newline

                System.out.print("Enter project title: ");
                String projectTitle = inp.nextLine();

                System.out.print("Enter project description: ");
                String projectDescription = inp.nextLine();

                System.out.print("Enter report ID: ");
                String reportId = inp.nextLine();

                System.out.print("Enter report content: ");
                String reportContent = inp.nextLine();

                Report newReport = new Report(reportId, reportContent, null); // Project will be set later

                System.out.print("Enter team name: ");
                String teamName = inp.nextLine();
                Team newTeam = new Team(teamName);

                System.out.print("Enter number of team members: ");
                int numMembers = inp.nextInt();
                inp.nextLine(); // Consume newline

                for (int i = 0; i < numMembers; i++) {
                    System.out.print("Enter student ID: ");
                    String studentId = inp.nextLine();

                    System.out.print("Enter student name: ");
                    String studentName = inp.nextLine();

                    System.out.print("Enter student email: ");
                    String studentEmail = inp.nextLine();

                    Student student = new Student(studentId, studentName, studentEmail);
                    newTeam.addMember(student);
                }

                Project newProject = new Project(projectId, projectTitle, projectDescription, newReport, newTeam);
                //newReport.setProject(newProject); // Set the project in the report

                System.out.print("Enter number of tasks: ");
                int numTasks = inp.nextInt();
                inp.nextLine(); // Consume newline

                for (int i = 0; i < numTasks; i++) {
                    System.out.print("Enter task ID: ");
                    int taskId = inp.nextInt();
                    inp.nextLine(); // Consume newline

                    System.out.print("Enter task name: ");
                    String taskName = inp.nextLine();

                    System.out.print("Enter task status: ");
                    String taskStatus = inp.nextLine();

                    Task task = new Task(taskId, taskName, taskStatus);

                    System.out.print("Enter task deadline (yyyy-mm-dd) or leave blank if none: ");
                    String taskDeadline = inp.nextLine();
                    if (!taskDeadline.isEmpty()) {
                        task.setDeadline(new Deadline(taskDeadline));
                    }

                    newProject.addTask(task);
                }

                System.out.print("Enter number of reviews: ");
                int numReviews = inp.nextInt();
                inp.nextLine(); // Consume newline

                for (int i = 0; i < numReviews; i++) {
                    System.out.print("Enter review author: ");
                    String reviewAuthor = inp.nextLine();

                    System.out.print("Enter review content: ");
                    String reviewContentDetail = inp.nextLine();

                    Review review = new Review(reviewAuthor, reviewContentDetail);
                    newReport.addReview(review);
                }

                System.out.print("Enter number of milestones: ");
                int numMilestones = inp.nextInt();
                inp.nextLine(); // Consume newline

                for (int i = 0; i < numMilestones; i++) {
                    System.out.print("Enter milestone ID: ");
                    int milestoneId = inp.nextInt();
                    inp.nextLine(); // Consume newline

                    System.out.print("Enter milestone description: ");
                    String milestoneDescription = inp.nextLine();

                    System.out.print("Enter milestone due date (yyyy-mm-dd): ");
                    String milestoneDueDate = inp.nextLine();

                    // Milestone milestone = new Milestone(milestoneId, milestoneDescription, milestoneDueDate);
                    // newProject.addMilestone(milestone);
                }

                System.out.println("New project added successfully!");
                newProject.printProjectDetails();
                break;


                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

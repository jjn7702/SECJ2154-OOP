import java.util.Scanner; 
import java.util.Vector;

public class GroupProjectManager3 { public static void main(String[] args) {
 System.out.println("\tWELCOME TO GROUP MANAGEMENT SYSTEM");

    Vector<Project> projects = new Vector<>(); // Vector to hold projects

    try {
        Student std1 = new Student("A22EC0178", "Kugen", "kugen@graduate.utm.my");
        Student std2 = new Student("A22EC0123", "Idham", "idham@graduate.utm.my");
        Student std3 = new Student("A22EC0234", "Firzanah", "nana@graduate.utm.my");
        Student std4 = new Student("A22EC0456", "Habiel", "habiel@graduate.utm.my");
        Student std5 = new Student("A22EC0678", "Ben", "ben@graduate.utm.my");

        Instructor inst1 = new Instructor("Ms.Lizawati", "msliza@utm.my", "A12345");

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


            // Creating projects
            Project project = new Project(101, "New Website", "Development of a new company website", report, team);
            Project project2 = new Project(102, "Old Website", "Development of an old company website", report, team);
            Project project3 = new Project(101, "New Website", "Development of a new company website", report, team);




        project.addTask(task1);
        project.addTask(task2);

        projects.add(project);
        projects.add(project2);

        // Adding reviews to the report
        Review review1 = new Review("UTM", "Great job!");
        Review review2 = new Review("UKM", "Needs more details.");
        report.addReview(review1);
        report.addReview(review2);

        Scanner inp = new Scanner(System.in);

<<<<<<< Updated upstream
        int choice;
        System.out.println("List of Actions\n");
        System.out.println("1) View Project List\n2) Add Project\n");
        System.out.print("Select your choice : ");
        choice = inp.nextInt();
=======
            switch (choice) {
                case 1:
                    for(Project p: project) {
                        p.getName();
                    } 
>>>>>>> Stashed changes

        switch (choice) {
            case 1:
            if (projects.size() > 0) {
                for (Project proj : projects) {
                    System.out.println("Project Title: " + proj.getTitle());
                    System.out.println("Project ID: " + proj.getProjectID());
                    System.out.println("--------------------");
                }
        
                System.out.print("Select a project to view details (enter Project ID): ");
                int selectedProjectId = inp.nextInt();
                inp.nextLine(); // Consume newline
        
                boolean projectFound = false;
                for (Project proj : projects) {
                    if (proj.getProjectID() == selectedProjectId) {
                        projectFound = true;
                        System.out.println("\nProject Details:");
                        proj.printProjectDetails(); // Assuming printProjectDetails method exists
                        System.out.println("--------------------");
                        
                        // Nested switch for further actions on selected project
                        int nestedChoice;
                        System.out.println("1) Edit Project\n2) Delete Project\n3) Back to Main Menu\n");
                        System.out.print("Select your choice to manageproject: ");
                        nestedChoice = inp.nextInt();
        
                        switch (nestedChoice) {
                            case 1:
                                System.out.println("Editing project with ID " + selectedProjectId);
                                System.out.print("Enter new project title: ");
                                String newTitle = inp.nextLine();
                                System.out.print("Enter new project description: ");
                                String newDescription = inp.nextLine();
                                
                                // Assuming setter methods exist in Project class
                               // proj.setTitle(newTitle);
                               // proj.setDescription(newDescription);
                                
                                System.out.println("Project updated successfully:");
                                proj.printProjectDetails(); // Print updated details
                                break;
                        
                            case 2:
                            int nestedChoice2;
                            while (true) {
                                System.out.println("\n1) Delete Whole Project\n2) Delete Task\n3) Delete Member\n4) Back to Main Menu");
                                System.out.print("\nWhich one would you like to delete? : ");
                                nestedChoice2 = inp.nextInt();
                                // Remove project from projects list or mark as deleted
                                switch (nestedChoice2) {
                                    case 1:
                                        projects.remove(proj);
                                        System.out.println("Project deleted successfully.");
                                        break;
                                    
                                    case 2:
                                        task1.removeTask(task1);
                                        task2.removeTask(task2);
                                        System.out.println("Tasks deleted successfully.");
                                        break;

                                    case 3:
                                        team.removeMember(std1);
                                        team.removeMember(std2);
                                        team.removeMember(std3);
                                        team.removeMember(std4);
                                        team.removeMember(std5);
                                        System.out.println("Member deleted successfully.");
                                        break;
                                    
                                    case 4:
                                        System.out.println("Returning to main menu.");
                                        choice = 0; // Set choice to 0 to go back to the main menu
                                        break;
                                        default:
                                        System.out.println("Invalid option. Please try again.");
                                        break;
                                }
                        
                                if (nestedChoice2 == 4) {
                                    break; // Exit the loop if the user chooses to go back to the main menu
                                }
                            }
                            break; 
        
                            case 3:
                                System.out.println("Returning to main menu.");
                                break;
                        
                            default:
                                System.out.println("Invalid choice for selected project.");
                                break;
                        }
                        break; // Exit loop once project is found
                    }
                }
        
                if (!projectFound) {
                    System.out.println("Project with ID " + selectedProjectId + " not found.");
                }
            } else {
                System.out.println("No projects available.");
            }
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
                projects.add(newProject);

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
                System.out.println("INVALID CHOICE !");
                break;
        }

    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
}
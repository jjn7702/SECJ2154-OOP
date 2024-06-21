import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GroupProjectManager {
    private static List<Project> projects = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\tWELCOME TO GROUP MANAGEMENT SYSTEM");
        
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║       Group Project Management System       ║");
        System.out.println("╚═════════════════════════════════════════════╝");

        addDummyData();

        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n\n╔════════════════════════════════════╗");
            System.out.printf("║     %5s%s%-8s   ║\n", "", "List Of Actions", "");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║  1) View Project Details           ║");
            System.out.println("║  2) Add New Project                ║");
            System.out.println("║  3) Edit Project                   ║");
            System.out.println("║  4) Delete Project                 ║");
            System.out.println("║  5) Exit                           ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.println("Select your choice: ");
            int choice = inp.nextInt();
            inp.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProjectList(inp);
                    break;
                case 2:
                    addNewProject(inp);
                    break;
                case 3:
                    editProject(inp);
                    break;
                case 4:
                    deleteProject(inp);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void viewProjectList(Scanner inp) {
        System.out.println();

        if (projects.isEmpty()) {
            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║       No projects available.       ║");
            System.out.println("╚════════════════════════════════════╝");
            return;
        }

        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║    %7s%s%-8s    ║\n", "", "Project Lists", "");
        System.out.println("╠════════════════════════════════════╣");
        
        for (int i = 0; i < projects.size(); i++) {
            System.out.printf("║  %d) %-30s ║\n", i + 1, projects.get(i).getTitle());
        }
        System.out.println("╚════════════════════════════════════╝");

        System.out.println("Select a project to view details (enter number): ");
        int projectIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            projects.get(projectIndex).printProjectDetails();
        } else {
            System.out.println("Invalid project selection.");
        }
    }

    //ADD FUNCTION FIXED
    private static void addNewProject(Scanner inp) {
        //Project Info
        System.out.println("\n╔═════════════════════════╗");
        System.out.println("║     Add New Project     ║");
        System.out.println("╚═════════════════════════╝");

        System.out.println("Enter project ID: ");
        String projectId = inp.nextLine();

        System.out.println("\nEnter project name: ");
        String projectName = inp.nextLine();

        System.out.println("\nEnter project description: ");
        String projectDescription = inp.nextLine();

        //Instructor Info
        System.out.println("\nEnter instructor name: ");
        String instructorName = inp.nextLine();

        System.out.println("\nEnter instructor email: ");
        String instructorEmail = inp.nextLine();

        System.out.println("\nEnter instructor employee number: ");
        String instructorNumber = inp.nextLine();

        Instructor instructor = new Instructor(instructorName, instructorEmail, instructorNumber);

        System.out.println("\n\n╔══════════════════════════╗");
        System.out.println("║     Team Information     ║");
        System.out.println("╚══════════════════════════╝");

        //Team Info
        System.out.println("Enter team name: ");
        String teamName = inp.nextLine();
        
        Team team = new Team(teamName);

        //Project data insert
        Report report = null; // Placeholder, could be added with more details
        Project project = new Project(projectId, projectName, projectDescription, report, team, instructor);

        System.out.println("\nEnter number of team members: ");
        int numMembers = inp.nextInt();
        inp.nextLine(); // Consume newline

        for (int i = 0; i < numMembers; i++) {

            System.out.println("\n╔═════════════════════════╗");
            System.out.printf("║        Member #%-1d        ║", (i + 1));
            System.out.println("\n╚═════════════════════════╝");

            System.out.println("Enter student name: ");
            String studentName = inp.nextLine();

            System.out.println("\nEnter student matric number: ");
            String matricNumber = inp.nextLine();

            System.out.println("\nEnter student email: ");
            String studentEmail = inp.nextLine();

            System.out.println("\nEnter student role: ");
            String studentRole = inp.nextLine();

            Student student = new Student(matricNumber, studentName, studentEmail, studentRole);
            team.addMember(student);
        }

        System.out.println("\n╔═══════════════════════════╗");
        System.out.println("║   Milestone Information   ║");
        System.out.println("╚═══════════════════════════╝");

        //Milestone Info
        System.out.println("Enter number of milestones: ");
        int numMilestones = inp.nextInt();
        inp.nextLine(); // Consume newline

        //Declaration to use addMilestone() method
        // Project project = new Project();

        for (int i = 0; i < numMilestones; i++) {
            
            System.out.println("\n╔════════════════════════╗");
            System.out.printf("║      Milestone #%-1d      ║", (i + 1));
            System.out.println("\n╚════════════════════════╝");

            System.out.println("Enter milestone ID: ");
            String milestoneID = inp.nextLine();

            System.out.println("\nEnter milestone name: ");
            String milestoneName = inp.nextLine();

            System.out.println("\nEnter milestone description: ");
            String milestoneDescription = inp.nextLine();

            System.out.println("\nEnter milestone deadline: ");
            String milestoneDeadline = inp.nextLine();

            Deadline deadlineMilestone = new Deadline(milestoneDeadline);
            Milestone milestone = new Milestone(milestoneID, milestoneName, milestoneDescription, deadlineMilestone);

            System.out.println("\nEnter number of tasks: ");
            int numTasks = inp.nextInt();
            inp.nextLine(); // Consume newline

            for (int j = 0; j < numTasks; j++) {
                System.out.println("\n╔════════════════════════╗");
                System.out.printf("║        Task #%-1d         ║", (j + 1));
                System.out.println("\n╚════════════════════════╝");

                System.out.println("Enter task name: ");
                String taskName = inp.nextLine();

                System.out.println("\nEnter milestone deadline: ");
                String taskDeadline = inp.nextLine();

                Deadline deadlineTask = new Deadline(taskDeadline);
                Task task = new Task(taskName, deadlineTask);
                milestone.addTask(task);
            }

            project.addMilestone(milestone);
        }

        projects.add(project);

        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║  Project added successfully!  ║");
        System.out.println("╚═══════════════════════════════╝");
    }

    private static void editProject(Scanner inp) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║             Edit Project            ║");
        System.out.println("╚═════════════════════════════════════╝");
    
        // Project List
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║            Project List            ║");
        System.out.println("╠════════════════════════════════════╣");
    
        for (int i = 0; i < projects.size(); i++) {
            System.out.printf("║  %d) %-30s ║\n", i + 1, projects.get(i).getTitle());
        }
        System.out.println("╚════════════════════════════════════╝");
    
        System.out.print("Enter the number of the project to edit: ");
        int projectIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (projectIndex >= 0 && projectIndex < projects.size()) {
            Project project = projects.get(projectIndex);
    
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║    %-50s    ║\n", "Editing Project: " + project.getTitle());
            System.out.println("╚══════════════════════════════════════════════════════════╝");
    
            boolean keepEditing = true;
    
            while (keepEditing) {
                System.out.println("Select the section to edit:");
                System.out.println("1. Project ID");
                System.out.println("2. Project Name");
                System.out.println("3. Project Description");
                System.out.println("4. Instructor Info");
                System.out.println("5. Team Info");
                System.out.println("6. Milestones");
                System.out.println("7. Report");
                System.out.println("0. Finish Editing");
    
                System.out.print("Enter your choice: ");
                int choice = inp.nextInt();
                inp.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        System.out.println("Current project ID: " + project.getProjectID());
                        System.out.print("Enter new project ID (or press Enter to keep the current name): ");
                        String projectID = inp.nextLine();
                        if (!projectID.isEmpty()) {
                            project.setProjectID(projectID);                   
                            
                            System.out.println("╔═══════════════════════════════════════════╗");
                            System.out.println("║      Project ID edited successfully!      ║");
                            System.out.println("╚═══════════════════════════════════════════╝");    
                        }
                        break;

                    case 2:
                        System.out.println("Current project name: " + project.getTitle());
                        System.out.print("Enter new project name (or press Enter to keep the current name): ");
                        String projectName = inp.nextLine();
                        if (!projectName.isEmpty()) {
                            project.setTitle(projectName);
                            
                            System.out.println("╔════════════════════════════════════════════╗");
                            System.out.println("║      Project name edited successfully!     ║");
                            System.out.println("╚════════════════════════════════════════════╝");
                        }
                        break;
    
                    case 3:
                        System.out.println("Current project description: " + project.getDescription());
                        System.out.print("Enter new project description (or press Enter to keep the current description): ");
                        String projectDescription = inp.nextLine();
                        if (!projectDescription.isEmpty()) {
                            project.setDescription(projectDescription);

                            System.out.println("╔════════════════════════════════════════════╗");
                            System.out.println("║  Project description edited successfully!  ║");
                            System.out.println("╚════════════════════════════════════════════╝");
                        }
                        break;
    
                    case 4:
                        editInstructorInfo(inp, project.getInstructor());
                        break;
    
                    case 5:
                        editTeamInfo(inp, project.getTeam());
                        break;
    
                    case 6:
                        editMilestones(inp, project);
                        break;
    
                    case 7:
                        editReport(inp, project);
                        break;
    
                    case 0:
                        keepEditing = false;
                        break;
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }
    
    private static void editInstructorInfo(Scanner inp, Instructor instructor) {
        System.out.println("Current instructor name: " + instructor.getName());
        System.out.print("Enter new instructor name (or press Enter to keep the current name): ");
        String instructorName = inp.nextLine();
        if (!instructorName.isEmpty()) {
            instructor.setName(instructorName);
        }
    
        System.out.println("Current instructor email: " + instructor.getEmail());
        System.out.print("Enter new instructor email (or press Enter to keep the current email): ");
        String instructorEmail = inp.nextLine();
        if (!instructorEmail.isEmpty()) {
            instructor.setEmail(instructorEmail);
        }
    
        System.out.println("Current instructor employee number: " + instructor.getEmpNum());
        System.out.print("Enter new instructor employee number (or press Enter to keep the current number): ");
        String instructorNumber = inp.nextLine();
        if (!instructorNumber.isEmpty()) {
            instructor.setEmpNum(instructorNumber);
        }
    }
    
    private static void editTeamInfo(Scanner inp, Team team) {
        System.out.println("Current team name: " + team.getTeamName());
        System.out.print("Enter new team name (or press Enter to keep the current name): ");
        String teamName = inp.nextLine();
        if (!teamName.isEmpty()) {
            team.setTeamName(teamName);
        }
    
        // Display team members and edit specific member
        System.out.println("Team members:");
        for (int i = 0; i < team.getMembers().size(); i++) {
            Student student = team.getMembers().get(i);
            System.out.printf("%d. %s (Matric Number: %s)\n", i + 1, student.getName(), student.getMatricsNum());
        }
        System.out.print("Enter the number of the team member to edit (or 0 to skip): ");
        int memberIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (memberIndex >= 0 && memberIndex < team.getMembers().size()) {
            Student student = team.getMembers().get(memberIndex);
    
            System.out.println("Editing student: " + student.getName());
    
            System.out.print("Enter new student name (or press Enter to keep the current name): ");
            String studentName = inp.nextLine();
            if (!studentName.isEmpty()) {
                student.setName(studentName);
            }
    
            System.out.print("Enter new student email (or press Enter to keep the current email): ");
            String studentEmail = inp.nextLine();
            if (!studentEmail.isEmpty()) {
                student.setEmail(studentEmail);
            }
    
            System.out.print("Enter new student role (or press Enter to keep the current role): ");
            String studentRole = inp.nextLine();
            if (!studentRole.isEmpty()) {
                student.setRole(studentRole);
            }
        }
    }
    
    private static void editMilestones(Scanner inp, Project project) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║                Milestones                ║");
        System.out.println("╚══════════════════════════════════════════╝");
    
        for (int i = 0; i < project.getMilestone().size(); i++) {
            Milestone milestone = project.getMilestone().get(i);
            System.out.printf("%d. %s (ID: %s)\n", i + 1, milestone.getMilestoneName(), milestone.getMilestoneID());
        }
    
        System.out.print("Enter the number of the milestone to edit (or 0 to skip): ");
        int milestoneIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (milestoneIndex >= 0 && milestoneIndex < project.getMilestone().size()) {
            Milestone milestone = project.getMilestone().get(milestoneIndex);
    
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║          Editing Milestone               ║");
            System.out.println("╚══════════════════════════════════════════╝");
            
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║ Current milestone name: " + milestone.getMilestoneName() + " ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Enter new milestone name (or press Enter to keep the current name): ");
            String milestoneName = inp.nextLine();
            if (!milestoneName.isEmpty()) {
                milestone.setMilestoneName(milestoneName);
    
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║   Milestone name edited successfully!    ║");
                System.out.println("╚══════════════════════════════════════════╝");
            }
    
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║ Current milestone description: " + milestone.getMilestoneDescription() + " ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Enter new milestone description (or press Enter to keep the current description): ");
            String milestoneDescription = inp.nextLine();
            if (!milestoneDescription.isEmpty()) {
                milestone.setMilestoneDescription(milestoneDescription);
    
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║ Milestone description edited successfully ║");
                System.out.println("╚══════════════════════════════════════════╝");
            }
    
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║ Current milestone deadline: " + milestone.getDeadline().getDueDate() + " ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print("Enter new milestone deadline (or press Enter to keep the current deadline): ");
            String milestoneDeadline = inp.nextLine();
            if (!milestoneDeadline.isEmpty()) {
                Deadline deadline = new Deadline(milestoneDeadline);
                milestone.setDeadline(deadline);
    
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║ Milestone deadline edited successfully!  ║");
                System.out.println("╚══════════════════════════════════════════╝");
            }
    
            // Edit tasks within the selected milestone
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║                Tasks                     ║");
            System.out.println("╚══════════════════════════════════════════╝");
    
            for (int j = 0; j < milestone.getTask().size(); j++) {
                Task task = milestone.getTask().get(j);
                System.out.printf("%d. %s (Deadline: %s)\n", j + 1, task.getName(), task.getDeadline().getDueDate());
            }
            System.out.print("Enter the number of the task to edit (or 0 to skip): ");
            int taskIndex = inp.nextInt() - 1;
            inp.nextLine(); // Consume newline
    
            if (taskIndex >= 0 && taskIndex < milestone.getTask().size()) {
                Task task = milestone.getTask().get(taskIndex);
    
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.println("║              Editing Task                ║");
                System.out.println("╚══════════════════════════════════════════╝");
    
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.printf("║ Current task name: %-35s║", task.getName());
                System.out.println("╚══════════════════════════════════════════╝");
                System.out.print("Enter new task name (or press Enter to keep the current name): ");
                String newTaskName = inp.nextLine();
                if (!newTaskName.isEmpty()) {
                    task.setName(newTaskName);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║    Task name edited successfully!        ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
    
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.println("║ Current task deadline: " + task.getDeadline().getDueDate() + " ║");
                System.out.println("╚══════════════════════════════════════════╝");
                System.out.print("Enter new task deadline (or press Enter to keep the current deadline): ");
                String taskDeadline = inp.nextLine();
                if (!taskDeadline.isEmpty()) {
                    Deadline deadline = new Deadline(taskDeadline);
                    task.setDeadline(deadline);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║    Task deadline edited successfully!    ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
    
                System.out.print("Edit task status (1 - Completed, 2 - In Progress, Enter - Skip): ");
                String statusChoice = inp.nextLine();
                if (!statusChoice.isEmpty()) {
                    task.setStatus(statusChoice);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║    Task status edited successfully!      ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
            }
        }
    }

    
    private static void editReport(Scanner inp, Project project) {
        if (project.getReport() == null) {
            System.out.print("This project doesn't have a report. Would you like to add one? (yes/no): ");
            String addReportResponse = inp.nextLine();
            if (addReportResponse.equalsIgnoreCase("yes")) {
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.println("║                Add Report                ║");
                System.out.println("╚══════════════════════════════════════════╝");
    
                System.out.print("Enter report ID: ");
                String reportID = inp.nextLine();
                System.out.print("Enter report title: ");
                String reportTitle = inp.nextLine();
                System.out.print("Enter report content: ");
                String reportContent = inp.nextLine();
                System.out.print("Enter report submission date: ");
                String reportSubmissionDate = inp.nextLine();
    
                Report report = new Report(reportID, reportTitle, reportContent, reportSubmissionDate);
                project.setReport(report);
    
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║        Report added successfully!        ║");
                System.out.println("╚══════════════════════════════════════════╝");
    
                // Add review to the newly added report
                System.out.print("Would you like to add a review to this report? (yes/no): ");
                String addReviewResponse = inp.nextLine();
    
                if (addReviewResponse.equalsIgnoreCase("yes")) {
                    System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.println("║                Add Review                ║");
                    System.out.println("╚══════════════════════════════════════════╝");
    
                    System.out.print("Enter review ID: ");
                    String reviewID = inp.nextLine();
    
                    System.out.print("Enter review comments: ");
                    String reviewComments = inp.nextLine();
                    
                    System.out.print("Enter review rating (1-5): ");
                    int reviewRating = inp.nextInt();
                    inp.nextLine(); // Consume newline
    
                    Review review = new Review(reviewID, reviewComments, reviewRating);
                    report.setReview(review);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║        Review added successfully!        ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
            }
        } else {
            Report report = project.getReport();
    
            System.out.println("Edit Report:");
            System.out.println("Current report ID: " + report.getReportID());
            System.out.println("Current report title: " + report.getTitle());
            System.out.print("Enter new report title (or press Enter to keep the current title): ");
            String reportTitle = inp.nextLine();
            if (!reportTitle.isEmpty()) {
                report.setTitle(reportTitle);
    
                System.out.println("╔═══════════════════════════════════════════╗");
                System.out.println("║     Report title edited successfully!     ║");
                System.out.println("╚═══════════════════════════════════════════╝");
            }
    
            System.out.println("Current report content: " + report.getContent());
            System.out.print("Enter new report content (or press Enter to keep the current content): ");
            String reportContent = inp.nextLine();
            if (!reportContent.isEmpty()) {
                report.setContent(reportContent);
    
                System.out.println("╔═══════════════════════════════════════════╗");
                System.out.println("║    Report content edited successfully!    ║");
                System.out.println("╚═══════════════════════════════════════════╝");
            }

            // Add or edit review within the report
            if (report.getReview() == null) {
                System.out.print("This report doesn't have a review. Would you like to add one? (Yes/No): ");
                String addReviewResponse = inp.nextLine();
                if (addReviewResponse.equalsIgnoreCase("yes")) {
                    System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.println("║                Add Review                ║");
                    System.out.println("╚══════════════════════════════════════════╝");
    
                    System.out.print("Enter review ID: ");
                    String reviewID = inp.nextLine();
    
                    System.out.print("Enter review comments: ");
                    String reviewComments = inp.nextLine();
    
                    System.out.print("Enter review rating (1-5): ");
                    int reviewRating = inp.nextInt();
                    inp.nextLine(); // Consume newline
    
                    Review review = new Review(reviewID, reviewComments, reviewRating);
                    report.setReview(review);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║        Review added successfully!        ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
            } else {
                Review review = report.getReview();
    
                System.out.println("Edit Review:");
                System.out.println("Current review ID: " + review.getReviewID());
                System.out.print("Enter new review ID (or press Enter to keep the current ID): ");
                String reviewID = inp.nextLine();
                if (!reviewID.isEmpty()) {
                    review.setReviewID(reviewID);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║      Review ID edited successfully!      ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
    
                System.out.println("Current review comments: " + review.getComments());
                System.out.print("Enter new review comments (or press Enter to keep the current comments): ");
                String reviewComments = inp.nextLine();
                if (!reviewComments.isEmpty()) {
                    review.setComment(reviewComments);
    
                    System.out.println("╔═══════════════════════════════════════════╗");
                    System.out.println("║    Review comment edited successfully!    ║");
                    System.out.println("╚═══════════════════════════════════════════╝");
                }
    
                System.out.println("Current review rating: " + review.getRating());
                System.out.print("Enter new review rating (1-5) (or press Enter to keep the current rating): ");
                String reviewRatingInput = inp.nextLine();
                if (!reviewRatingInput.isEmpty()) {
                    int reviewRating = Integer.parseInt(reviewRatingInput);
                    review.setRating(reviewRating);
    
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║    Review rating edited successfully!    ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                }
            }
        }
    }

    private static void deleteProject(Scanner inp) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║             Delete Project          ║");
        System.out.println("╚═════════════════════════════════════╝");
    
        // Project List
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║            Project List            ║");
        System.out.println("╠════════════════════════════════════╣");
    
        for (int i = 0; i < projects.size(); i++) {
            System.out.printf("║  %d) %-30s ║\n", i + 1, projects.get(i).getTitle());
        }
        System.out.println("╚════════════════════════════════════╝");
    
        System.out.print("Enter the number of the project to delete: ");
        int projectIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (projectIndex >= 0 && projectIndex < projects.size()) {
            Project project = projects.get(projectIndex);
    
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║    %-50s    ║\n", "Deleting Project: " + project.getTitle());
            System.out.println("╚══════════════════════════════════════════════════════════╝");
    
            System.out.println("Select the item to delete:");
            System.out.println("1. Delete Milestone");
            System.out.println("2. Delete Task");
            System.out.println("3. Delete Team Member");
            System.out.println("4. Delete the whole project");
            System.out.println("0. Cancel");
    
            System.out.print("Enter your choice: ");
            int choice = inp.nextInt();
            inp.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    deleteMilestone(inp, project);
                    break;
                case 2:
                    deleteTask(inp, project);
                    break;
                case 3:
                    deleteTeamMember(inp, project.getTeam());
                    break;
                case 4:
                    projects.remove(projectIndex);
                    System.out.println("╔══════════════════════════════════════════╗");
                    System.out.println("║        Project deleted successfully!     ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("Deletion canceled.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }
    
    private static void deleteMilestone(Scanner inp, Project project) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║                Milestones                ║");
        System.out.println("╚══════════════════════════════════════════╝");
    
        for (int i = 0; i < project.getMilestone().size(); i++) {
            Milestone milestone = project.getMilestone().get(i);
            System.out.printf("%d. %s (ID: %s)\n", i + 1, milestone.getMilestoneName(), milestone.getMilestoneID());
        }
    
        System.out.print("Enter the number of the milestone to delete (or 0 to cancel): ");
        int milestoneIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (milestoneIndex >= 0 && milestoneIndex < project.getMilestone().size()) {
            project.getMilestone().remove(milestoneIndex);
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║       Milestone deleted successfully!    ║");
            System.out.println("╚══════════════════════════════════════════╝");
        } else {
            System.out.println("Invalid milestone number.");
        }
    }
    
    private static void deleteTask(Scanner inp, Project project) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          Select Milestone                ║");
        System.out.println("╚══════════════════════════════════════════╝");
    
        for (int i = 0; i < project.getMilestone().size(); i++) {
            Milestone milestone = project.getMilestone().get(i);
            System.out.printf("%d. %s (ID: %s)\n", i + 1, milestone.getMilestoneName(), milestone.getMilestoneID());
        }
    
        System.out.print("Enter the number of the milestone containing the task to delete (or 0 to cancel): ");
        int milestoneIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (milestoneIndex >= 0 && milestoneIndex < project.getMilestone().size()) {
            Milestone milestone = project.getMilestone().get(milestoneIndex);
    
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║                Tasks                     ║");
            System.out.println("╚══════════════════════════════════════════╝");
    
            for (int j = 0; j < milestone.getTask().size(); j++) {
                Task task = milestone.getTask().get(j);
                System.out.printf("%d. %s (Deadline: %s)\n", j + 1, task.getName(), task.getDeadline().getDueDate());
            }
    
            System.out.print("Enter the number of the task to delete (or 0 to cancel): ");
            int taskIndex = inp.nextInt() - 1;
            inp.nextLine(); // Consume newline
    
            if (taskIndex >= 0 && taskIndex < milestone.getTask().size()) {
                milestone.getTask().remove(taskIndex);
                System.out.println("╔══════════════════════════════════════════╗");
                System.out.println("║          Task deleted successfully!      ║");
                System.out.println("╚══════════════════════════════════════════╝");
            } else {
                System.out.println("Invalid task number.");
            }
        } else {
            System.out.println("Invalid milestone number.");
        }
    }
    
    private static void deleteTeamMember(Scanner inp, Team team) {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║             Team Members                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
    
        for (int i = 0; i < team.getMembers().size(); i++) {
            Student student = team.getMembers().get(i);
            System.out.printf("%d. %s (Matric Number: %s)\n", i + 1, student.getName(), student.getMatricsNum());
        }
    
        System.out.print("Enter the number of the team member to delete (or 0 to cancel): ");
        int memberIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (memberIndex >= 0 && memberIndex < team.getMembers().size()) {
            team.getMembers().remove(memberIndex);
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║      Team member deleted successfully!   ║");
            System.out.println("╚══════════════════════════════════════════╝");
        } else {
            System.out.println("Invalid team member number.");
        }
    }
    

    //DUMMY DATA
    private static void addDummyData() {
        Instructor instr1 = new Instructor("Lizawati", "lizawati@instructor.utm.my", "CS8493");
        Team team1 = new Team("Team Alpha");
        Report report1 = null; // Placeholder, modify as per the actual constructor of Report class
        Project project1 = new Project("P001", "Project Management System", "A system to manage projects efficiently.", report1, team1, instr1);

        // Adding 4 team members
        team1.addMember(new Student("A12345", "John Doe", "john.doe@student.utm.my", "Team Leader"));
        team1.addMember(new Student("A12346", "Jane Smith", "jane.smith@student.utm.my", "Developer"));
        team1.addMember(new Student("A12347", "Emily Johnson", "emily.johnson@student.utm.my", "Tester"));
        team1.addMember(new Student("A12348", "Michael Brown", "michael.brown@student.utm.my", "Designer"));

        // Adding milestones and tasks for project1
        Deadline deadline1 = new Deadline("15/07/2024");
        Milestone milestone1 = new Milestone("M001", "Planning Phase", "Define project scope, Identify stakeholders, Develop project plan, Set milestones", deadline1);
        
        Deadline deadline11 = new Deadline("05/07/2024");
        Deadline deadline12 = new Deadline("10/07/2024");
        Deadline deadline13 = new Deadline("13/07/2024");
        Deadline deadline14 = new Deadline("14/07/2024");
        
        milestone1.addTask(new Task("Define project scope", deadline11));
        milestone1.addTask(new Task("Identify stakeholders", deadline12));
        milestone1.addTask(new Task("Develop project plan", deadline13));
        milestone1.addTask(new Task("Set milestones", deadline14));

        Deadline deadline2 = new Deadline("01/09/2024");
        Milestone milestone2 = new Milestone("M002", "Development Phase", "Code module 1, Code module 2", deadline2);
       
        Deadline deadline21 = new Deadline("11/08/2024");
        Deadline deadline22 = new Deadline("17/08/2024");
       
        milestone2.addTask(new Task("Code module 1", deadline21));
        milestone2.addTask(new Task("Code module 2", deadline22));

        Deadline deadline3 = new Deadline("15/11/2024");
        Milestone milestone3 = new Milestone("M003", "Testing Phase", "Unit testing, Integration testing, User acceptance testing", deadline3);
        
        Deadline deadline31 = new Deadline("4/11/2024");
        Deadline deadline32 = new Deadline("11/11/2024");
        Deadline deadline33 = new Deadline("13/11/2024");
        
        milestone3.addTask(new Task("Unit testing", deadline31));
        milestone3.addTask(new Task("Integration testing", deadline32));
        milestone3.addTask(new Task("User acceptance testing", deadline33));

        project1.addMilestone(milestone1);
        project1.addMilestone(milestone2);
        project1.addMilestone(milestone3);

        // Adding the first project to the list of projects
        projects.add(project1);

        // Creating second project directly in main
        // Second Project - Inventory Management System
        Instructor instr2 = new Instructor("Ahmad", "ahmad@instructor.utm.my", "CS8494");
        Team team2 = new Team("Team Bravo");
        Report report2 = null; // Placeholder, modify as per the actual constructor of Report class
        Project project2 = new Project("P002", "Inventory Management System", "A system to manage inventory efficiently.", report2, team2, instr2);

        // Adding 4 team members
        team2.addMember(new Student("A12349", "Alice White", "alice.white@student.utm.my", "Team Leader"));
        team2.addMember(new Student("A12350", "Bob Green", "bob.green@student.utm.my", "Developer"));
        team2.addMember(new Student("A12351", "Charlie Black", "charlie.black@student.utm.my", "Tester"));
        team2.addMember(new Student("A12352", "David Blue", "david.blue@student.utm.my", "Designer"));

        // Adding milestones and tasks for project2
        Deadline deadline4 = new Deadline("20/07/2024");
        Milestone milestone4 = new Milestone("M101", "Requirement Gathering", "Identify requirements, Conduct feasibility study", deadline4);
        
        Deadline deadline41 = new Deadline("01/07/2024");
        Deadline deadline42 = new Deadline("05/07/2024");
        Deadline deadline43 = new Deadline("12/07/2024");
        Deadline deadline44 = new Deadline("15/07/2024");
        
        milestone4.addTask(new Task("Identify requirements", deadline41));
        milestone4.addTask(new Task("Conduct feasibility study", deadline42));
        milestone4.addTask(new Task("Develop requirements document", deadline43));
        milestone4.addTask(new Task("Review requirements", deadline44));

        Deadline deadline5 = new Deadline("05/09/2024");
        Milestone milestone5 = new Milestone("M102", "System Design", "Design database schema, Create wireframes", deadline5);
        
        Deadline deadline51 = new Deadline("01/09/2024");
        Deadline deadline52 = new Deadline("04/09/2024");
        
        milestone5.addTask(new Task("Design database schema", deadline51));
        milestone5.addTask(new Task("Create wireframes", deadline52));

        Deadline deadline6 = new Deadline("20/11/2024");
        Milestone milestone6 = new Milestone("M103", "Implementation", "Develop frontend, Develop backend", deadline6);
        
        Deadline deadline61 = new Deadline("03/11/2024");
        Deadline deadline62 = new Deadline("05/11/2024");
        Deadline deadline63 = new Deadline("15/11/2024");
        
        milestone6.addTask(new Task("Develop frontend", deadline61));
        milestone6.addTask(new Task("Develop backend", deadline62));
        milestone6.addTask(new Task("Integrate systems", deadline63));

        project2.addMilestone(milestone4);
        project2.addMilestone(milestone5);
        project2.addMilestone(milestone6);

        // Adding the second project to the list of projects
        projects.add(project2);
    }
}    
                           
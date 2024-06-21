import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.Date;

public class GroupProjectManager {
    private static List<Project> projects = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\tWELCOME TO GROUP MANAGEMENT SYSTEM");

        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║       Group Project Management System       ║");
        System.out.println("╚═════════════════════════════════════════════╝");

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
        milestone1.addTask(new Task("Define project scope", deadline1));
        milestone1.addTask(new Task("Identify stakeholders", deadline1));
        milestone1.addTask(new Task("Develop project plan", deadline1));
        milestone1.addTask(new Task("Set milestones", deadline1));

        Deadline deadline2 = new Deadline("01/09/2024");
        Milestone milestone2 = new Milestone("M002", "Development Phase", "Code module 1, Code module 2", deadline2);
        milestone2.addTask(new Task("Code module 1", deadline2));
        milestone2.addTask(new Task("Code module 2", deadline2));

        Deadline deadline3 = new Deadline("15/11/2024");
        Milestone milestone3 = new Milestone("M003", "Testing Phase", "Unit testing, Integration testing, User acceptance testing", deadline3);
        milestone3.addTask(new Task("Unit testing", deadline3));
        milestone3.addTask(new Task("Integration testing", deadline3));
        milestone3.addTask(new Task("User acceptance testing", deadline3));

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
        milestone4.addTask(new Task("Identify requirements", deadline4));
        milestone4.addTask(new Task("Conduct feasibility study", deadline4));
        milestone4.addTask(new Task("Develop requirements document", deadline4));
        milestone4.addTask(new Task("Review requirements", deadline4));

        Deadline deadline5 = new Deadline("05/09/2024");
        Milestone milestone5 = new Milestone("M102", "System Design", "Design database schema, Create wireframes", deadline5);
        milestone5.addTask(new Task("Design database schema", deadline5));
        milestone5.addTask(new Task("Create wireframes", deadline5));

        Deadline deadline6 = new Deadline("20/11/2024");
        Milestone milestone6 = new Milestone("M103", "Implementation", "Develop frontend, Develop backend", deadline6);
        milestone6.addTask(new Task("Develop frontend", deadline6));
        milestone6.addTask(new Task("Develop backend", deadline6));
        milestone6.addTask(new Task("Integrate systems", deadline6));

        project2.addMilestone(milestone4);
        project2.addMilestone(milestone5);
        project2.addMilestone(milestone6);

        // Adding the second project to the list of projects
        projects.add(project2);

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
            System.out.printf("║        Member #%-1d     ║", (i + 1));
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
                System.out.printf("║      Task #%-1d           ║", (j + 1));
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

        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║  Project added successfully!  ║");
        System.out.println("╚═══════════════════════════════╝");
    }

    private static void editProject(Scanner inp) {
        System.out.println("╔══════════════════╗");
        System.out.println("║  Edit Project    ║");
        System.out.println("╚══════════════════╝");


    
        System.out.println("Enter the project ID of the project you want to edit: ");
        String projectId = inp.nextLine();
    
        Project project = findProjectById(projectId);
        if (project == null) {
            System.out.println("Project not found!");
            return;
        }
    
        System.out.println("Editing Project: " + project.getTitle());
    
        // Edit project info
        System.out.println("Current project name: " + project.getTitle());
        System.out.println("Enter new project name (or press Enter to keep the current name): ");
        String projectName = inp.nextLine();
        if (!projectName.isEmpty()) {
            project.setTitle(projectName);
        }
    
        System.out.println("Current project description: " + project.getDescription());
        System.out.println("Enter new project description (or press Enter to keep the current description): ");
        String projectDescription = inp.nextLine();
        if (!projectDescription.isEmpty()) {
            project.setDescription(projectDescription);
        }
    
        // Edit instructor info
        Instructor instructor = project.getInstructor();
    
        System.out.println("Current instructor name: " + instructor.getName());
        System.out.println("Enter new instructor name (or press Enter to keep the current name): ");
        String instructorName = inp.nextLine();
        if (!instructorName.isEmpty()) {
            instructor.setName(instructorName);
        }
    
        System.out.println("Current instructor email: " + instructor.getEmail());
        System.out.println("Enter new instructor email (or press Enter to keep the current email): ");
        String instructorEmail = inp.nextLine();
        if (!instructorEmail.isEmpty()) {
            instructor.setEmail(instructorEmail);
        }
    
        System.out.println("Current instructor employee number: " + instructor.getEmpNum());
        System.out.println("Enter new instructor employee number (or press Enter to keep the current number): ");
        String instructorNumber = inp.nextLine();
        if (!instructorNumber.isEmpty()) {
            instructor.setEmpNum(instructorNumber);
        }
    
        // Edit team info
        Team team = project.getTeam();
    
        System.out.println("Current team name: " + team.getTeamName());
        System.out.println("Enter new team name (or press Enter to keep the current name): ");
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
        System.out.println("Enter the number of the team member to edit (or 0 to skip): ");
        int memberIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (memberIndex >= 0 && memberIndex < team.getMembers().size()) {
            Student student = team.getMembers().get(memberIndex);
    
            System.out.println("Editing student: " + student.getName());
    
            System.out.println("Enter new student name (or press Enter to keep the current name): ");
            String studentName = inp.nextLine();
            if (!studentName.isEmpty()) {
                student.setName(studentName);
            }
    
            System.out.println("Enter new student email (or press Enter to keep the current email): ");
            String studentEmail = inp.nextLine();
            if (!studentEmail.isEmpty()) {
                student.setEmail(studentEmail);
            }
    
            System.out.println("Enter new student role (or press Enter to keep the current role): ");
            String studentRole = inp.nextLine();
            if (!studentRole.isEmpty()) {
                student.setRole(studentRole);
            }
        }
    
        // Edit milestones
        System.out.println("Milestones:");
        for (int i = 0; i < project.getMilestone().size(); i++) {
            Milestone milestone = project.getMilestone().get(i);
            System.out.printf("%d. %s (ID: %s)\n", i + 1, milestone.getMilestoneName(), milestone.getMilestoneID());
        }
        System.out.println("Enter the number of the milestone to edit (or 0 to skip): ");
        int milestoneIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline
    
        if (milestoneIndex >= 0 && milestoneIndex < project.getMilestone().size()) {
            Milestone milestone = project.getMilestone().get(milestoneIndex);
    
            System.out.println("Editing milestone: " + milestone.getMilestoneName());
    
            System.out.println("Enter new milestone name (or press Enter to keep the current name): ");
            String milestoneName = inp.nextLine();
            if (!milestoneName.isEmpty()) {
                milestone.setMilestoneName(milestoneName);
            }
    
            System.out.println("Enter new milestone description (or press Enter to keep the current description): ");
            String milestoneDescription = inp.nextLine();
            if (!milestoneDescription.isEmpty()) {
                milestone.setMilestoneDescription(milestoneDescription);
            }
    
            System.out.println("Enter new milestone deadline (or press Enter to keep the current deadline): ");
            String milestoneDeadline = inp.nextLine();
            if (!milestoneDeadline.isEmpty()) {
                Deadline deadline = new Deadline(milestoneDeadline);
                milestone.setDeadline(deadline);
            }
    
            // Edit tasks within the selected milestone
            System.out.println("Tasks:");
            for (int j = 0; j < milestone.getTask().size(); j++) {
                Task task = milestone.getTask().get(j);
                System.out.printf("%d. %s (Deadline: %s)\n", j + 1, task.getName(), task.getDeadline().toString());
            }
            System.out.println("Enter the number of the task to edit (or 0 to skip): ");
            int taskIndex = inp.nextInt() - 1;
            inp.nextLine(); // Consume newline
    
            if (taskIndex >= 0 && taskIndex < milestone.getTask().size()) {
                Task task = milestone.getTask().get(taskIndex);
    
                System.out.println("Editing task: " + task.getName());
    
                System.out.println("Enter new task name (or press Enter to keep the current name): ");
                String newTaskName = inp.nextLine();
                if (!newTaskName.isEmpty()) {
                    task.setName(newTaskName);
                }
    
                System.out.println("Enter new task deadline (or press Enter to keep the current deadline): ");
                String taskDeadline = inp.nextLine();
                if (!taskDeadline.isEmpty()) {
                    Deadline deadline = new Deadline(taskDeadline);
                    task.setDeadline(deadline);
                }
            }
        }
    
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║  Project edited successfully! ║");
        System.out.println("╚═══════════════════════════════╝");
    }

    
    private static Project findProjectById(String projectId) {
        for (Project project : projects) {
            if (project.getProjectID().equals(projectId)) {
                return project;
            }
        }
        return null;
    }
    

    private static void deleteProject(Scanner inp) {
        if (projects.isEmpty()) {
            System.out.println("No projects available to delete.");
            return;
        }

        for (int i = 0; i < projects.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, projects.get(i).getTitle());
        }

        System.out.println("Select a project to delete (enter number): ");
        int projectIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            projects.remove(projectIndex);
            System.out.println("Project deleted successfully!");
        } else {
            System.out.println("Invalid project selection.");
        }
    }

    private static void editProjectInfo(Scanner inp, Project project) {
        System.out.println("Enter new project ID: ");
        String projectId = inp.nextLine();

        System.out.println("Enter new project name: ");
        String projectName = inp.nextLine();

        System.out.println("Enter new project description: ");
        String projectDescription = inp.nextLine();

        project.setProjectID(projectId);
        project.setTitle(projectName);
        project.setDescription(projectDescription);

        System.out.println("Project info updated successfully!");
    }

    private static void editTeamMembers(Scanner inp, Team team) {
        System.out.println("Team Members:");
        Vector<Student> members = team.getMembers();
        for (int i = 0; i < members.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, members.get(i).getName());
        }

        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("Select your choice: ");
        int choice = inp.nextInt();
        inp.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.println("Enter student matric number: ");
            String matricNumber = inp.nextLine();

            System.out.println("Enter student name: ");
            String studentName = inp.nextLine();

            System.out.println("Enter student email: ");
            String studentEmail = inp.nextLine();

            System.out.println("Enter student role: ");
            String studentRole = inp.nextLine();

            Student student = new Student(matricNumber, studentName, studentEmail, studentRole);
            team.addMember(student);
            System.out.println("Member added successfully!");
        } else if (choice == 2) {
            System.out.println("Enter number of member to remove: ");
            int memberIndex = inp.nextInt() - 1;
            inp.nextLine(); // Consume newline

            if (memberIndex >= 0 && memberIndex < members.size()) {
                team.removeMember(members.get(memberIndex));
                System.out.println("Member removed successfully!");
            } else {
                System.out.println("Invalid member selection.");
            }
        } else {
            System.out.println("Invalid choice, please try again.");
        }
    }

    private static void editTasks(Scanner inp, Project project) {
        List<Milestone> milestones = project.getMilestone();
        if (milestones.isEmpty()) {
            System.out.println("No milestones available to edit.");
            return;
        }

        for (int i = 0; i < milestones.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, milestones.get(i).getMilestoneName());
        }

        System.out.println("Select a milestone to edit (enter number): ");
        int milestoneIndex = inp.nextInt() - 1;
        inp.nextLine(); // Consume newline

        if (milestoneIndex >= 0 && milestoneIndex < milestones.size()) {
            Milestone milestone = milestones.get(milestoneIndex);
            List<Task> tasks = milestone.getTask();

            if (tasks.isEmpty()) {
                System.out.println("No tasks available to edit.");
                return;
            }

            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf("%d) %s\n", i + 1, tasks.get(i).getName());
            }

            System.out.println("Select a task to edit (enter number): ");
            int taskIndex = inp.nextInt() - 1;
            inp.nextLine(); // Consume newline

            if (taskIndex >= 0 && taskIndex < tasks.size()) {
                Task task = tasks.get(taskIndex);

                System.out.println("Editing Task: " + task.getName());
                System.out.println("Enter new task name: ");
                String taskName = inp.nextLine();

                System.out.println("Enter new task deadline (yyyy-mm-dd) or leave blank if none: ");
                String taskDeadline = inp.nextLine();
                Deadline deadline = taskDeadline.isEmpty() ? null : new Deadline(taskDeadline);

                System.out.println("1) Completed");
                System.out.println("2) In Progress");
                System.out.println("Select task status: ");
                int statusChoice = inp.nextInt();
                inp.nextLine(); // Consume newline

                task.setDeadline(deadline);
                task.setStatus(statusChoice);

                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Invalid task selection.");
            }
        } else {
            System.out.println("Invalid milestone selection.");
        }
    }

    private static void editReport(Scanner inp, Project project) {
        Report report = project.getReport();

        if (report == null) {
            System.out.println("No report available for this project.");
            return;
        }

        System.out.println("Editing Report: " + report.getTitle());

        System.out.println("Enter new report title: ");
        String reportTitle = inp.nextLine();

        System.out.println("Enter new report content: ");
        String reportContent = inp.nextLine();

        System.out.println("Enter new submission date (yyyy-mm-dd): ");
        String submissionDate = inp.nextLine();

        report.setTitle(reportTitle);
        report.setContent(reportContent);
        report.setSubmissionDate(submissionDate);

        System.out.println("Report updated successfully!");
    }

    // private static void editReviews(Scanner inp, Report report) {
    //     if (report == null) {
    //         System.out.println("No report available to add/edit reviews.");
    //         return;
    //     }

    //     System.out.println("1) Add Review");
    //     System.out.println("2) Edit Review");
    //     System.out.println("Select your choice: ");
    //     int choice = inp.nextInt();
    //     inp.nextLine(); // Consume newline

    //     switch (choice) {
    //         case 1:
    //             System.out.println("Enter review ID: ");
    //             String reviewId = inp.nextLine();

    //             System.out.println("Enter reviewer name: ");
    //             String reviewerName = inp.nextLine();

    //             System.out.println("Enter comments: ");
    //             String comments = inp.nextLine();

    //             System.out.println("Enter rating (1-5): ");
    //             int rating = inp.nextInt();
    //             inp.nextLine(); // Consume newline

    //             Review review = new Review(reviewId, reviewerName, comments, rating, report);
    //             // Assuming there's a method to add reviews to a report
    //             // report.addReview(review);

    //             System.out.println("Review added successfully!");
    //             break;
    //         case 2:
    //             // Assuming there's a list of reviews in the report
    //             List<Review> reviews = new ArrayList<>(); // replace with actual method to get reviews

    //             for (int i = 0; i < reviews.size(); i++) {
    //                 System.out.printf("%d) %s\n", i + 1, reviews.get(i).getReviewID());
    //             }

    //             System.out.println("Select a review to edit (enter number): ");
    //             int reviewIndex = inp.nextInt() - 1;
    //             inp.nextLine(); // Consume newline

    //             if (reviewIndex >= 0 && reviewIndex < reviews.size()) {
    //                 Review reviewToEdit = reviews.get(reviewIndex);

    //                 System.out.println("Editing Review: " + reviewToEdit.getReviewID());

    //                 System.out.println("Enter new reviewer name: ");
    //                 reviewerName = inp.nextLine();

    //                 System.out.println("Enter new comments: ");
    //                 comments = inp.nextLine();

    //                 System.out.println("Enter new rating (1-5): ");
    //                 rating = inp.nextInt();
    //                 inp.nextLine(); // Consume newline

    //                 reviewToEdit.setReviewerName(reviewerName);
    //                 reviewToEdit.setComments(comments);
    //                 reviewToEdit.setRating(rating);

    //                 System.out.println("Review updated successfully!");
    //             } else {
    //                 System.out.println("Invalid review selection.");
    //             }
    //             break;
    //         default:
    //             System.out.println("Invalid choice, please try again.");
    //     }
    // }
}
                           
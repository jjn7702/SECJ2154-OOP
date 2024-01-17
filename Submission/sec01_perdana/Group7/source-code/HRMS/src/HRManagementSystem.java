import java.io.*;
import java.util.*;

public class HRManagementSystem {
    public static Scanner scanner = new Scanner(System.in);
    private static HRSystem hrSystem = new HRSystem();

    public static void main(String[] args) {
        int choice, choiceEmp, employeeIDToRemove, choiceDep, choicePos, choiceSal, choiceAtt;

        displayWelcomeBanner();
        do {
            hrSystem.displayMainMenu();
            choice = scanner.nextInt();
            clearScreenWithPrompt();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n===================");
                        System.out.println("Employee Management");
                        System.out.println("===================");
                        System.out.println("1. Display Employee List");
                        System.out.println("2. Add Employee");
                        System.out.println("3. Remove Employee");
                        System.out.println("4. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        choiceEmp = scanner.nextInt();

                        switch (choiceEmp) {
                            case 1:
                                clearScreenWithPrompt();
                                hrSystem.displayEmployeeList();
                                clearScreenWithPrompt();
                                break;
                            case 2:
                                clearScreenWithPrompt();
                                System.out.print("Add New Employee\n");
                                System.out.print("================\n\n");
                                addEmployee();
                                clearScreenWithPrompt();
                                break;
                            case 3:
                                clearScreenWithPrompt();
                                hrSystem.displayEmployeeList();
                                System.out.print("Enter the ID of the employee to remove: ");
                                employeeIDToRemove = scanner.nextInt();
                                hrSystem.removeEmployee(employeeIDToRemove);
                                break;
                            case 4:
                                System.out.println("Thank you for filling Employe page!");
                                break;
                            default:
                                System.out.println("Enter correct choice!");
                        }
                    } while (choiceEmp != 4);
                    break;
                case 2:
                    do {
                        System.out.println("\n=====================");
                        System.out.println("Department Management");
                        System.out.println("=====================");
                        System.out.println("1. Display Department");
                        System.out.println("2. Add Department");
                        System.out.println("3. Assign Employee to Department");
                        System.out.println("4. Display Assigned Employee to Department");
                        System.out.println("5. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        choiceDep = scanner.nextInt();

                        switch (choiceDep) {
                            case 1:
                                clearScreenWithPrompt();
                                hrSystem.displayDepartments();
                                clearScreenWithPrompt();
                                break;
                            case 2:
                                clearScreenWithPrompt();
                                System.out.print("Add Department\n");
                                System.out.print("==============\n\n");
                                addDepartment();
                                clearScreenWithPrompt();
                                break;
                            case 3:
                                clearScreenWithPrompt();
                                System.out.print("Assign Employee to Department\n");
                                System.out.print("=============================\n\n");
                                hrSystem.displayDepartments();
                                System.out.println();
                                hrSystem.displayEmployeeList();
                                System.out.println();
                                System.out.print("Enter the ID of the employee to assign: ");
                                int employeeIDToAssign = scanner.nextInt();
                                System.out.print("Enter the ID of the department to assign to: ");
                                int departmentIDToAssign = scanner.nextInt();
                                hrSystem.assignEmployeeToDepartment(employeeIDToAssign, departmentIDToAssign);
                                clearScreenWithPrompt();
                                break;
                            case 4:
                                clearScreenWithPrompt();
                                System.out.print("Display Assigned Employees by Department\n");
                                System.out.print("========================================\n\n");
                                hrSystem.displayDepartments();
                                hrSystem.displayAssignedEmployees();
                                break;
                            case 5:
                                // JOptionPane.showMessageDialog(null, "Thank you for filling Employee List!");
                                System.out.println("Thank you for filling Department page!");
                                break;
                            default:
                                System.out.println("Enter correct choice!");
                        }
                    } while (choiceDep != 5);
                    break;
                case 3:
                    do {
                        System.out.println("\n========================");
                        System.out.println("Work Position Management");
                        System.out.println("========================");
                        System.out.println("1. Display Position");
                        System.out.println("2. Add Position");
                        System.out.println("3. Assign Employee Position");
                        System.out.println("4. Display Assigned Employee Position");
                        System.out.println("5. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        choicePos = scanner.nextInt();

                        switch (choicePos) {
                            case 1:
                                clearScreenWithPrompt();
                                hrSystem.displayPositions();
                                clearScreenWithPrompt();
                                break;
                            case 2:
                                clearScreenWithPrompt();
                                System.out.print("Add Position\n");
                                System.out.print("============\n\n");
                                addPosition();
                                clearScreenWithPrompt();
                                break;
                            case 3:
                                clearScreenWithPrompt();
                                System.out.print("Assign Employee Position\n");
                                System.out.print("========================\n\n");
                                hrSystem.displayPositions();
                                System.out.println();
                                hrSystem.displayEmployeeList();
                                System.out.println();
                                System.out.print("Enter the ID of the employee to assign: ");
                                int employeeIDToAssign = scanner.nextInt();
                                System.out.print("Enter the ID of the position to assign to: ");
                                int positionIDToAssign = scanner.nextInt();
                                hrSystem.assignEmployeeToPosition(employeeIDToAssign, positionIDToAssign);
                                clearScreenWithPrompt();
                                break;
                            case 4:
                                clearScreenWithPrompt();
                                System.out.print("Display Assigned Employees Position\n");
                                System.out.print("===================================\n\n");
                                hrSystem.displayPositions();
                                hrSystem.displayAssignedEmployees();
                                break;
                            case 5:
                                System.out.println("Thank you for filling Position page!");
                                break;
                            default:
                                System.out.println("Enter correct choice!");
                        }
                    } while (choicePos != 5);
                    break;
                case 4:
                    do {
                        System.out.println("\n=====================");
                        System.out.println("Attendance Management");
                        System.out.println("=====================");
                        System.out.println("1. Display Attendance List");
                        System.out.println("2. Record Attendance");
                        System.out.println("3. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        choiceAtt = scanner.nextInt();

                        switch (choiceAtt) {
                            case 1:
                                clearScreenWithPrompt();
                                hrSystem.displayAttendanceList();
                                clearScreenWithPrompt();
                                break;
                            case 2:
                                clearScreenWithPrompt();
                                System.out.print("Add Attendance Record\n");
                                System.out.print("=====================\n\n");
                                hrSystem.displayEmployeeList();
                                hrSystem.recordAttendance();
                                clearScreenWithPrompt();
                                break;
                            case 3:
                                System.out.println("Thank you for filling Attendance page!");
                                break;
                            default:
                                System.out.println("Enter correct choice!");
                        }
                    } while (choiceAtt != 3);
                    break;
                case 5:
                    do {
                        System.out.println("\n=================");
                        System.out.println("Salary Management");
                        System.out.println("=================");
                        System.out.println("1. Key-In Employee Salary");
                        System.out.println("2. Display Employee Salary");
                        System.out.println("3. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        choiceSal = scanner.nextInt();

                        switch (choiceSal) {
                            case 1:
                                clearScreenWithPrompt();
                                System.out.print("Key-In Employee Salary\n");
                                System.out.print("======================\n\n");
                                hrSystem.displayEmployeeList();
                                System.out.print("Enter employee ID: ");
                                int employeeIDForSalary = scanner.nextInt();
                                Employee employeeForSalary = hrSystem.findEmployeeByID(employeeIDForSalary);

                                if (employeeForSalary != null) {
                                    System.out.print("Enter salary per day : RM ");
                                    double salaryAmount = scanner.nextDouble();


                                    double deductions = 100 * employeeForSalary.getAttendance().getDaysOnLeave();

                                    double netSalary = salaryAmount
                                            * employeeForSalary.getAttendance().getDaysAttended()
                                            - (deductions);

                                    Salary salary = new Salary(hrSystem.generateSalaryID(), netSalary, deductions,
                                            employeeForSalary);
                                    hrSystem.addSalary(salary);

                                    hrSystem.updateSalaryDataFile();

                                    System.out.println("Salary recorded successfully.");
                                } else {
                                    System.out.println("Employee not found.");
                                }

                                clearScreenWithPrompt();
                                break;
                            case 2:
                                clearScreenWithPrompt();
                                hrSystem.displayEmployeeSalary();
                                System.out.println();
                                clearScreenWithPrompt();
                                break;
                            case 3:
                                System.out.println("Thank you for filling Salary page!");
                                break;
                            default:
                                System.out.println("Enter correct choice!");
                        }
                    } while (choiceSal != 3);
                    break;
                case 6:
                    clearScreen();
                    System.out.println("Exiting HR Management System. Goodbye!");
                    break;
                default:
                    clearScreen();
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

            if (choice != 6) {
                System.out.print("\nDo you want to continue? (Y or N): ");
                String continueChoice = scanner.next();
                if (!continueChoice.equalsIgnoreCase("Y")) {
                    System.out.println("Exiting HR Management System. Goodbye!");
                    break;
                }
            }

            clearScreen();

        } while (choice != 6);
    }

    public static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().toUpperCase();
    
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().toUpperCase();
    
        System.out.print("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine().toUpperCase();
    
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine().toUpperCase();
    
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
    
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
    
        Employee newEmployee = new Employee(employeeID, firstName, lastName, dateOfBirth, gender, contactInfo, email);
        hrSystem.addEmployee(newEmployee);
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt", true));
                BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
    
            if (reader.readLine() == null) {
                writer.write(String.format("%-10s | %-15s | %-15s | %-15s | %-10s | %-20s | %-20s%n",
                        "ID", "First Name", "Last Name", "Date of Birth", "Gender", "Contact Info", "Email"));
                writer.write("-".repeat(110));
                writer.newLine();
            }
    
            writer.write(String.format("%-10s | %-15s | %-15s | %-15s | %-10s | %-20s | %-20s%n",
                    newEmployee.getEmployeeID(), newEmployee.getFirstName(), newEmployee.getLastName(),
                    newEmployee.getDateOfBirth(), newEmployee.getGender(), newEmployee.getContactInfo(),
                    newEmployee.getEmail()));
        } catch (IOException e) {
            System.out.println("Error logging employee data: " + e.getMessage());
        }
    }
    

    public static void addDepartment() {
        System.out.print("Enter Department ID: ");
        int departmentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Department Name: ");
        String departmentName = scanner.nextLine().toUpperCase();

        System.out.print("Enter Department Manager: ");
        String departmentManager = scanner.nextLine().toUpperCase();

        Department newDepartment = new Department(departmentID, departmentName, departmentManager);
        hrSystem.addDepartment(newDepartment);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("department_data.txt", true));
                BufferedReader reader = new BufferedReader(new FileReader("department_data.txt"))) {

            if (reader.readLine() == null) {
                writer.write(String.format("%-15s | %-20s | %-15s%n", "Department ID", "Department Type", "Manager"));
                writer.write("-".repeat(60));
                writer.newLine();
            }

            writer.write(String.format("%-15d | %-20s | %-15s%n", newDepartment.getDepartmentID(),
                    newDepartment.getDepartmentType(), newDepartment.getManager()));
        } catch (IOException e) {
            System.out.println("Error logging department data: " + e.getMessage());
        }
    }

    public static void addPosition() {
        System.out.print("Enter Position ID: ");
        int positionID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Position Title: ");
        String positionTitle = scanner.nextLine().toUpperCase();

        // Assuming you have a Position class with appropriate constructor
        Position newPosition = new Position(positionID, positionTitle);
        hrSystem.addPosition(newPosition);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("position_data.txt", true));
                BufferedReader reader = new BufferedReader(new FileReader("position_data.txt"))) {

            if (reader.readLine() == null) {
                writer.write(String.format("%-15s | %-20s%n", "Position ID", "Position Title"));
                writer.write("-".repeat(40));
                writer.newLine();
            }

            writer.write(String.format("%-15d | %-20s%n", newPosition.getPositionID(), newPosition.getTitle()));
            System.out.println("Position data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error logging position data: " + e.getMessage());
        }
    }

    public static void displayWelcomeBanner() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                                         ║");
        System.out.println("║      \033[1;36mWelcome to\033[0m \033[1;33mH\033[1;31mR\033[1;32mM\033[1;34mS\033[1;35m\033[1;36m Management System\033[0m  ║");
        System.out.println("║                                         ║");
        System.out.println("║   \033[1;32mWe Got Your Back, We'll Call You Back\033[0m ║");
        System.out.println("║                                         ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.println();
    }
    

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearScreenWithPrompt() {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
        clearScreen();
    }
}

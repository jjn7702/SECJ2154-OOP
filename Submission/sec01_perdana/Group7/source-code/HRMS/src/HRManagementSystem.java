import java.util.*;

public class HRManagementSystem {
    private static Scanner input = new Scanner(System.in);
    private static HRSystem hrSystem = new HRSystem();

    public static void main(String[] args) {
        int choice;
        do {
            hrSystem.displayMainMenu();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    hrSystem.displayEmployeeList();
                    break;
                case 3:
                    hrSystem.displayDepartmentList();
                    break;
                case 4:
                    hrSystem.displayPositionList();
                    break;
                case 5:
                    hrSystem.displaySalaryList();
                    break;
                case 6:
                    hrSystem.displayAttendanceList();
                    break;
                case 7:
                    hrSystem.displayLeaveRequestList();
                    break;
                case 8:
                    System.out.println("Exiting HR Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 8);
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int employeeID = input.nextInt();
        input.nextLine(); 

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter date of birth: ");
        String dateOfBirth = input.nextLine();

        System.out.print("Enter gender: ");
        String gender = input.nextLine();

        System.out.print("Enter contact info: ");
        String contactInfo = input.nextLine();

        Employee newEmployee = new Employee(employeeID, firstName, lastName, dateOfBirth, gender, contactInfo);
        hrSystem.addEmployee(newEmployee);
        System.out.println("Employee added to the system.");
    }
}
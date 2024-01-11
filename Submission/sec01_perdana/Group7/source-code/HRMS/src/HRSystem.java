import java.util.*;

class HRSystem {
    private ArrayList<Employee> employees;
    private ArrayList<Department> departments;
    private ArrayList<Position> positions;
    private ArrayList<Salary> salaries;
    private ArrayList<Attendance> attendanceRecords;
    private ArrayList<Leave> leaveRequests;
    private ArrayList<HRManager> hrManagers;

    public HRSystem() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.positions = new ArrayList<>();
        this.salaries = new ArrayList<>();
        this.attendanceRecords = new ArrayList<>();
        this.leaveRequests = new ArrayList<>();
        this.hrManagers = new ArrayList<>();
    }

    private HRManager findFirstHRManager() {
        for (HRManager manager : hrManagers) {
            return manager;
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added to the system.");

        HRManager firstHRManager = findFirstHRManager();
        if (firstHRManager != null) {
            firstHRManager.setManagedEmployee(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("Employee removed from the system.");
    }

    // Association: Aggregation
    public void assignPosition(Employee employee, Position position) {
        System.out.println("Position assigned to employee.");
        if (employee instanceof Staff) {
            ((Staff) employee).setPosition(position);
        }
    }

    public void processLeaveRequest(Leave leave) {
        // Exception handling
        try {
            if (leave.validateLeaveRequest()) {
                System.out.println("Leave request approved.");
            } else {
                System.out.println("Leave request rejected.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the leave request: " + e.getMessage());
        }
    }

    // Display methods for lists
    public void displayEmployeeList() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getEmployeeID() + ", Name: " + employee.getFirstName() + " " + employee.getLastName());
        }
    }

    public void displayDepartmentList() {
        System.out.println("Department List:");
        for (Department department : departments) {
            System.out.println("ID: " + department.getDepartmentID() + ", Name: " + department.getDepartmentName());
        }
    }

    public void displayPositionList() {
        System.out.println("Position List:");
        for (Position position : positions) {
            System.out.println("ID: " + position.getPositionID() + ", Title: " + position.getTitle());
        }
    }

    public void displaySalaryList() {
        System.out.println("Salary List:");
        for (Salary salary : salaries) {
            System.out.println("ID: " + salary.getSalaryID() + ", Amount: " + salary.calculateNetSalary());
        }
    }

    public void displayAttendanceList() {
        System.out.println("Attendance List:");
        for (Attendance attendance : attendanceRecords) {
            System.out.println("ID: " + attendance.getAttendanceID() + ", Employee: " +
                    attendance.getEmployeeFirstName() + " " + attendance.getEmployeeLastName() +
                    ", Hours Worked: " + attendance.getEmployeeHoursWorked());
        }
    }

    public void displayLeaveRequestList() {
        System.out.println("Leave Request List:");
        for (Leave leave : leaveRequests) {
            System.out.println("ID: " + leave.getLeaveID() + ", Employee: " +
                    leave.getEmployeeFirstName() + " " + leave.getEmployeeLastName() +
                    ", Start Date: " + leave.getStartDate() + ", End Date: " + leave.getEndDate() +
                    ", Reason: " + leave.getReason());
        }
    }

    public void displayMainMenu() {
        System.out.println("HR Management System Menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Display Employee List");
        System.out.println("3. Display Department List");
        System.out.println("4. Display Position List");
        System.out.println("5. Display Salary List");
        System.out.println("6. Display Attendance List");
        System.out.println("7. Display Leave Request List");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}
import java.util.*;
import javax.swing.text.Position;

class HRSystem {
    private List<Employee> employees;
    private List<Department> departments;
    private List<Position> positions;
    private List<Salary> salaries;
    private List<Attendance> attendanceRecords;
    private List<Leave> leaveRequests;

    public HRSystem() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.positions = new ArrayList<>();
        this.salaries = new ArrayList<>();
        this.attendanceRecords = new ArrayList<>();
        this.leaveRequests = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added to the system.");
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("Employee removed from the system.");
    }

    // Association: Aggregation
    public void assignPosition(Employee employee, Position position) {
        // Set the position for the employee
        System.out.println("Position assigned to employee.");
        // Update the employee's position attribute
        if (employee instanceof Staff) {
            ((Staff) employee).setPosition(position);
        }
    }

    public void processLeaveRequest(Leave leave) {
        try {
            // Approve the leave if valid, reject otherwise
            if (leave.validateLeaveRequest()) {
                System.out.println("Leave request approved.");
            } else {
                System.out.println("Leave request rejected.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the leave request: " + e.getMessage());
        }
    }
}

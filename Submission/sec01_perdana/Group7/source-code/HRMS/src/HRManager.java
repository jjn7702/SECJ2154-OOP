import java.util.*;

class HRManager {
    private int hrManagerID;
    private Employee employee;
    private ArrayList<Department> managedDepartments;
    private ArrayList<Position> managedPositions;

    public HRManager(int hrManagerID, Employee employee) {
        this.hrManagerID = hrManagerID;
        this.employee = employee;
        this.managedDepartments = new ArrayList<>();
        this.managedPositions = new ArrayList<>();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void manageEmployee(Employee employee) {
        if (employee != null) {
            System.out.println("HR Manager " + employee.getFullName() + " is managing " +
                    employee.getFullName());
        } else {
            System.out.println("Invalid employee. Unable to manage.");
        }
    }

    public void assignTask(Employee employee, String task) {
        if (employee != null) {
            System.out.println("HR Manager " + this.employee.getFullName() + " is assigning task '" +
                    task + "' to " + employee.getFullName());
        } else {
            System.out.println("Invalid employee. Unable to assign task.");
        }
    }

    public void addManagedEmployee(Department department) {
        managedDepartments.add(department);
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getHrManagerID() {
        return hrManagerID;
    }

    public void setManagedEmployee(Employee employee) {
        setEmployee(employee);
    }

    public void addManagedDepartment(Department department) {
        managedDepartments.add(department);
    }

    public void addManagedPosition(Position newPosition) {
        managedPositions.add(newPosition);
    }
}
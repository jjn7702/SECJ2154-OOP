import java.util.*;

class HRManager {
    private int hrManagerID;
    private Employee employee;
    private ArrayList<Department> managedDepartments;

    public HRManager(int hrManagerID, Employee employee) {
        this.hrManagerID = hrManagerID;
        this.employee = employee;
        this.managedDepartments = new ArrayList<>();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void manageEmployee(Employee employee) {
        if (employee != null) {
            System.out.println("HR Manager " + getEmployee().getFirstName() + " is managing " +
                    employee.getFirstName() + " " + employee.getLastName());
        } else {
            System.out.println("Invalid employee. Unable to manage.");
        }
    }

    public void assignTask(Employee employee, String task) {
        if (employee != null) {
            System.out.println("HR Manager " + getEmployee().getFirstName() + " is assigning task '" +
                    task + "' to " + employee.getFirstName() + " " + employee.getLastName());
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
}
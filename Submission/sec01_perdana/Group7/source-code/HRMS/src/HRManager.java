public class HRManager {
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
    }

    public void assignTask(Employee employeeToAssign, String task) {
    }

    public void addManagedDepartment(Department department) {
        managedDepartments.add(department);
    }

    public ArrayList<Department> getManagedDepartments() {
        return managedDepartments;
    }
}

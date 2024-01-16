import java.util.*;

class Department {
    private int departmentID;
    private String departmentType;
    private String manager;
    private ArrayList<Staff> staffMembers;
    private List<Employee> employeesInDepartment;

    public Department(int departmentID, String departmentType, String manager) {
        this.departmentID = departmentID;
        this.departmentType = departmentType;
        this.manager = manager;
        this.staffMembers = new ArrayList<>();
        this.employeesInDepartment = new ArrayList<>();
    }

    public void addStaffMember(Staff staff) {
        staffMembers.add(staff);
        employeesInDepartment.add(staff); // Assuming staff is also an Employee
    }

    public void removeStaffMember(Staff staff) {
        staffMembers.remove(staff);
        employeesInDepartment.remove(staff);
    }

    public void displayDepartmentInfo() {
        System.out.println("Department ID: " + departmentID);
        System.out.println("Department Name: " + departmentType);
        System.out.println("Manager: " + manager);
        System.out.println("Number of Staff Members: " + staffMembers.size());
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public String getManager() {
        return manager;
    }

    public ArrayList<Staff> getStaffMembers() {
        return staffMembers;
    }
}
import java.util.*;

class Department {
    private int departmentID;
    private String departmentName;
    private HRManager manager;
    private ArrayList<Staff> staffMembers;

    public Department(int dID, String dName, HRManager manager) {
        this.departmentID = dID;
        this.departmentName = dName;
        this.manager = manager;
        this.staffMembers = new ArrayList<>();
    }

    public void addStaffMember(Staff staff) {
        staffMembers.add(staff);
    }

    public void removeStaffMember(Staff staff) {
        staffMembers.remove(staff);
    }

    public void displayDepartmentInfo() {
        System.out.println("Department ID: " + departmentID);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Manager: " + manager.getEmployee().getFirstName() + " " + manager.getEmployee().getLastName());
        System.out.println("Number of Staff Members: " + staffMembers.size());
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName(){
        return departmentName;
    }


}
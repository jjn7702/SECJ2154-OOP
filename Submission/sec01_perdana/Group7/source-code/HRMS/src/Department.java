class Department {
    private int departmentID;
    private String departmentName;
    private HRManager manager;
    private List<Staff> staffMembers;

    public Department(int departmentID, String departmentName, HRManager manager) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
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
        System.out.println(
                "Manager: " + manager.getEmployee().getFirstName() + " " + manager.getEmployee().getLastName());
        System.out.println("Number of Staff Members: " + staffMembers.size());
    }
}
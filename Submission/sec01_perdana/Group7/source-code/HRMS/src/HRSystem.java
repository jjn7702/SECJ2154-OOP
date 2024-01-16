import java.io.*;
import java.util.*;

class HRSystem {
    private static ArrayList<Attendance> attendanceRecords = new ArrayList<>();
    private static ArrayList<Salary> salaryRecords = new ArrayList<>();
    private ArrayList<Employee> employees;
    private ArrayList<Department> departments;
    private ArrayList<Position> positions;
    // private ArrayList<Attendance> attendanceRecords;
    private ArrayList<HRManager> hrManagers;

    public HRSystem() {
        this.employees = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.positions = new ArrayList<>();
        // this.attendanceRecords = new ArrayList<>();
        this.hrManagers = new ArrayList<>();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    private HRManager findFirstHRManager() {
        return hrManagers.isEmpty() ? null : hrManagers.get(0);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added to the system.");

        HRManager firstHRManager = findFirstHRManager();
        if (firstHRManager != null) {
            firstHRManager.setManagedEmployee(employee);
        }
    }

    public void removeEmployee(int employeeID) {
        Employee employeeToRemove = findEmployeeByID(employeeID);
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            updateEmployeeDataFile(); // Update the file after removing the employee
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + employeeID + " not found.");
        }
    }

    private void updateEmployeeDataFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt"))) {
            writer.write(String.format("%-10s | %-15s | %-15s | %-15s | %-10s | %-20s | %-20s | %-20s | %-20s%n",
                    "ID", "First Name", "Last Name", "Date of Birth", "Gender", "Contact Info", "Email", "Department", "Position"));
            writer.write("-".repeat(170));
            writer.newLine();
    
            for (Employee employee : employees) {
                String assignedDepartment = (employee.getAssignedDepartment() != null) ? employee.getAssignedDepartment().getDepartmentType() : "Not Assigned";
                String assignedPosition = (employee.getAssignedPosition() != null) ? employee.getAssignedPosition().getTitle() : "Not Assigned";
    
                writer.write(String.format("%-10s | %-15s | %-15s | %-15s | %-10s | %-20s | %-20s | %-20s | %-20s%n",
                        employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(),
                        employee.getDateOfBirth(), employee.getGender(), employee.getContactInfo(),
                        employee.getEmail(), assignedDepartment, assignedPosition));
            }
            System.out.println("Employee data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error updating employee data file: " + e.getMessage());
        }
    }
    
    public Employee findEmployeeByID(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    public void assignPosition(Employee employee, Position position) {
        System.out.println("Position assigned to employee.");
        if (employee instanceof Staff) {
            ((Staff) employee).setPosition(position);
        }
    }

    public void addDepartment(Department newDepartment) {
        departments.add(newDepartment);
        System.out.println("Department added to the system.");

        HRManager firstHRManager = findFirstHRManager();
        if (firstHRManager != null) {
            firstHRManager.addManagedDepartment(newDepartment);
        }
    }

    public void displayDepartments() {
        System.out.println("Display Department");
        System.out.println("==================");

        try (BufferedReader reader = new BufferedReader(new FileReader("department_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading department data from file: " + e.getMessage());
        }

        System.out.println();
    }

    public void removeDepartment(int departmentID) {
        Department departmentToRemove = findDepartmentByID(departmentID);
        if (departmentToRemove != null) {
            departments.remove(departmentToRemove);
            updateDepartmentDataFile(); // Update the file after removing the employee
            System.out.println("Department removed successfully.");
        } else {
            System.out.println("Department with ID " + departmentID + " not found.");
        }
    }

    public void updateDepartmentDataFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("department_data.txt"))) {
            writer.write(String.format("%-15s | %-20s | %-15s%n", "Department ID", "Department Type", "Manager"));
            writer.write("-".repeat(60));
            writer.newLine();

            for (Department department : departments) {
                writer.write(String.format("%-15d | %-20s | %-15s%n", department.getDepartmentID(),
                        department.getDepartmentType(), department.getManager()));
            }
            System.out.println("Department data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error updating department data file: " + e.getMessage());
        }
    }

    public void addHRManager(HRManager hrManager) {
        hrManagers.add(hrManager);
    }

    public void setHRManagerInfo(int hrManagerID, String hrManagerFirstName, String hrManagerLastName) {
        HRManager hrManager = findHRManagerByID(hrManagerID);
        if (hrManager != null) {
            Employee hrManagerEmployee = hrManager.getEmployee();
            hrManagerEmployee.setFirstName(hrManagerFirstName);
            hrManagerEmployee.setLastName(hrManagerLastName);
            System.out.println("HR Manager information updated successfully.");
        } else {
            System.out.println("HR Manager not found in the system.");
        }
    }

    private HRManager findHRManagerByID(int hrManagerID) {
        for (HRManager hrManager : hrManagers) {
            if (hrManager.getHrManagerID() == hrManagerID) {
                return hrManager;
            }
        }
        return null;
    }

    public void displayEmployeeList() {
        System.out.println("Employee List:");
        System.out.println("==============\n");
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data from file: " + e.getMessage());
        }

        System.out.println();
    }

    public void assignEmployeeToDepartment(int employeeID, int departmentID) {
        Employee employee = findEmployeeByID(employeeID);
        Department department = findDepartmentByID(departmentID);

        if (employee != null && department != null) {
            employee.setAssignedDepartment(department);
            updateEmployeeDataFile();
            generateEmployeeDepartmentFile();

            department.addStaffMember(new Staff(employee.getEmployeeID(), employee.getFirstName(),
                    employee.getLastName(), employee.getDateOfBirth(), employee.getGender(),
                    employee.getContactInfo(), employee.getEmail(), null));

            System.out.println("Employee assigned to department successfully.");
        } else {
            System.out.println("Invalid employee ID or department ID. Assignment failed.");
        }
    }

    public void displayAssignedEmployees() {
        System.out.println("\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data from file: " + e.getMessage());
        }

        System.out.println();
    }

    private Department findDepartmentByID(int departmentID) {
        for (Department department : departments) {
            if (department.getDepartmentID() == departmentID) {
                return department;
            }
        }
        return null;
    }

    public void generateEmployeeDepartmentFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_department_data.txt"))) {
            writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n", "ID", "Employee Name", "Department ID", "Department Type"));
            writer.write("-".repeat(70));
            writer.newLine();
    
            for (Employee employee : employees) {
                String employeeName = employee.getFirstName() + " " + employee.getLastName();
                String assignedDepartmentID = "Not Assigned";
                String assignedDepartmentType = "Not Assigned";
    
                Department assignedDepartment = employee.getAssignedDepartment();
                if (assignedDepartment != null) {
                    assignedDepartmentID = String.valueOf(assignedDepartment.getDepartmentID());
                    assignedDepartmentType = assignedDepartment.getDepartmentType();
                }
    
                writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n",
                        employee.getEmployeeID(), employeeName, assignedDepartmentID, assignedDepartmentType));
            }
    
            System.out.println("Employee-Department data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error generating employee-department data file: " + e.getMessage());
        }
    }
    

    public void addPosition(Position newPosition) {
        positions.add(newPosition);
        System.out.println("Position added to the system.");

        HRManager firstHRManager = findFirstHRManager();
        if (firstHRManager != null) {
            firstHRManager.addManagedPosition(newPosition);
        }
    }

    public void displayPositions() {
        System.out.println("Display Positions");
        System.out.println("==================");

        try (BufferedReader reader = new BufferedReader(new FileReader("position_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading position data from file: " + e.getMessage());
        }

        System.out.println();
    }

    private Position findPositionByID(int positionID) {
        for (Position position : positions) {
            if (position.getPositionID() == positionID) {
                return position;
            }
        }
        return null;
    }

    public void assignEmployeeToPosition(int employeeID, int positionID) {
        Employee employee = findEmployeeByID(employeeID);
        Position position = findPositionByID(positionID);

        if (employee != null && position != null) {
            employee.setAssignedPosition(position);
            updateEmployeeDataFile();
            generateEmployeePositionFile();

            System.out.println("Employee assigned to position successfully.");
        } else {
            System.out.println("Invalid employee ID or position ID. Assignment failed.");
        }
    }

    public void generateEmployeePositionFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_position_data.txt"))) {
            writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n", "ID", "Employee Name", "Position ID",
                    "Position Title"));
            writer.write("-".repeat(70));
            writer.newLine();

            for (Employee employee : employees) {
                String employeeName = employee.getFirstName() + " " + employee.getLastName();
                String assignedPositionTitle = (employee.getAssignedPosition() != null)
                        ? employee.getAssignedPosition().getTitle()
                        : "Not Assigned";
                String assignedPositionID = (employee.getAssignedPosition() != null)
                        ? String.valueOf(employee.getAssignedPosition().getPositionID())
                        : "Not Assigned";

                writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n",
                        employee.getEmployeeID(), employeeName, assignedPositionID, assignedPositionTitle));
            }

            System.out.println("Employee-Position data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error generating employee-position data file: " + e.getMessage());
        }
    }

    public void displayAttendanceList() {
        System.out.println("Attendance List:");
        System.out.println("================\n");
        try (BufferedReader reader = new BufferedReader(new FileReader("attendance_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading attendance data from file: " + e.getMessage());
        }
        System.out.println();
    }

    public void updateAttendanceDataFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("attendance_data.txt"))) {
            String headerFormat = "%-15s | %-15s | %-15s%n";
            writer.write(String.format(headerFormat, "Attendance ID", "Employee ID", "Days Attended"));
            writer.write("-".repeat(60));
            writer.newLine();

            for (Attendance attendance : attendanceRecords) {
                writer.write(String.format("%-15s | %-15s | %-15s%n",
                        attendance.getAttendanceID(), attendance.getEmployee().getEmployeeID(),
                        attendance.getDaysAttended()));
            }
        } catch (IOException e) {
            System.out.println("Error updating attendance data file: " + e.getMessage());
        }
    }

    public int generateAttendanceID() {
        return attendanceRecords.size() + 1;
    }

    public void recordAttendance() {

        Scanner scanner = new Scanner(System.in);

        // Get employee ID
        System.out.print("Enter employee ID: ");
        int employeeID = scanner.nextInt();
        Employee employee = findEmployeeByID(employeeID);

        if (employee != null) {
            System.out.print("Enter days attended (1-30): ");
            int daysAttended = scanner.nextInt();

            // int daysOnLeave = (daysAttended >= 1 && daysAttended <= 30) ? 30 -
            // daysAttended : 0;
            int daysOnLeave = 0;
            if (daysAttended >= 1 && daysAttended <= 30) {
                daysOnLeave = 30 - daysAttended;
            }

            int attendanceID = generateAttendanceID();
            Attendance attendance = new Attendance(attendanceID, employee, daysAttended, daysOnLeave);
            employee.setAttendance(attendance);
            attendanceRecords.add(attendance);
            updateAttendanceDataFile();
            System.out.println("Attendance recorded successfully.");
        } else {
            System.out.println("Employee not found.");
        }
        // scanner.close();
    }

    // public double calculateSalary(int employeeID, int daysAttended, int
    // daysOnLeave) {
    // Employee employee = findEmployeeByID(employeeID);
    // if (employee != null) {
    // double baseSalary = 1000.0; // Replace with your actual base salary
    // double dailyRate = baseSalary / 30.0; // Assuming a 30-day month

    // // Calculate salary based on daysAttended
    // double salary = dailyRate * daysAttended;

    // // Deduct $100 for each day on leave
    // salary -= (daysOnLeave * 100.0);

    // return salary;
    // } else {
    // System.out.println("Employee not found.");
    // return 0;
    // }
    // }

    // public double calculateSalary(int employeeID, int daysAttended, int
    // daysOnLeave) {
    // Employee employee = findEmployeeByID(employeeID);
    // if (employee != null) {
    // Salary latestSalary = getLatestSalary(); // Assuming this method returns the
    // latest salary

    // if (latestSalary != null) {
    // double totalSalary = latestSalary.getAmount() * 30; // Assuming a 30-day
    // month
    // double deduction = Math.max((daysOnLeave - 100.0), 0.0);

    // // Ensure deduction does not exceed total salary
    // deduction = Math.min(deduction, totalSalary);

    // double attendanceSalary = totalSalary - deduction;

    // // Ensure salary is not negative
    // if (attendanceSalary < 0) {
    // attendanceSalary = 0;
    // }

    // return attendanceSalary;
    // } else {
    // System.out.println("No salary records found for the employee.");
    // return 0;
    // }
    // } else {
    // System.out.println("Employee not found.");
    // return 0;
    // }
    // }

    public double calculateSalary(int employeeID, int daysAttended, int daysOnLeave) {
        Employee employee = findEmployeeByID(employeeID);
        if (employee != null) {
            Salary latestSalary = getLatestSalary(); // Assuming this method returns the latest salary

            if (latestSalary != null) {
                double totalSalary = latestSalary.getAmount() * 30; // Assuming a 30-day month
                double deduction = daysOnLeave * 100.0;

                // Ensure deduction is at least 0
                if (deduction < 0.0) {
                    deduction = 0.0;
                }

                // Ensure deduction does not exceed total salary
                if (deduction > totalSalary) {
                    deduction = totalSalary;
                }

                double attendanceSalary = totalSalary - deduction;

                // Ensure salary is not negative
                if (attendanceSalary < 0) {
                    attendanceSalary = 0;
                }

                return attendanceSalary;
            } else {
                System.out.println("No salary records found for the employee.");
                return 0;
            }
        } else {
            System.out.println("Employee not found.");
            return 0;
        }

    }

    public void updateSalaryDataFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("salary_data.txt", true))) {
            Salary latestSalary = getLatestSalary(); // Implement this method to get the latest salary

            if (latestSalary != null) {
                // Assuming Salary has getSalaryID(), getAmount(), and getEmployee() methods
                writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n",
                        "Salary ID", "Amount", "Deductions", "Employee ID"));
                writer.write("-".repeat(60));
                writer.newLine();
                writer.write(String.format("%-10s | %-15s | %-15s | %-20s%n",
                        latestSalary.getSalaryID(), latestSalary.getAmount(), latestSalary.getDeductions(),
                        latestSalary.getEmployee().getEmployeeID()));
                System.out.println("Salary data written to file successfully.");
            } else {
                System.out.println("No salary records found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating salary data file: " + e.getMessage());
        }
    }

    public Salary getLatestSalary() {
        if (!salaryRecords.isEmpty()) {
            // Sort the list by salary ID in descending order (assuming higher salary IDs
            // are newer)
            salaryRecords.sort(Comparator.comparingInt(Salary::getSalaryID).reversed());
            return salaryRecords.get(0); // Return the first (latest) salary
        } else {
            return null; // Return null if the list is empty
        }
    }

    public int generateSalaryID() {
        return salaryRecords.size() + 1;
    }

    public void addSalary(Salary salary) {
        salaryRecords.add(salary);
    }

    public void displayEmployeeSalary() {
        System.out.print("Display Employee Salary\n");
        System.out.print("=======================\n\n");

        try (BufferedReader reader = new BufferedReader(new FileReader("salary_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading salary data from file: " + e.getMessage());
        }
    }

    public void displayMainMenu() {
        System.out.println("\nHR Management System Menu:");
        System.out.println("1. Employee");
        System.out.println("2. Department");
        System.out.println("3. Work Position");
        System.out.println("4. Attendance Performance");
        System.out.println("5. Salary Management");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}
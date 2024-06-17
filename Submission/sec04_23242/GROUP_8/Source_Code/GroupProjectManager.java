
import java.util.Vector;

abstract class User {
    private String userID;
    private String name;
    private String email;

    public User() {
    }

    public User(String id, String name, String email) {
        this.userID = id;
        this.name = name;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayInfo() {

    }
}

class Student extends User {
    public Student(String std_ID, String name, String email) {
        super(std_ID, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("ID: " + getUserID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}

class Instructor extends User {
    public Instructor(String ins_ID, String name, String email) {
        super(ins_ID, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor Info:");
        System.out.println("ID: " + getUserID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}

class ProjectManager extends User {
    public ProjectManager(String man_ID, String name, String email) {
        super(man_ID, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Project Manager Info:");
        System.out.println("ID: " + getUserID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}

public class GroupProjectManager {
    public static void main(String[] args) {
        User std1 = new Student("A22EC0178", "Kugen", "kugen@graduate.utm.my");
        std1.displayInfo();
    }
}

class Task {
    private int taskID;
    private String taskName;
    private String status;
    private Deadline deadline;

    public Deadline getDeadline() { // composition
        return deadline;
    }

    public Task(int taskID, String taskName, String status) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.status = status;
    }

    public int gettaskID() {
        return taskID;
    }

    public String gettaskName() {
        return taskName;
    }

    public String getstatus() {
        return status;
    }

    public void setStatus() {

    }

}

class Deadline {
    private String dueDate;

    public Deadline(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate() {

    }
}

class Milestone {
    private String milestoneName;
    private Vector<Task> task = new Vector<>();

    public Milestone(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    void addTask(Task t) {
        task.add(t);
    }

    public void printTask() {
        for (int i = 0; i < task.size(); i++) {
            System.out.println(task.get(i));
        }
    }
}

class Team {
    private String teamName;
    
}

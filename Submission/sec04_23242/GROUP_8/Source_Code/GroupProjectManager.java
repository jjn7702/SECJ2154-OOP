
abstract class User {
    private String userID;
    private String name;
    private String email;

    public User() {}

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

    public  void displayInfo()
    {

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


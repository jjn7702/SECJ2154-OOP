import java.util.Vector;

// abstract class User {
//     private int userID;
//     private String name;
//     private String email;

//     public User() { }

//     public User(int id, String name, String email) {
//         this.userID = id;
//         this.name = name;
//         this.email = email;
//     }

//     public int getUserID() {
//         return userID;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public void display() {

//     }
// }

// class Student extends User {
//     private String matricsNumber, role;

//     public Student(int userID, String name, String email, String mat_No, String r) {
//         super(name, email);
//         matricsNumber = mat_No;
//         role = r;
//     }

//     public String getMatricsNum() {
//         return matricsNumber;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setMatricsNum (String matricsNumber){
//         this.matricsNumber = matricsNumber;
//     }

//     public 

//     @Override
//     public void displayInfo() {
//         System.out.println("Student Info:");
//         // System.out.println("ID: " + getUserID());
//         // System.out.println("Name: " + getName());
//         // System.out.println("Email: " + getEmail());
//     }
// }

// class Instructor extends User {
//     public Instructor(String ins_ID, String name, String email) {
//         super(ins_ID, name, email);
//     }

    
//     public void displayInfo() {
//         System.out.println("Instructor Info:");
//         System.out.println("ID: " + getUserID());
//         System.out.println("Name: " + getName());
//         System.out.println("Email: " + getEmail());
//     }
// }


// class Task {
//     private int taskID;
//     private String taskName;
//     private String status;
//     private Deadline deadline;

//     public Deadline getDeadline() { // composition
//         return deadline;
//     }

//     public Task(int taskID, String taskName, String status) {
//         this.taskID = taskID;
//         this.taskName = taskName;
//         this.status = status;
//     }

//     public int gettaskID() {
//         return taskID;
//     }

//     public String gettaskName() {
//         return taskName;
//     }

//     public String getstatus() {
//         return status;
//     }

//     public void setStatus() {

//     }

// }

// class Deadline {
//     private String dueDate;

//     public Deadline(String dueDate) {
//         this.dueDate = dueDate;
//     }

//     public String getDueDate() {
//         return dueDate;
//     }

//     public void setDueDate() {

//     }
// }

// class Milestone {
//     private String milestoneName;
//     private Vector<Task> task = new Vector<>();

//     public Milestone(String milestoneName) {
//         this.milestoneName = milestoneName;
//     }

//     public String getMilestoneName() {
//         return milestoneName;
//     }

<<<<<<< HEAD
    void addTask(Task t) {
        task.add(t);
    }
}
=======
//     void addTask(Task t) {
//         task.add(t);
//     }

//     public void printTask() {
//         for (int i = 0; i < task.size(); i++) {
//             System.out.println(task.get(i));
//         }
//     }
// }
>>>>>>> 0a70781d68299d93b7c4ccce252a03fb53c41153



// class Report {
//     private String reportID;
//     private String content;
//     private Project project;
    

//     public Report(String reportID, String content, Project project) {
//         this.reportID = reportID;
//         this.content = content;
//         this.project = project;
//     }

//     public String getReportID() {
//         return reportID;
//     }

//     public String getContent() {
//         return content;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public void setReportID(String reportID) {
//         this.reportID = reportID;
//     }

//     public Project getProject() {
//         return project;
//     }
// }

// class Review {
//     private String reviewerName;
//     private String feedback;
//     private Report report;

//     public Review(String reviewerName, String feedback, Report report) {
//         this.reviewerName = reviewerName;
//         this.feedback = feedback;
//         this.report = report;
//     }

//     public String getReviewName() {
//         return reviewerName;
//     }

//     public String getFeedback() {
//         return feedback;
//     }

//     public Report getReport() {
//         return report;
//     }
// }

public class GroupProjectManager {
    public static void main(String[] args) {
        User std1 = new Student("Kugen", "kugen@graduate.utm.my", "A22EC0178", "Project Manager");
        std1.display();
    }
}
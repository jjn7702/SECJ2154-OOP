<<<<<<< Updated upstream
import java.util.Vector;

class Task {
    private int taskID;
    private String taskName;
    private String status;
    private Deadline deadline;
    private Vector<Student> tek; // test

    public Task(int taskID, String taskName, String status) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.status = status;
        tek = new Vector<>(); //test
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
=======
public class Task {
    private String name;
    private Deadline deadline;
    private String status;

    public Task(String name, Deadline deadline) {
        this.name = name;
        this.deadline = deadline;
        this.status = "No progress";
    }

    public String getName() { 
        return name;
>>>>>>> Stashed changes
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline d) {
        deadline = d;
    }

<<<<<<< Updated upstream
    
    public void removeTask(Task t) { //test
        tek.remove(t);
    }
}
=======
    public String getStatus() {
        return status;
    }

    //This setter's parameter is int because it will ask the user's input 
    //based on the number they chose on the list of actions in main.
    public void setStatus(int intStatus) {
        if(intStatus == 1) 
            status = "Completed"; 
        else 
            if(intStatus == 2) 
                status = "In progress"; 
    }
}
>>>>>>> Stashed changes

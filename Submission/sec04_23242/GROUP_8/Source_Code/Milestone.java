import java.util.*;

public class Milestone {
    private String milestoneID;
    private String milestoneName;
    private String milestoneDescription;

    private Deadline deadline;
    private ArrayList<Task> task;

    public Milestone(String milestoneID, String milestoneName, String milestoneDescription, Deadline deadline) {
        this.milestoneID = milestoneID;
        this.milestoneName = milestoneName;
        this.milestoneDescription = milestoneDescription;
        this.deadline = deadline;
        this.task = new ArrayList<>();
    }

    //Basic Getter
    public String getMilestoneID() {
        return milestoneID;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public String getMilestoneDescription() {
        return milestoneDescription;
    }
    //------------

    //Basic Setter
    public void setMilestoneID(String sID) {
        milestoneID = sID;
    }

    public void setMilestoneName(String n) {
        milestoneName = n;
    }

    public void setMilestoneDescription(String d) {
        milestoneDescription = d;
    }
    //-------------

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline d) {
        deadline = d;
    }

    public List<Task> getTask() {
        return task;
    }

    public void addTask(Task t) {
        task.add(t);
    }

    public void removeTask(Task t) {
        task.remove(t);
    }
}
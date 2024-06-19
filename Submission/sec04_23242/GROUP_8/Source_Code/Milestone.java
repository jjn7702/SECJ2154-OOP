import java.util.*;

public class Milestone {
    private String id;
    private String name;
    private String description;
    private Deadline deadline;
    private ArrayList<Task> task;

    public Milestone(String id, String name, String description, Deadline deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.task = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

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
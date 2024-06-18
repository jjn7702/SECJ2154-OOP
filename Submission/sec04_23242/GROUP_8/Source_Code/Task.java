class Task {
    private int taskID;
    private String taskName;
    private String status;
    private Deadline deadline;

    public Task(int taskID, String taskName, String status) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }
}

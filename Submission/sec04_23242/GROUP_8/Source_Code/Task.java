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
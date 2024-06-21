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
    }

    public void setName(String n) {
        name = n;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline d) {
        deadline = d;
    }

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
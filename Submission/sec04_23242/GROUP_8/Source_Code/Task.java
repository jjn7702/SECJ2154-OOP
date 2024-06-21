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
    public void setStatus(String intStatus) {
        switch (intStatus) {
            case "1":
                status = "Completed"; 
            
            case "2": 
                status = "In Progress";

            case "":
                System.out.println("Skipping task status edit.");

            default:
                System.out.println("Invalid input. Task status unchanged");
        }
    }
}

//     public void setStatus(String s) {
//         status = s;
//     }
// }
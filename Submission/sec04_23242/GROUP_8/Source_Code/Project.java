 import java.util.*;
 
 class Project {
    private int projectID;
    private String title;
    private String  description;
    private Vector<Task>task;
    private Report rep;

    public Project(int id,String title,String desc,Report rep)
    {
        projectID=id;
        this.title=title;
        description=desc;
        task = new Vector<>();
        this.rep=rep;

    }

    public int getProjectID()
    {
        return projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void addTask(Task t)
    {
        task.add(t);
    }

    public void removeTask(Task t)
    {
        task.remove(t);
    }

    

    
}

class Milestone {
    private String milestoneName;
    private Vector<Task> task = new Vector<>();

    public Milestone(String milestoneName) {
        this.milestoneName = milestoneName;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    void addTask(Task t) {
        task.add(t);
    }

    public void printTask() {
        for (int i = 0; i < task.size(); i++) {
            System.out.println(task.get(i));
        }
    }
}
class Position {
    private int positionID;
    private String title;
    private String responsibilities;

    public Position(int positionID, String title, String responsibilities) {
        this.positionID = positionID;
        this.title = title;
        this.responsibilities = responsibilities;
    }

    public void displayPositionInfo() {
        System.out.println("Position ID: " + positionID);
        System.out.println("Title: " + title);
        System.out.println("Responsibilities: " + responsibilities);
    }

    public int getPositionID() {
        return positionID;
    }

    public String getTitle() {
        return title;
    }
}
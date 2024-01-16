class Position {
    private int positionID;
    private String title;

    public Position(int positionID, String title) {
        this.positionID = positionID;
        this.title = title;
    }

    public void displayPositionInfo() {
        System.out.println("Position ID: " + positionID);
        System.out.println("Title: " + title);
    }

    public int getPositionID() {
        return positionID;
    }

    public String getTitle() {
        return title;
    }
}
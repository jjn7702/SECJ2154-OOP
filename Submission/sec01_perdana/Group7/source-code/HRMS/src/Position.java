class Position {
    private int positionID;
    private String title;
    private String responsibilities;

    public Position(int pID, String t, String respons) {
        this.positionID = pID;
        this.title = t;
        this.responsibilities = respons;
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

    public String getResponsibilities(){
        return responsibilities;
    }
}
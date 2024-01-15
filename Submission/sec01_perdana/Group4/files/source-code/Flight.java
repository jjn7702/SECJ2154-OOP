public class Flight extends SkyInfo{
    private String origin;
    private String destination;
    private String boardingTime;

    public Flight(String origin, String destination, String boardingTime) {
        super("Flight");
        this.origin = origin;
        this.destination = destination;
        this.boardingTime = boardingTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }
}

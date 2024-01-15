class Seat extends SkyInfo {
    private String seatName;

    public Seat(String seatName) {
        super("Seat");
        this.seatName = seatName;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}
class Ticket extends SkyInfo {
    private int ticketNumber;

    public Ticket(int ticketNumber) {
        super("Ticket");
        this.ticketNumber = ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}

public class Bill {
	private static int lastBillID = 0;
    private String billID;
    private double amount;
    private Appointment appointment;

    public Bill(String billID, double amount, Appointment appointment) {
		lastBillID++;
        this.billID = "B00" + lastBillID;
        this.amount = amount;
        this.appointment = appointment;
    }

    public String getBillID() {
        return billID;
    }

    public double getAmount() {
        return amount;
    }

}
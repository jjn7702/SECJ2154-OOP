public class Bill {
    private String billID;
    private double amount;
    private Appointment appointment;

    public Bill(String billID, double amount, Appointment appointment) {
        this.billID = billID;
        this.amount = amount;
        this.appointment = appointment;
    }

    public String getBillID() {
        return billID;
    }

    public double getAmount() {
        return amount;
    }

    public void displayInfo(){
		System.out.println("\nBill ID	\t: " + billID);
     	System.out.println("Bill Amount\t: RM" + amount);
	}



}
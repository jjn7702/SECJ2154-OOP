public class Payment {
    private String paymentMethod;
    private double amount;
    private String paymentStatus;

    public Payment(String paymentMethod, double amount, String paymentStatus) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String isPaid() {
        return paymentStatus;
    }
}

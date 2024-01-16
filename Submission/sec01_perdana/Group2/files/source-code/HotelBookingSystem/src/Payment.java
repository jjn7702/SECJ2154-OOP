// Encapsulation: The class represents payment information, encapsulating related data.
public class Payment {
    
    // Encapsulation: Private fields to store payment information.
    private String paymentMethod;
    private double amount;

    // Encapsulation and Constructor: Initializes a Payment object with provided information during object creation.
    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    // Getter methods: Provide access to the private fields, following encapsulation principles.
    public String getPaymentType() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    // Setter methods: Allow modification of private fields, following encapsulation principles.
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

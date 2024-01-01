public class RoomPrice {
    private double basePrice;
    private double additionalCharge;

    public RoomPrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public RoomPrice(double basePrice, double additionalCharge) {
        this.basePrice = basePrice;
        this.additionalCharge = additionalCharge;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }

    public double calculateTotalPrice(int numberOfDays) {
        // Calculate the total price based on the base price, additional charge, and number of days
        return basePrice + (additionalCharge * numberOfDays);
    }

    public double getRatePerDay() {
        return basePrice + additionalCharge;
    }
}

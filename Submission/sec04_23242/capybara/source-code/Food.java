public class Food extends Item {
    private String expirationDate; // expirationDate for Packet Food // Fruit, Lunch meal, Breakfast, Dinner, //
                                   // Packet food
    private boolean isVegetarian;

    public Food(String n, int q, double p, String e, Boolean t) {
        super(n, q, p);
        expirationDate = e;
        isVegetarian = t;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void addQuantity(int amount) {
        if (amount > 0) {
            setQuantity(getQuantity() + amount);
            System.out.println("Added " + amount + " " + getName() + ". Total quantity now: " + getQuantity());
        } else {
            System.out.println("Invalid quantity. Please enter a positive number.");
        }
    }
}

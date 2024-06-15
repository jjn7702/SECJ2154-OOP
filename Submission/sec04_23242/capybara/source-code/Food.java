public class Food extends Item {
    private String expirationDate; // expirationDate for Packet Food
    private String type; //Fruit, Lunch meal, Breakfast, Dinner, Packet food 
    private boolean isVegetarian;

    public Food (String n, int q, double p, String d, String e, String t){
        super(n,q,p,d);
        expirationDate = e;
        type = t;
    }

    public String getExpirationDate() {
        if(type == "Packet Food")
            return expirationDate;
        else 
            return "None";
    }

    public String getType() {
        return type;
    }

    public boolean isVegetarian() {
        return isVegetarian;
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


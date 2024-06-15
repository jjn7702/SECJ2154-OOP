class Item {
    private String name;
    private int quantity;
    private double price;
    private String description;// description about the Item

    public Item() {
    }

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() { // description of Item
        return description;
    }

    public double calcTotalCost() { // calculate price of any item
        return price * quantity;
    }
}
interface Taxable {
    double FOOD_TAX = 0.08;
    double SHOP_TAX = 0.1;
    double calculateTax(double amount);
}

abstract class Category implements Taxable {
    private int id;
    private String name, description;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String getCategoryType();
}

class ShoppingCategory extends Category {
    public ShoppingCategory(int id) {
        super(id, "Shopping", "Shopping Transaction");
    }

    public String getCategoryType() {
        return "Shopping";
    }

    public double calculateTax(double amount) {
        return amount * SHOP_TAX;
    }
}

class FoodCategory extends Category {
    public FoodCategory(int id) {
        super(id, "Food", "Food Transaction");
    }

    public String getCategoryType() {
        return "Food";
    }

    public double calculateTax(double amount) {
        return amount * FOOD_TAX;
    }
}

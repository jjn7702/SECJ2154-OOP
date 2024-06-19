class Category {
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
}

class ShoppingCategory extends Category {
    public ShoppingCategory(int id) {
        super(id, "Shopping", "Shopping Transaction");
    }
}

class FoodCategory extends Category {
    public FoodCategory(int id) {
        super(id, "Food", "Food Transaction");
    }
}

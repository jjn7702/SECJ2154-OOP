package GroupProject;

public enum FoodItemEnum {
    // Breakfast items
    APPLE("Apple", 52),
    BANANA("Banana", 89),
    ORANGE("Orange", 62),
    OATMEAL("Oatmeal", 150),
    PANCAKES("Pancakes", 175),
    SCRAMBLED_EGGS("Scrambled Eggs", 140),
    BACON("Bacon", 42),
    TOAST("Toast", 75),
    YOGURT("Yogurt", 100),
    GRANOLA("Granola", 200),
    SMOOTHIE("Smoothie", 250),
    
    // Lunch items
    NOODLES("Noodles", 200),
    SHRIMP("Shrimp", 100),
    MCHICKEN("McChicken", 450),
    FRIED_RICE("FriedRice", 330),
    NASI_LEMAK("NasiLemak", 280),
    PASTA("Pasta", 300),
    SALAD("Salad", 150),
    SANDWICH("Sandwich", 250),
    BURGER("Burger", 500),
    SUSHI("Sushi", 200),
    SOUP("Soup", 150),
    
    // Dinner items
    ZAPFAN("Zapfan", 313),
    STEAK("Steak", 679),
    GRILLED_CHICKEN("Grilled Chicken", 335),
    PIZZA("Pizza", 285),
    TACO("Taco", 200),
    SPAGHETTI("Spaghetti", 220),
    ROAST_BEEF("Roast Beef", 250),
    STIR_FRY("Stir Fry", 400),
    LASAGNA("Lasagna", 350),
    BBQ_RIBS("BBQ Ribs", 400),
    
    // Snacks
    CHOCOLATE_BAR("Chocolate Bar", 210),
    CHIPS("Chips", 152),
    NUTS("Nuts", 175),
    FRUIT_SALAD("Fruit Salad", 120),
    GRANOLA_BAR("Granola Bar", 150),
    COOKIES("Cookies", 160),
    ICE_CREAM("Ice Cream", 137),
    POPCORN("Popcorn", 55),
    CHEESE("Cheese", 113),
    TRAIL_MIX("Trail Mix", 200);

    private String name;
    private int calories;

    FoodItemEnum(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public static Integer getCaloriesByName(String name) {
        for (FoodItemEnum item : FoodItemEnum.values()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getCalories();
            }
        }
        return null; // Food item not found
    }
}

package GroupProject;

import java.util.ArrayList;

public class Meal {
    private String type;
    private String date;
    private ArrayList<FoodItem> foodItems;

    public Meal(String type, String date) {
        this.type = type;
        this.date = date;
        this.foodItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public int getCalories() {
        int totalCalories = 0;
        for (FoodItem item : foodItems) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    public void displayMealDetails() {
        System.out.println("Meal: " + type);
        System.out.println("Date: " + date);
        for (FoodItem item : foodItems) {
            System.out.println(" - " + item.getName() + ": " + item.getCalories() + " calories");
        }
    }
}

package GroupProject;

import java.util.ArrayList;

public class NutritionTracker {
    private ArrayList<Meal> meals;

    public NutritionTracker() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public int calculateTotalCalories() {
        int totalCalories = 0;
        for (Meal meal : meals) {
            totalCalories += meal.getCalories();
        }
        return totalCalories;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }
}

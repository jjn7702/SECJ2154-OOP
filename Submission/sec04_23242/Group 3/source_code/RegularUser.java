package GroupProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RegularUser extends User {
    private ArrayList<Meal> meals;

    public RegularUser(String username, String password) {
        super(username, password);
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void viewMeals() {
        if (meals.isEmpty()) {
            System.out.println("No meals found for user: " + this.getUsername());
        } else {
            // Group meals by date
            Map<String, ArrayList<Meal>> mealsByDate = new HashMap<>();
            for (Meal meal : meals) {
                mealsByDate.computeIfAbsent(meal.getDate(), k -> new ArrayList<>()).add(meal);
            }

            // Display meals by date
            for (String date : mealsByDate.keySet()) {
                System.out.println("Date: " + date + "\n");
                for (Meal meal : mealsByDate.get(date)) {
                    System.out.println("Meal: " + meal.getType());
                    for (FoodItem item : meal.getFoodItems()) {
                        System.out.println(" - " + item.getName() + ": " + item.getCalories() + " calories");
                    }
                    System.out.println(); // Add a newline for better readability
                }
            }
        }
    }

    public ArrayList<Meal> getMealsByDate(String date) {
        return meals.stream()
                .filter(meal -> meal.getDate().equals(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void editMeal(String date, String mealType, Meal newMeal) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getDate().equals(date) && meals.get(i).getType().equals(mealType)) {
                meals.set(i, newMeal);
                return;
            }
        }
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void displayOptions() {
        System.out.println("1. Add Meal");
        System.out.println("2. View Meals");
        System.out.println("3. Edit Meal");
    }
}
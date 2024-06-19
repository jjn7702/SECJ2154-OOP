package GroupProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class NutritionTracker {
    private ArrayList<Meal> meals;

    public NutritionTracker() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void editMeal(String date, String mealType, Meal newMeal) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getDate().equals(date) && meals.get(i).getType().equals(mealType)) {
                meals.set(i, newMeal);
                return;
            }
        }
    }

    public ArrayList<Meal> getMealsByDate(String date) {
        return meals.stream()
                .filter(meal -> meal.getDate().equals(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void viewMeals(RegularUser user) {
        if (meals.isEmpty()) {
            System.out.println("No meals found for user: " + user.getUsername());
        } else {
            // Calculate recommended calorie intake
            int recommendedCalories = (int) user.calculateRecommendedCalories();
            double bmi = user.calculateBMI();

            // Display user information
            System.out.println("+-------------------+");
            System.out.println("| User Info         |");
            System.out.println("+-------------------+");
            System.out.printf("| Name: %-11s |\n", user.getUsername());
            System.out.printf("| Age : %-11d |\n", user.getAge());
            System.out.printf("| BMI : %-11.2f |\n", bmi);
            System.out.println("+-------------------+\n");

            // Group meals by date
            Map<String, ArrayList<Meal>> mealsByDate = new HashMap<>();
            for (Meal meal : meals) {
                mealsByDate.computeIfAbsent(meal.getDate(), k -> new ArrayList<>()).add(meal);
            }

            // Sort the dates
            ArrayList<String> sortedDates = new ArrayList<>(mealsByDate.keySet());
            Collections.sort(sortedDates);

            // Display meals in table format
            System.out.println("+------------+------------+----------------------+----------+");
            System.out.println("| Date       | Meal Type  | Food Item            | Calories |");
            System.out.println("+------------+------------+----------------------+----------+");

            for (String date : sortedDates) {
                int dailyCalories = 0;
                boolean firstEntry = true;
                String lastMealType = "";
                for (Meal meal : mealsByDate.get(date)) {
                    for (FoodItem item : meal.getFoodItems()) {
                        if (firstEntry) {
                            System.out.printf("| %-10s | %-10s | %-20s | %-8d |%n",
                                date, meal.getType(), item.getName(), item.getCalories());
                            firstEntry = false;
                            lastMealType = meal.getType();
                        } else {
                            String mealTypeDisplay = meal.getType().equals(lastMealType) ? "" : meal.getType();
                            System.out.printf("| %-10s | %-10s | %-20s | %-8d |%n",
                                "", mealTypeDisplay, item.getName(), item.getCalories());
                            lastMealType = meal.getType();
                        }
                        dailyCalories += item.getCalories();
                    }
                }
                // Display daily total and recommended calorie intake
                System.out.println("+------------+------------+----------------------+----------+");
                System.out.printf("| %-10s | %-10s | %-20s | %-8d |%n", 
                    date, "Total", "", dailyCalories);
                System.out.printf("| %-10s | %-10s | %-20s | %-8d |%n", 
                    date, "Recommend", "", recommendedCalories);
                if (dailyCalories > recommendedCalories) {
                    System.out.printf("| %-10s | %-10s | %-20s | %-8s |%n", 
                        date, "Status", "", "Exceeded");
                } else {
                    System.out.printf("| %-10s | %-10s | %-20s | %-8s |%n", 
                        date, "Status", "", "Under");
                }
                System.out.println("+------------+------------+----------------------+----------+");
            }
        }
    }
}

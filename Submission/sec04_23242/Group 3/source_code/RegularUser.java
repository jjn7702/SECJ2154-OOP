package GroupProject;

import java.util.ArrayList;

public class RegularUser extends User {
    private int age;
    private String gender;
    private double weight;
    private double height;
    private NutritionTracker nutritionTracker;

    public RegularUser(String username, String password, int age, String gender, double weight, double height) {
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.nutritionTracker = new NutritionTracker();
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double calculateBMI() {
        return weight / ((height / 100) * (height / 100));
    }

    public void addMeal(Meal meal) {
        nutritionTracker.addMeal(meal);
    }

    public void viewMeals() {
        nutritionTracker.viewMeals(this);
    }

    public void editMeal(String date, String mealType, Meal newMeal) {
        nutritionTracker.editMeal(date, mealType, newMeal);
    }

    public ArrayList<Meal> getMealsByDate(String date) {
        return nutritionTracker.getMealsByDate(date);
    }

    public ArrayList<Meal> getMeals() {
        return nutritionTracker.getMeals();
    }

    public void displayOptions() {
        System.out.println("1. Add Meal");
        System.out.println("2. View Meals");
        System.out.println("3. Edit Meal");
    }
    
    public double calculateRecommendedCalories() {
        // Harris-Benedict Equation to calculate Basal Metabolic Rate (BMR)
        double bmr;
        if (gender.equalsIgnoreCase("male")) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
        // Assuming a sedentary activity level (BMR * 1.2)
        return bmr * 1.2;
    }
}

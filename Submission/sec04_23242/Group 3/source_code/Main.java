package GroupProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        DatabaseManager dbManager = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);
        pauseForUserInput();
        while (true) {
            clearConsole();
            System.out.println("1. Admin Login");
            System.out.println("2. Regular User Login");
            System.out.println("3. Register");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (choice == 1) {
                adminLogin(dbManager, scanner);
            } else if (choice == 2) {
                userLogin(dbManager, scanner);
            } else if (choice == 3) {
                userRegister(dbManager, scanner);
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
                pauseForUserInput();
            }
        }

        scanner.close();
    }

    private static void adminLogin(DatabaseManager dbManager, Scanner scanner) {
        clearConsole();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Admin admin : dbManager.getAdmins()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("Admin login successful!");
                pauseForUserInput();
                adminOptions(admin, dbManager, scanner);
                return;
            }
        }
        System.out.println("Invalid admin credentials!");
        pauseForUserInput();
    }

    private static void userLogin(DatabaseManager dbManager, Scanner scanner) {
        clearConsole();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (RegularUser user : dbManager.getRegularUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User login successful!");
                pauseForUserInput();
                userOptions(user, dbManager, scanner);
                return;
            }
        }
        System.out.println("Invalid user credentials!");
        pauseForUserInput();
    }

    private static void userRegister(DatabaseManager dbManager, Scanner scanner) {
        clearConsole();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            pauseForUserInput();
            return;
        }

        RegularUser newUser = new RegularUser(username, password);
        dbManager.addRegularUser(newUser);
        dbManager.saveRegularUsers(); // Save the new user to the file
        System.out.println("User registration successful!");
        pauseForUserInput();
    }

    private static void adminOptions(Admin admin, DatabaseManager dbManager, Scanner scanner) {
        while (true) {
            clearConsole();
            admin.displayOptions();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                clearConsole();
                admin.viewAllMeals(dbManager);
                pauseForUserInput();
            } else if (choice == 2) {
                clearConsole();
                admin.displayUserList(dbManager);
                pauseForUserInput();
            } else if (choice == 3) {
                clearConsole();
                System.out.print("Enter username to delete: ");
                String usernameToDelete = scanner.nextLine();
                admin.deleteRegularUser(dbManager, usernameToDelete);
                System.out.println("User deleted successfully!");
                pauseForUserInput();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
                pauseForUserInput();
            }
        }
    }

    private static void userOptions(RegularUser user, DatabaseManager dbManager, Scanner scanner) {
        while (true) {
            clearConsole();
            System.out.println("1. Enter Meal");
            System.out.println("2. View Meals");
            System.out.println("3. Edit Meal");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                clearConsole();
                System.out.print("Enter meal type (Breakfast/Lunch/Dinner/Snack): ");
                String mealType = scanner.nextLine();
                System.out.print("Enter meal date: ");
                String mealDate = scanner.nextLine();
                Meal meal = new Meal(mealType, mealDate);
                
                // Loop to enter multiple food items
                while (true) {
                    System.out.print("Enter food item name (or type 'done' to finish): ");
                    String foodName = scanner.nextLine();
                    if (foodName.equalsIgnoreCase("done")) {
                        break;
                    }
                    System.out.print("Enter calories for " + foodName + ": ");
                    int calories = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    meal.addFoodItem(new FoodItem(foodName, calories));
                }
                
                user.addMeal(meal);
                dbManager.saveMeals();
                System.out.println("Meal added successfully!");
                pauseForUserInput();
            } else if (choice == 2) {
                clearConsole();
                user.viewMeals();
                pauseForUserInput();
            } else if (choice == 3) {
                clearConsole();
                System.out.print("Enter the date of the meal you want to edit (yyyy-mm-dd): ");
                String mealDateToEdit = scanner.nextLine();
                ArrayList<Meal> mealsOnDate = user.getMealsByDate(mealDateToEdit);

                if (mealsOnDate.isEmpty()) {
                    System.out.println("No meals found for the specified date.");
                } else {
                    System.out.println("Meals on " + mealDateToEdit + ":");
                    for (Meal meal : mealsOnDate) {
                        meal.displayMealDetails();
                    }
                    System.out.print("Enter the meal type to edit: ");
                    String mealTypeToEdit = scanner.nextLine();
                    Meal mealToEdit = mealsOnDate.stream()
                            .filter(meal -> meal.getType().equals(mealTypeToEdit))
                            .findFirst()
                            .orElse(null);

                    if (mealToEdit == null) {
                        System.out.println("No meal found with the specified type.");
                    } else {
                        System.out.print("Enter new meal type (Breakfast/Lunch/Dinner/Snack): ");
                        String newMealType = scanner.nextLine();
                        System.out.print("Enter new meal date: ");
                        String newMealDate = scanner.nextLine();
                        Meal newMeal = new Meal(newMealType, newMealDate);
                        
                        // Loop to enter multiple food items
                        while (true) {
                            System.out.print("Enter food item name (or type 'done' to finish): ");
                            String foodName = scanner.nextLine();
                            if (foodName.equalsIgnoreCase("done")) {
                                break;
                            }
                            System.out.print("Enter calories for " + foodName + ": ");
                            int calories = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            newMeal.addFoodItem(new FoodItem(foodName, calories));
                        }
                        
                        user.editMeal(mealDateToEdit, mealTypeToEdit, newMeal);
                        dbManager.saveMeals();
                        System.out.println("Meal edited successfully!");
                    }
                }
                pauseForUserInput();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice!");
                pauseForUserInput();
            }
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pauseForUserInput() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

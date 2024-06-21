package GroupProject;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void viewFoodItems() {
        String leftAlignFormat = "| %-20s | %-8d |%n";
        
        System.out.println("+----------------------+----------+");
        System.out.println("| Food Item            | Calories |");
        System.out.println("+----------------------+----------+");

        for (FoodItemEnum foodItem : FoodItemEnum.values()) {
            System.out.printf(leftAlignFormat, foodItem.getName(), foodItem.getCalories());
        }

        System.out.println("+----------------------+----------+");
    }

    public void deleteRegularUser(DatabaseManager dbManager, String username) {
        boolean userDeleted = dbManager.deleteRegularUser(username);
        if (userDeleted) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    public void displayUserList(DatabaseManager dbManager) {
        System.out.println("---- List of existing users ----\n");
        for (RegularUser user : dbManager.getRegularUsers()) {
            System.out.println("- " + user.getUsername());
        }
    }

    public void displayOptions() {
        System.out.println("       A D M I N   M E N U   ");
        System.out.println("+----------------------+----------+\n");
        System.out.println("1. View Food Items");
        System.out.println("2. View User List");
        System.out.println("3. Delete Regular User");
        System.out.println("4. Logout");
    }
}
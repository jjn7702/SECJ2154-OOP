package GroupProject;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void viewAllMeals(DatabaseManager dbManager) {
        for (RegularUser user : dbManager.getRegularUsers()) {
            System.out.println("Meals for user: " + user.getUsername());
            user.viewMeals();
        }
    }

    public void deleteRegularUser(DatabaseManager dbManager, String username) {
        dbManager.deleteRegularUser(username);
    }

    public void displayUserList(DatabaseManager dbManager) {
        System.out.println("List of existing users:");
        for (RegularUser user : dbManager.getRegularUsers()) {
            System.out.println("- " + user.getUsername());
        }
    }

    public void displayOptions() {
        System.out.println("1. View All Meals");
        System.out.println("2. View User List");
        System.out.println("3. Delete Regular User");
        System.out.println("4. Logout");
    }
}
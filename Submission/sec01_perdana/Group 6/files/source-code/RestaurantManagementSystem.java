import java.util.*;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        try {
            Restaurant restaurant = new Restaurant();
            Scanner scanner = new Scanner(System.in);

            MenuItem item1 = new MenuItem("Burger", 8.99);
            MenuItem item2 = new MenuItem("Pizza", 12.99);
            MenuItem item3 = new MenuItem("Spaghetti Carbonara", 15.20);
            SpecialMenuItem item4 = new SpecialMenuItem("Fried Rice", 8, "No onions");
            MenuItem item5 = new MenuItem("Steak", 27.89);
            MenuItem item6 = new MenuItem("Mushroom Soup", 5);
            MenuItem item7 = new MenuItem("Garlic Bread", 3);

            restaurant.addMenuItem(item1);
            restaurant.addMenuItem(item2);
            restaurant.addMenuItem(item3);
            restaurant.addMenuItem(item4);
            restaurant.addMenuItem(item5);
            restaurant.addMenuItem(item6);
            restaurant.addMenuItem(item7);

            Table table1 = new Table(1);
            Table table2 = new Table(2);
            Table table3 = new Table(3);
            Table table4 = new Table(4);
            Table table5 = new Table(5);

            restaurant.addTable(table1);
            restaurant.addTable(table2);
            restaurant.addTable(table3);
            restaurant.addTable(table4);
            restaurant.addTable(table5);

            System.out.println("================================================================");
            System.out.println("\t\tWelcome to our Restaurant");
            System.out.println("================================================================");
            System.out.println("\nMenu Items:");
            List<FoodItem> menuItems = restaurant.getMenu().getItems();
            for (int i = 0; i < menuItems.size(); i++) {
                FoodItem menuItem = menuItems.get(i);
                System.out.printf("%d. %-25s RM%.2f\n", (i + 1), menuItem.getName(), menuItem.getPrice());
            }

            System.out.print("\nEnter table number (1-5): ");
            int tableNumber = getValidTableNumber(scanner);

            Table selectedTable = restaurant.getTables().stream()
                    .filter(table -> table.getTableNumber() == tableNumber)
                    .findFirst()
                    .orElse(null);

            if (selectedTable != null) {
                boolean addAnotherOrder = true;
                while (addAnotherOrder) {
                    Customer customer = new Customer("Ahmad");
                    Order order = new Order(customer);

                    System.out.print("\nEnter the item number to order: ");
                    int itemNumber = getValidMenuItemNumber(scanner, restaurant.getMenu().getItems().size());
                    System.out.print("Enter the quantity: ");
                    int quantity = getValidQuantity(scanner);

                    FoodItem selectedFoodItem = restaurant.getMenu().getItems().get(itemNumber - 1);
                    order.addItem(selectedFoodItem, quantity);

                    selectedTable.placeOrder(order);

                    System.out.println("\nTable " + tableNumber + " Order:");
                    List<FoodItem> tableOrderItems = selectedTable.getCurrentOrder().getItems();
                    for (FoodItem tableOrderItem : tableOrderItems) {
                        if (tableOrderItem instanceof SpecialMenuItem) {
                            SpecialMenuItem specialItem = (SpecialMenuItem) tableOrderItem;
                            System.out.printf("%-25s RM%.2f (Special Instruction: %s)\n",
                                    specialItem.getName(), specialItem.getPrice(), specialItem.getSpecialInstruction());
                        } else {
                            System.out.printf("%-25s RM%.2f\n", tableOrderItem.getName(), tableOrderItem.getPrice());
                        }
                    }

                    System.out.printf("Total Price: RM%.2f\n", selectedTable.getCurrentOrder().getTotalPrice());

                    System.out.print("\nDo you want to add another order? (yes/no): ");
                    addAnotherOrder = getValidYesNoResponse(scanner);
                }
            } else {
                System.out.println("\nInvalid table number.");
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class RestaurantManagementSystem {

    public static void main(String[] args) {
        try {
            Restaurant restaurant = new Restaurant();
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;

            FoodItem item1 = new FoodItem("Burger", 8.99);
            FoodItem item2 = new FoodItem("Pizza", 12.99);
            FoodItem item3 = new FoodItem("Spaghetti Carbonara", 15.20);
            SpecialMenuItem item4 = new SpecialMenuItem("Fried Rice", 8, "No onions");
            FoodItem item5 = new FoodItem("Steak", 27.89);
            FoodItem item6 = new FoodItem("Mushroom Soup", 5);
            FoodItem item7 = new FoodItem("Garlic Bread", 3);

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

            do {
                System.out.println("================================================================");
                System.out.println("||                   Welcome to our Restaurant                ||");
                System.out.println("================================================================");
                System.out.println("|| Options:                                                   ||");
                System.out.println("|| 1. Display All Menu Items                                  ||");
                System.out.println("|| 2. Place Order                                             ||");
                System.out.println("|| 3. Make Reservation                                        ||");
                System.out.println("|| 4. Exit                                                    ||");
                System.out.println("================================================================");
                System.out.print("\nEnter your choice (1, 2, 3, or 4): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        displayAllMenuItems(restaurant);
                        break;
                    case 2:
                        handleOrder(restaurant, scanner);
                        break;
                    case 3:
                        handleReservation(restaurant, scanner);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Exiting the Restaurant Management System. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (!exit);

            scanner.close();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayAllMenuItems(Restaurant restaurant) {
        Scanner scanner = restaurant.getScanner();
        int backOption;

        do {
            System.out.println("======================================");
            System.out.println("All Menu Items:");
            List<FoodItem> menuItems = restaurant.getMenu().getItems();
            for (int i = 0; i < menuItems.size(); i++) {
                FoodItem menuItem = menuItems.get(i);
                System.out.printf("%d. %-25s RM%.2f\n", (i + 1), menuItem.getName(), menuItem.getPrice());
            }

            // Add an option to go back
            System.out.print("\nPress 0 to go back to the main menu: ");
            backOption = scanner.nextInt();

            // Consume the newline character left in the buffer
            scanner.nextLine();

            if (backOption == 0) {
                System.out.println("Going back to the main menu.");
            } else {
                System.out.println("Invalid option. Please enter 0 to go back to the main menu.");
            }
        } while (backOption != 0);
    }

    private static void handleOrder(Restaurant restaurant, Scanner scanner) {

        System.out.print("Enter table number (1-5): ");
        int tableNumber = getValidTableNumber(scanner);

        Table selectedTable = restaurant.getTables().stream()
                .filter(table -> table.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);

        if (selectedTable != null) {
            boolean addAnotherOrder = true;
            double totalOrderPrice = 0.0;

            // Create a copy of the original menu to use for subsequent orders
            List<FoodItem> originalMenu = new ArrayList<>(restaurant.getMenu().getItems());

            while (addAnotherOrder) {
                Customer customer = new Customer("Ahmad");
                Order order = new Order(customer);

                if (totalOrderPrice > 0.0) {
                    System.out.println("\nPrevious Order Total Price: RM" + totalOrderPrice);
                }
                System.out.println("================================================================");
                System.out.println("Menu Items:");
                for (int i = 0; i < originalMenu.size(); i++) {
                    FoodItem menuItem = originalMenu.get(i);
                    System.out.printf("%d. %-25s RM%.2f\n", (i + 1), menuItem.getName(), menuItem.getPrice());
                }

                System.out.print("\nEnter the item number to order: ");
                int itemNumber = getValidMenuItemNumber(scanner, originalMenu.size());
                System.out.print("Enter the quantity: ");
                int quantity = getValidQuantity(scanner);

                FoodItem selectedFoodItem = originalMenu.get(itemNumber - 1);
                order.addItem(selectedFoodItem, quantity);

                selectedTable.placeOrder(order);
                totalOrderPrice += selectedTable.getCurrentOrder().getTotalPrice();

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

                System.out.printf("Total Price: RM%.2f\n", totalOrderPrice);

                System.out.print("\nDo you want to add another order? (yes/no): ");
                addAnotherOrder = getValidYesNoResponse(scanner);
            }

            // Display receipt when the user decides not to add another order
            System.out.println("\nThank you for placing your order!");
            System.out.println("======================================");
            System.out.println("Receipt for Table " + tableNumber + ":");
            List<FoodItem> receiptItems = selectedTable.getCurrentOrder().getItems();
            for (FoodItem receiptItem : receiptItems) {
                if (receiptItem instanceof SpecialMenuItem) {
                    SpecialMenuItem specialItem = (SpecialMenuItem) receiptItem;
                    System.out.printf("%-25s RM%.2f (Special Instruction: %s)\n",
                            specialItem.getName(), specialItem.getPrice(), specialItem.getSpecialInstruction());
                } else {
                    System.out.printf("%-25s RM%.2f\n", receiptItem.getName(), receiptItem.getPrice());
                }
            }
            System.out.printf("Total Price: RM%.2f\n", totalOrderPrice);
        } else {
            System.out.println("\nInvalid table number.");
        }
    }

    private static void handleReservation(Restaurant restaurant, Scanner scanner) {
        System.out.print("Enter table number for reservation (1-5): ");
        int reservationTableNumber = getValidTableNumber(scanner);

        Table reservationTable = restaurant.getTables().stream()
                .filter(table -> table.getTableNumber() == reservationTableNumber)
                .findFirst()
                .orElse(null);

        if (reservationTable != null) {
            System.out.print("Enter reservation date and time (yyyy-MM-dd HH:mm): ");
            String dateString = scanner.next();
            String timeString = scanner.next();
            LocalDateTime reservationDateTime = LocalDateTime.parse(dateString + " " + timeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            if (restaurant.makeReservation(reservationTable, reservationDateTime)) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Table not available for the specified time.");
            }
        } else {
            System.out.println("Invalid table number for reservation.");
        }
    }

    private static int getValidTableNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a valid table number (1-5): ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int getValidMenuItemNumber(Scanner scanner, int menuSize) {
        while (true) {
            try {
                int menuItemNumber = scanner.nextInt();
                if (menuItemNumber >= 1 && menuItemNumber <= menuSize) {
                    return menuItemNumber;
                } else {
                    System.out.print("Invalid input. Please enter a valid item number: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a valid item number: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int getValidQuantity(Scanner scanner) {
        while (true) {
            try {
                int quantity = scanner.nextInt();
                if (quantity > 0) {
                    return quantity;
                } else {
                    System.out.print("Invalid input. Please enter a valid quantity: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a valid quantity: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static boolean getValidYesNoResponse(Scanner scanner) {
        while (true) {
            try {
                String response = scanner.next().toLowerCase();
                if (response.equals("yes") || response.equals("no")) {
                    return response.equals("yes");
                } else {
                    System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        try {
            Restaurant restaurant = new Restaurant();
            Scanner scanner = new Scanner(System.in);

            System.out.println("================================================================");
            System.out.println("\t\tWelcome to our Restaurant");
            System.out.println("================================================================");

            System.out.println("1. Place an Order");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1, 2, or 3): ");

            int choice = getValidChoice(scanner, 1, 3);

            switch (choice) {
                case 1:
                    placeOrder(restaurant, scanner);
                    break;
                case 2:
                    makeReservation(restaurant, scanner);
                    break;
                case 3:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting program.");
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Invalid input. Please enter a valid choice: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid choice: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void placeOrder(Restaurant restaurant, Scanner scanner) {
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
    }

    private static void makeReservation(Restaurant restaurant, Scanner scanner) {
        System.out.print("\nEnter the table number for reservation: ");
        int reservationTableNumber = getValidTableNumber(scanner);
        Table reservationTable = restaurant.getTables().stream()
                .filter(table -> table.getTableNumber() == reservationTableNumber)
                .findFirst()
                .orElse(null);

        if (reservationTable != null) {
            System.out.print("Enter the reservation date and time (yyyy-MM-dd HH:mm): ");
            String reservationDateTimeString = scanner.next() + " " + scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date reservationDateTime = dateFormat.parse(reservationDateTimeString);
                if (restaurant.makeReservation(reservationTable, reservationDateTime)) {
                    System.out.println("Reservation successful!");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date and time format. Please use yyyy-MM-dd HH:mm.");
            }
        } else {
            System.out.println("Invalid table number for reservation.");
        }
    }

    private static int getValidTableNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
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
            } catch (InputMismatchException e) {
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
            } catch (InputMismatchException e) {
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
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}

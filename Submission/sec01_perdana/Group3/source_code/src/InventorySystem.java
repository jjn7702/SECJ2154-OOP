import java.io.*;
import java.util.*;

public class InventorySystem {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice, userOption, userOptionSupplier;
        User user = new User();
        do{
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            header();

            System.out.println("\n\nRoles :\n\t1. Admin\n\t2. Customer\n\t3. Supplier");
            System.out.print("Enter your role (1-3) : ");
            choice = scan.nextInt();
            if(choice<1 || choice > 3){
                System.out.println("Invalid option entered. Please Try Again! Press any key to continue...");
                scan.nextLine();
                scan.nextLine();
            }
        }while(choice<1 || choice > 3);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        header();
        if (choice == 1 || choice == 3) {
            if (choice == 1) {
                do {
                    scan.nextLine();
                    System.out.print("\n\nEnter username : ");
                    String uName = scan.nextLine();
                    System.out.print("\nEnter password : ");
                    String pw = scan.nextLine();
                    user = User.login(uName, pw, choice);
                    if (user == null) {
                        System.out.println(
                                "Invalid Credentials Entered. Please Try Again!");
                    }
                } while (user == null);
                Book b = new Book();
                User realUser = new Admin(
                        user.getUserID(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getUserRole(),
                        user.getName().getfName(),
                        user.getName().getlName(),
                        b.getBooksfromFile());

                if (realUser.getUserRole() == 1) { // admin
                    // BookManager bkm = new BookManager();
                    do {
                        scan.nextLine();
                        userOption = realUser.viewMenu();
                        switch (userOption) {
                            case 1:
                                b.viewAllBooks(
                                        ((Admin) realUser).getBooks(),
                                        realUser.getUserRole());
                                break;
                            case 2:
                                // Order Book
                                b.viewAllBooks(
                                        ((Admin) realUser).getBooks(),
                                        realUser.getUserRole());
                                Vector<OrderManagement> orderListAdmin = new Vector<OrderManagement>();
                                OrderManagement orderrr = new OrderManagement();
                                orderListAdmin = orderrr.getOrderFromFile(user.getUserRole());
                                int n = orderListAdmin.size() + 1;
                                int orderQuantity = 0;
                                do {
                                    // System.out.print("How many book do u wanna Order:");
                                    // orderQuantity = scan.nextInt();
                                    try {
                                        System.out.print("How many books do you want to order: ");
                                        orderQuantity = scan.nextInt();
                                        if (orderQuantity < 0) {
                                            System.out.println("Please enter a non-negative number.");
                                        }
                                    } catch (java.util.InputMismatchException e) {
                                        System.out.println(
                                                "Invalid input. Please enter a valid integer."); // Consume the invalid
                                                                                                 // input to avoid an
                                                                                                 // infinite loop
                                        scan.nextLine();
                                        orderQuantity = -1;
                                    }
                                } while (orderQuantity < 0);
                                scan.nextLine();
                                OrderManagement order1 = new OrderManagement();
                                boolean checkAdmin = false;
                                String bookID = "";
                                int Bookquantity = 0;
                                for (int i = 0; i < orderQuantity; i++) {
                                    do {
                                        System.out.print("Enter the book ID to order : ");
                                        bookID = scan.nextLine();
                                        System.out.print("Enter book quantity : ");
                                        Bookquantity = scan.nextInt();
                                        checkAdmin = order1.validation(
                                                bookID,
                                                Bookquantity,
                                                realUser.getUserRole());
                                        scan.nextLine();
                                    } while (checkAdmin == false);

                                    // do{
                                    // System.out.print("Enter the book ID to order : ");
                                    // bookID = scan.nextLine();
                                    // System.out.print("Enter book Quantity : ");
                                    // Bookquantity = scan.nextInt();
                                    // checking = order.validation(bookID, Bookquantity, realUser.getUserRole());
                                    // scan.nextLine();
                                    // }while(checking == false);
                                    // OrderManagement order = new OrderManagement();
                                    order1.orderBook(bookID, Bookquantity, realUser, n);
                                    // OrderManagement.orderBook(()bookID, quantity , roleId);
                                    n++;
                                    scan.nextLine();
                                }
                                // OrderManagement.orderBook(()bookID, quantity , roleId);
                                break;
                            case 3:
                                Vector<OrderManagement> orderList = new Vector<OrderManagement>();
                                OrderManagement order = new OrderManagement();
                                orderList = order.getOrderFromFile(realUser.getUserRole());
                                // System.out.println(orderList);
                                order.viewAllOrders(
                                        orderList,
                                        realUser.getUserRole(),
                                        "Customer");
                                scan.nextLine();
                                // view customer orders
                                break;
                            case 4:
                                Vector<OrderManagement> orderListSupplier = new Vector<OrderManagement>();
                                OrderManagement orderSup = new OrderManagement();
                                orderListSupplier = orderSup.getOrderFromFile(realUser.getUserRole());
                                // System.out.println(orderList);
                                orderSup.viewAllOrders(
                                        orderListSupplier,
                                        realUser.getUserRole(),
                                        "Supplier");
                                scan.nextLine();
                                // view Supplier orders
                                break;
                            case 5:
                                Vector<OrderManagement> orderListAll = new Vector<OrderManagement>();
                                OrderManagement orderAll = new OrderManagement();
                                orderListAll = orderAll.getOrderFromFile(realUser.getUserRole());
                                // System.out.println(orderList);
                                orderAll.viewAllOrders(
                                        orderListAll,
                                        realUser.getUserRole(),
                                        "All");
                                scan.nextLine();
                                // view Supplier orders
                                break;
                            case 6:
                                int val = manageMenu(realUser.getUserRole());
                                if (val == 9) {
                                }
                                break;
                            case 7:
                                // generate report
                                Report ReportOrder = new Report();
                                ReportOrder.generateReport(realUser.getUserRole());
                                scan.nextLine();
                                break;
                            case 8:
                                ((Admin) realUser).viewAllCustomers(new Customer());
                                break;
                            case 9:
                                System.exit(0);
                                break;
                            default:
                                break;
                        }
                    } while (userOption != 9);
                    // if else/ case.
                }
            }
        }
    }

    public static int manageMenu(int roleID) throws IOException{
        int option;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("\n\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Book          ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Add New Book               ║");
            System.out.println("║ 2. Remove Book                ║");
            System.out.println("║ 3. Edit Book Details          ║");
            System.out.println("║ 4. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-4): ");
            option = scan.nextInt();

            if(option < 1 || option >4){
                System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
            }
        } while (option < 1 || option >4);


        if(option == 4){
            return 9;
        }else{
            Book bk = new Book(); //creating a book with empty constructor and dont hold any value to send as param in admin's method.
            Admin.manageBookOperation(bk, option, roleID);
            return option;
        }

    }

    public static void header(){
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                                         ║");
        System.out.println("║     Welcome to Kedai Buku Kamal!        ║");
        System.out.println("║  Your One-Stop Bookstore Experience :)  ║");
        System.out.println("║                                         ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }
}

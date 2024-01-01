import java.io.*;
import java.util.Scanner;
import java.util.Vector;

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
        if(choice == 1 || choice ==3){
            if(choice ==1){
            do{
                scan.nextLine();
                System.out.print("\n\nEnter username : ");
                String uName = scan.nextLine();
                System.out.print("\nEnter password : ");
                String pw = scan.nextLine();
                user = User.login(uName, pw, choice);
                if(user == null){
                    System.out.println("Invalid Credentials Entered. Please Try Again!");
                }
            }while(user == null);
            Book b = new Book();
            User realUser = new Admin(user.getUserID(), user.getUserName(),user.getPassword(),user.getEmail(), user.getUserRole(), user.getName().getfName(), user.getName().getlName(),b.getBooksfromFile());

            if(realUser.getUserRole() == 1){ //admin
                // BookManager bkm = new BookManager();
                do {
                    scan.nextLine();
                    userOption = realUser.viewMenu();
                    switch (userOption) {
                        case 1:
                            b.viewAllBooks(((Admin)realUser).getBooks(),realUser.getUserRole());
                            break;
                        case 2:
                            //Order Book
                            b.viewAllBooks(((Admin)realUser).getBooks(),realUser.getUserRole());
                            Vector<OrderManagement> orderListAdmin = new Vector<OrderManagement>();
                            OrderManagement orderrr = new OrderManagement();
                            orderListAdmin = orderrr.getOrderFromFile(user.getUserRole());
                            int n = orderListAdmin.size()+1;
                            System.out.print("How many book do u wanna Order:");
                            int orderQuantity = scan.nextInt();
                            scan.nextLine();

                            for(int i = 0; i < orderQuantity; i++){
                                System.out.print("Enter the book ID to order : ");
                                String bookID = scan.nextLine();
                                System.out.print("Enter book Quantity : ");
                                int Bookquantity = scan.nextInt();
                                OrderManagement order = new OrderManagement();
                                order.orderBook(bookID, Bookquantity, realUser, n);
                                //OrderManagement.orderBook(()bookID, quantity , roleId);
                                n++;
                                scan.nextLine();
                            }
                            //OrderManagement.orderBook(()bookID, quantity , roleId);
                            break;
                        case 3:
                            Vector<OrderManagement> orderList = new Vector<OrderManagement>();
                            OrderManagement order = new OrderManagement();
                            orderList = order.getOrderFromFile(realUser.getUserRole());
                            // System.out.println(orderList);
                            order.viewAllOrders(orderList,realUser.getUserRole(),"Customer");
                            scan.nextLine();
                            //view customer orders
                            break;
                        case 4:
                            Vector<OrderManagement> orderListSupplier = new Vector<OrderManagement>();
                            OrderManagement orderSup = new OrderManagement();
                            orderListSupplier = orderSup.getOrderFromFile(realUser.getUserRole());
                            // System.out.println(orderList);
                            orderSup.viewAllOrders(orderListSupplier,realUser.getUserRole(),"Supplier");
                            scan.nextLine();
                            //view Supplier orders
                            break;
                        case 5:
                            Vector<OrderManagement> orderListAll = new Vector<OrderManagement>();
                            OrderManagement orderAll = new OrderManagement();
                            orderListAll = orderAll.getOrderFromFile(realUser.getUserRole());
                            // System.out.println(orderList);
                            orderAll.viewAllOrders(orderListAll,realUser.getUserRole(),"All");
                            scan.nextLine();
                            //view Supplier orders
                            break;
                        case 6:
                             int val = manageMenu(realUser.getUserRole());
                            if(val == 9){
                                
                            }
                            break;
                        case 7:
                            //generate report
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
                } while (userOption !=9);
                

                //if else/ case.
            }
            }else{ //supplier
            do{
                scan.nextLine();
                System.out.print("\n\nEnter username : ");
                String uName = scan.nextLine();
                System.out.print("\nEnter password : ");
                String pw = scan.nextLine();
                user = User.login(uName, pw, choice);
                if(user == null){
                    System.out.println("Invalid Credentials Entered. Please Try Again!");
                }
            }while(user == null);
                User realUser = new BookSupplier(user.getUserID(), user.getUserName(),user.getPassword(),user.getEmail(), user.getUserRole(), user.getName().getfName(), user.getName().getlName());
              
                if(realUser.getUserRole()==3){
                do {
                    userOptionSupplier = realUser.viewMenu();
                    switch (userOptionSupplier) {
                        case 1:
                            //View All Orders - All status with user roleID ==1
                            Vector<OrderManagement> orderList = new Vector<OrderManagement>();
                            OrderManagement order = new OrderManagement();
                            orderList = order.getOrderFromFile(realUser.getUserRole());
                            // System.out.println(orderList);
                            order.viewAllOrders(orderList,realUser.getUserRole(),"");
                            // for(OrderManagement o: orderList){
                            //     System.out.println(o.getOrderID()+" "+o.getTotalAmount()+" "+o.getOrderDate()+" "+o.getOrderStatus()+" "+
                            //     o.getUser().userID+" "+o.getUser().userRole);
                            // }
                            // System.out.print("Press Enter to continue...");
                            scan.nextLine();
                            break;
                        case 2:
                            //Approval Order - Show Pending, allow them to enter orderID, then approve or reject
                            Vector<OrderManagement> orders = new Vector<OrderManagement>();
                            OrderManagement orderApproval = new OrderManagement();
                            BookSupplier supplier = new BookSupplier();

                            orders = orderApproval.getOrderFromFile(realUser.getUserRole());
                            // System.out.println(orderList);
                            orderApproval.viewAllOrders(orders,realUser.getUserRole(),"");
                            supplier.updateOrderStatus(orders,realUser);
                            //OrderManagement.orderBook(()bookID, quantity , roleId);
                            // scan.nextLine();
                            break;
                        case 3:
                            BookSupplier.manageAccount(realUser);
                            break;
                    
                        default:
                            break;
                    }
                }while(userOptionSupplier != 4);
            }
            }
        }else{
            do{
                System.out.println("Customer Options:\n\t1. Login\n\t2. Register");
                System.out.print("\nEnter the option (1-2) : ");
                choice = scan.nextInt();
                if(choice<1 || choice > 2){
                    System.out.println("Invalid option entered. Please Try Again!");
                    scan.nextLine();
                    scan.nextLine();
                }
            }while(choice<1 || choice > 2);

            if(choice == 1){
                do{
                    scan.nextLine();
                    System.out.print("\n\nEnter username : ");
                    String uName = scan.nextLine();
                    System.out.print("\nEnter password : ");
                    String pw = scan.nextLine();
                    user = User.login(uName, pw, 2);
                    if(user == null){
                        System.out.println("Invalid Credentials Entered. Please Try Again!");
                    }
                }while(user == null);
                Book b = new Book();
                User realUser = new Customer(user.getUserID(), user.getUserName(),user.getPassword(),user.getEmail(), user.getUserRole(), user.getName().getfName(), user.getName().getlName());
                do {
                    scan.nextLine();
                    userOption = realUser.viewMenu();
                    switch (userOption) {
                        case 1:
                            b.viewAllBooks(b.getBooksfromFile(),realUser.getUserRole());
                            break;
                        case 2:
                            //Order books
                            Vector<OrderManagement> orderListSupplier = new Vector<OrderManagement>();
                            OrderManagement orderrr = new OrderManagement();
                            orderListSupplier = orderrr.getOrderFromFile(user.getUserRole());
                            int n = orderListSupplier.size()+1;

                            b.viewAllBooks(b.getBooksfromFile(),realUser.getUserRole());
                            System.out.print("How many book do u wanna Order:");
                            int orderQuantity = scan.nextInt();
                            scan.nextLine();
                            for(int i = 0; i < orderQuantity; i++){
                                System.out.print("Enter the book ID to order : ");
                                String bookID = scan.nextLine();
                                System.out.print("Enter book Quantity : ");
                                int Bookquantity = scan.nextInt();
                                OrderManagement order = new OrderManagement();
                                order.orderBook(bookID, Bookquantity, realUser, n);
                                //OrderManagement.orderBook(()bookID, quantity , roleId);
                                scan.nextLine();
                            }
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            //generate report
                            break;
                        case 5:
                            //manage customers
                            ((Admin) realUser).viewAllCustomers(new Customer());
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                } while (userOption !=7);
                //if else/ case
            }else{
                Customer.registration();
                System.out.println("Successfully Registered..You will be navigated to Login :)");
                scan.nextLine();
            }

        }
scan.close();
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
            System.out.println("******************************************");
            System.out.println("*                                        *");
            System.out.println("*     Welcome to Kedai Buku Kamal!        *");
            System.out.println("*  Your One-Stop Bookstore Experience :) *");
            System.out.println("*                                        *");
            System.out.println("******************************************");
    }

    
}

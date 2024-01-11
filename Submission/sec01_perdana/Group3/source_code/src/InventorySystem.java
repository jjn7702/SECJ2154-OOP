import java.io.*;
import java.util.*;

public class InventorySystem {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice =0, userOption=0;
        User user = new User();
        Console console = System.console();

        if (console == null) {
            System.out.println("Console not available");
            System.exit(1);
        }


        do{
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            header();

            System.out.println("\n\nRoles :\n\t1. Admin\n\t2. Customer\n\t3. Supplier");
            System.out.print("Enter your role (1-3) : ");        
            try{
                choice = scan.nextInt();
                if(choice<1 || choice > 3){
                    System.out.println("Invalid option entered. Please Try Again! Press any key to continue...");
                    scan.nextLine();
                    scan.nextLine();
                }   
            }catch(InputMismatchException e){
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                scan.nextLine();
                choice = 4;
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
                // System.out.print("\nEnter password : ");
                char[] passwordArray = System.console().readPassword("Enter your password: ");
                String pw = new String(passwordArray);
                user = User.login(uName, pw, choice);
                if(user == null){
                    System.out.println("Invalid Credentials Entered. Please Try Again!");
                }
            }while(user == null);
            Book b = new Book();
            User realUser = new Admin(user.getUserID(), user.getUserName(),user.getPassword(),user.getEmail(), user.getUserRole(), user.getName().getfName(), user.getName().getlName(),b.getBooksfromFile());
            System.out.print("Successfully Login :)\nPress any key to continue..");
            scan.nextLine();
            scan.nextLine();
            if(realUser.getUserRole() == 1){ //admin
                do {
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    header();
                    userOption = realUser.viewMenu();
                    switch (userOption) {
                        case 1:
                            b.viewAllBooks(((Admin)realUser).getBooks(),realUser.getUserRole());
                            break;
                        case 2:
                            //Order Book
                            Vector<Book> temp = new Vector<Book>();
                            temp = b.getBooksfromFile();
                            Vector<OrderManagement> tempOrder = new Vector<OrderManagement>();
                            if(temp.size() == 0){
                                System.out.println("No books in the database to order. Please try again later.");
                            }else{
                                b.viewAllBooks(b.getBooksfromFile(),realUser.getUserRole());
                                Vector<OrderManagement> orderListAdmin = new Vector<OrderManagement>();
                                OrderManagement orderrr = new OrderManagement();
                                orderListAdmin = orderrr.getOrderFromFile(user.getUserRole());
                                int n = orderListAdmin.size()+1;
                                int orderQuantity = 0;
                                do{
                                    try {
                                        System.out.print("How many books do you want to order: ");
                                        orderQuantity = scan.nextInt();
                                        if (orderQuantity < 0) {
                                            System.out.println("Please enter a non-negative number.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                        scan.nextLine();
                                        scan.nextLine();
                                        orderQuantity = -10; 
                                    }
                                }while( orderQuantity < 0);
                                scan.nextLine();
                                OrderManagement order1 = new OrderManagement();
                                boolean checkAdmin = false;
                                String bookID = "";
                                int bookquantity = 0;
                                for(int i = 0; i < orderQuantity; i++){
                                    do{

                                        System.out.print("Enter Book ID to order : "); 
                                        bookID = scan.nextLine().toUpperCase();
                                        boolean validation  = false;
                                        Vector<Book> bks = new Vector<Book>();
                                        bks = b.getBooksfromFile();
                                        for (Book bk : bks) {
                                            if (bk.getBookID().equals(bookID.toUpperCase())) { 
                                                validation = true;
                                                break;
                                            }
                                        }
                        
                                        while(validation == false){
                                                System.out.println("Book ID not exists in our database. Please Try Again!");
                                                System.out.print("\nEnter Book ID : ");
                                                bookID = scan.nextLine().toUpperCase();
                                                for (Book bk : bks) {
                                                    if (bk.getBookID().equals(bookID.toUpperCase())) {
                                                        validation = true;
                                                        break;
                                                    }
                                                }   
                                        }
                                    System.out.print("Enter book quantity : ");
                                    try {
                                        bookquantity = scan.nextInt();
                                        if(bookquantity <= 0){
                                            System.out.println("Invalid book quantity entered. Please Try Again :)");
                                        }else{
                                            checkAdmin = order1.validation(bookID, bookquantity, realUser.getUserRole());
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                        scan.nextLine();
                                        scan.nextLine();
                                        bookquantity = -10; 
                                    }
                                    scan.nextLine();
                                    }while(checkAdmin == false || bookquantity <= 0);
                                    
                                    order1.orderBook(bookID, bookquantity, realUser, n);
                                    ((Admin) realUser).orderBooks(order1);

                                    n++;
                                    scan.nextLine();
                                }
                            }

                            break;
                        case 3:
                            //view customer orders
                            Vector<OrderManagement> orderList = new Vector<OrderManagement>();
                            OrderManagement order = new OrderManagement();
                            orderList = order.getOrderFromFile(realUser.getUserRole());
                            if(orderList.size() == 0){
                                System.out.print("You have no orders to view.\nPress any key to continue..");
                            }else{
                                order.viewAllOrders(orderList,realUser.getUserRole(),"Customer");
                            }
                            scan.nextLine();
                            break;
                        case 4:
                            Vector<OrderManagement> orderListSupplier = new Vector<OrderManagement>();
                            OrderManagement orderSup = new OrderManagement();
                            orderListSupplier = orderSup.getOrderFromFile(realUser.getUserRole());
                            if(orderListSupplier.size() == 0){
                                System.out.print("You have no orders to view.\nPress any key to continue..");
                            }else{
                                orderSup.viewAllOrders(orderListSupplier,realUser.getUserRole(),"Supplier");
                            }
                            scan.nextLine();
                            //view Supplier orders
                            break;
                        case 5:
                        Vector<OrderManagement> orderListAll = new Vector<OrderManagement>();
                        OrderManagement orderAll = new OrderManagement();
                        orderListAll = orderAll.getOrderFromFile(realUser.getUserRole());
                            if(orderListAll.size() == 0){
                                System.out.print("You have no orders to view.\nPress any key to continue..");
                            }else{
                                orderAll.viewAllOrders(orderListAll,realUser.getUserRole(),"All");
                            }
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
                            Report reportOrder = new Report();
                            ((Admin)realUser).generateSalesReport(reportOrder);
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
                } while (userOption !=9);
            }
            }else{ //supplier
            do{
                scan.nextLine();
                System.out.print("\n\nEnter username : ");
                String uName = scan.nextLine();
                char[] passwordArray = System.console().readPassword("Enter your password: ");
                String pw = new String(passwordArray);
                user = User.login(uName, pw, choice);
                if(user == null){
                    System.out.println("Invalid Credentials Entered. Please Try Again!");
                }
            }while(user == null);
                User realUser = new BookSupplier(user.getUserID(), user.getUserName(),user.getPassword(),user.getEmail(), user.getUserRole(), user.getName().getfName(), user.getName().getlName());
              
                if(realUser.getUserRole()==3){
                    int value;
                    do {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        header();
                        value = realUser.viewMenu();
                        switch (value) {
                            case 1:
                                Vector<OrderManagement> orderList = new Vector<OrderManagement>();
                                OrderManagement order = new OrderManagement();
                                orderList = order.getOrderFromFile(realUser.getUserRole());
                                if(orderList.size() == 0){
                                    System.out.print("No orders to provide approval status.\nPress any key to continue..");
                                }else{
                                    order.viewAllOrders(orderList,realUser.getUserRole(),"");
                                }
                                scan.nextLine();
                                break;
                            case 2:
                                //Approval Order - Show Pending, allow them to enter orderID, then approve or reject
                                Vector<OrderManagement> orders = new Vector<OrderManagement>();
                                OrderManagement orderApproval = new OrderManagement();
                                BookSupplier supplier = new BookSupplier();

                                orders = orderApproval.getOrderFromFile(realUser.getUserRole());
                                if(orders.size() == 0){
                                    System.out.println("No orders to provide approval status.");
                                }else{
                                    orderApproval.viewAllOrders(orders,realUser.getUserRole(),"");
                                    supplier.updateOrderStatus(orders,realUser);
                                }
                                break;
                            case 3:
                                BookSupplier.manageAccount(realUser);
                                break;
                            case 4:
                                System.exit(0);
                                break;
                        
                            default:
                                break;
                        }
                    } while (value!=4);
                }
            }
        }else{ //customer
            do{
                System.out.println("Customer Options:\n\t1. Login\n\t2. Register");
                System.out.print("\nEnter the option (1-2) : ");
                try{
                    choice = scan.nextInt();
                    if(choice<1 || choice > 2){
                        System.out.println("Invalid option entered. Please Try Again!");
                        scan.nextLine();
                        scan.nextLine();
                    }
                }catch(InputMismatchException e){
                    System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                    scan.nextLine();
                    scan.nextLine();
                    choice = 4;         
                }
            }while(choice<1 || choice > 2);

            if(choice == 1){
                do{
                    scan.nextLine();
                    System.out.print("\n\nEnter username : ");
                    String uName = scan.nextLine();
                    char[] passwordArray = System.console().readPassword("Enter your password: ");
                    String pw = new String(passwordArray);
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
                            Vector<Book> bk1 = new Vector<Book>();
                            bk1 = b.getBooksfromFile();
                            ((Customer)realUser).displayBooks(bk1, realUser.getUserRole());
                            break;
                        case 2:
                            //Order books
                            Vector<OrderManagement> orderListSupplier = new Vector<OrderManagement>();
                            OrderManagement orderrr = new OrderManagement();
                            orderListSupplier = orderrr.getOrderFromFile(user.getUserRole());
                            int n = orderListSupplier.size()+1;
                            Vector<Book> temp = new Vector<Book>();
                            temp = b.getBooksfromFile();
                            b.viewAllBooks(b.getBooksfromFile(),realUser.getUserRole());
                            if(temp.size() == 0){
                            }else{
                                int quantityOrd = 0;
                                do{
                                    try {
                                        System.out.print("How many books do you want to order: ");
                                        quantityOrd = scan.nextInt();
                                        if (quantityOrd <= 0) {
                                            System.out.println("Please enter a valid order quantity.");
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid integer.");
                                        scan.nextLine();
                                        quantityOrd = -1;
                                    }
                                }while( quantityOrd <= 0);
                                scan.nextLine();
                                OrderManagement order = new OrderManagement();
                                boolean checking = false, doubleCheck = false;
                                String bookID = "";
                                int Bookquantity = 0;
                                for(int i = 0; i < quantityOrd; i++){
                                    do{
                                    System.out.print("Enter the book ID to order : ");
                                    bookID = scan.nextLine().toUpperCase();
                                    System.out.print("Enter book Quantity : ");
                                    try {
                                        Bookquantity = scan.nextInt();
                                        if(Bookquantity <=0){
                                             System.out.println("Order Quantity is lower than 0.Please enter a valid order quantity.");
                                             scan.nextLine();
                                             doubleCheck = false;
                                        }else{
                                            doubleCheck = true;
                                        }

                                    } catch (Exception e) {
                                            System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                            scan.nextLine();
                                            doubleCheck = false;
                                    }
                                    if(doubleCheck){
                                        checking = order.validation(bookID.toUpperCase(), Bookquantity, realUser.getUserRole());
                                    }else{
                                        checking = false;
                                    }
                                    scan.nextLine();
                                    }while(checking == false);
                                    
                                    order.orderBook(bookID.toUpperCase(), Bookquantity, realUser, n);
                                    ((Customer) realUser).orderNewBooks(order);
                                    scan.nextLine();
                                }
                                order.generateInvoice();
                            }
                            break;
                        case 3:
                            ((Customer)realUser).updateCustomerAcc(realUser);
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                } while (userOption !=4);
            }else{

                Customer.registration();
                System.out.println("Successfully Registered..You will be exited from the system to login :)");
                scan.nextLine();
            }

        }
scan.close();
    }


    public static int manageMenu(int roleID) throws IOException{
        int option = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            header();
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Book          ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Add New Book               ║");
            System.out.println("║ 2. Remove Book                ║");
            System.out.println("║ 3. Edit Book Details          ║");
            System.out.println("║ 4. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-4): ");
            try{
                option = scan.nextInt();
                if(option < 1 || option >4){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
                    scan.nextLine();
                    scan.nextLine();
                }
            }catch(Exception e){
                    System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                    scan.nextLine();
                    scan.nextLine();
                    option = 7;
            }

        } while (option < 1 || option >4);


        if(option == 4){
            return 9;
        }else{
            Book bk = new Book();
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

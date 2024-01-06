//Wei Yang
import java.io.*;
import java.time.LocalDate;
import java.util.*;


class BookSupplier extends User{
    private Vector<OrderManagement> orderList;
    public BookSupplier(String id, String name ,String pw, String mail, int roleID,String fName,String lName){
        super(id, name, pw, mail, roleID,fName,lName);
    }

    public BookSupplier(){
    }


    public static void displaySupplier(User u){
        System.out.println("╔═════════════════╦═════════════════════╦═════════════════════╦═════════════════════╗");
        System.out.println("║  Supplier ID    ║    Username         ║     Full Name       ║        Email        ║");
        System.out.println("╬═════════════════╬═════════════════════╬═════════════════════╬═════════════════════╬");
    
        System.out.printf("║ %-15s ║ %-19s ║ %-19s ║ %-19s ║%n", u.getUserID(), u.getUserName(), u.getName().getfName() + " " + u.getName().getlName(), u.getEmail());
    
        System.out.println("╚═════════════════╩═════════════════════╩═════════════════════╩═════════════════════╝");
    
}
    @Override
    protected int viewMenu(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            InventorySystem.header();
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Supplier Menu        ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View all Orders            ║");
            System.out.println("║ 2. Manage Orders              ║");
            System.out.println("║ 3. Manage Account             ║");
            System.out.println("║ 4. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-4) : ");
            try {
                option = sc.nextInt();
                if(option < 1 || option > 4){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
                    sc.nextLine();
                    sc.nextLine();
                }             
            } catch (InputMismatchException e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                sc.nextLine();
                sc.nextLine();
                option = 10; 
            }
        }while(option < 1 || option > 4);
        return option;
    }

    public void updateOrderStatus(Vector<OrderManagement> orderList, User realUser) throws IOException{
        this.orderList = orderList;
        Boolean isPending = false;
        for(OrderManagement order : orderList){
            if(order.getOrderStatus().equals("Pending")){
                isPending = true;
                break;
            }
        }
        if(isPending == true){
            OrderManagement orderApproval = new OrderManagement();
            LocalDate UpdateAt = LocalDate.now();
            Scanner sc = new Scanner(System.in);
            Book books = new Book();
            Vector<Book> bkList = new Vector<Book>();
            bkList = books.getBooksfromFile();
            String bookId ="";
            int quantityOrder = 0;
            boolean checkOrderId = false;
            String orderId = "";
            do{
            System.out.print(" \nEnter order ID to edit : ");
            orderId = sc.next().toUpperCase();
            for(OrderManagement order : orderList){
                if(order.getOrderID().equals(orderId) && order.getOrderStatus().equals("Pending")){
                    checkOrderId = true;
                }
            }
            if(!checkOrderId){
                    System.out.println("Order ID not found");   
                }
            }while(checkOrderId == false);
            int optionApproval = 0;
            do{
                try{
                    System.out.print("Enter Status (1- Approve / 2- Reject) :");
                    optionApproval = sc.nextInt();
                    if(optionApproval < 1 || optionApproval > 2){
                        System.out.println("Invalid option entered. Please enter a number between 1 and 2. Try Again :)");
                    }
                }catch(Exception e){
                    System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                    sc.nextLine();
                    sc.nextLine();
                    optionApproval = 10; 
                }
            }while(optionApproval < 1 || optionApproval > 2);
            if(optionApproval == 1){
                for(OrderManagement order : orderList){
                    if(order.getOrderID().equals(orderId)){
                        order.setOrderStatus("Approved");
                        bookId = order.getBookInfo().getBookID();
                        quantityOrder = order.getQuantityOrder();
                        for(Book bks : bkList){
                            if(bks.getBookID().equals(bookId)){
                                bks.setQuantityInStock(bks.getQuantityInStock()+quantityOrder);
                            }
                        }
                        System.out.println("Order Approved Successfully");
                    }
                }
            }else if(optionApproval == 2){
                for(OrderManagement order : orderList){
                    if(order.getOrderID().equals(orderId)){
                        order.setOrderStatus("Rejected");
                        bookId = order.getBookInfo().getBookID();
                        System.out.println("Order Rejected Successfully");
                    }
                }
            }
            FileWriter file = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt",false);
            FileWriter fileOrders = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/ordersDatabase.txt",false);
            for(Book bks : bkList){
                if(bks.getBookID().equals(bookId)){
                    file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+bks.getQuantityInStock()+" "+bks.getBookPrice()+"\n");
                }else{
                    file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+bks.getQuantityInStock()+" "+bks.getBookPrice()+"\n");
                }
            }
            int i =1;
            for (OrderManagement order : orderList) {
                fileOrders.write("OR0"+i+" "+order.getTotalAmount()+" "+
                order.getBookInfo().getBookID()+ " "+order.getQuantityOrder()+" "+order.getUser().getUserID()+" "+order.getUser().getUserRole()+" "+
                order.getOrderStatus()+" "+order.getOrderDate()+"\n");
                i++;
            }
            fileOrders.close();
            file.close();
            for(OrderManagement order : orderList){
                System.out.println(order.getOrderID()+" "+order.getOrderStatus());
            }
        }else{
            return;
        }

    }

    public static void manageAccount(User currUser) throws IOException{
        Scanner scan = new Scanner(System.in);
        int option =0;
        String newValue = "";
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            InventorySystem.header();
            displaySupplier(currUser);
            System.out.println("\n\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Account       ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Update Username            ║");
            System.out.println("║ 2. Update Password            ║");
            System.out.println("║ 3. Update Email               ║");
            System.out.println("║ 4. Update Name                ║");
            System.out.println("║ 5. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-5): ");
            try {
                option = scan.nextInt();

                if(option < 1 || option >5){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
                }                
            } catch (Exception e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                scan.nextLine();
                option = 10; 
            }

        } while (option < 1 || option >5);
        scan.nextLine();

        switch (option) {
            case 1:
                System.out.print("\nEnter new username : ");
                newValue = scan.nextLine();
                currUser.setUserName(newValue);
                break;
            case 2:
                System.out.print("\nEnter new password: ");
                newValue= scan.nextLine();

                System.out.print("\nRe-enter your password: ");
                String confirmPassword = scan.nextLine();


                while (newValue.equals(confirmPassword) == false) {
                    System.out.println("Passwords do not match. Please re-enter your password.");
                    System.out.print("\nEnter a password: ");
                    newValue = scan.nextLine();

                    System.out.print("\nRe-enter your password: ");
                    confirmPassword = scan.nextLine();
                }
                currUser.setPassword(newValue);
                break;
            case 3:
                System.out.print("\nEnter new email : ");
                newValue = scan.nextLine();
                currUser.setEmail(newValue);
                break;
            case 4:
                System.out.print("\nEnter new first name : ");
                newValue = scan.nextLine();
                currUser.getName().setfName(newValue);
                System.out.print("\nEnter new last name : ");
                newValue= scan.nextLine();
                currUser.getName().setlName(newValue);
                break;
            
            case 5:
                return;
        
            default:
                break;
        }
        Vector<User> us = new Vector<User>();
        us = User.readAllUsers();
        FileWriter file = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/usersDatabase.txt",false);
        for (User c : us) {
                String fullName = c.getName().getfName()+"_"+c.getName().getlName();
                if(c.getUserID().equals(currUser.getUserID())){
                    String username = currUser.getUserName().replaceAll(" ", "");
                    String em = currUser.getEmail().replaceAll(" ", "");
                    fullName = currUser.getName().getfName()+"_"+currUser.getName().getlName();
                    String line = String.format("%s %s %s %s %s %d%n", currUser.getUserID(), username, currUser.getPassword(), em,fullName, 3);
                    file.write(line);
                }else{
                    String line = String.format("%s %s %s %s %s %d%n", c.getUserID(), c.getUserName(), c.getPassword(), c.getEmail(),fullName, c.getUserRole());
                    file.write(line);
                }

            }
            file.close();
        System.out.println("Updated Successfully :)");
    };
}
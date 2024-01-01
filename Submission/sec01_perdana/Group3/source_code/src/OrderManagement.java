import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// to generate random order ID
import java.util.*;
import java.time.LocalDate;// to get latest date

public class OrderManagement {
    private String orderID;
    private Vector<Book> bookList;
    private Book bookInfo;
    private String orderStatus;
    private double totalAmount;
    private User user;
    private String orderDate;
    private int quantityOrder;
    private int quantityInStock;
    // private Report report;
    // private Vector<Integer> bookQuantity; //tmb

    //OrderMangement order = new OrderManagement(orderId, book,user, orderStatus, orderDate);
    public OrderManagement(String orderID, Book bookInfo, User user, double totalAmount, String orderStatus, String orderDate, int quantityInStock
    , int quantityOrder){
        this.orderID = orderID;
        this.bookInfo = bookInfo;
        this.orderStatus = orderStatus;
        this.user = user;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.quantityInStock = quantityInStock;
        this.quantityOrder = quantityOrder;
        // this.report = report;
    }
    
    public OrderManagement(){
        this.orderID = "";
        this.orderStatus = "";
        this.user = new User();
        this.totalAmount = 0.0;
        this.orderDate = "";
        // this.report = new Report();
    }
    // TAN MUST UPDATE THIS
    public Vector<OrderManagement> getOrderFromFile(int role) throws FileNotFoundException {
        Vector<OrderManagement> orders = new Vector<OrderManagement>();
        Scanner sc = new Scanner(new File("ordersDatabase.txt")); //need to change path when export to github
        
        while(sc.hasNext()){

            String orderId = sc.next();
            double totalAmount = sc.nextDouble();
            String bookId = sc.next();
            String title = sc.next();
            String mainAuthor = sc.next();
            int genre = sc.nextInt();
            int quantityOrder = sc.nextInt();
            int quantityInStock = sc.nextInt();
            double price = sc.nextDouble();
            String userID = sc.next();
            int userRole = sc.nextInt();
            String orderStatus = sc.next();
            String orderDate = sc.next();
            
            Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,price);
            User users = new User(userID,"userName", "password","mail", userRole,"fname","lname");
                OrderManagement order = new OrderManagement(orderId, book,users,totalAmount, orderStatus, orderDate, quantityInStock, quantityOrder);
                orders.add(order);
            // if(role.equals(3) && orderStatus == "Pending"){
            // if(role == 3&& orderStatus.equals("Pending")){
            //     Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,price);
            //     User users = new User(userID,"userName", "password","mail", userRole,"fname","lname");
            //     OrderManagement order = new OrderManagement(orderId, book,users,totalAmount, orderStatus, orderDate);
            //     orders.add(order);
            // }else if (role == 2 && orderStatus.equals("Completed")){
            //     Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,price);
            //     User users = new User(userID,"userName", "password","mail", userRole,"fname","lname");
            //     OrderManagement order = new OrderManagement(orderId, book,users,totalAmount, orderStatus, orderDate);
            //     orders.add(order);
            // }else if (role == 1 && userRole == 2){
            //     Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,price);
            //     User users = new User(userID,"userName", "password","mail", userRole,"fname","lname");
            //     OrderManagement order = new OrderManagement(orderId, book,users,totalAmount, orderStatus, orderDate);
            //     orders.add(order);
            // }
        }
            
            // User user = new User( String id, String names ,String pw, String mail, int roleID,String fName, String lName){
            // OrderManagement(String orderID, Vector<Book> bookList, String orderStatus, User user, double totalAmount, String orderDate, Vector<Integer> quantity)
            // OrderManagement order = new OrderManagement(orderId, book, orderStatus, title, mainAuthor, genre, quantityInStock, price, userID, userRole, orderStatus, orderDate)
        return orders; 
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void viewAllOrders(Vector<OrderManagement> orders,int role) throws FileNotFoundException{ //based on role as Customer no need to see stock quantity what.
        // Vector<Book> books = new Vector<Book>();
        // books = getBooksfromFile(); // double check with sarveish as we might use association here.
        System.out.print("╔════════╦══════════════════════════════╦══════════════════════════════╦══════════════════════╦════════════════════════╗\n");
        if(role == 1){
            System.out.print("║Order ID ║            Title             ║         Main Author          ║         Genre        ║       Stock Quantity        ║       Price (RM)        ║\n");

        }else{
            System.out.print("║Order ID ║            Title             ║         Main Author          ║         Genre        ║    Price (RM)      ║\n");
        }
        System.out.print("╠════════╬══════════════════════════════╬══════════════════════════════╬══════════════════════╬════════════════════════╣\n");
        // System.out.println("inside view all orders");
        for(OrderManagement ord:orders){
            ord.displayOrder(role);
            // System.out.println(ord.getUser().getUserID());
        }
        System.out.print("╚════════╩══════════════════════════════╩══════════════════════════════╩══════════════════════╩════════════════════════╝\n");
        System.out.print("Press Enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void displayOrder(int role){ //Testing since need to check with Sarveish.
        String genreStr ="";
        switch (bookInfo.getGenre()) {
            case 1:
                genreStr = "Romance";
                break;
            case 2:
                genreStr = "Mystery";
                break;
            case 3:
                genreStr = "Fantasy";
                break;
            case 4:
                genreStr = "Comedy";
                break;
            case 5:
                genreStr = "Thriller";
                break;
            default:
                break;
        }

        if (role == 1 && getOrderStatus().equals("Completed")) {
             System.out.printf("║%-8s║%-8s║%-30s║%-30s║%-22s║%-18d║%-18d║%-18s║%-18s║%-18.2f║%-18s║%n",getOrderID(), bookInfo.getBookID(), 
            bookInfo.getTitle(),bookInfo.getMainAuthor(), genreStr,getQuantityOrder(), bookInfo.getQuantityInStock(),user.getUserID()
            ,getOrderStatus(),getTotalAmount(),getOrderDate());
        }else if(role == 3 && getOrderStatus().equals("Pending")){
            System.out.printf("║%-8s║%-8s║%-30s║%-30s║%-22s║%-18d║%-18d║%-18s║%-18s║%-18.2f║%-18s║%n",getOrderID(), bookInfo.getBookID(), 
            bookInfo.getTitle(),bookInfo.getMainAuthor(), genreStr,getQuantityOrder(), bookInfo.getQuantityInStock(),user.getUserID()
            ,getOrderStatus(),getTotalAmount(),getOrderDate());
        }
    }

    public void addOrderIntoFile(Book bk, User user, int quantityOrder) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("inside add order");
        LocalDate currentDate = LocalDate.now();
        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();
        
        PrintWriter outputFile = new PrintWriter(new FileWriter("ordersDatabase.txt",true));
        Book books = new Book();
        Vector<Book> bkList = new Vector<Book>();
        bkList = books.getBooksfromFile();
        if(user.getUserRole() == 1){ 
            
        outputFile.write("OR001"+" "+getTotalAmount()+" "+
        bk.getBookID()+ " "+bk.getTitle()+ " "+bk.getMainAuthor()+ " "+bk.getGenre()+ " "+quantityOrder+" "+bk.getQuantityInStock()+" "+bk.getBookPrice()+" "+
        user.getUserID()+" "+user.getUserRole()+" "+
        "Pending"+" "+currentDate+"\n");

        }else if(user.getUserRole() == 2){
            //Add data into order file
            //help, cannot used setquantityInstock, idk why. i force to use (bks.getQuantityInStock()-quantityOrder) to minus and update to database
            FileWriter file = new FileWriter("booksDatabase.txt",false);
            for (Book bks : bkList) {
                if(bks.getBookID().equals(bk.getBookID())){
                    file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+(bks.getQuantityInStock()-quantityOrder)+" "+bks.getBookPrice()+"\n");
                }else{
                    file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+bks.getQuantityInStock()+" "+bks.getBookPrice()+"\n");
                }
                // file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+(bks.getQuantityInStock()-quantityOrder)+" "+bks.getBookPrice()+"\n");
            }
        file.close();
            outputFile.write("OR001"+" "+getTotalAmount()+" "+
        bk.getBookID()+ " "+bk.getTitle()+ " "+bk.getMainAuthor()+ " "+bk.getGenre()+ " "+quantityOrder+" "+bk.getQuantityInStock()+" "+bk.getBookPrice()+" "+
        user.getUserID()+" "+user.getUserRole()+" "+
        "Completed"+" "+currentDate+"\n");
        }       
        outputFile.close();
        // bk.add(c);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void orderBook(String bookId, int quantityOrder, User realUser) throws IOException{
            Vector<Book> bkList = new Vector<Book>();
            Book book = new Book();
            // book.getBooksfromFile();
            bkList = book.getBooksfromFile();
            System.out.println("username: " + realUser.getUserName()+ " " + realUser.getUserRole());
            for(Book b:bkList){
                if(b.getBookID().equals(bookId)){
                    this.setTotalAmount(b.getBookPrice()*quantityOrder);
                    System.out.println("This is the book you want to order: "+ b.getTitle() + " " + b.getBookPrice() + " " + b.getQuantityInStock());
                    System.out.println("Total Amount: " + getTotalAmount());
                    this.addOrderIntoFile(b, realUser,quantityOrder);
                    // bookList.add(b);
                    // bookQuantity.add(quantity);
                    // totalAmount += b.getBookPrice()*quantity;
                }
                // System.out.println(b.getBookID() + " " + b.getTitle() + " " + b.getBookPrice() + " " + b.getQuantityInStock());
            }
    }

    public String getOrderID(){
        return orderID;
    }

    public String getOrderStatus(){
        return orderStatus;
    }   

    public double getTotalAmount(){
        return totalAmount;
    }

    public String getOrderDate(){
        return orderDate;
    }

     public int getQuantityOrder(){
        return quantityOrder;
    }

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }
    //typo
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    //typo
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    // public void generateInvoice(){ //order object need to be sent here to show the order stuff 
    //     System.out.println("===============================================");
    //     System.out.println("             KEDAI BUKU KAMAL");
    //     System.out.println("===============================================");
    //     System.out.println("Address:      " + "No 12, Jalan Sri Sabah 25, Taman University, 41200 Klang, Selangor");
    //     System.out.println("Phone Number: " + "03-9973628777");
    //     System.out.println("-----------------------------------------------");

    //     System.out.printf("%-20s | %-8s | %-10s\n", "Book Name", "Quantity", "Price");
    //     System.out.println("-----------------------------------------------");
    //         for(int i:bookQuantity){
    //              System.out.printf("%-20s | %-8d | $%-10.2f\n",bookList.get(bookList.size()-1).getTitle(),i,bookList.get(bookList.size()-1).getBookPrice()*i);
    //         }
    //         System.out.println("-----------------------------------------------");
    //         System.out.printf("%-29s $%.2f\n", "Total Amount to Pay (RM):", getTotalAmount());
    //         System.out.println("==============================================="); 
    //     //Create new method or continue to add into order file sini.
    // }

    // public void calculateTotalAmount(){

    // }

    public User getUser(){
        return user;
    }

    public Vector<Book> getbookList(){
        return bookList;
        
    }

    public static void getAllCustomerOrder(){
        // read from file ordersDatabase and tunjuk with bookName, quantity and total amount of that user and continue to another user.
    }

}
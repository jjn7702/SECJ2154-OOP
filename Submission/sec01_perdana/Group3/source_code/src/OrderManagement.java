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
    // private Report report;
    // private Vector<Integer> bookQuantity; //tmb

    //OrderMangement order = new OrderManagement(orderId, book,user, orderStatus, orderDate);
    public OrderManagement(String orderID, Book bookInfo, User user, double totalAmount, String orderStatus, String orderDate){
        this.orderID = orderID;
        this.bookInfo = bookInfo;
        this.orderStatus = orderStatus;
        this.user = user;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
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
    public Vector<OrderManagement> getOrderFromFile() throws FileNotFoundException {
        Vector<OrderManagement> orders = new Vector<OrderManagement>();
        Scanner sc = new Scanner(new File("ordersDatabase.txt")); //need to change path when export to github
        while(sc.hasNext()){
            String orderId = sc.next();
            double totalAmount = sc.nextDouble();
            String bookId = sc.next();
            String title = sc.next();
            String mainAuthor = sc.next();
            int genre = sc.nextInt();
            int quantityInStock = sc.nextInt();
            double price = sc.nextDouble();
            String userID = sc.next();
            int userRole = sc.nextInt();
            String orderStatus = sc.next();
            String orderDate = sc.next();
            Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,price);
            User user = new User(userID,"userName", "password","mail", userRole,"fname","lname");
            OrderManagement order = new OrderManagement(orderId, book,user,totalAmount, orderStatus, orderDate);
            // User user = new User( String id, String names ,String pw, String mail, int roleID,String fName, String lName){
            // OrderManagement(String orderID, Vector<Book> bookList, String orderStatus, User user, double totalAmount, String orderDate, Vector<Integer> quantity)
            // OrderManagement order = new OrderManagement(orderId, book, orderStatus, title, mainAuthor, genre, quantityInStock, price, userID, userRole, orderStatus, orderDate)
            orders.add(order);
        }
        return orders; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addOrderIntoFile(Book bk, User user) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("inside add order");
        LocalDate currentDate = LocalDate.now();
        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();
        
        // Convert UUID to string
        String randomId = randomUUID.toString();
        PrintWriter outputFile = new PrintWriter(new FileWriter("ordersDatabase.txt",true));
        // String title = c.getTitle().replaceAll(" ", "_");
        // String author = c.getMainAuthor().replaceAll(" ", "_");
        outputFile.write("OR001"+" "+getTotalAmount()+" "+
        bk.getBookID()+ " "+bk.getTitle()+ " "+bk.getMainAuthor()+ " "+bk.getGenre()+ " "+bk.getQuantityInStock()+" "+bk.getBookPrice()+" "+
        user.getUserID()+" "+user.getUserRole()+" "+
        "Pending"+" "+currentDate+"\n");
        // outputFile.write(c.getBookID()+ " "+title+ " "+author+ " "+c.getGenre()+ " "+c.getQuantityInStock()+" "+c.getBookPrice()+"\n");
        outputFile.close();
        // bk.add(c);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void orderBook(String bookId, int quantity, User realUser) throws IOException{
        if(realUser.getUserRole() == 1){ //admin
            Vector<Book> bkList = new Vector<Book>();
            Book book = new Book();
            // book.getBooksfromFile();
            bkList = book.getBooksfromFile();
            System.out.println("username: " + realUser.getUserName()+ " " + realUser.getUserRole());
            for(Book b:bkList){
                if(b.getBookID().equals(bookId)){
                    this.setTotalAmount(b.getBookPrice()*quantity);
                    System.out.println("This is the book you want to order: "+ b.getTitle() + " " + b.getBookPrice() + " " + b.getQuantityInStock());
                    System.out.println("Total Amount: " + getTotalAmount());
                    this.addOrderIntoFile(b, realUser);
                    // bookList.add(b);
                    // bookQuantity.add(quantity);
                    // totalAmount += b.getBookPrice()*quantity;
                }
                // System.out.println(b.getBookID() + " " + b.getTitle() + " " + b.getBookPrice() + " " + b.getQuantityInStock());
            }
            

        }else if(realUser.getUserRole()== 2){
            
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
import java.io.*;
// to generate random order ID
import java.util.*;
import java.time.LocalDate;// to get latest date

public class OrderManagement {
    private String orderID;
    private Vector<Book> bookList;
    private Vector<Book> bookCart;
    private Vector<OrderManagement> custOrderCart;
    private Book bookInfo;
    private String orderStatus;
    private double totalAmount;
    private User user;
    private String orderDate;
    private int quantityOrder;
    private int quantityInStock;

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
    }
    
    public OrderManagement(){
        this.orderID = "";
        this.orderStatus = "";
        this.user = new User();
        this.totalAmount = 0.0;
        this.orderDate = "";
        bookCart = new Vector<Book>();
        custOrderCart = new Vector<OrderManagement>();
        // this.report = new Report();
    }
    public Vector<OrderManagement> getOrderFromFile(int role) throws FileNotFoundException {
        Vector<OrderManagement> orders = new Vector<OrderManagement>();
        Vector<Book> books = new Vector<Book>();
        try {
            Scanner sc = new Scanner(new File("Submission/sec01_perdana/Group3/source_code/src/ordersDatabase.txt")); //need to change path when export to github
            while(sc.hasNext()){

                String orderId = sc.next();
                double totalAmount = sc.nextDouble();
                String bookId = sc.next();
                int quantityOrder = sc.nextInt();
                // double price = sc.nextDouble();
                String userID = sc.next();
                int userRole = sc.nextInt();
                String orderStatus = sc.next();
                String orderDate = sc.next();
                

                Book bookSelected = new Book();
                books = bookSelected.getBooksfromFile();
                for(Book b:books){
                    if(b.getBookID().equals(bookId.toUpperCase())){
                        bookInfo = b;
                    }
                }
                //System.out.println(bookInfo.getTitle()+ " " + bookInfo.getMainAuthor()+ " " + bookInfo.getGenre()+ " " + bookInfo.getQuantityInStock()+ " " + bookInfo.getBookPrice());
                    User users = new User(userID,"userName", "password","mail", userRole,"fname","lname");
                    OrderManagement order = new OrderManagement(orderId, bookInfo,users,totalAmount, orderStatus, orderDate, quantityInStock, quantityOrder);
                    orders.add(order);
                    
            }            
        } catch (Exception e) {
            System.out.print("An error is occured during the file operation..Please Try again later..\nPress Any Key to continue..");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        }

        return orders; 
        }
        public void generateInvoice() throws FileNotFoundException {
            System.out.println(
                "╔══════════════════════════════════════════════════════════════════════════════════════╗");
            System.out.println(
                "║                                    KEDAI BUKU KAMAL                                  ║");
            System.out.println(
                "╠══════════════════════════════════════════════════════════════════════════════════════╣");
            System.out.println(
                "║Address:      " + "No 12, Jalan Sri Sabah 25, Taman University, 41200 Klang, Selangor      ║");
            System.out.println(
                "║Phone Number: " + "03-9973628777                                                           ║");
            System.out.println(
                "║--------------------------------------------------------------------------------------║");
            System.out.printf(
                "║%-30s | %-15s | %-20s%16s\n", "Book Name", "Quantity", "Price","║");
            System.out.println(
                "║--------------------------------------------------------------------------------------║");
        
            double totalAmount = 0;
        
            Vector<String> bookTitles = new Vector<String>();
            Vector<Integer> bookQuantities = new Vector<Integer>();
        
            for (OrderManagement order : custOrderCart) {
                Book book = order.getBookInfo();
                String title = book.getTitle().replaceAll("_", " ");
                int quantity = order.getQuantityOrder();
        
                int index = bookTitles.indexOf(title);
                if (index == -1) { //adding books in order to avoid duplicate book title to be shown in invoice.
                    bookTitles.add(title);
                    bookQuantities.add(quantity);
                } else {
                    bookQuantities.set(index, bookQuantities.get(index) + quantity);
                }
            }
        
            for (int i = 0; i < bookTitles.size(); i++) {
                String t = bookTitles.get(i);
                int quantity = bookQuantities.get(i);
        
                Book book =  new Book();
                Vector<Book> books = new Vector<Book>();
                Book bk = new Book();
            
                books = bk.getBooksfromFile();
            
                for (Book b : books) { //double checking with title
                    if (b.getTitle().replaceAll("_", " ").toUpperCase().equals(t.replaceAll("_", " ").toUpperCase())) {
                        book = b;
                        break;
                    }
                }
                if (book != null) {
                    double price = book.getBookPrice();
                    System.out.printf("║%-30s | %-15d | %-20.2f%16s\n", t, quantity, price * quantity,"║");
                    totalAmount += price * quantity;
                }
            }
        
            System.out.println("║--------------------------------------------------------------------------------------║");
            System.out.printf("║%-29s RM%.2f%49s\n", "Total Amount to Pay (RM):", totalAmount,"║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════╝");
        }

    public void viewAllOrders(Vector<OrderManagement> orders,int role,String sortBy) throws FileNotFoundException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        InventorySystem.header();
        Boolean isPending = false;
        if(role ==3){
            for(OrderManagement order : orders){
                if(order.getOrderStatus().equals("Pending")){
                    isPending = true;
                    break;
                }
            }
            if(isPending == true){
                System.out.print(
                    "╔═══════╦══════╦══════════════════════════════╦══════════════════╦═══════════╦═════════╦═════════════╦══════════╦════════════╦═══════════╗\n");
                    System.out.print(
                        "║OrderID║BookID║             Title            ║    Main Author   ║   Genre   ║Order Qty║   UserId    ║  Status  ║TotalAmount ║ OrderDate ║\n");
        
                System.out.print(
                    "╠═══════╬══════╬══════════════════════════════╬══════════════════╬═══════════╬═════════╬═════════════╬══════════╬════════════╬═══════════╣\n");
                for(OrderManagement ord:orders){
                    ord.displayOrder(role,sortBy);
                }
                System.out.print(
                    "╚═══════╩══════╩══════════════════════════════╩══════════════════╩═══════════╩═════════╩═════════════╩══════════╩════════════╩═══════════╝\n");
                System.out.print("Press Enter to continue...");
                return;
            }else{
                System.out.print("No orders to provide approval status. Please wait for new admin orders.");
                System.out.print("\nPress Enter to continue...");
                Scanner scan = new Scanner(System.in);
                scan.nextLine();
                return;
            }
        }
        System.out.print(
            "╔═══════╦══════╦══════════════════════════════╦══════════════════╦═══════════╦═════════╦═════════════╦══════════╦════════════╦═══════════╗\n");
        if(role == 1){
        System.out.print(
            "║OrderID║BookID║             Title            ║    Main Author   ║   Genre   ║Order Qty║   UserId    ║  Status  ║TotalAmount ║ OrderDate ║\n");

        }else{
        System.out.print(
            "║OrderID║BookID║             Title            ║    Main Author   ║   Genre   ║Order Qty║   UserId    ║  Status  ║TotalAmount ║ OrderDate ║\n");
        }
        System.out.print(
            "╠═══════╬══════╬══════════════════════════════╬══════════════════╬═══════════╬═════════╬═════════════╬══════════╬════════════╬═══════════╣\n");
        for(OrderManagement ord:orders){
            ord.displayOrder(role,sortBy);
        }
        System.out.print(
            "╚═══════╩══════╩══════════════════════════════╩══════════════════╩═══════════╩═════════╩═════════════╩══════════╩════════════╩═══════════╝\n");
        System.out.print("Press Enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void displayOrder(int role,String sortBy){ //Testing since need to check with Sarveish.
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
        String title = bookInfo.getTitle().replaceAll("_", " ");
        String author = bookInfo.getMainAuthor().replaceAll("_", " ");
        if (role == 1) {

            if(sortBy.equals("Customer")){
                if(getOrderStatus().equals("Completed")){
                    System.out.printf("║%-7s║%-6s║%-30s║%-18s║%-11s║%-9d║%-13s║%-10s║RM%-10.2f║%-11s║%n",getOrderID(), bookInfo.getBookID(), 
                    title,author, genreStr,getQuantityOrder(),user.getUserID()
                    ,getOrderStatus(),getTotalAmount(),getOrderDate());
                }
            }else if(sortBy.equals("Supplier")){
                
                if(getOrderStatus().equals("Pending") || getOrderStatus().equals("Approved") || getOrderStatus().equals("Rejected")){
                    
                    System.out.printf("║%-7s║%-6s║%-30s║%-18s║%-11s║%-9d║%-13s║%-10s║RM%-10.2f║%-11s║%n",getOrderID(), bookInfo.getBookID(), 
                    title,author, genreStr,getQuantityOrder(),user.getUserID()
                    ,getOrderStatus(),getTotalAmount(),getOrderDate());
                }
            }else if(sortBy.equals("All")){
    
                System.out.printf("║%-7s║%-6s║%-30s║%-18s║%-11s║%-9d║%-13s║%-10s║RM%-10.2f║%-11s║%n",getOrderID(), bookInfo.getBookID(), 
                title,author, genreStr,getQuantityOrder(),user.getUserID()
                ,getOrderStatus(),getTotalAmount(),getOrderDate());
            }
        }else if(role == 3 && getOrderStatus().equals("Pending")){
            System.out.printf("║%-7s║%-6s║%-30s║%-18s║%-11s║%-9d║%-13s║%-10s║RM%-10.2f║%-11s║%n",getOrderID(), bookInfo.getBookID(), 
            title,author, genreStr,getQuantityOrder(),user.getUserID()
            ,getOrderStatus(),getTotalAmount(),getOrderDate());
        }
    }

    public void addOrderIntoFile(Book bk, User user, int quantityOrder,int n) throws IOException{
        Scanner scan = new Scanner(System.in);
        LocalDate UpdateAt = LocalDate.now();
        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();
        try {
                PrintWriter outputFile = new PrintWriter(new FileWriter("Submission/sec01_perdana/Group3/source_code/src/ordersDatabase.txt",true));
                Book books = new Book();
                Vector<Book> bkList = new Vector<Book>();
                bkList = books.getBooksfromFile();
                if(user.getUserRole() == 1){ 
                    
                outputFile.write("OR0"+n+" "+getTotalAmount()+" "+
                bk.getBookID()+ " "+quantityOrder+" "+user.getUserID()+" "+user.getUserRole()+" "+"Pending"+" "+UpdateAt+"\n");

                }else if(user.getUserRole() == 2){
                    FileWriter file = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt",false);
                    for (Book bks : bkList) {
                        if(bks.getBookID().equals(bk.getBookID())){
                            file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+(bks.getQuantityInStock()-quantityOrder)+" "+bks.getBookPrice()+"\n");
                        }else{
                            file.write(bks.getBookID()+ " "+bks.getTitle()+ " "+bks.getMainAuthor()+ " "+bks.getGenre()+ " "+bks.getQuantityInStock()+" "+bks.getBookPrice()+"\n");
                        }
                    }
                file.close();
                    outputFile.write("OR0"+n+" "+Math.round(getTotalAmount() * 10) / 10.0+" "+
                bk.getBookID()+ " "+quantityOrder+" "+user.getUserID()+" "+user.getUserRole()+" "+"Completed"+" "+UpdateAt+"\n");

                OrderManagement order = new OrderManagement("OR0"+n, bk, user, Math.round(getTotalAmount() * 10) / 10.0, "Completed", UpdateAt.toString(), bk.getQuantityInStock(), quantityOrder);
                custOrderCart.add(order);
            }       
                outputFile.close();            
        } catch (Exception e) {
            System.out.print("An error is occured during the file operation. The order is not added..Please Try again later..\nPress Any Key to continue..");
            scan.nextLine();
        }

    }

    public void orderBook(String bookId, int quantityOrder, User realUser, int n) throws IOException{
            Vector<Book> bkList = new Vector<Book>();
            Book book = new Book();
            // book.getBooksfromFile();
            bkList = book.getBooksfromFile();
            for(Book b:bkList){
                if(b.getBookID().equals(bookId)){
                    this.setTotalAmount(b.getBookPrice()*quantityOrder);
                    if(realUser.getUserRole() == 1){
                        System.out.println("Total Amount: " + getTotalAmount());
                        System.out.println("Order Successfully, Please wait Supplier to Approve the order......");
                    }else{
                        System.out.println("Purchase Successfully......");
                    }
                    this.addOrderIntoFile(b, realUser,quantityOrder, n);
                    this.getcustOrderCart();
                    bookCart.add(b);
                }
            }
    }

    public boolean validation(String bookId, int bookQuantity, int roleId) throws FileNotFoundException{
        Vector<Book> bkList = new Vector<Book>();
        Book book = new Book();
        Boolean check = false;
        bkList = book.getBooksfromFile();
            
            try {
                for (Book b : bkList) {
                    if (b.getBookID().equals(bookId)) {
                        check = true;
                        break;  // Exit the loop if the book is found
                    }
                }

                if (!check) {
                    System.out.println("Sorry, the book id you entered is not found.");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                check = false;
            }
            if(roleId == 2){
                 for(Book b:bkList){
                    if(b.getBookID().equals(bookId)){
                        if(b.getQuantityInStock() >= bookQuantity){
                            check = true;
                            break; // Exit the loop if the book is found
                        }else{
                            System.out.println("Sorry, the quantity you order is more than the quantity in stock.");
                            check = false;
                        }
                    }
                }
            }
           
        return check;
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
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public User getUser(){
        return user;
    }

    public Vector<Book> getbookList(){
        return bookList;
        
    }

    public Vector<Book> getBookCart(){
        return bookCart;
        
    }

    public Vector<OrderManagement> getcustOrderCart(){
        return custOrderCart;
        
    }
    public Book getBookInfo(){
        return bookInfo;
    }

}
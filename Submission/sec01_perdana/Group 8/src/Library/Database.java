package Library;
import java.util.ArrayList;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Database {
    
    private  ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> userName = new ArrayList<String>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<String> bookName = new ArrayList<String>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Borrowing> borrowings = new ArrayList<Borrowing>();


    private File usersfile = new File("src/data/Users.txt");
    private File bookfile = new File("src/data/Books.txt");
    private File ordersfile = new File("src/data/Orders.txt");
    private File borrowingsfile = new File("src/data/Borrowings.txt");
    private File folder = new File("src/data");

    public Database(){
        if (!folder.exists()){
            folder.mkdir();
        }
        if (!usersfile.exists()){
            try{
                usersfile.createNewFile();
            }catch (Exception e){}
        }
        if (!bookfile.exists()){
            try{
                bookfile.createNewFile();
            }catch (Exception e){}
        }
        if (!ordersfile.exists()){
            try{
                ordersfile.createNewFile();
            }catch (Exception e){}
        }
        if (!borrowingsfile.exists()){
            try{
                borrowingsfile.createNewFile();
            }catch (Exception e){}
        }
        getUsers();
        getBooks();
        getOrders();
        getBorrowings();
    }

    public void AddUser(User m){
        users.add(m);
        userName.add(m.getName());
        saveUsers();
    } 

    public int login(String phoneNumber,String email){  
        int n = -1;
        for(User s : users){
            if(s.getPhoneNumber().equals(phoneNumber) && s.getEmail().equals(email)){
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }

    public User getUser(int n){
        return  users.get(n);
    }


    public void AddBook(Book b){
        books.add(b);
        bookName.add(b.getTitle());
        saveBooks();
    } 

    private void getUsers(){
        String text1 = "";

        try{
            BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }

        if(!text1.matches("") || !text1 .isEmpty()){
            String[] a1 = text1.split("<NewUser/>");
            for(String s : a1){
                String[] a2 = s.split("<N/>");
                if(a2[3].equals("Admin")){
                    User user = new Admin(a2[0],a2[1],a2[2]);
                    users.add(user);
                    userName.add(user.getName());

                }else{
                    User user = new Members(a2[0],a2[1],a2[2]);
                    users.add(user);
                    userName.add(user.getName());
                }
            }
        }

    }

    private void saveUsers(){
        String text1 = "";
        for(User user : users){
           text1 = text1 + user.toString() + "<NewUser/>\n";
        }
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(usersfile));
            pw.println(text1);
            pw.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void saveBooks(){
        String text1 = "";
        for(Book book : books){
           text1 = text1 + book.toString2() + "<NewBook/>\n";
        }
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(bookfile));
            pw.println(text1);
            pw.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void getBooks(){
        String text1 = "";

        try{
            BufferedReader br1 = new BufferedReader(new FileReader(bookfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }

        if(!text1.matches("") || !text1 .isEmpty()){
            String[] a1 = text1.split("<NewBook/>");
            for(String s : a1){
                Book book = parseBook(s);
                books.add(book);
                bookName.add(book.getTitle());
    
            }
        }

    }

    public Book parseBook(String s){
        String[] a = s.split("<N/>");
        Book book = new Book();
        book.setTitle(a[0]);
        book.setAuthor(a[1]);
        book.setPublisher(a[2]);
        book.setIsbn(a[3]);
        book.setQty(Integer.parseInt(a[4]));
        book.setPrice(Double.parseDouble(a[5]));
        book.setBrwCoppies(Integer.parseInt(a[6]));
        return book;
    }

    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public int getBook(String tittle){
        int i = -1;
        for(Book book : books){
            if(book.getTitle().equals(tittle)){
                i = books.indexOf(book);
            }
        }
        return i;
    }

    public Book getBook(int i){
        return books.get(i);
    }

    public void deleteBook(int n){
        books.remove(n);
        bookName.remove(n);
        saveBooks();
    }

    public void deleteAllData(){
        if (usersfile.exists()){
            try{
                usersfile.delete();
            }catch (Exception e){}
        }
        if (bookfile.exists()){
            try{
                bookfile.delete();
            }catch (Exception e){}
        }
        if (ordersfile.exists()){
            try{
                ordersfile.delete();
            }catch (Exception e){}
        }
        if (borrowingsfile.exists()){
            try{
                borrowingsfile.delete();
            }catch (Exception e){}
        }
    }

    public void addOrder(Order order,Book book,int bookindex){
        orders.add(order);
        books.set(bookindex, book);
        saveOrders();
        saveBooks();
    }

    private void saveOrders(){
        String text1 = "";
        for(Order order : orders){
           text1 = text1 + order.toString2() + "<NewOrder/>\n";
        }
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(ordersfile));
            pw.println(text1);
            pw.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void getOrders(){
        String text1 = "";

        try{
            BufferedReader br1 = new BufferedReader(new FileReader(ordersfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }

        if(!text1.matches("") || !text1 .isEmpty()){
            String[] a1 = text1.split("<NewOrder/>");
            for(String s : a1){
                Order order = parseOrder(s);
                orders.add(order);
    
            }
        }

    }
    

    public boolean userExist(String name ){
        boolean f = false;
        for(User user : users){
            if(user.getName().toLowerCase().equals(name.toLowerCase())){
                break;
            }
        }

        return f;

    }
    
    private User getUserByName(String name){
        User u = new Members("");
        for(User user : users){
            if(user.getName().equals(name)){
                u = user;
                break;
            }
        }
        return u;
    }

    private Order parseOrder(String s ){
        String[] a = s.split("<N/>");
        Order order = new Order(books.get(getBook(a[0])),getUserByName(a[1]),Double.parseDouble(a[2]),Integer.parseInt(a[3]));
        return order;

    }

    public ArrayList<Order> getAllOrders(){
        return orders;
    }

    private void saveBorrowings(){
        String text1 = "";
        for(Borrowing borrowing : borrowings){
           text1 = text1 + borrowing.toString2() + "<NewBorrowing/>\n";
        }
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(borrowingsfile));
            pw.println(text1);
            pw.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void getBorrowings(){
        String text1 = "";

        try{
            BufferedReader br1 = new BufferedReader(new FileReader(borrowingsfile));
            String s1;
            while((s1 = br1.readLine()) != null){
                text1 = text1 + s1;
            }
            br1.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }

        if(!text1.matches("") || !text1 .isEmpty()){
            String[] a1 = text1.split("<NewBorrowing/>");
            for(String s : a1){
                Borrowing borrowing = parseBorrowing(s);
                borrowings.add(borrowing);
    
            }
        }

    }

    private Borrowing parseBorrowing(String s ){
        String[] a = s.split("<N/>");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate start = LocalDate.parse(a[0],formatter);
        LocalDate finish = LocalDate.parse(a[1],formatter);
        Book book = getBook(getBook(a[3]));
        User user = getUserByName(a[4]);
        Borrowing brw = new Borrowing(start,finish,book, user);
        return brw;
    }

    public void borrowBook(Borrowing brw, Book book, int bookindex){
        borrowings.add(brw);
        books.set(bookindex, book);
        saveBorrowings();
        saveBooks();
    }

    public ArrayList<Borrowing> getBrws(){
        return borrowings;
    }

    public void returnBook(Borrowing b, Book book, int bookindex){
        borrowings.remove(b);
        books.set(bookindex, book);
        saveBorrowings();
        saveBooks();
    }


}

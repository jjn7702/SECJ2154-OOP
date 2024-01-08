import java.io.*;
import java.util.*;

class Book{
    private String bookID;
    private String title;
    private String mainAuthor;
    private int genre;
    private int quantityInStock;
    private double bookPrice;


    public Book(){}

    public Book(String id, String titleBook, String author, int genreCat, int stock,double price){
        bookID = id;
        title = titleBook;
        mainAuthor = author;
        genre = genreCat;
        quantityInStock = stock;
        bookPrice = price;
    }

    public double getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMainAuthor() {
        return mainAuthor;
    }
    public void setMainAuthor(String mainAuthor) {
        this.mainAuthor = mainAuthor;
    }
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayBook(int role){ //Testing since need to check with Sarveish.
        String genreStr ="";
        switch (genre) {
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
        String title = getTitle().replaceAll("_", " ");
        String author = getMainAuthor().replaceAll("_", " ");
        if (role == 1) {
            System.out.printf("║%-8s║%-30s║%-30s║%-22s║%-20d║%-20.2f║%n", getBookID(), title, author, genreStr, getQuantityInStock(), getBookPrice());
        } else {
            System.out.printf("║%-8s║%-30s║%-30s║%-22s║%-20.2f║%n", getBookID(), title, author, genreStr, getBookPrice());
        }
    }

    public  Vector<Book> getBooksfromFile() throws FileNotFoundException {
        Vector<Book> books = new Vector<Book>();
        Scanner sc = new Scanner(new File("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt"));
        
        while(sc.hasNext()){
            String bookId = sc.next();
            String title = sc.next();
            String mainAuthor = sc.next();
            int genre = sc.nextInt();
            int quantityInStock = sc.nextInt();
            double bookPrice = sc.nextDouble();
            Book book = new Book(bookId, title, mainAuthor, genre, quantityInStock,bookPrice);
            books.add(book);
        }
        return books; 
    }

    public void addBooksIntoFile(Vector<Book> bk) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("============ADD BOOK============");
        System.out.print("\nEnter Book ID: ");
        String id = scan.nextLine();

        Vector<Book> bkList = new Vector<Book>();
        bkList = getBooksfromFile();

        for(Book c:bkList){
            while (c.getBookID().equals(id.toUpperCase())) {
                System.out.println("Book ID already exists. Please choose a different Book ID.");
                System.out.print("\nEnter a new Book ID : ");
                id = scan.nextLine().toUpperCase();
            }
        }

        System.out.print("\nEnter Title: ");
        String ttl = scan.nextLine();

        System.out.print("\nEnter Main Author: ");
        String mainAuthor = scan.nextLine();
        int genreOption = 0;
        do{
            System.out.print("\nEnter new book genre (1-Romance , 2-Mystery , 3-Fantasy , 4-Comedy , 5-Thriller) : ");
            try {
                genreOption = scan.nextInt();
                if(genreOption <1 || genreOption>5){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
                }                
            } catch (InputMismatchException e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                genreOption = 8; 
            }
        }while(genreOption <1 || genreOption>5);


        int quantityInStock=0; 
        do{
            System.out.print("\nEnter Quantity in Stock: ");
            try {
                quantityInStock = scan.nextInt();
                if (quantityInStock >= 0) {
                    break;
                } else {
                    System.out.println("Stock quantity cannot be lower than 0. Please enter a valid stock quantity.");
                }
            } catch (Exception e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                scan.nextLine();
                quantityInStock = -10; 
            }


        }while(quantityInStock<=0);

        double bookPrice=0.0;
        do{
            System.out.print("\nEnter Book Price (RM): ");
            try {
                bookPrice = scan.nextDouble();    
                if (bookPrice >= 0) {
                    break;
                } else {
                    System.out.println("Invalid price entered. Please try again.");
                }            
            } catch (InputMismatchException e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                scan.nextLine();
                quantityInStock = -10; 
            }
        }while(bookPrice<=0);



        Book c = new Book(id.toUpperCase(), ttl, mainAuthor, genreOption, quantityInStock,bookPrice);
        PrintWriter outputFile = new PrintWriter(new FileWriter("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt",true));
        String title = c.getTitle().replaceAll(" ", "_");
        String author = c.getMainAuthor().replaceAll(" ", "_");
        outputFile.write(c.getBookID()+ " "+title+ " "+author+ " "+c.getGenre()+ " "+c.getQuantityInStock()+" "+c.getBookPrice()+"\n");
        outputFile.close();
        bk.add(c);
    }

    public void viewAllBooks(Vector<Book> books,int role) throws FileNotFoundException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        InventorySystem.header();
        if(books.size() == 0){
            System.out.println("No books in the database.");
        }else{
            if(role == 1){
                System.out.print(
                   "╔════════╦══════════════════════════════╦══════════════════════════════╦══════════════════════╦════════════════════╦════════════════════╗\n");
               System.out.print(
                   "║Book ID ║            Title             ║         Main Author          ║         Genre        ║   Stock Quantity   ║    Price (RM)      ║\n");
   
               System.out.print(
                   "╠════════╬══════════════════════════════╬══════════════════════════════╬══════════════════════╬════════════════════╬════════════════════╣\n");
               for(Book bk:books){
                   bk.displayBook(role);
               }
               System.out.print(
                   "╚════════╩══════════════════════════════╩══════════════════════════════╩══════════════════════╩════════════════════╩════════════════════╝\n");
           }else{
                System.out.print(
                   "╔════════╦══════════════════════════════╦══════════════════════════════╦══════════════════════╦════════════════════╗\n");
               System.out.print(
                   "║Book ID ║            Title             ║         Main Author          ║         Genre        ║    Price (RM)      ║\n");
               System.out.print(
                   "╠════════╬══════════════════════════════╬══════════════════════════════╬══════════════════════╬════════════════════╣\n");
               for(Book bk:books){
                   bk.displayBook(role);
               }
               System.out.print(
                   "╚════════╩══════════════════════════════╩══════════════════════════════╩══════════════════════╩════════════════════╝\n");
            }
        }

        System.out.print("Press Enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public void updateBookMenu(Vector<Book> books, int role) throws IOException{
        Scanner scan = new Scanner(System.in);
        if(books.size() != 0){
            int option=0, newOption=0;
            do {
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                viewAllBooks(books,role);
                System.out.println("\n\n");
                System.out.println("╔═══════════════════════════════╗");
                System.out.println("║          Update Book          ║");
                System.out.println("╠═══════════════════════════════╣");
                System.out.println("║ 1. Book Title                 ║");
                System.out.println("║ 2. Book Main Author           ║");
                System.out.println("║ 3. Book Genre                 ║");
                System.out.println("║ 4. Book Stock Quantity        ║");
                System.out.println("║ 5. Book Price                 ║");
                System.out.println("║ 6. Back                       ║");
                System.out.println("╚═══════════════════════════════╝");
                System.out.print("\nEnter your option (1-6): ");
                try {
                    option = scan.nextInt();
                    if(option < 1 || option >6){
                        System.out.println("Invalid option entered. Please enter a number between 1 and 6.\n Try Again :)");
                        scan.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                    scan.nextLine();
                    option = 10; 
                }

            } while (option < 1 || option >6);
            scan.nextLine();
                if(option == 6){
                    return;
                }
                System.out.print("Enter Book ID : "); 
                String  id = scan.nextLine().toUpperCase();
                boolean validation  = false;

                for (Book bk : books) {
                    if (bk.getBookID().equals(id.toUpperCase())) { 
                        validation = true;
                        break;
                    }
                }

                while(validation == false){
                        System.out.println("Book ID not exists in our database. Please Try Again!");
                        System.out.print("\nEnter Book ID : ");
                        id = scan.nextLine().toUpperCase();
                        for (Book bk : books) {
                            if (bk.getBookID().equals(id.toUpperCase())) {
                                validation = true;
                                break;
                            }
                        }   
                }

                switch (option) {
                    case 1:
                        System.out.print("Enter new book title : ");
                        String newVal = scan.nextLine();
                        Boolean val = editBookDetails(books,option, id.toUpperCase(), newVal);
                        break;
                    case 2:
                        System.out.print("Enter new book author : ");
                        newVal = scan.nextLine();
                        val = editBookDetails(books,option, id, newVal);
                        break;
                    case 3:
                        do{
                            System.out.print("Enter new book genre (1-Romance , 2-Mystery , 3-Fantasy , 4-Comedy , 5-Thriller) : ");
                            newVal = scan.nextLine();
                            
                            try {
                            newOption = Integer.parseInt(newVal); 
                                if(newOption <1 || newOption>5){
                                    System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                scan.nextLine();
                                scan.nextLine();
                                newOption = -10; 
                            }

                        }while(newOption <1 || newOption>5);
                        val = editBookDetails(books,option, id.toUpperCase(), newVal);
                        break;
                    case 4:
                        int temp = 0;
                        do {
                            System.out.print("Enter new book stock Quantity : ");
                            newVal = scan.nextLine();
                            try {
                                temp = Integer.parseInt(newVal); 
                                if(temp < 0){
                                    System.out.println("The stock quantity is lower than zero. Please enter an appropriate quantity. Try Again :)");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                scan.nextLine();
                                temp = -1;
                            }   
                        } while (temp <0 );
                        val = editBookDetails(books,option, id.toUpperCase(), newVal);
                        break;
                    case 5:
                        double tempDouble = 0;
                        do {
                            System.out.print("Enter new book price (RM) : ");
                            newVal = scan.nextLine();
                            try {
                                tempDouble = Double.parseDouble(newVal); 
                                if(tempDouble < 0){
                                    System.out.println("The price is lower than zero. Please enter an appropriate price. Try Again :)");
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                                scan.nextLine();
                                tempDouble = -1 ; 
                            }   
                        } while (tempDouble <0);
                        
                        val = editBookDetails(books,option, id.toUpperCase(), newVal);
                        break;
                    default:
                        break;
            }
        }else{
            System.out.println("No books in the database.\nPress any key to continue..");
            scan.nextLine();
        }
        
    }

    public void removeBookFromFile(Vector<Book> bk2) throws IOException{
        Scanner scan = new Scanner(System.in);
        Vector<OrderManagement> orderList = new Vector<OrderManagement>();
        OrderManagement orders = new OrderManagement();
        orderList = orders.getOrderFromFile(3);
        if(bk2.size() != 0){
            viewAllBooks(bk2,1);
            String bookId = "";
            int index =0;

            System.out.print("\nEnter Book ID : "); 
            bookId = scan.nextLine().toUpperCase();
            boolean validation  = false;

            for (Book bk : bk2) {
                if (bk.getBookID().equals(bookId.toUpperCase())) {
                    validation = true;
                    break;
                }
            }

            while(validation == false){
                    System.out.println("Book ID not exists in our database. Please Try Again!");
                    System.out.print("\nEnter Book ID : ");
                    bookId = scan.nextLine().toUpperCase();
                    for (Book bk : bk2) {
                        if (bk.getBookID().equals(bookId.toUpperCase())) {
                            validation = true;
                            break;
                        }
                    }   
            }
            PrintWriter outputFile = new PrintWriter(new FileWriter("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt"),false);
            PrintWriter outputOrderFile = new PrintWriter(new FileWriter("Submission/sec01_perdana/Group3/source_code/src/ordersDatabase.txt"),false);
            for(Book book:bk2){
                if(book.getBookID().equals(bookId.toUpperCase())){
                    break;
                }else{
                    outputFile.write(book.getBookID().toUpperCase()+ " "+book.getTitle()+ " "+book.getMainAuthor()+ " "+book.getGenre()+ " "+book.getQuantityInStock()+" "+book.getBookPrice()+"\n");
                }
                index++;
            }
            bk2.remove(index);

            for(OrderManagement order: orderList){
                if(order.getBookInfo().getBookID() != bookId){
                    outputOrderFile.write(order.getOrderID()+" "+Math.round(order.getTotalAmount() * 10) / 10.0+" "+
                    order.getBookInfo().getBookID()+ " "+order.getQuantityOrder()+" "+order.getUser().getUserID()+" "+
                    order.getUser().getUserRole()+" "+order.getOrderStatus()+" "+order.getOrderDate()+"\n");
                }
            }

            outputFile.close();
            outputOrderFile.close();
        }else{
            System.out.println("No books in the database.\nPress any key to continue..");
            scan.nextLine();
        }

    }

    public Boolean editBookDetails(Vector<Book> books,int category, String id, String value) throws IOException{
        value = value.replaceAll(" ", "_");
        for(Book book:books){
            if(book.getBookID().equals(id.toUpperCase())){
                switch (category) {
                    case 1:
                        book.setTitle(value);
                        break;
                    case 2:
                        book.setMainAuthor(value);
                        break;
                    case 3:
                        book.setGenre(Integer.parseInt(value));
                        break;
                    case 4:
                        book.setQuantityInStock(Integer.parseInt(value));
                        break;
                    case 5:
                        book.setBookPrice(Double.parseDouble(value));
                        break;
                    default:
                        return false;
                }
            }

        }
        if(books !=null){
            FileWriter file = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/booksDatabase.txt",false);
            for (Book bk : books) {
                file.write(bk.getBookID().toUpperCase()+ " "+bk.getTitle()+ " "+bk.getMainAuthor()+ " "+bk.getGenre()+ " "+bk.getQuantityInStock()+" "+bk.getBookPrice()+"\n");
            }
            file.close();
        }
        return true;
    }


}
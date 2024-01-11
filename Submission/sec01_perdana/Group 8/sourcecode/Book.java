import java.util.Vector;

public class Book {
    private String bookID;
    private String title;
    private String ISBN;
    private int quantity;
    private int genre;
    private String author;

    public Book(){
    }

    public Book(String title, String bookID, String ISBN, int quantity, int genre, String author){
        this.title = title;
        this.bookID = bookID;
        this.ISBN = ISBN;
        this.quantity = quantity;
        this.genre =  genre;
        this.author = author;
    }

    public String getBookID(){
        return bookID;
    }

    public String getTitle(){
        return title;
    }

    public String getISBN(){
        return ISBN;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getGenre(){
        return genre;
    }

    public String getAuthor(){
        return author;
    }

    public void setBookID(String bookID){
        this.bookID = bookID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setGenre(int genre){
        this.genre = genre;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void display(){
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Quantity: " + quantity);
        System.out.println("Genre: " + genre);
        System.out.println("Author: " + author);
    }

    public void addBookToLibrary(Vector<Book> library) {
        library.add(this);
    }

    public void updateBookQuantity(Vector<Book> library, int newQuantity) {
        for (Book book : library) {
            if (book.getBookID().equals(this.bookID)) {
                book.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void removeBook(Vector<Book> library) {
        library.remove(this);
    }

    public void updateBookDetails(Vector<Book> library) {
        for (Book book : library) {
            if (book.getBookID().equals(this.bookID)) {
                book.setTitle(this.title);
                book.setISBN(this.ISBN);
                book.setQuantity(this.quantity);
                book.setGenre(this.genre);
                book.setAuthor(this.author);
                break;
            }
        }
    }
}


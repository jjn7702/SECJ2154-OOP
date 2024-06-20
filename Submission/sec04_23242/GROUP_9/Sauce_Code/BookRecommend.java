interface User{
public String getMatricID();

}

//class UG implements User here

//class PG implements User here

class Book{ // stores or get book data 
  // Encapsulation: Private fields to hide data from outside access
    private String genre;
    private String ref;
    private double pages;
    private String publisher;
    private String author;
    private String title;

    // Constructor to initialize the book details
    public Book(String genre, String ref, double pages, String publisher, String author, String title) {
        this.genre = genre;
        this.ref = ref;
        this.pages = pages;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
    }

    // Getter methods to provide controlled access to private fields
    public String getGenre() {
        return genre;
    }

    public String getRef() {
        return ref;
    }

    public double getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "genre='" + genre + '\'' +
                ", ref='" + ref + '\'' +
                ", pages=" + pages +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

class Admin {
    // Composition: Admin 'has a' list of books. Admin's lifecycle does not depend on books
    private List<Book> books;

    public Admin() {
        this.books = new ArrayList<>();
    }

    // Encapsulation: Controlling how books are added or removed
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}


class faculty extends Book{ // contains specific books

    public faculty(String genre, String ref, double pages, String publisher , String author, String title){
        super(genre, ref, pages, publisher, author, title);
        
    }
}


class UG implements User{ 

private String MatricID;

public UG(String MatricID){
    this.MatricID = MatricID;
}

    public String getMatricID(){
        return MatricID;
    }
}


class PG implements User{

private String MatricID;

public PG(String MatricID){
    this.MatricID = MatricID;
}
    public String getMatricID(){
        return MatricID;
    }
}


class others {

}




public class BookRecommend{
    public static void main(String[] args) {
    }
}

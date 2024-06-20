interface User{
public String getMatricID();

}

class Undergraduate implements User{
  private String matricID;

  public Undergraduate(String matricID){
    this.matricID = matricID;
  }

  public String getMatricID(）{
    return matricID;
  }
  
class Postgraduate implements User{
  private String matricID;

  public Postgraduate(String matricID){
    this.matricID = matricID;
  }

  public String getMatricID(){
    this.matricID = matricID;
  }
}
  
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


class Library{
  private Admin admin;
  private List<Book> books; //Showing Aggregation

  public Library(){
    this.admin = new Admin();
    this.books = admin.getBooks();
  }

  public void addBook(Book book){
    admin.addBook(book);
  }

  public void removeBook(Book book){
    admin.removeBook(book);
  }

  public List<BookM getBooks(){
    return books;
  }
}

class RecommendationEngine{ 
    // Composition: RecommendationEngine 'has a' list of books. RecommendationEngine's lifecycle does not depend on books
  private List<Book> books;

  public RecommendationEngine(List<Book> books){
    this.books = books;
  }

  public void recommendByGenre(String genre){
    for (Book book : books){
      if (book.getGenre().equalsIgnoreCase(genre)){
        System.out.println(book);
      }
    }
  }

  public void recommendByRef(String ref){
    for (Book book : books){
      if (book.getRef().equalsIgnoreCase(ref)){
        System.out.println(book);
      }
    }
  }

  public void recommendByPages(double pages){
    for (Book book : books){
      if (book.getPages() <= pages){
        System.out.println(book);
      }
    }
  }

  public void recommendByPublisher(string publisher){
    for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book);
            }
        }
    }

    public void recommendByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public void recommendByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
            }
        }
    }
}



//class BookRecommendationSystem here aka public void static main here

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

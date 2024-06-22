import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface User {
    public String getMatricID();
}

// UG class uses inheritance to implement User interface
class UG implements User {
    private String matricID;

    public UG(String matricID) {
        this.matricID = matricID;
    }

    public String getMatricID() {
        return matricID;
    }
}

// PG class uses inheritance to implement User interface
class PG implements User {
    private String matricID;

    public PG(String matricID) {
        this.matricID = matricID;
    }

    public String getMatricID() {
        return matricID;
    }
}


class Book {
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

class Library {
    // Composition: Library 'has a' list of books. Library's lifecycle does not depend on books
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

class RecommendationEngine {
    // Composition: RecommendationEngine 'has a' list of books. RecommendationEngine's lifecycle does not depend on books
    private List<Book> books;

    public RecommendationEngine(List<Book> books) {
        this.books = books;
    }

    public void recommendByGenre(String genre) {
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book);
            }
        }
    }

    public void recommendByRef(String ref) {
        for (Book book : books) {
            if (book.getRef().equalsIgnoreCase(ref)) {
                System.out.println(book);
            }
        }
    }

    public void recommendByPages(double pages) {
        for (Book book : books) {
            if (book.getPages() <= pages) {
                System.out.println(book);
            }
        }
    }

    public void recommendByPublisher(String publisher) {
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

class BookRecommendationSystem {
    private Admin admin;
    private Library library;
    private RecommendationEngine recommendationEngine;
    private Scanner scanner;

    public BookRecommendationSystem() {
        this.admin = new Admin();
        this.library = new Library();
        this.recommendationEngine = new RecommendationEngine(library.getBooks());
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            try {
                System.out.println("Welcome to the Main Menu of the BOOKBYTES Book Recommended System\n");
                System.out.println("Please enter a corresponding number based on the options below to navigate the menu:\n");
                System.out.println("1. Undergraduate");
                System.out.println("2. Postgraduate");
                System.out.println("3. Others (limited access)");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.print("\nChoose your option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                    case 2:
                        handleStudent(option == 1);
                        break;
                    case 3:
                        handleOthers();
                        break;
                    case 4:
                        handleAdmin();
                        break;
                    case 5:
                        System.out.println("Exiting system...");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                // Exception handling: catching any unexpected exceptions to prevent crash
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void handleStudent(boolean isUG) {
        System.out.print("Enter your Matric No: ");
        String matricNo = scanner.nextLine();
        User student = isUG ? new UG(matricNo) : new PG(matricNo); // Polymorphism: Using interface type to refer to objects
        recommendBooks(student);
    }

    private void handleOthers() {
        recommendBooks(null);
    }

    private void handleAdmin() {
        System.out.print("Enter admin credentials: ");
        String credentials = scanner.nextLine();
        // Validate credentials (assume always valid for simplicity)
        adminMenu();
    }

    private void adminMenu() {
        while (true) {
            try {
                System.out.println("Admin Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Back to Main Menu");
                System.out.print("Choose your option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                // Exception handling: catching any unexpected exceptions to prevent crash
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void addBook() {
        try {
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter ref: ");
            String ref = scanner.nextLine();
            System.out.print("Enter pages: ");
            double pages = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            Book book = new Book(genre, ref, pages, publisher, author, title);
            admin.addBook(book);
            library.addBook(book);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            // Exception handling: catching any unexpected exceptions to prevent crash
            System.out.println("An error occurred while adding the book: " + e.getMessage());
            scanner.next(); // Clear invalid input
        }
    }

    private void removeBook() {
        try {
            System.out.print("Enter title of the book to remove: ");
            String title = scanner.nextLine();
            Book bookToRemove = library.findBookByTitle(title);
            if (bookToRemove != null) {
                admin.removeBook(bookToRemove);
                library.removeBook(bookToRemove);
                System.out.println("Book removed successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (Exception e) {
            // Exception handling: catching any unexpected exceptions to prevent crash
            System.out.println("An error occurred while removing the book: " + e.getMessage());
            scanner.next(); // Clear invalid input
        }
    }

    private void recommendBooks(User user) {
        while (true) {
            try {
                System.out.println("Book Recommendation Menu:");
                System.out.println("1. Recommend by Genres");
                System.out.println("2. Recommend by Journals/Articles/References");
                System.out.println("3. Recommend by Pages");
                System.out.println("4. Recommend by Publisher");
                System.out.println("5. Recommend by Authors");
                System.out.println("6. Recommend by Title");
                System.out.print("Choose your option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        recommendByGenre();
                        break;
                    case 2:
                        recommendByRef();
                        break;
                    case 3:
                        recommendByPages();
                        break;
                    case 4:
                        recommendByPublisher();
                        break;
                    case 5:
                        recommendByAuthor();
                        break;
                    case 6:
                        recommendByTitle();
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }

                // Ask user if they want to go back to the recommendation menu or exit
                System.out.println("Would you like to:");
                System.out.println("1. Go back to the Recommendation Menu");
                System.out.println("2. Exit");
                System.out.print("Choose your option: ");
                int nextOption = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (nextOption == 2) {
                    System.out.println("Exiting the recommendation system...");
                    return;
                }

            } catch (Exception e) {
                // Exception handling: catching any unexpected exceptions to prevent crash
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void recommendByGenre() {
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        recommendationEngine.recommendByGenre(genre);
    }

    private void recommendByRef() {
        System.out.print("Enter reference type: ");
        String ref = scanner.nextLine();
        recommendationEngine.recommendByRef(ref);
    }

    private void recommendByPages() {
        System.out.print("Enter max pages: ");
        double pages = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        recommendationEngine.recommendByPages(pages);
    }

    private void recommendByPublisher() {
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        recommendationEngine.recommendByPublisher(publisher);
    }

    private void recommendByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        recommendationEngine.recommendByAuthor(author);
    }

    private void recommendByTitle() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        recommendationEngine.recommendByTitle(title);
    }

    public static void main(String[] args) {
        BookRecommendationSystem system = new BookRecommendationSystem();
        system.start();
    }
}

import java.util.*;

class Librarian extends Users {
    Vector <Member> member = new Vector<Member>();
    Vector <Borrow> borrow = new Vector<Borrow>();
    private Report report;

    public Librarian(String userID, String userName, String password, int userRole , String fName, String lName, Vector<Book> Book){
        super(userID,userName,password,userRole,fName,lName);
        member = new Vector<Member>();
        borrow = new Vectro<Member>();
        book = Book;
        
        
        
    }

    public Librarian(){}

    protected static viewMenu(){
        
    }

    public void viewAllMembers(){

    }

    public static void manageBookOperation(Vector<Book> Book , int , int){

    }

    public void generateReport(Report report){

    }

    public void addBorrowedBooks(Vector<Borrow> borrow) {
        borrow.add(this);
    }

    public static Vector<Book> getBook(){
        return book;
    }

    public static Vector<Member> getMember(){
        return member;
    }

}
import java.util.Date;
import java.util.Vector;

public class Borrow{
    private Vector<Book> bookInfo;
    private String bookStatus;
    private Users user;
    private Date borrowDate;
    private Report report;

    public Borrow(){

    }

    public Borrow(Vector<Book> bookInfo, String bookStatus, Users user, Date borrowDate, Report report){
       this.bookInfo = bookInfo;
       this.bookStatus = bookStatus;
       this.user = user;
       this.borrowDate = borrowDate;
       this.report = report;
    }

    public Vector<Book> getBorrowInfo(){
        return bookInfo;
    }

    public String getBorrowStatus(){
        return bookStatus;
    }

    public Users getUser(){
        return user;
    }

    public void setBookStatus(String bookStatus){
        this.bookStatus = bookStatus;
    }
}

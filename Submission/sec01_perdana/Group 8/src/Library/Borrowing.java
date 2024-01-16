package Library;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Borrowing {
    LocalDate start;
    LocalDate finish;

    int daysleft;
    Book book;
    User user;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public Borrowing(Book book, User user) {
        start  = LocalDate.now();
        finish = start.plusDays(14);
        daysleft = Period.between(start, finish).getDays();
        this.book = book;
        this.user = user;
    }

    public Borrowing(LocalDate start, LocalDate finish,Book book,User user) {
        this.start = start;
        this.finish = finish;
        this.daysleft = Period.between(finish,LocalDate.now()).getDays();
        this.book = book;
        this.user = user;
    }


    public String getStart(){
        return formatter.format(start);
    }

    public String getFinish(){
        return formatter.format(finish);
    }

    public int getDaysleft(){
        return Period.between(finish,LocalDate.now()).getDays();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public String toString(){
        return "Borrowing time : " + start+"\nExpiry Date : " + finish + "\nDays left : " + daysleft;
    }

    public String toString2(){
        return getStart() + "<N/>" + getFinish() + "<N/>" + getDaysleft() + "<N/>" + book.getTitle() + "<N/>" + user.getName()+"<N/>";
    }


}

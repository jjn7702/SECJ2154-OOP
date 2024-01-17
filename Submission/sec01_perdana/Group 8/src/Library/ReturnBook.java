package Library;
import java.util.Scanner;
public class ReturnBook implements IOOperation {

    Scanner scanner = new Scanner(System.in);
    public void oper(Database database,User user){
        System.out.print("Enter book name : ");
        String bookName = scanner.nextLine();

        if(!database.getBrws().isEmpty()){
            for(Borrowing b : database.getBrws()){
                if(b.getBook().getTitle().matches(bookName) && b.getUser().getName().matches(user.getName())){
                    Book book = b.getBook();
                    int i = database.getAllBooks().indexOf(book);
                    if(b.getDaysleft()>0){
                        System.out.println("You are late " + "You have to pay" + Math.abs(b.getDaysleft()*50) + "as fine");
                    }
                    book.setBrwCoppies(book.getBrwCoppies()+1);
                    database.returnBook(b, book, i);
                    System.out.println("Book returned successfully\n");
                    break;
                }else{
                    System.out.println("You didn't borrow this book\n");
                }
            }
        }else{
            System.out.println("You didn't borrow any book\n");
        }

        System.out.print("Press any to continue.... ");
        Scanner pause = new Scanner(System.in);
        pause.nextLine();
        System.out.print("\033[H\033[2J");
            System.out.flush();

        user.menu(database, user);

    }
}

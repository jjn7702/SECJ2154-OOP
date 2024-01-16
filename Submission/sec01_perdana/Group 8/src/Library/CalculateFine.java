package Library;
import java.util.Scanner;
public class CalculateFine implements IOOperation {

    Scanner scanner = new Scanner(System.in);
    public void oper(Database database,User user){
        System.out.println("Enter book name : ");
        String bookName = scanner.nextLine();

        boolean g = true;

        for(Borrowing b : database.getBrws()){
            if(b.getBook().getTitle().equals(bookName) && b.getUser().getName().equals(user.getName())){
                if(b.getDaysleft()>0){
                    System.out.println("You are late\n" + "You have to pay " + b.getDaysleft()*50 + " as fine");
                }else{
                    System.out.println("You dont have to pay any fine");
                }
                g= false;
                break;
            }
        }
        user.menu(database, user);

        if(g){
            System.out.println("You didn't borrow this book");
        }
        


    }
}

package Library;
import java.util.Scanner;
public class DeleteBook implements IOOperation {

    Scanner s = new Scanner(System.in);

    public void oper(Database database,User user){

        System.out.print("Enter book name to delete : ");
        String bookName = s.nextLine();


        int i = database.getBook(bookName);
        if (i>-1){
            database.deleteBook(i);
            System.out.println("Book deleted successfully\n");
        }else{
            System.out.println("Book not found / Book Doesn't exist\n");
        }
       
        user.menu(database, user);


    }
}
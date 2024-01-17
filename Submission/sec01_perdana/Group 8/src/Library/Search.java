package Library;
import java.util.*;
public class Search implements IOOperation{

    Scanner scanner = new Scanner(System.in);
    public void oper(Database database,User user){
        System.out.print("Enter the name of the book you want to search : ");
        String name = scanner.nextLine();

        int i = database.getBook(name);
        if (i>-1){
            System.out.println("\n" + database.getBook(i).toString()+"\n");
            System.out.print("\n\nPress Any key to continue...");
            scanner.nextLine(); // This will pause the program


        }else{
            System.out.println("Book not found / Book Doesn't exist\n");
            System.out.print("\n\nPress Any key to continue...");
            scanner.nextLine(); // This will pause the program

        }
        
        

        user.menu(database, user);


    }
}

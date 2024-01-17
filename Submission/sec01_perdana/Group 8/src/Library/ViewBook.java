package Library;
import java.util.ArrayList;
import java.util.Scanner;
public class ViewBook implements IOOperation{

    Scanner scanner = new Scanner(System.in);

    public void oper(Database database,User user){
        ArrayList<Book> books = database.getAllBooks();
        System.out.println("=".repeat(280));
        printCentered("Name", "Author", "Publisher", "ISBN", "Quantity", "Price", "Borrowing Copies");
        System.out.println("=".repeat(280));

        for(Book b : books){
            printCentered(b.getTitle(), b.getAuthor(), b.getPublisher(), b.getIsbn(), String.valueOf(b.getQty()), String.format("RM%.2f", b.getPrice()), String.valueOf(b.getBrwCoppies()));
        }
       

        System.out.print("Press Any key to continue...");
        scanner.nextLine();
        user.menu(database, user);


    }
      private void printCentered(String... texts) {
         for (String text : texts) {
             System.out.printf("%20s%20s", "", text);
         }
         System.out.println();
     }

}

package Library;
import java.util.Scanner;

public class ViewOrders implements IOOperation {

    Scanner s = new Scanner(System.in);

    public void oper(Database database,User user){
        System.out.print("\nEnter book name :  ");
        String bookName = s.nextLine();

        int i = database.getBook(bookName);
        if(i>-1){
            System.out.printf("\n\n%-20s %-20s %-10s %-10s%n", "Book", "User", "Quantity", "Price");
            for (Order order : database.getAllOrders()) {
                if(order.getBook().getTitle().equals(bookName)){
                    System.out.printf("%-20s %-20s %-10d %-10.2f%n", 
                    order.getBook().getTitle(), 
                    order.getUser().getName(), 
                    order.getQuantity(), 
                    order.getPrice());
                }
                System.out.print("\n\nPress Any key to continue...");
                s.nextLine(); // This will pause the program
            }
            System.out.println();
        }else{
            System.out.println("Book doesn't exist in the database\n");
            System.out.print("Press Any key to continue...");
            s.nextLine(); // This will pause the program


        }

        user.menu(database, user);

    }
}

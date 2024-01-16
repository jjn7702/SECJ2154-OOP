package Library;
import java.util.Scanner;

public class ViewOrders implements IOOperation {

    Scanner s = new Scanner(System.in);

    public void oper(Database database,User user){
        System.out.println("\nEnter book name :  ");
        String bookName = s.nextLine();

        int i = database.getBook(bookName);
        if(i>-1){
            System.out.println("Book\t\tUser\t\tQuantity\t\tPrice");
            for (Order order : database.getAllOrders()) {
                if(order.getBook().getTitle().equals(bookName)){
                    System.out.println(order.getBook().getTitle()+ "\t\t"+
                    order.getUser().getName()+ "\t\t" + order.getQuantity() + "\t\t" + order.getPrice());
                }
                
            }
            System.out.println();
        }else{
            System.out.println("Book doesn't exist in the database\n");
        }

        user.menu(database, user);

    }
}

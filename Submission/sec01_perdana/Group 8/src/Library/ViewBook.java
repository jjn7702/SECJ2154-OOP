package Library;
import java.util.ArrayList;
public class ViewBook implements IOOperation{
    public void oper(Database database,User user){
        ArrayList<Book> books = database.getAllBooks();
        System.out.println("Name\tAuthor\tPublisher\tISBN\tStatus\tQuantity\tPrice\tBorrowing Copies");

        for(Book b : books){
            System.out.println(b.getTitle()+"\t"+b.getAuthor()+"\t"+b.getPublisher()+"\t\t"+b.getIsbn()+"\t"+b.getStatus()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+b.getBrwCoppies());
            
        }

        System.out.println("Press Enter to continue...");
        user.menu(database, user);


    }
}

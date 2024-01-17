package Library;

import java.util.Scanner;

public class AddBook implements IOOperation {

    Scanner scanner = new Scanner(System.in);
    public void oper(Database database,User user){
        Book book = new Book();
        System.out.print("Enter Book Name              : ");
        String name = scanner.nextLine();

        if(database.getBook(name) > -1){
            System.out.println("Book Already Exist\n");
            user.menu(database, user);
            return;

        }else{
            book.setTitle(name);
            System.out.print("Enter Book Author            : ");
            book.setAuthor(scanner.nextLine());
            System.out.print("Enter Book Publisher         : ");
            book.setPublisher(scanner.nextLine());
            System.out.print("Enter Book ISBN              : ");
            book.setIsbn(scanner.nextLine());
            System.out.print("Enter Book Quantity          : ");
            book.setQty(scanner.nextInt());
            System.out.print("Enter Book Price             : RM");
            book.setPrice(scanner.nextDouble());
            System.out.print("Enter Borrowing Quantity     : ");
        book.setBrwCoppies(scanner.nextInt());
            database.AddBook(book);
            System.out.println("\nBook Added Successfully\n");
            
            user.menu(database, user);
        }
       
    }
}

package Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation{

    Scanner scanner = new Scanner(System.in);
    public void oper(Database database,User user){


        Order order = new Order();
        System.out.println("\nEnter Book Name : ");
        String bookName = scanner.nextLine();

        int i = database.getBook(bookName);

        if(i<=-1){
            System.out.println("Book doesn't exist in the database");
        }else{
            Book book = database.getBook(i);
            order.setBook(book);
            order.setUser(user);
            System.out.println("Enter qty :");
            int qty = scanner.nextInt();
            order.setQuantity(qty);
            order.setPrice(book.getPrice()*qty);

            int bookindex = database.getBook(book.getTitle());

            book.setQty(book.getQty()-qty);
            database.addOrder(order,book,bookindex);
            System.out.println("Order Placed Successfully\n");
        }

        user.menu(database, user);


    }

    
}

package Library;

import java.util.Scanner;

public class BorrowBook implements IOOperation{
    Scanner s = new Scanner(System.in);
    public void oper(Database database,User user){
        
        System.out.println("Enter Book You Wanna borrow : ");
        String bookName = s.nextLine();

        int i = database.getBook(bookName);

        if (i>-1){
            Book book = database.getBook(i);
            boolean n = true;
            for(Borrowing b  : database.getBrws()){
                if(b.getBook().getTitle().equals(bookName) && b.getUser().getName().equals(user.getName())){
                    n = false;
                    System.out.println("You already borrowed this book\n");
                }
            }

            if(n){
                if(book.getBrwCoppies()>1){
                    Borrowing borrowing = new Borrowing(book,user);
                    book.setBrwCoppies(book.getBrwCoppies()-1);
                    database.borrowBook(borrowing, book, i);
                    System.out.println("You must return the book the book before 14 days from now \n" + "Exipry Date : " + borrowing.getFinish() + "\nEnjoy!\n");
                }else{
                    System.out.println("Sorry, No available copies for this book\n");
                }
            }

        }else{
            System.out.println("Book not found / Book Doesn't exist\n");
        }

        user.menu(database, user);

    }
}

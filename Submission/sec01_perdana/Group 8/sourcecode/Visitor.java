import java.util.Vector;

class Visitor{
    private static Vector<Book> BookView;

    public Visitors(){

    }

    public static void registration(){

    }

    public static void displayBooks(Vector<Book> BookView){
        for (Book book: BookView){
            System.out.println(book);
        }          
    }
}
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

class Admin extends User {
    private Vector<Customer> customers;
    private static Vector<Book> books;
    public Admin(String id, String name ,String pw, String mail, int roleID, String fName, String lName){
        super(id, name, pw, mail, roleID,fName,lName);
        customers = new Vector<Customer>();
        books = new Vector<Book>(); //double check with sarveish.
    }

    public Admin(){}

    public void viewAllCustomers(Customer c) throws FileNotFoundException{
        customers = c.getCustomersfromFile();
        c.viewAllCustomers(customers);
    }

    // public void viewAllBooks(Book b,int roleID) throws FileNotFoundException{ //New function sar, double check nanti :)
    //     books = b.getBooksfromFile();
    //     b.viewAllBooks(roleID);
    // }

    public void manageBookOperation(Book b, int option, int roleID) throws IOException{
        books = b.getBooksfromFile();
        switch (option) {
            case 1:
                b.addBooksIntoFile(books);
                break;
            case 2:
                b.removeBookFromFile(books); //stopped here, sarveish, kasi continue from here if u feel anything u bole improve.
                break;
            case 3:
                b.updateBookMenu(1);
                break;
            case 4:
                b.viewAllBooks(roleID); //to view book catalogue.
                break;
            default:
                break;
        }
    }

    @Override
    protected int viewMenu(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║           Admin Menu          ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View Books Catalog         ║");
            System.out.println("║ 2. Manage Orders              ║");
            System.out.println("║ 3. Manage Book                ║");
            System.out.println("║ 4. Generate Report            ║");
            System.out.println("║ 5. View All Customers         ║");
            System.out.println("║ 6. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-6) : ");
            option = sc.nextInt();

            if(option < 1 || option > 6){
                System.out.println("Invalid option entered. Please enter a number between 1 and 7. Try Again :)");
            }

        }while(option < 1 || option > 6);
        return option;
    }


}

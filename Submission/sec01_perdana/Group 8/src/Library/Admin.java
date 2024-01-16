package Library;
import java.util.*;

public class Admin extends User{
    
   
    
    public Admin(){};

    public Admin(String name){
        super(name);
        this.operations = new IOOperation[]{
            new ViewBook(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()

        };
    }

    public Admin(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
        this.operations = new IOOperation[]{
            new ViewBook(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
            new Exit()

        };
    }

    @Override
    public void menu(Database database,User user){
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search Books");
        System.out.println("5. Delete All Data");
        System.out.println("6. View Orders");
        System.out.println("7. Exit ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Press any to continue.... ");
        scanner.nextLine();
        this.operations[n-1].oper(database,user);
        scanner.close();


    }

    public String toString(){
        return name + "<N/>" + email + "<N/>" + phoneNumber + "<N/>" + "Admin";  
    }

}

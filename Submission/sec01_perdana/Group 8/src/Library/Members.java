package Library;
import java.util.Scanner;

public class Members extends User {
        
    public Members(){};

    public Members(String name){
        super(name);
        this.operations = new IOOperation[]{
            new ViewBook(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()

        };
    }

    public Members(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
        this.operations = new IOOperation[]{
            new ViewBook(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()

        };
    }

    @Override
    public void menu(Database database,User user){
        System.out.println("1. View Books");
        System.out.println("2. Search Books");
        System.out.println("3. Place Orders");
        System.out.println("4. Borrow Book ");
        System.out.println("5. Caluclate Fine ");
        System.out.println("6. Return Book ");
        System.out.println("7. Exit ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        this.operations[n-1].oper(database,user);
        scanner.close();

    }
    public String toString(){
        return name + "<N/>" + email + "<N/>" + phoneNumber + "<N/>" + "Member";  
    }

} 
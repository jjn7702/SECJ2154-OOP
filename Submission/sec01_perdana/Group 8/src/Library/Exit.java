package Library;
import java.util.Scanner;


public class Exit implements IOOperation {
    Scanner scanner = new Scanner(System.in);
    Database database;
    User user;
    public void oper(Database database,User user){
        this.database = database;
        this.user = user;
        System.out.println("\nAre you sure you want to exit\n 1. Yes\n 2. Main Menu");
        int n = scanner.nextInt();
        if(n==1){
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");
            int num  = scanner.nextInt();
    
            switch(num){
                case 1:
                    Login();
                    break;
                case 2:
                    Register();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        else{
            user.menu(database, user);
        }
    }



    public void Login(){
        System.out.println("Login");
        System.out.print("Enter your Phone Number : ");
        String phoneNumber = scanner.next();
        System.out.print("Enter your Email: ");
        String email = scanner.next();
        int n = database.login(phoneNumber, email);
        if(n!= -1){
            User user = database.getUser(n);
            user.menu( database, user);
        }else{
            System.out.println("User Does not exist");
        }
    }

    public void Register(){
        System.out.println("======================Create An Account======================");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your phone number : ");
        String phoneNumber = scanner.next();
        System.out.print("Enter your email: ");
        String email = scanner.next();

        System.out.println("1. Admin \n2. Member");
        int n2 = scanner.nextInt();
        User user;
        if(n2==1){
            user = new Admin(name, email, phoneNumber);
    
        }
        else{
            user = new Members(name, email, phoneNumber);
        }
        database.AddUser(user);
        user.menu(database, user);

   

    }


}
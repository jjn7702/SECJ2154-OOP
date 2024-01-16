package Library;
import java.util.Scanner;

public class Main{

    private static Scanner scanner = new Scanner(System.in);
    static Database database;
    public static void main(String[] args) {
        
        database = new Database();

        
        System.out.println("====================================");
        System.out.println("Welcome to Library Management System");
        System.out.println("===================================="); 

            int num;
                System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");
            num  = scanner.nextInt();
    
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
            scanner.close();
            
    
        
    }


    public static void Login(){
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

    public static void Register(){
        System.out.println("======================Create An Account======================");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        if(database.userExist(name)){
            System.out.println("User exist !");
            Register();
        }
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
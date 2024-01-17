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
        System.out.print("\033[H\033[2J");
            System.out.flush();
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
        System.out.println("============================================OTTER LMS==================================================");
        System.out.println("=                                                                                                     =");
        System.out.println("=                                         CREATE ACCOUNT                                              =");
        System.out.println("=                                                                                                     =");
        System.out.println("=======================================================================================================");
        System.out.print("Enter Your Name: ");
        String name = scanner.next();
        if(database.userExist(name)){
            System.out.println("This User/Username is already exist !.....");
            System.out.println("Please try again,Thank You.....");
            Register();
        }
        System.out.print("Enter your phone number : ");
        String phoneNumber = scanner.next();
        System.out.print("Enter your email        : ");
        String email = scanner.next();

        System.out.print("\033[H\033[2J");
        System.out.flush();


        System.out.println("============================================OTTER LMS==================================================");
        System.out.println("=                                        Choose Your User Type                                        =");
        System.out.println("=                                        1. Admin                                                     =");
        System.out.println("=                                        2. Member                                                    =");
        System.out.println("=======================================================================================================");

        int n2 = scanner.nextInt();
        User user;
        if(n2==1){
            user = new Admin(name, email, phoneNumber);
    
        }
        else{
            user = new Members(name, email, phoneNumber);
        }
        database.AddUser(user);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        user.menu(database, user);

        
   

    }


}

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

        System.out.println("\n\n");
        System.out.println("===================================================================================================================================");
        System.out.println("=                                                                                                                                 =");
        System.out.println("=                                                                                                                                 =");
        System.out.println("=                                            Welcome to Library Management System                                                 =");
        System.out.println("=                                          ## ##   #### ##  #### ##  ### ###   ### ##                                             =");
        System.out.println("=                                         ##   ##  # ## ##  # ## ##   ##  ##   ##  ##                                             =");
        System.out.println("=                                         ##   ##    ##       ##      ##       ##  ##                                             =");
        System.out.println("=                                         ##   ##    ##       ##      ## ##    ## ##                                              =");
        System.out.println("=                                         ##   ##    ##       ##      ##       ## ##                                              =");
        System.out.println("=                                         ##   ##    ##       ##      ##  ##   ##  ##                                             =");
        System.out.println("=                                         ##   ##    ##       ##      ##  ##   ##  ##                                             =");
        System.out.println("=                                          ## ##    ####     ####    ### ###  #### ##                                             =");
        System.out.println("-----------------------------------                                                       --------------------------------------");
        System.out.println("=                                               ####       ##   ##   ## ##                                                        =");
        System.out.println("=                                               ##         ##   ##  ##   ##                                                       =");
        System.out.println("=                                               ##         # ### #  ####                                                          =");
        System.out.println("=                                               ##         ## # ##   #####                                                        =");
        System.out.println("=                                               ##         ##   ##      ###                                                       =");
        System.out.println("=                                               ##  ##     ##   ##  ##   ##                                                       =");
        System.out.println("=                                               ### ###    ##   ##   ## ##                                                        =");
        System.out.println("=                                                                                                                                 =");
        System.out.println("===================================================================================================================================");
        System.out.println("=                                                                                                                                 =");
        System.out.printf("=                                                             Hello %-61s =%n", this.name.toUpperCase());
        System.out.println("=                                                                                                                                 =");
        System.out.println("===================================================================================================================================");


        System.out.println("========================================================ADMIN PRIVELAGES==========================================================");
        System.out.println("=                                                                                                                                =");
        System.out.println("=                                                                                                                                =");
        System.out.println("=                                                   1. View Books                                                                =");
        System.out.println("=                                                   2. Add Books                                                                 =");
        System.out.println("=                                                   3. Delete Books                                                              =");
        System.out.println("=                                                   4. Search Books                                                              =");
        System.out.println("=                                                   5. Delete All Data                                                           =");
        System.out.println("=                                                   6. View Orders                                                               =");
        System.out.println("=                                                   7. Exit                                                                      =");
        System.out.println("=                                                                                                                                =");
        System.out.println("=                                                                                                                                =");
        System.out.println("==================================================================================================================================");


        System.out.print("Enter your choice you would like to perform : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.print("Press any to continue.... ");
        Scanner pause = new Scanner(System.in);
        pause.nextLine();
        System.out.print("\033[H\033[2J");
            System.out.flush();
        
        this.operations[n-1].oper(database,user);
        scanner.close();
        pause.close();


    }

    public String toString(){
        return name + "<N/>" + email + "<N/>" + phoneNumber + "<N/>" + "Admin";  
    }

}

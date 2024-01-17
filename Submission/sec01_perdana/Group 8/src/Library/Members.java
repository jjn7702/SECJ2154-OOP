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

        System.out.println("========================================================MEMBER PRIVELAGES==========================================================");
        System.out.println("=                                                                                                                                 =");
        System.out.println("=                                                        1. View Books                                                            =");
        System.out.println("=                                                        2. Search Books                                                          =");
        System.out.println("=                                                        3. Place Orders                                                          =");
        System.out.println("=                                                        4. Borrow Book                                                           =");
        System.out.println("=                                                        5. Caluclate Fine                                                        =");
        System.out.println("=                                                        6. Return Book                                                           =");
        System.out.println("=                                                        7. Exit                                                                  =");
        System.out.println("=                                                                                                                                 =");
        System.out.println("=                                                                                                                                 =");
        System.out.println("===================================================================================================================================");


        System.out.print("Enter your choice you woud like to perform : ");
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
        return name + "<N/>" + email + "<N/>" + phoneNumber + "<N/>" + "Member";  
    }

}   

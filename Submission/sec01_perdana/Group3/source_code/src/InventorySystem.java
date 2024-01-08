import java.io.*;
import java.util.*;

public class InventorySystem {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice, userOption, userOptionSupplier;
        User user = new User();
        do{
            System.out.print("\033[H\033[2J");  
            System.out.flush();

            header();

            System.out.println("\n\nRoles :\n\t1. Admin\n\t2. Customer\n\t3. Supplier");
            System.out.print("Enter your role (1-3) : ");
            choice = scan.nextInt();
            if(choice<1 || choice > 3){
                System.out.println("Invalid option entered. Please Try Again! Press any key to continue...");
                scan.nextLine();
                scan.nextLine();
            }
        }while(choice<1 || choice > 3);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        header();

    }

    public static int manageMenu(int roleID) throws IOException{
        int option;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("\n\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Book          ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Add New Book               ║");
            System.out.println("║ 2. Remove Book                ║");
            System.out.println("║ 3. Edit Book Details          ║");
            System.out.println("║ 4. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-4): ");
            option = scan.nextInt();

            if(option < 1 || option >4){
                System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
            }
        } while (option < 1 || option >4);


        if(option == 4){
            return 9;
        }else{
            Book bk = new Book(); //creating a book with empty constructor and dont hold any value to send as param in admin's method.
            Admin.manageBookOperation(bk, option, roleID);
            return option;
        }

    }

    public static void header(){
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║                                         ║");
        System.out.println("║     Welcome to Kedai Buku Kamal!        ║");
        System.out.println("║  Your One-Stop Bookstore Experience :)  ║");
        System.out.println("║                                         ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }
}

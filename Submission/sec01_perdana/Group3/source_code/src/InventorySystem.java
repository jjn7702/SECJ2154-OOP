import java.io.*;
import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice, userOption;
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
        if(choice == 1 || choice ==3){
            do{
                scan.nextLine();
                System.out.print("\n\nEnter username : ");
                String uName = scan.nextLine();
                System.out.print("\nEnter password : ");
                String pw = scan.nextLine();
                user = User.login(uName, pw, choice);
                if(user == null){
                    System.out.println("Invalid Credentials Entered. Please Try Again!");
                }
            }while(user == null);
            if(user.getUserRole() == 1){
                BookManager bkm = new BookManager();
                do {
                    scan.nextLine();
                    userOption = Admin.viewAdminMenu();
                    switch (userOption) {
                        case 1:
                            bkm.viewAllBooks(1);

                            break;
                        case 2:
                            //manage orders
                            break;
                        case 3:
                            int val = manageMenu();
                            if(val == 9){
                                
                            }
                            break;
                        case 4:
                            //generate report
                            break;
                        case 5:
                            //manage customers
                            CustomerManager cust = new CustomerManager();
                            cust.viewAllCustomers();
                            break;
                        case 6:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                } while (userOption !=7);
                

                //if else/ case.
            }else{
                int value = BookSupplier.viewSupplierMenu();
                //if else/ case.
            }
        }else{
            do{
                System.out.println("Customer Options:\n\t1. Login\n\t2. Register");
                System.out.print("\nEnter the option (1-2) : ");
                choice = scan.nextInt();
                if(choice<1 || choice > 2){
                    System.out.println("Invalid option entered. Please Try Again!");
                    scan.nextLine();
                    scan.nextLine();
                }
            }while(choice<1 || choice > 2);

            if(choice == 1){
                do{
                    scan.nextLine();
                    System.out.print("\n\nEnter username : ");
                    String uName = scan.nextLine();
                    System.out.print("\nEnter password : ");
                    String pw = scan.nextLine();
                    user = User.login(uName, pw, 2);
                    if(user == null){
                        System.out.println("Invalid Credentials Entered. Please Try Again!");
                    }
                }while(user == null);
                int value = Customer.viewCustomerMenu();
                //if else/ case
            }else{
                Customer.registration();
                System.out.println("Successfully Registered..You will be navigated to Login :)");
                scan.nextLine();

            }

        }
scan.close();
    }


    public static int manageMenu() throws IOException{
        BookManager bkm = new BookManager();
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
                System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
            }
        } while (option < 1 || option >4);


        if(option == 4){
            return 9;
        }else{
            switch (option) {
                case 1:
                    bkm.addBooksIntoFile();
                    break;
                case 2:
                    bkm.removeBookFromFile();
                    break;
                case 3:
                    bkm.updateBookMenu(1);
                default:
                    break;
            }
            return option;
        }

    }
    public static void header(){
            System.out.println("******************************************");
            System.out.println("*                                        *");
            System.out.println("*     Welcome to Kedai Buku Kamal!        *");
            System.out.println("*  Your One-Stop Bookstore Experience :) *");
            System.out.println("*                                        *");
            System.out.println("******************************************");
    }
}

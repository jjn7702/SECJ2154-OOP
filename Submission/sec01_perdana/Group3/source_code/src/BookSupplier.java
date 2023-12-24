import java.io.*;
import java.util.*;


class BookSupplier extends User{
    public BookSupplier(String id, String name ,String pw, String mail, int roleID,String fName,String lName){
        super(id, name, pw, mail, roleID,fName,lName);
    }

    public BookSupplier(){
    }


    public static void displaySupplier(User u){
        System.out.println("+-----------------+---------------------+---------------------+---------------------+");
        System.out.println("|  Supplier ID    |    Username         |     Full Name       |        Email        |");
        System.out.println("+-----------------+---------------------+---------------------+---------------------+");
    
        System.out.printf("| %-15s | %-19s | %-19s | %-19s |%n", u.getUserID(), u.getUserName(), u.getName().getfName() + " " + u.getName().getlName(), u.getEmail());
    
        System.out.println("+-----------------+---------------------+---------------------+---------------------+");
    
}
    @Override
    protected int viewMenu(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Supplier Menu        ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View All Orders            ║");
            System.out.println("║ 2. Order Approval             ║");
            System.out.println("║ 3. Manage Account             ║");
            System.out.println("║ 4. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-4) : ");
            option = sc.nextInt();

            if(option < 1 || option > 4){
                System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
            }

        }while(option < 1 || option > 4);
        return option;
    }

    public static void manageAccount(User currUser) throws IOException{
        Scanner scan = new Scanner(System.in);
        int option;
        String newValue = "";
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            displaySupplier(currUser);
            System.out.println("\n\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Account       ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Update Username            ║");
            System.out.println("║ 2. Update Password            ║");
            System.out.println("║ 3. Update Email               ║");
            System.out.println("║ 3. Update Name                ║");
            System.out.println("║ 5. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-5): ");
            option = scan.nextInt();

            if(option < 1 || option >5){
                System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
            }
        } while (option < 1 || option >5);
        scan.nextLine();

        switch (option) {
            case 1:
                System.out.print("\nEnter new username : ");
                newValue = scan.nextLine();
                currUser.setUserName(newValue);
                break;
            case 2:
                System.out.print("\nEnter new password: ");
                newValue= scan.nextLine();

                System.out.print("\nRe-enter your password: ");
                String confirmPassword = scan.nextLine();


                while (newValue.equals(confirmPassword) == false) {
                    System.out.println("Passwords do not match. Please re-enter your password.");
                    System.out.print("\nEnter a password: ");
                    newValue = scan.nextLine();

                    System.out.print("\nRe-enter your password: ");
                    confirmPassword = scan.nextLine();
                }
                currUser.setPassword(newValue);
                break;
            case 3:
                System.out.print("\nEnter new email : ");
                newValue = scan.nextLine();
                currUser.setEmail(newValue);
                break;
            case 4:
                System.out.print("\nEnter new first name : ");
                newValue = scan.nextLine();
                currUser.getName().setfName(newValue);
                System.out.print("\nEnter new last name : ");
                newValue= scan.nextLine();
                currUser.getName().setlName(newValue);
                break;
            
            case 5:
                return;
        
            default:
                break;
        }
        Vector<User> us = new Vector<User>();
        us = User.readAllUsers();
        FileWriter file = new FileWriter("userDatabase.txt",false);
        for (User c : us) {
                String fullName = c.getName().getfName()+"_"+c.getName().getlName();
                if(c.getUserID().equals(currUser.getUserID())){
                    String username = currUser.getUserName().replaceAll(" ", "");
                    String em = currUser.getEmail().replaceAll(" ", "");
                    fullName = currUser.getName().getfName()+"_"+currUser.getName().getlName();
                    String line = String.format("%s %s %s %s %s %d%n", currUser.getUserID(), username, currUser.getPassword(), em,fullName, 3);
                    file.write(line);
                }else{
                    String line = String.format("%s %s %s %s %d%n", c.getUserID(), c.getUserName(), c.getPassword(), c.getEmail(),fullName, c.getUserRole());
                    file.write(line);
                }

            }
            file.close();
        System.out.println("Updated Successfully :)");
    };
}
import java.io.*;
import java.util.*;

public class Customer extends User  {
    private Vector<Book> bookList;
    private Vector<OrderManagement> order = new Vector<OrderManagement>();

    public Customer(){}

    public Customer(String id, String name ,String pw, String mail, int roleID, String fName, String lName){
        super(id, name, pw, mail, roleID,fName,lName);
    }

    public static void registration() throws IOException{
        Vector<Customer> cust = new Vector<Customer>();
        cust = getCustomersfromFile();
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        InventorySystem.header();
        System.out.print("\n\nEnter your username : ");
        String username = sc.nextLine();

        for(Customer c:cust){
            while (c.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                System.out.print("\nEnter a new username : ");
                username = sc.nextLine();
            }
        }

        username = username.replaceAll("\\s",""); //replacing spaces with no-space.

        System.out.print("Enter your first name: ");
        String nameFirst = sc.nextLine();

        System.out.print("Enter your last name: ");
        String nameLast = sc.nextLine();  

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter a password: ");
        String pw = sc.nextLine();

        System.out.print("Re-enter your password: ");
        String confirmPassword = sc.nextLine();

        while (pw.equals(confirmPassword) == false) {
            System.out.println("Passwords do not match. Please re-enter your password.");
            System.out.print("Enter a password: ");
            pw = sc.nextLine();

            System.out.print("Re-enter your password: ");
            confirmPassword = sc.nextLine();
        }

        String userID = username+"Cust"; //creating a fixed userID with username that they created first.
        Customer c = new Customer(userID, username, pw, email, 2,nameFirst,nameLast);
        addCustomersIntoFile(c);
        sc.close();
    }
   
    @Override
    protected int viewMenu(){ 
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            InventorySystem.header();
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Customer Menu        ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View Books Catalog         ║");
            System.out.println("║ 2. Order Books                ║");
            System.out.println("║ 3. Manage Account             ║");
            System.out.println("║ 4. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-4) : ");
            try{
                option = sc.nextInt();
                if(option < 1 || option > 4){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 4. Try Again :)");
                }
            }catch(Exception e){
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                sc.nextLine();
                sc.nextLine();
                option = 10;
            }

        }while(option < 1 || option > 4);
        return option;
    }

    public static Vector<Customer> getCustomersfromFile() throws FileNotFoundException {
        Vector<Customer> customers = new Vector<Customer>();
        Vector<User> users = User.readFromUserFile(2);

        for (User user : users) {
            Customer customer = new Customer(user.getUserID(), user.getUserName(), user.getPassword(), user.getEmail(), user.getUserRole(),user.getName().getfName(),user.getName().getlName());
            customers.add(customer);
        }
        return customers;
    }

    public static void addCustomersIntoFile(Customer c) throws IOException{
        try {
            PrintWriter outputFile = new PrintWriter(new FileWriter("Submission/sec01_perdana/Group3/source_code/src/usersDatabase.txt",true));
            String fullName =  c.getName().getfName()+"_"+c.getName().getlName();
            outputFile.write(c.getUserID()+ " "+c.getUserName()+ " "+c.getPassword()+ " "+c.getEmail()+ " "+fullName+" "+2+"\n");
            outputFile.close();

            System.out.println("\nYour username : "+c.getUserName()+"\nYour Password: "+c.getPassword());            
        } catch (Exception e) {
            System.out.print("An error is occured during file operation..Please try again..\nPress Any Key to Continue..");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        }
   
    }

    public void viewAllCustomers(Vector<Customer> customers) throws FileNotFoundException {
        if(customers.size() == 0){
            System.out.println("\nNo customers in the database.");
        }else{
            System.out.println("╔═════════════════╦═════════════════════╦═════════════════════╦═════════════════════╗");
            System.out.println("║  Customer ID    ║    Username         ║     Full Name       ║        Email        ║");
            System.out.println("╠═════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣");
            
            for (Customer u : customers) {
                System.out.printf("║ %-15s ║ %-19s ║ %-19s ║ %-19s ║%n", u.getUserID(), u.getUserName(), u.getName().getfName() + " " + u.getName().getlName(), u.getEmail());
            }
            
            System.out.println("╚═════════════════╩═════════════════════╩═════════════════════╩═════════════════════╝");
        }
         System.out.print("Press Enter to continue...");
         Scanner scan = new Scanner(System.in);
         scan.nextLine();
     }

     public static void displayCustomer(User u){
        System.out.println("╔═════════════════╦═════════════════════╦═════════════════════╦═════════════════════╗");
        System.out.println("║  Customer ID    ║    Username         ║     Full Name       ║        Email        ║");
        System.out.println("╠═════════════════╬═════════════════════╬═════════════════════╬═════════════════════╣");
    
        System.out.printf("║ %-15s ║ %-19s ║ %-19s ║ %-19s ║%n", u.getUserID(), u.getUserName(), u.getName().getfName() + " " + u.getName().getlName(), u.getEmail());
    
        System.out.println("╚═════════════════╩═════════════════════╩═════════════════════╩═════════════════════╝");
    
}

    public static void updateCustomerAcc(User currUser) throws IOException{
        Scanner scan = new Scanner(System.in);
        int option=0;
        String newValue = "";
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            InventorySystem.header();
            displayCustomer(currUser);
            System.out.println("\n\n");
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Manage Account       ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. Update Username            ║");
            System.out.println("║ 2. Update Password            ║");
            System.out.println("║ 3. Update Email               ║");
            System.out.println("║ 4. Update Name                ║");
            System.out.println("║ 5. Back                       ║");
            System.out.println("╚═══════════════════════════════╝");
            System.out.print("\nEnter your option (1-5): ");
            try {
                option = scan.nextInt();   
                if(option < 1 || option >5){
                    System.out.println("Invalid option entered. Please enter a number between 1 and 5. Try Again :)");
                    System.out.print("Press any key to continue..");
                    scan.nextLine();
                    scan.nextLine();
                }             
            } catch (InputMismatchException e) {
                System.out.println("Invalid option entered. Please Enter an appropriate number.\nPress any key to continue...");
                scan.nextLine();
                scan.nextLine();
                option = 10;                
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
        try {
            FileWriter file = new FileWriter("Submission/sec01_perdana/Group3/source_code/src/usersDatabase.txt",false);
                for (User c : us) {
                        String fullName = c.getName().getfName()+"_"+c.getName().getlName();
                        if(c.getUserID().equals(currUser.getUserID())){
                            String username = currUser.getUserName().replaceAll(" ", "");
                            String em = currUser.getEmail().replaceAll(" ", "");
                            fullName = currUser.getName().getfName()+"_"+currUser.getName().getlName();
                            String line = String.format("%s %s %s %s %s %d%n", currUser.getUserID(), username, currUser.getPassword(), em,fullName, 2);
                            file.write(line);
                        }else{
                            String line = String.format("%s %s %s %s %s %d%n", c.getUserID(), c.getUserName(), c.getPassword(), c.getEmail(),fullName, c.getUserRole());
                            file.write(line);
                        }

                    }
                    file.close();
                System.out.println("Updated Successfully :)");            
        } catch (Exception e) {
            System.out.print("An error is occured during file operation..Please try again..\nPress Any Key to Continue..");
            scan.nextLine();
        }
 
    }

    public void orderNewBooks(OrderManagement o){
        order.add(o);
    }  

    public  void displayBooks(Vector<Book>b,int role) throws FileNotFoundException{
        bookList = b;
        bookList.get(0).viewAllBooks(bookList,2);
    }
}


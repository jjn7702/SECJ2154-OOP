import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class Customer extends User{
    private String customerID;


    public Customer(){}

    public Customer(String id, String name ,String pw, String mail, int roleID){
        super(id, name, pw, mail, roleID);
        customerID = id;
    }

    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public static void registration() throws IOException {
        Vector<Customer> cust = new Vector<Customer>();
        cust = CustomerManager.getCustomersfromFile();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEnter your username (No spaces in-between): ");
        String username = sc.nextLine();

        for(Customer c:cust){
            while (c.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                System.out.print("\nEnter a new username (No spaces in-between): ");
                username = sc.nextLine();
            }
        }

        username = username.replaceAll("\\s","");

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        // Prompt for password
        System.out.print("Enter a password: ");
        String pw = sc.nextLine();

        // Prompt for re-entered password
        System.out.print("Re-enter your password: ");
        String confirmPassword = sc.nextLine();

        // Validate password match
        while (pw.equals(confirmPassword) == false) {
            System.out.println("Passwords do not match. Please re-enter your password.");
            System.out.print("Enter a password: ");
            pw = sc.nextLine();

            System.out.print("Re-enter your password: ");
            confirmPassword = sc.nextLine();
        }
        String userID = username+"Cust";
        Customer c = new Customer(userID, username, pw, email, 2);
        CustomerManager cm = new CustomerManager();
        cm.addCustomersIntoFile(c);
        sc.close();
    }


    public static int viewCustomerMenu(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Customer Menu        ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View Books Catalog         ║");
            System.out.println("║ 2. Order Books                ║");
            System.out.println("║ 3. Check Order History        ║");
            System.out.println("║ 4. Manage Account             ║");
            System.out.println("║ 5. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-5) : ");
            option = sc.nextInt();

            if(option < 1 || option > 5){
                System.out.println("Invalid option entered. Please enter a number between 1 and 7. Try Again :)");
            }

        }while(option < 1 || option > 5);
        return option;
    }
}

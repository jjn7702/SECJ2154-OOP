import java.io.*;
import java.util.*;

class CustomerManager{
    private static Vector<Customer> customers;

    public CustomerManager() throws FileNotFoundException{
         customers = getCustomersfromFile();

    }

    public static Vector<Customer> getCustomersfromFile() throws FileNotFoundException {
        Vector<Customer> customers = new Vector<Customer>();
        Vector<User> users = User.readFromUserFile(2);

        for (User user : users) {
            Customer customer = new Customer(user.getUserID(), user.getUserName(), user.getPassword(), user.getEmail(), user.getUserRole());
            customers.add(customer);
        }
        return customers;
    }

    public void addCustomersIntoFile(Customer c) throws IOException{
        PrintWriter outputFile = new PrintWriter(new FileWriter("userDatabase.txt",true));
        outputFile.write(c.getUserID()+ " "+c.getUserName()+ " "+c.getPassword()+ " "+c.getEmail()+ " "+2+"\n");
        outputFile.close();
        customers.add(c);

        System.out.println("Your username : "+c.getUserName()+"\nYour Password: "+c.getPassword());
    }

    public void viewAllCustomers() {
        System.out.println("+------------------+---------------------+---------------------+---------------------+");
        System.out.println("|   Customer ID    |      Username       |        Email        |         Role        |");
        System.out.println("+------------------+---------------------+---------------------+---------------------+");
        
        for (Customer customer : customers) {
            System.out.printf("| %-16s | %-19s | %-19s | %-19s |%n",
                    customer.getUserID(), customer.getUserName(), customer.getEmail(), "Customer");
        }
        
        System.out.println("+------------------+---------------------+---------------------+---------------------+");
        

        System.out.print("Press Enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
    
    public Boolean updateCustomerAcc(int category, String id, String value) throws IOException{
        for(Customer c : customers){
            if(c.getUserID().equals(id)){
                switch (category) {
                    case 1:
                        c.setUserName(value);
                        break;
                    case 2:
                        c.setPassword(value);
                    case 3:
                        c.setEmail(value);
                
                    default:
                        return false;
                }
            }
        }

        if(customers !=null){
            FileWriter file = new FileWriter("userDatabase.txt",false);
            for (Customer c : customers) {
                String line = String.format("%s %s %s %s %d%n",
                        c.getUserID(), c.getUserName(), c.getPassword(), c.getEmail(), 2);
                file.write(line);
            }
            file.close();
        }

        return true;
    }
}
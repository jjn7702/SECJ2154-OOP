import java.io.*;
import java.util.*;

public class GrocerySystem {
    public static void main(String[] args) throws IOException {

        ArrayList<Buyer> users = new ArrayList<>();
        ArrayList<Seller> seller = new ArrayList<>();
        int option = 0;
        Scanner inp = new Scanner(System.in);
        File f = new File("User.csv");
        Scanner in = new Scanner(f);
        users = ReadUser(in);
        in.close();
        f = new File("Seller.csv");
        in = new Scanner(f);
        seller = ReadSeller(in);

        do {
            System.out.printf("%50s%s\n", " ", "Hello and Welcome to Grocery Shopping Assistant!");
            System.out.printf("%50s%s\n", " ", "------------------------------------------------");
            System.out.println("Press 1 is you want to make a grocery list!");
            System.out.println("Press 2 if you want to manage your store!");
            System.out.println("Press 3 to exit the system!");
            System.out.print("Option: ");
            option = Integer.parseInt(inp.nextLine());

            switch (option) {
                case 1: {
                    Buyer now = null;
                    now = LoginBuyer(users);
                    if (now == null) {
                        System.out.println("Please try again!");
                    } else {
                        now.BuyerInterface(seller);
                        now.GroceryList(seller);
                        saveBuyerAndSeller(seller, users);
                        System.out.println("Thank you for using our system!");
                        System.exit(0);
                    }
                    break;
                }
                case 2: {
                    Seller now = null;
                    now = LoginSeller(seller);
                    if (now == null)
                        System.out.println("Error");
                    else
                        now.Manage();
                    saveBuyerAndSeller(seller, users);
                    System.out.println("Thank you for using our system!");
                    System.exit(0);
                    break;
                }

                default: {
                    saveBuyerAndSeller(seller, users);
                    System.out.println("Thank you for using our system!");
                }
                    break;
            }

        } while (option != 3);

    }
    public static void saveBuyerAndSeller(ArrayList<Seller> s, ArrayList<Buyer> b) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("User.csv"))) {
            for (Buyer x : b) {
                writer.print(x.getEmail().toLowerCase() + ",");
                writer.print(x.getPassword() + ",");
                writer.print(x.getName() + ",");
                writer.print(x.getAdd().getStreet() + ",");
                writer.print(x.getAdd().getState() + ",");
                writer.print(x.getAdd().getZipcode() + ",");
                writer.println(x.getAdd().getCountry());
                x.saveData();
            }
        } catch (IOException e) {
            System.out.println("Error : File not found");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("Seller.csv"))) {
            for (Seller x : s) {
                writer.print(x.getEmail().toLowerCase() + ",");
                writer.print(x.getPassword() + ",");
                writer.print(x.getName() + ",");
                writer.print(x.getStore().getName() + ",");
                writer.print(x.getStore().getAdd().getStreet() + ",");
                writer.print(x.getStore().getAdd().getState() + ",");
                writer.print(x.getStore().getAdd().getZipcode() + ",");
                writer.println(x.getStore().getAdd().getCountry());
                x.saveData();
            }
        } catch (IOException e) {
            System.out.println("Error : File not found");
        }
    }

}



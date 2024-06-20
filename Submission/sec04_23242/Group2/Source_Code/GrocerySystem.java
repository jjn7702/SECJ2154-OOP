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

    //Read User
    public static ArrayList<Buyer> ReadUser(Scanner inp) throws IOException {

        inp.useDelimiter(",|\\n");
        ArrayList<Buyer> Buyers = new ArrayList<>();
        int num = 0;

        while (inp.hasNext()) {
            String e = "", p = "", n = "", st = "", state = "", zipcode = "", country = "";
            e = inp.next();
            p = inp.next();
            n = inp.next();
            st = inp.next();
            state = inp.next();
            zipcode = inp.next();
            country = inp.nextLine();
            country = country.substring(1);
            Buyers.add(new Buyer(e, p, n, new Address(st, zipcode, state, country)));
            Buyers.get(num).readCart();
            num++;
        }
        return Buyers;
    }

    //Read Seller
    public static ArrayList<Seller> ReadSeller(Scanner inp) throws IOException {

        inp.useDelimiter(",|\\n");
        ArrayList<Seller> s = new ArrayList<>();
        int z = 0;

        while (inp.hasNext()) {
            String e = "", p = "", n = "", i = "", st = "", state = "", zipcode = "", country = "";
            e = inp.next();
            p = inp.next();
            n = inp.next();
            i = inp.next();
            st = inp.next();
            state = inp.next();
            zipcode = inp.next();
            country = inp.nextLine();
            country = country.substring(1);
            s.add(new Seller(e, p, n, new Store(i, new Address(st, zipcode, state, country))));
            s.get(z).readItem();
            z++;
        }
        return s;
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

        //Login Buyer
    public static Buyer LoginBuyer(ArrayList<Buyer> b) {
        Scanner inp = new Scanner(System.in);
        System.out.println();
        System.out.println("Press 1 to login!");
        System.out.println("Press 2 for register!");
        System.out.print("Option: ");
        int opt = Integer.parseInt(inp.nextLine());
        System.out.println();
        if (opt == 1) {
            boolean check = true;
            do {
                System.out.print("Please enter your Email: ");
                String email = inp.nextLine();
                System.out.print("Please enter your password: ");
                String pass = inp.nextLine();
                Buyer atm = GetCurrentUser(email, pass, b);
                if (atm == null)
                    check = true;
                else
                    return atm;
            } while (check);
        } else {
            System.out.print("Please enter your email: ");
            String e = inp.nextLine().toLowerCase();
            boolean email = true;
            for (Buyer x : b) {
                if (x.getEmail().equals(e)) {
                    email = false;
                    break;
                }
            }

            if (email) {
                System.out.print("Please enter your name: ");
                String n = inp.nextLine();
                System.out.println("Please enter your Address");
                System.out.print("Street: ");
                String st = inp.nextLine();
                System.out.print("Zipcode: ");
                String z = inp.nextLine();
                System.out.print("State: ");
                String state = inp.nextLine();
                System.out.print("Country: ");
                String c = inp.nextLine();

                System.out.print("Please enter your password: ");
                String p = inp.nextLine();
                boolean check = true;
                do {
                    System.out.print("Please re-enter your password: ");
                    String g = inp.nextLine();
                    if (p.equals(g))
                        check = true;
                    else
                        check = false;
                } while (!check);

                Address a = new Address(st, state, z, c);
                Buyer b1 = new Buyer(e, p, n, a);
                b.add(b1);
                return b1;
            } else {
                System.out.println("There is already a account with this email!");
            }
        }
        return null;
    }

    //Get Current User
    public static Buyer GetCurrentUser(String email, String pass, ArrayList<Buyer> B) {
        for (Buyer x : B) {
            if (x.getEmail().equals(email) && (x.getPassword().equals(pass))) {
                return x;
            }
        }
        return null;
    }

    //Login Seller
    public static Seller LoginSeller(ArrayList<Seller> s) {
        System.out.println();
        Scanner inp = new Scanner(System.in);
        System.out.println("Press 1 to login!");
        System.out.println("Press 2 for register!");
        System.out.print("Option: ");
        int opt = Integer.parseInt(inp.nextLine());
        System.out.println();
        if (opt == 1) {
            boolean check = true;
            do {
                System.out.print("Please enter your Email: ");
                String email = inp.nextLine();
                System.out.print("Please enter your password: ");
                String pass = inp.nextLine();
                Seller atm = GetCurrentSeller(email, pass, s);
                if (atm == null)
                    check = true;
                else
                    return atm;
            } while (!check);
        } else {
            System.out.print("Please enter your email: ");
            String e = inp.nextLine().toLowerCase();
            boolean email = true;
            for (Seller x : s) {
                if (x.getEmail().equals(e)) {
                    email = false;
                    break;
                }
            }

            if (email) {
                System.out.print("Please enter your name: ");
                String n = inp.nextLine();
                System.out.println("Please enter your Address");
                System.out.print("Street: ");
                String st = inp.nextLine();
                System.out.print("Zipcode: ");
                String z = inp.nextLine();
                System.out.print("State: ");
                String state = inp.nextLine();
                System.out.print("Country: ");
                String c = inp.nextLine();

                System.out.print("Please enter your password: ");
                String p = inp.nextLine();
                boolean check = true;
                do {
                    System.out.print("Please re-enter your password: ");
                    String g = inp.nextLine();
                    if (p.equals(g))
                        check = true;
                    else
                        check = false;
                } while (!check);
                System.out.print("Please enter your shop name: ");
                String sh = inp.nextLine();
                Address a = new Address(st, state, z, c);
                Store st1 = new Store(sh, a);
                Seller s1 = new Seller(e, p, n, st1);
                s.add(s1);
                return s1;
            } else {
                System.out.println("There is already a account with this email!");
            }
        }
        return null;
    }


        //Get Current Seller
    public static Seller GetCurrentSeller(String email, String pass, ArrayList<Seller> s) {
        for (Seller x : s) {
            if (x.getEmail().equals(email) && (x.getPassword().equals(pass))) {
                return x;
            }
        }
        return null;
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



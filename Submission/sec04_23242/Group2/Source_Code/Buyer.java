import java.util.*;
import java.io.*;

class Buyer extends User implements interfaceBuyer {
    private String id;
    private Cart cart;
    private Address add;
    private static int n = 0;

    public Buyer(String email, String pass, String name, Address a) {
        super(email, pass, name);
        cart = new Cart();
        add = a;
        assignId();
    }

    public void display() {
        System.out.println();
        System.out.println("Name: " + super.getName());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Password: " + getPassword());
        System.out.println("Address: " + add.toString());

    }

    public Address getAdd() {
        return add;
    }

    public void displayCart() {
        cart.displayCart();
    }

    public void assignId() {
        id = "B" + n;
        n++;
    }

    public void BuyerInterface(ArrayList<Seller> sellers) {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n1) Add Item");
            System.out.println("2) Edit Quantity");
            System.out.println("3) Delete Item");
            System.out.println("4) View Cart");
            System.out.println("5) Change Address");
            System.out.println("6) User Menu");
            System.out.println("7) Exit");
            System.out.print("Option(1-7): ");
            choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1: {
                    cart.addItem();
                    break;
                }
                case 2: {
                    cart.EditItem();
                    break;
                }

                case 3: {
                    cart.deleteItem();
                    break;
                }
                case 4: {
                    cart.displayCartFinal(sellers, add);
                    break;
                }
                case 5: {
                    System.out.println("Please enter the new address!");
                    System.out.print("Street: ");
                    String st = in.nextLine();
                    System.out.print("Town: ");
                    String zip = in.nextLine();
                    System.out.print("State: ");
                    String s = in.nextLine();
                    System.out.print("Country: ");
                    String c = in.nextLine();

                    setAdd(new Address(st, s, zip, c));
                    break;
                }
                case 6: {
                    display();
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice != 7);
    }

    public Cart getCCart() {
        return cart;
    }

    public String getId() {
        return id;
    }

    public void setAdd(Address a) {
        add = a;
    }

    public void readCart() throws IOException {
        String f = "/workspaces/SECJ2154-OOP/Submission/sec04_23242/Group2/Source_Code/"+id + ".csv";
        if (new File(f).exists()) {
            Scanner inp = new Scanner(new File(f));
            if (cart.getCart() == null) {
                System.out.println("No Cart yet!");
            } else {
                inp.useDelimiter(",|\\n");

                while (inp.hasNext()) {
                    String n = "", c = "";
                    n = inp.next().toLowerCase();
                    c = inp.next().toUpperCase();
                    String num = inp.nextLine();
                    num = num.substring(1);
                    int nz = Integer.parseInt(num);
                    Category cat = Category.valueOf(c);
                    cart.readItem(n, cat, nz);
                }
            }
        }

    }

    public void saveData() throws IOException {
        String filename = "/workspaces/SECJ2154-OOP/Submission/sec04_23242/Group2/Source_Code/"+id + ".csv";
        int num = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product s : cart.getCart()) {
                writer.print(s.getName() + ",");
                writer.print(s.getCategory() + ",");
                writer.print(cart.getAmount().get(num));
                writer.println();
                num++;
            }
        } catch (IOException e) {
            System.out.println("Error : File not found");
        }
    }

    public void GroceryList(ArrayList<Seller> sellers) throws IOException {
        String filename = "/workspaces/SECJ2154-OOP/Submission/sec04_23242/Group2/Source_Code/"+getName() + ".txt";
        int n = 0;
        String[] gz = new String[sellers.size()];

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.printf("%-5s%-15s%-10s%-15s%s\n", "No.", "Item", "Category", "Amount", "Recomended Shop");
            for (Product x : cart.getCart()) {
                writer.printf("%d%-4s%-15s%-10s%-15d", (n + 1), ")", capitalizeFirstLetter(x.getName()),
                        x.getCategory(), cart.getAmount().get(n));
                n++;
                int num = 0;
                for (User s : sellers) {
                    for (int q = 0; q < s.getStore().getProducts().size(); q++)
                        if (s.getStore().getAdd().getState().toLowerCase().equals(a.getState().toLowerCase())
                            && (s.getStore().getProducts().get(q).contains(x))) {
                            gz[num] = s.getStore().toString();
                            num++;
                        }
                }
                if (gz.length != 0) {
                    for (int i = 0; i < num; i++) {
                        if (gz[i] != null) {
                            if (i == 0) {
                                writer.print(gz[i]);
                            } else {
                                writer.printf("\n%45s%-1s", " ", gz[i]);
                            }
                        }
                    }
                }
                gz = new String[sellers.size()];
                writer.println();
                num = 0;
            }
        }

    }

    public String capitalizeFirstLetter(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}

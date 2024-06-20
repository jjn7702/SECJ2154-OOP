import java.util.Scanner;
import java.io.*;

class Seller extends User {
    private Store store;
    private String sid;
    private static int id = 0;

    public Seller(String email, String pass, String name, Store store) {
        super(email, pass, name);
        this.store = store;
        assignId();
    }

    public void assignId() {
        sid = "S" + id;
        id++;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void Manage() {
        int choice = 0;
        Scanner inp = new Scanner(System.in);
        do {
            System.out.println("\n1) Add Item");
            System.out.println("2) Delete Item");
            System.out.println("3) View Item");
            System.out.println("4) Edit Address");
            System.out.println("5) User Menu");
            System.out.println("5) Exit");
            System.out.print("Option: ");
            choice = Integer.parseInt(inp.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("\nPlease enter the name: ");
                    String name = inp.nextLine().toLowerCase();
                    System.out.print(
                            "Please enter the Category [FRUITS(F), VEGETABLES(V), DAIRY(D), MEAT(M), BAKERY(B), SNACKS(S), OTHERS(O)]: ");
                    String cat = inp.nextLine().toUpperCase();
                    switch (cat) {
                        case "F": {
                            cat = "FRUITS";
                            break;
                        }
                        case "V": {
                            cat = "VEGETABLES";
                            break;
                        }
                        case "D": {
                            cat = "DAIRY";
                            break;
                        }
                        case "M": {
                            cat = "MEAT";
                            break;
                        }
                        case "B": {
                            cat = "BAKERY";
                            break;
                        }
                        case "S": {
                            cat = "SNACKS";
                            break;
                        }
                        default: {
                            cat = "OTHERS";
                            break;
                        }
                    }

                    Category c = Category.valueOf(cat);
                    boolean check = false;
                    if (store.getProducts().size() == 0) {
                        store.getProducts().add(new Product(name, c));
                        System.out.println("Item successfully added!");
                    } else {
                        for (Product x : store.getProducts()) {
                            if (x.getName().equals(name) && x.getCategory() == c) {
                                System.out.println("Item already exists in List!");
                                check = true;
                                break;
                            }
                        }
                        if (!check) {
                            store.getProducts().add(new Product(name, c));
                            System.out.println("Item successfully added!");
                        }
                    }
                    store.displayStore();
                    break;
                }
                case 2: {
                    store.displayStore();
                    System.out.print("Please enter the index of the item: ");
                    int n = Integer.parseInt(inp.nextLine());
                    if (n <= store.getProducts().size()) {
                        Product p = store.searchItem(n - 1);
                        if (p != null) {
                            store.deleteItem(p);
                            store.displayStore();
                        } else {
                            System.out.println("Sorry could not find the item, please try again!");
                            store.displayStore();
                        }
                    } else {
                        System.out.println("Sorry the item you have searched for cannot be found!");
                    }
                    break;
                }
                case 3: {
                    store.displayStore();
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new address!");
                    System.out.print("Street: ");
                    String st = inp.nextLine();
                    System.out.print("Town: ");
                    String zip = inp.nextLine();
                    System.out.print("State: ");
                    String s = inp.nextLine();
                    System.out.print("Country: ");
                    String c = inp.nextLine();

                    store.setAdd(new Address(st, s, zip, c));
                    break;
                }

                case 5: {
                    display();
                }
                default: {
                    saveData();
                }
            }
        } while (choice != 6);
    }

    public void display() {
        System.out.println();
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Store managed: " + store.toString());
    }

    public void readItem() throws IOException {
        if (store.getProducts() == null) {
            System.out.println("No Products Registered Yet!");
        } else {
            String filename = sid + ".csv";

            if (new File(filename).exists()) {
                Scanner inp = new Scanner(new File(filename));
                inp.useDelimiter(",|\\n");
                while (inp.hasNext()) {
                    String n = "", c = "";
                    n = inp.next().toLowerCase();
                    c = inp.nextLine().toUpperCase();
                    c = c.substring(1);
                    // System.out.println(n + c);
                    Category cat = Category.valueOf(c);
                    store.addItem(n, cat);
                }
            }
        }

    }

    public void saveData() {
        String filename = sid + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product s : store.getProducts()) {
                writer.print(s.getName() + ",");
                writer.print(s.getCategory());
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error : File not found");
        }
    }
}

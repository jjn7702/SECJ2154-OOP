import java.util.*;

import javax.swing.event.InternalFrameEvent;

public class Cart {
    private ArrayList<Product> cart;
    private ArrayList<Integer> amount;

    public Cart() {
        cart = new ArrayList<>();
        amount = new ArrayList<>();
    }

    public void addItem() {
        Scanner inp = new Scanner(System.in);
        System.out.print("\nPlease enter the item: ");
        String n = inp.nextLine().toLowerCase();
        System.out.print(
                "Please enter the Category [FRUITS(F), VEGETABLES(V), DAIRY(D), MEAT(M), BAKERY(B), SNACKS(S), OHTERS(O)]: ");
        String c = inp.nextLine().toUpperCase();
        switch (c) {
            case "F": {
                c = "FRUITS";
                break;
            }
            case "V": {
                c = "VEGETABLES";
                break;
            }
            case "D": {
                c = "DAIRY";
                break;
            }
            case "M": {
                c = "MEAT";
                break;
            }
            case "B": {
                c = "BAKERY";
                break;
            }
            case "S": {
                c = "SNACKS";
                break;
            }
            default: {
                c = "OTHERS";
                break;
            }
        }

        System.out.print("Please enter the amount: ");
        int am = Integer.parseInt(inp.nextLine());

        Category ca = Category.valueOf(c);
        boolean check = false;
        // inp.close();
        if (cart.size() == 0) {
            cart.add(new Product(n, ca));
            amount.add(am);
            System.out.println("Item successfully added!");
        } else {
            for (Product x : cart) {
                if (x.getName().equals(n) && x.getCategory() == ca) {
                    System.out.println("Item already exusts in List!");
                    check = true;
                    break;
                }
            }
            if (!check) {
                cart.add(new Product(n, ca));
                amount.add(am);
                System.out.println("Item successfully added!");
            }
        }
    }

    public void readItem(String n, Category ca, int am) {
        cart.add(new Product(n, ca));
        amount.add(am);
    }

    public void EditItem() {
        Scanner inp = new Scanner(System.in);
        displayCart();
        System.out.print("Please choose the index of item to edit: ");
        int s = Integer.parseInt(inp.nextLine());
        if (cart.size() <= s) {
            System.out.print("Please enter the new amount: ");
            int n = Integer.parseInt(inp.nextLine());
            // inp.close();
            amount.set((s - 1), n);
            System.out.println("Change has been applied!");
        } else {
            System.out.println("Item does not exist!");
        }

    }

    public void deleteItem() {
        displayCart();
        Scanner put = new Scanner(System.in);
        System.out.print("\nPlease enter the item you want to delete: ");
        int s = Integer.parseInt(put.nextLine());
        cart.remove(s - 1);
        amount.remove(s - 1);
        displayCart();

    }

    public void displayCart() {
        int n = 0;
        System.out.printf("%-5s%-15s%-10s%-6s\n", "No.", "Item", "Category", "Amount");
        for (Product x : cart) {
            System.out.printf("%d%-4s%-15s%-10s%-6d\n", (n + 1), ")", x.getName(), x.getCategory(), amount.get(n));
            n++;
        }
    }

    public void displayCartFinal(ArrayList<Seller> sellers, Address a) {
        int n = 0;
        String g = null;

        System.out.printf("%-5s%-15s%-10s%-15s%s\n", "No.", "Item", "Category", "Amount", "Recomended Shop");
        for (Product x : cart) {
            System.out.printf("%d%-4s%-15s%-10s%-15d", (n + 1), ")", capitalizeFirstLetter(x.getName()),
                    x.getCategory(), amount.get(n));
            n++;
            for (Seller s : sellers) {
                for (int q = 0; q < s.getStore().getProducts().size(); q++)
                    if (s.getStore().getAdd().getState().equals(a.getState())
                            && (s.getStore().getProducts().get(q).contains(x))) {
                        g = s.getStore().toString();
                    }
            }
            if (g != null) {
                System.out.println(g);
            } else {
                System.out.println(" ");
            }
            g = null;
        }
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public String capitalizeFirstLetter(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

}

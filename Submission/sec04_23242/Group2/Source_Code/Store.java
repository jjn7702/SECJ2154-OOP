import java.util.*;

public class Store {
    private String name;
    private Address add;
    private Vector<Product> products;

    public Store(String name, Address add) {
        this.name = name;
        this.add = add;
        products = new Vector<>();
    }

    public void addItem(String name, Category cat) {
        products.add(new Product(name, cat));
    }

    public void deleteItem(Product p) {
        products.remove(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public String toString() {
        return name + "\t" + add.toString();
    }

    public Product searchItem(int n) {
        return products.get(n);
    }

    public void displayStore() {
        int n = 0;
        System.out.printf("%-5s%-15s%-10s\n", "No.", "Item", "Category");
        for (Product p : products) {
            System.out.printf("%d%-4s%-15s%-10s\n", (n + 1), ")", p.getName(), p.getCategory());
            n++;
        }
    }

}

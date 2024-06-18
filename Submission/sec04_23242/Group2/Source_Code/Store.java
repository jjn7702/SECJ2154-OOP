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
}

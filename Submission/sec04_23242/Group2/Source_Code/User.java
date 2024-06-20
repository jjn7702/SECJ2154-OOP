import java.io.IOException;
import java.util.ArrayList;

public abstract class User {
    private String password;
    private String email;
    private String name;

    public User() {
    }

    public User(String email, String pass, String name) {
        this.password = pass;
        this.email = email;
        this.name = name;
    }

    public void setId(String id) {
        this.password = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public abstract void display();

    public abstract void assignId();

    public void readCart() throws IOException {
    }

    public void BuyerInterface(ArrayList<Seller> s) {
    }

    public void GroceryList(ArrayList<Seller> s) throws IOException {
    }

    public Address getAdd() {
        return null;
    }

    public void saveData() throws IOException {
    }

    public Store getStore() {
        return null;
    }

    public void Manage() {
    }
}

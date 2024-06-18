import java.util.Vector;

public class Users {
    private int id;
    private String name;
    private Vector<Account> accounts = new Vector<>();

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Vector<Account> getAccounts() {
        return accounts;
    }
}

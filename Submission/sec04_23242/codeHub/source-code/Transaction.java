import java.sql.Date;
import java.util.*;


class Transaction {
    private int id;
    private String description;
    private double amount;
    private Date date;
    private Category category;
    Scanner scan = new Scanner(System.in);

    public Transaction(int id, String description, double amount, Date date,Category category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getDetails(double rate) {
        return "Transaction ID: " + id + ", Description: " + description + ", Amount: RM" + (amount * rate) + ", Date: " + date
                + ", Category: " + category.getName();
    }
}

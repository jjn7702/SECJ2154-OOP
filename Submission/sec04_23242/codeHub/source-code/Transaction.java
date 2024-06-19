import java.sql.Date;


class Transaction {
    private int id;
    private String description;
    private double amount;
    private Date date;
    private Category category;

    public Transaction(int id, String description, double amount, Date date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
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
        return "Transaction ID: " + id + ", Description: " + description + ", Amount: " + (amount * rate) + ", Date: " + date
                + ", Category: " + category.getName();
    }
}

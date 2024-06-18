import java.sql.Date;

public class Saving {
    private int id;
    private String name;
    private double targetAmount, currentAmount;
    private Date targetDate;

    public Saving(int id, String name, double targetAmount, double currentAmount, Date targetDate) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.targetDate = targetDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void addAmount(double amount) {
        currentAmount += amount;
    }
}

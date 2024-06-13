import javax.swing.JOptionPane;

public class Budget {
    private double sumBudget;
    private double sumUsed;

    public Budget() {
        this.sumBudget = 0;
        this.sumUsed = 0;
    }

    public void setBudget(double sumBudget) {
        this.sumBudget = sumBudget;
    }

    public double getBudget() {
        return sumBudget;
    }

    public void setUsed(double sumUsed) {
        this.sumUsed = sumUsed;
    }

    public double getUsed() {
        return sumUsed;
    }

    public void addExpense(double amount) {
        if (amount > 0 && (sumUsed + amount) <= sumBudget) {
            sumUsed += amount;
        }
    }

    public double getRemainingBudget() {
        return sumBudget - sumUsed;
    }

    public void displayBudget() {
        JOptionPane.showMessageDialog(null, "Total Budget: RM" + sumBudget + "\nSpent Amount: RM" +
                sumUsed + "\nRemaining Budget: RM" + getRemainingBudget());
    }
}

import javax.swing.JOptionPane;
import java.awt.Color;

public class Activities extends Budget {//class kugan hantar
    private String activityName;
    private double activityCost;
    private Color activityColor;

    public Activities() {
        super();
    } 
    
    public Activities(String activityName, double activityCost, Color activityColor) {
        super();
        this.activityName = activityName;
        this.activityCost = activityCost;
        this.activityColor = activityColor;
    }

    public void setName(String activityName) {
        this.activityName = activityName;
    }

    public String getName() {
        return activityName;
    }

    public void setCost(double activityCost) {
        this.activityCost = activityCost;
    }

    public double getCost() {
        return activityCost;
    }

    public void setColor(Color activityColor) {
        this.activityColor = activityColor;
    }

    public Color getColor() {
        return activityColor;
    }

    public void setActivityDetails(String activityName, double activityCost, Color activityColor) {
        this.activityName = activityName;
        this.activityCost = activityCost;
        this.activityColor = activityColor;
    }

    public void addActivityExpense() {
        addExpense(activityCost);
        JOptionPane.showMessageDialog(null, "Added activity: " + activityName + " with cost: RM" + activityCost);
    }

    @Override
    public void displayBudget() {
        super.displayBudget();
        JOptionPane.showMessageDialog(null, "Activity Name: " + activityName + "\nActivity Cost: RM" + activityCost);
    }
}

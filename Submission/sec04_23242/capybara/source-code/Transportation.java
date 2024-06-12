import javax.swing.*;

class Transportation extends Budget {
    private String transportType;
    private double transportCost;

    // No-args Constructor
    public Transportation() {
        super();
    }

    // Type method
    public void setName(String transportType) {
        this.transportType = transportType;
    }

    public String getName() {
        return transportType;
    }

    // Cost method
    public void setCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public double getCost() {
        return transportCost;
    }

    public void setTransportDetails(String transportType, double transportCost) {
        this.transportType = transportType;
        this.transportCost = transportCost;
    }

    public void addTransportExpense() {
        addExpense(transportCost);
        JOptionPane.showMessageDialog(null, "Added transport: " + transportType + " with cost: RM" + transportCost);
    }

    public void displayBudget() {
        super.displayBudget();
        JOptionPane.showMessageDialog(null,
                "Transport Type: " + transportType + "\nTransport Cost: RM" + transportCost);
    }
}
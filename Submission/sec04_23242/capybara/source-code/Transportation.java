import javax.swing.JOptionPane;

public class Transportation extends Budget {
    private String transportType;
    private double transportCost;

    public Transportation() {
        super();
    } 
    
    public Transportation(String transportType, double transportCost) {
        super();
        this.transportType = transportType;
        this.transportCost = transportCost; 
    }

    public void setName(String transportType) {
        this.transportType = transportType;
    }

    public String getName() {
        return transportType;
    }

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

    @Override
    public void displayBudget() {
        super.displayBudget();
        JOptionPane.showMessageDialog(null,
                "Transport Type: " + transportType + "\nTransport Cost: RM" + transportCost);
    }
}

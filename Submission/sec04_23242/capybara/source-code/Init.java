import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Init {
    private static Vector<Budget> tripBudgets = new Vector<>();
    private static JFrame farif = new JFrame("Budget Camping Trips Planner!");
    private static Font headerFont = new Font("Arial", Font.BOLD, 18);

    public static void main(String[] args) {
        initializeMainFrame();
        showMainMenu();
        farif.setVisible(true);
    }

    private static void initializeMainFrame() {
        farif.setSize(450, 450);
        farif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        farif.setLayout(null);
        farif.setResizable(false);
    }

    private static void showMainMenu() {
        farif.getContentPane().removeAll();

        JLabel headarif = new JLabel("Plan your trips!");
        headarif.setBounds(30, 1, 200, 100);
        headarif.setFont(headerFont);
        farif.add(headarif);

        JButton addTripButtonarif = new JButton("Add New Trip");
        addTripButtonarif.setBounds(50, 150, 150, 30);
        addTripButtonarif.addActionListener(e -> showAddTripScreen());
        farif.add(addTripButtonarif);

        JButton showTripButtonarif = new JButton("Show Trips");
        showTripButtonarif.setBounds(230, 150, 150, 30);
        showTripButtonarif.addActionListener(e -> showTrips());
        farif.add(showTripButtonarif);

        farif.revalidate();
        farif.repaint();
    }

    private static void showAddTripScreen() {
        farif.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Add New Trip");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        farif.add(headerLabel);

        JLabel labelBudget = new JLabel("Total Budget");
        labelBudget.setBounds(30, 50, 150, 30);
        farif.add(labelBudget);

        JTextField budgetField = new JTextField();
        budgetField.setBounds(30, 80, 150, 30);
        farif.add(budgetField);

        JLabel labelTransportType = new JLabel("Transport Type");
        labelTransportType.setBounds(230, 50, 150, 30);
        farif.add(labelTransportType);

        String[] transportOptions = { "Car", "Bus", "Train", "Miscellaneous" };
        JComboBox<String> transportTypeComboBox = new JComboBox<>(transportOptions);
        transportTypeComboBox.setBounds(230, 80, 150, 30);
        farif.add(transportTypeComboBox);

        JLabel labelTransportCost = new JLabel("Transport Cost");
        labelTransportCost.setBounds(230, 120, 150, 30);
        farif.add(labelTransportCost);

        JTextField transportCostField = new JTextField();
        transportCostField.setBounds(230, 150, 150, 30);
        farif.add(transportCostField);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(300, 200, 80, 30);
        farif.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddActivityScreen(budgetField, transportTypeComboBox, transportCostField);
            }
        });

        farif.revalidate();
        farif.repaint();
    }

    private static void showAddActivityScreen(JTextField budgetField, JComboBox<String> transportTypeComboBox,
            JTextField transportCostField) {
        farif.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Add New Trip -> Activity");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        farif.add(headerLabel);

        JLabel labelActivityName = new JLabel("Activity Name");
        labelActivityName.setBounds(30, 50, 150, 30);
        farif.add(labelActivityName);

        JTextField activityNameField = new JTextField();
        activityNameField.setBounds(30, 80, 150, 30);
        farif.add(activityNameField);

        JLabel labelActivityCost = new JLabel("Activity Cost");
        labelActivityCost.setBounds(30, 120, 150, 30);
        farif.add(labelActivityCost);

        JTextField activityCostField = new JTextField();
        activityCostField.setBounds(30, 150, 150, 30);
        farif.add(activityCostField);

        // Add color dropdown for activity
        JLabel labelActivityColor = new JLabel("Activity Color");
        labelActivityColor.setBounds(230, 50, 150, 30);
        farif.add(labelActivityColor);

        ColoredItem[] items = {
                new ColoredItem("Family", Color.RED),
                new ColoredItem("Friend", Color.GREEN),
                new ColoredItem("Partner", Color.PINK),
                new ColoredItem("Others", Color.BLUE)
        };

        JComboBox<ColoredItem> colorComboBox = new JComboBox<>(items);
        colorComboBox.setRenderer(new ColorfulRenderer());
        colorComboBox.setBounds(230, 80, 150, 30);
        farif.add(colorComboBox);

        JButton saveButton = new JButton("Save Trip");
        saveButton.setBounds(300, 200, 100, 30);
        farif.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTrip(budgetField, transportTypeComboBox, transportCostField, activityNameField, activityCostField,
                        colorComboBox);
            }
        });

        farif.revalidate();
        farif.repaint();
    }

    private static void saveTrip(JTextField budgetField, JComboBox<String> transportTypeComboBox,
            JTextField transportCostField,
            JTextField activityNameField, JTextField activityCostField, JComboBox<ColoredItem> colorComboBox) {
        double budget = Double.parseDouble(budgetField.getText());
        String transportType = (String) transportTypeComboBox.getSelectedItem();
        if ("Miscellaneous".equals(transportType)) {
            transportType = JOptionPane.showInputDialog("Enter your transportation type:");
        }
        double transportCost = Double.parseDouble(transportCostField.getText());
        String activityName = activityNameField.getText();
        double activityCost = Double.parseDouble(activityCostField.getText());
        Color activityColor = ((ColoredItem) colorComboBox.getSelectedItem()).getColor();

        Budget tripBudget = new Budget();
        tripBudget.setBudget(budget);

        Transportation transport = new Transportation();
        transport.setTransportDetails(transportType, transportCost);
        transport.addTransportExpense();

        Activities activities = new Activities();
        activities.setActivityDetails(activityName, activityCost, activityColor);
        activities.addActivityExpense();

        tripBudgets.add(tripBudget);
        tripBudgets.add(transport);
        tripBudgets.add(activities);

        showSavedTripDetail(tripBudget, transport, activities);
    }

    private static void showSavedTripDetail(Budget tripBudget, Transportation transport, Activities activities) {
        farif.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Saved Trip Detail");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        farif.add(headerLabel);

        JLabel savedLabelBudget = new JLabel("Total Budget: RM" + tripBudget.getBudget());
        savedLabelBudget.setBounds(30, 80, 200, 30);
        farif.add(savedLabelBudget);

        JLabel savedLabelTransportType = new JLabel("Transport Type: " + transport.getName());
        savedLabelTransportType.setBounds(230, 150, 200, 30);
        farif.add(savedLabelTransportType);

        JLabel savedLabelTransportCost = new JLabel("Transport Cost: RM" + transport.getCost());
        savedLabelTransportCost.setBounds(230, 230, 200, 30);
        farif.add(savedLabelTransportCost);

        JLabel savedLabelActivityName = new JLabel("Activity Name: " + activities.getName());
        savedLabelActivityName.setBounds(30, 150, 200, 30);
        farif.add(savedLabelActivityName);

        JLabel savedLabelActivityCost = new JLabel("Activity Cost: RM" + activities.getCost());
        savedLabelActivityCost.setBounds(30, 230, 200, 30);
        farif.add(savedLabelActivityCost);

        // Display color of the activity
        JLabel savedLabelActivityColor = new JLabel("Activity Color: ");
        savedLabelActivityColor.setBounds(30, 310, 200, 30);
        farif.add(savedLabelActivityColor);

        JLabel colorDisplay = new JLabel(createColoredDotIcon(activities.getColor()));
        colorDisplay.setBounds(150, 310, 30, 30);
        farif.add(colorDisplay);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(30, 350, 150, 30);
        backButton.addActionListener(e -> showMainMenu());
        farif.add(backButton);

        farif.revalidate();
        farif.repaint();
    }

    private static void showTrips() {
        StringBuilder tripsDetails = new StringBuilder();
        for (Budget budget : tripBudgets) {
            if (budget instanceof Activities) {
                tripsDetails.append("Activity:\n");
                ((Activities) budget).displayBudget();
            } else if (budget instanceof Transportation) {
                tripsDetails.append("Transportation:\n");
                ((Transportation) budget).displayBudget();
            } else {
                tripsDetails.append("Budget:\n");
                budget.displayBudget();
            }
        }
        JOptionPane.showMessageDialog(farif, tripsDetails.toString(), "Trips Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    static class ColoredItem {
        private final String name;
        private final Color color;

        public ColoredItem(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class ColorfulRenderer extends JLabel implements ListCellRenderer<ColoredItem> {
        public ColorfulRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends ColoredItem> list, ColoredItem value,
                int index, boolean isSelected, boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setText(value.getName());
            setIcon(createColoredDotIcon(value.getColor()));

            return this;
        }
    }

    private static Icon createColoredDotIcon(Color color) {
        return new Icon() {
            private static final int SIZE = 10;

            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(color);
                g.fillOval(x, y, SIZE, SIZE);
            }

            @Override
            public int getIconWidth() {
                return SIZE;
            }

            @Override
            public int getIconHeight() {
                return SIZE;
            }
        };
    }
}

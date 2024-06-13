import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Init {
    private static Vector<CampingTrips> campingTrips = new Vector<CampingTrips>();
    private static JFrame frame = new JFrame("Camping Trips Planner!");
    private static Font headerFont = new Font("Arial", Font.BOLD, 18);

    public static void main(String[] args) {
        initializeMainFrame();
        showMainMenu();
        frame.setVisible(true);
    }

    private static void initializeMainFrame() {
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
    }

    private static void showMainMenu() {
        frame.getContentPane().removeAll();

        JLabel head = new JLabel("Plan your trips!");
        head.setBounds(30, 1, 200, 100);
        head.setFont(headerFont);
        frame.add(head);

        JButton addTripButton = new JButton("Add New Trip");
        addTripButton.setBounds(50, 150, 150, 30);
        addTripButton.addActionListener(e -> showAddTripScreen());
        frame.add(addTripButton);

        JButton showTripButton = new JButton("Show Trips");
        showTripButton.setBounds(230, 150, 150, 30);
        showTripButton.addActionListener(e -> showTrips());
        frame.add(showTripButton);

        frame.revalidate();
        frame.repaint();
    }

    private static void showAddTripScreen() {
        frame.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Add New Trip");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        frame.add(headerLabel);

        JLabel labelNameTrip = new JLabel("Name Trip");
        labelNameTrip.setBounds(30, 100, 150, 30);
        frame.add(labelNameTrip);

        JTextField nameField = new JTextField();
        nameField.setBounds(30, 130, 150, 30);
        frame.add(nameField);

        JLabel labelLocationTrip = new JLabel("Location Trip");
        labelLocationTrip.setBounds(230, 100, 150, 30);
        frame.add(labelLocationTrip);

        JTextField locationField = new JTextField();
        locationField.setBounds(230, 130, 150, 30);
        frame.add(locationField);

        JLabel labelTransportType = new JLabel("Transport Type");
        labelTransportType.setBounds(30, 260, 150, 30);
        frame.add(labelTransportType);

        String[] transportOptions = { "Car", "Bus", "Train", "Miscellaneous" };
        JComboBox<String> transportTypeComboBox = new JComboBox<>(transportOptions);
        transportTypeComboBox.setBounds(30, 290, 150, 30);
        frame.add(transportTypeComboBox);

        JLabel labelTransportCost = new JLabel("Transport Cost");
        labelTransportCost.setBounds(230, 260, 150, 30);
        frame.add(labelTransportCost);

        JTextField transportCostField = new JTextField();
        transportCostField.setBounds(230, 290, 150, 30);
        frame.add(transportCostField);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(340, 370, 80, 30);
        frame.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddActivityScreen(nameField, locationField, transportTypeComboBox, transportCostField);
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private static void showAddActivityScreen(JTextField nameField, JTextField locationField,
            JComboBox<String> transportTypeComboBox,
            JTextField transportCostField) {
        frame.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Add New Trip | Activity");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 400, 100);
        frame.add(headerLabel);

        JLabel labelActivityName = new JLabel("Activity Name");
        labelActivityName.setBounds(30, 80, 150, 30);
        frame.add(labelActivityName);

        JTextField activityNameField = new JTextField();
        activityNameField.setBounds(30, 110, 150, 30);
        frame.add(activityNameField);

        JLabel labelActivityCost = new JLabel("Activity Cost");
        labelActivityCost.setBounds(30, 200, 150, 30);
        frame.add(labelActivityCost);

        JTextField activityCostField = new JTextField();
        activityCostField.setBounds(30, 230, 150, 30);
        frame.add(activityCostField);

        // Add color dropdown for activity
        JLabel labelActivityColor = new JLabel("Activity Color");
        labelActivityColor.setBounds(230, 80, 150, 30);
        frame.add(labelActivityColor);

        ColoredItem[] items = {
                new ColoredItem("Family", Color.RED),
                new ColoredItem("Friend", Color.GREEN),
                new ColoredItem("Partner", Color.PINK),
                new ColoredItem("Others", Color.BLUE)
        };

        JComboBox<ColoredItem> colorComboBox = new JComboBox<>(items);
        colorComboBox.setRenderer(new ColorfulRenderer());
        colorComboBox.setBounds(230, 110, 150, 30);
        frame.add(colorComboBox);

        JButton saveButton = new JButton("Save Trip");
        saveButton.setBounds(320, 370, 100, 30);
        frame.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveTrip(nameField, locationField, transportTypeComboBox, transportCostField,
                        activityNameField, activityCostField,
                        colorComboBox);
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private static void saveTrip(JTextField nameField, JTextField locationField,
            JComboBox<String> transportTypeComboBox,
            JTextField transportCostField,
            JTextField activityNameField, JTextField activityCostField, JComboBox<ColoredItem> colorComboBox) {
        Vector<Budget> tripBudgets = new Vector<Budget>();

        // double budget = Double.parseDouble(budgetField.getText());
        String transportType = (String) transportTypeComboBox.getSelectedItem();

        if ("Miscellaneous".equals(transportType)) {
            transportType = JOptionPane.showInputDialog("Enter your transportation type:");
        }
        double transportCost = Double.parseDouble(transportCostField.getText());
        String activityName = activityNameField.getText();
        double activityCost = Double.parseDouble(activityCostField.getText());
        Color activityColor = ((ColoredItem) colorComboBox.getSelectedItem()).getColor();

        // Budget tripBudget = new Budget();
        // tripBudget.setBudget(budget);

        Transportation transport = new Transportation();
        transport.setTransportDetails(transportType, transportCost);
        transport.addTransportExpense();

        Activities activities = new Activities();
        activities.setActivityDetails(activityName, activityCost, activityColor);
        activities.addActivityExpense();

        // tripBudgets.add(tripBudget);
        tripBudgets.add(transport);
        tripBudgets.add(activities);

        campingTrips.add(new CampingTrips(nameField.getText(), locationField.getText(), tripBudgets));
        showSavedTripDetail(nameField, locationField, transport, activities);
    }

    private static void showSavedTripDetail(JTextField nameField, JTextField locationField,
            Transportation transport, Activities activities) {
        frame.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("Saved Trip Detail");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        frame.add(headerLabel);

        JLabel savedLabelBudget = new JLabel("Total Budget: RM" +
                (transport.getCost() + activities.getCost()));
        savedLabelBudget.setBounds(30, 80, 200, 30);
        frame.add(savedLabelBudget);

        JLabel savedLabelTransportType = new JLabel("Transport Type: " + transport.getName());
        savedLabelTransportType.setBounds(230, 150, 200, 30);
        frame.add(savedLabelTransportType);

        JLabel savedLabelTransportCost = new JLabel("Transport Cost: RM" + transport.getCost());
        savedLabelTransportCost.setBounds(230, 230, 200, 30);
        frame.add(savedLabelTransportCost);

        JLabel savedLabelActivityName = new JLabel("Activity Name: " + activities.getName());
        savedLabelActivityName.setBounds(30, 150, 200, 30);
        frame.add(savedLabelActivityName);

        JLabel savedLabelActivityCost = new JLabel("Activity Cost: RM" + activities.getCost());
        savedLabelActivityCost.setBounds(30, 230, 200, 30);
        frame.add(savedLabelActivityCost);

        // Display color of the activity
        JLabel savedLabelActivityColor = new JLabel("Activity Color: ");
        savedLabelActivityColor.setBounds(30, 310, 200, 30);
        frame.add(savedLabelActivityColor);

        JLabel colorDisplay = new JLabel(createColoredDotIcon(activities.getColor()));
        colorDisplay.setBounds(150, 310, 30, 30);
        frame.add(colorDisplay);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(30, 350, 150, 30);
        backButton.addActionListener(e -> showMainMenu());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private static void showTrips() {
        frame.getContentPane().removeAll();

        JLabel headerLabel = new JLabel("All Trips");
        headerLabel.setFont(headerFont);
        headerLabel.setBounds(30, 1, 200, 100);
        frame.add(headerLabel);

        JTextArea tripsArea = new JTextArea();
        tripsArea.setEditable(false);
        tripsArea.setLineWrap(true);
        tripsArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(tripsArea);
        scrollPane.setBounds(30, 80, 380, 270);
        frame.add(scrollPane);

        StringBuilder tripsText = new StringBuilder();
        for (CampingTrips trip : campingTrips) {
            tripsText.append("Trip Name: ").append(trip.getName()).append("\n");
            tripsText.append("Location: ").append(trip.getLocation()).append("\n");
            // tripsText.append("Total Budget:
            // RM").append(trip.budget.getTotalCost()).append("\n\n");

            for (Budget budget : trip.getBudgets()) {
                if (budget instanceof Transportation) {
                    Transportation transport = (Transportation) budget;
                    tripsText.append("  Transport Type: ").append(transport.getName()).append("\n");
                    tripsText.append("  Transport Cost: RM").append(transport.getCost()).append("\n");
                } else if (budget instanceof Activities) {
                    Activities activity = (Activities) budget;
                    tripsText.append("  Activity Name: ").append(activity.getName()).append("\n");
                    tripsText.append("  Activity Cost: RM").append(activity.getCost()).append("\n");
                }
            }
            tripsText.append("\n");
        }
        tripsArea.setText(tripsText.toString());

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(30, 360, 150, 30);
        backButton.addActionListener(e -> showMainMenu());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
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

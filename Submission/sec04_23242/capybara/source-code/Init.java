import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Init {
    private static final Vector<CampingTrips> campingTrips = new Vector<>();
    private static final JFrame frame = new JFrame("Camping Trips Planner!");
    private static final Font headerFont = new Font("Arial", Font.BOLD, 18);
    private static final Font textFont = new Font("Arial", Font.PLAIN, 12);
    private static final Vector <JTextField> foodNamesField = new Vector <>();
    private static final Vector <JTextField> foodQuantitiesField = new Vector <>();
    private static final Vector <JTextField> foodCostsField = new Vector <>();

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

        addLabel("Plan your trips!", 30, 1, 200, 100, headerFont);

        addButton("Add New Trip", 50, 150, e -> showAddTripScreen());
        addButton("Show Trips", 230, 150, e -> showTrips());

        frame.revalidate();
        frame.repaint();
    }

    private static void showAddTripScreen() {
        frame.getContentPane().removeAll();

        addLabel("Add New Trip", 30, 1, 200, 100, headerFont);

        JTextField nameField = addTextField("Name Trip", 30, 100, 150, 30);
        JTextField locationField = addTextField("Location Trip", 230, 100, 150, 30);

        JComboBox<String> transportTypeComboBox = addComboBox("Transport Type", 30, 220, 150, 30,
                new String[] { "Car", "Bus", "Train", "Miscellaneous" });
        JTextField transportCostField = addTextField("Transport Cost", 230, 220, 150, 30);

        addButton("Next", 270, 370,
                e -> showAddActivityScreen(nameField, locationField, transportTypeComboBox, transportCostField));

        frame.revalidate();
        frame.repaint();
    }

    private static void showAddActivityScreen(JTextField nameField, JTextField locationField,
            JComboBox<String> transportTypeComboBox, JTextField transportCostField) {
        frame.getContentPane().removeAll();

        addLabel("Add New Trip | Activity", 30, 1, 400, 100, headerFont);

        JTextField activityNameField = addTextField("Activity Name", 30, 80, 150, 30);
        JTextField activityCostField = addTextField("Activity Cost", 30, 200, 150, 30);
        JComboBox<ColoredItem> colorComboBox = addColorComboBox("Activity Color", 230, 80, 150, 30, new ColoredItem[] {
                new ColoredItem("Family", Color.RED),
                new ColoredItem("Friend", Color.GREEN),
                new ColoredItem("Partner", Color.PINK),
                new ColoredItem("Others", Color.BLUE)
        });

        addButton("Next", 270, 370, e -> showAddFoodScreen(nameField, locationField, transportTypeComboBox,
                transportCostField, activityNameField, activityCostField, colorComboBox));

        frame.revalidate();
        frame.repaint();
    }

    private static void showAddFoodScreen(JTextField nameField, JTextField locationField,
    JComboBox<String> transportTypeComboBox, JTextField transportCostField, JTextField activityNameField,
    JTextField activityCostField, JComboBox<ColoredItem> colorComboBox){
        frame.setSize(640,450);
        frame.getContentPane().removeAll();
        addLabel("Add New Trip | Food", 30, 1, 400, 100, headerFont);
        JPanel foodPanel = new JPanel();
        foodPanel.setLayout(new BoxLayout(foodPanel,BoxLayout.Y_AXIS));
        foodPanel.setBounds(30,80,500,230);
        frame.add(foodPanel);
        addFoodField(foodPanel);

        JButton addFoodButton = new JButton("Add More Food");
        addFoodButton.setBounds(100, 320, 150,30);
        addFoodButton.addActionListener(e -> addFoodField(foodPanel));
        frame.add(addFoodButton);
        JButton addSaveButton = new JButton("Save Food");
        addSaveButton.setBounds(300, 320, 150,30);
        frame.add(addSaveButton);

    }

    private static void addFoodField (JPanel panel){
        JTextField foodNameField = new JTextField();
        JTextField foodQuantityField = new JTextField();
        JTextField foodCostField = new JTextField();

        foodNamesField.addElement(foodNameField);
        foodQuantitiesField.addElement(foodQuantityField);
        foodCostsField.add(foodCostField);
        JPanel foodItemPanel = new JPanel();
        foodItemPanel.setLayout(new GridLayout(1, 3,10,10));
        foodItemPanel.add(new JLabel("Food Name"));
        foodItemPanel.add(foodNameField);
        foodItemPanel.add(new JLabel("Food Quantity"));
        foodItemPanel.add(foodQuantityField);
        foodItemPanel.add(new JLabel("Food Cost"));
        foodItemPanel.add(foodCostField);

        panel.add(foodItemPanel);
        panel.revalidate();
        panel.repaint();
    }

    private static void showAddDateTimeScreen(JTextField nameField, JTextField locationField,
            JComboBox<String> transportTypeComboBox, JTextField transportCostField, JTextField activityNameField,
            JTextField activityCostField, JComboBox<ColoredItem> colorComboBox) {
        frame.getContentPane().removeAll();

        addLabel("Add New Trip | Date & Time", 30, 1, 400, 100, headerFont);

        // Input fields untuk date and time
        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.add(new JLabel("YYYY:"));
        JTextField yearField = new JTextField(4);
        datePanel.add(yearField);

        datePanel.add(new JLabel("MM:"));
        JTextField monthField = new JTextField(2);
        datePanel.add(monthField);

        datePanel.add(new JLabel("DD:"));
        JTextField dayField = new JTextField(2);
        datePanel.add(dayField);

        datePanel.setBounds(30, 140, 350, 30);
        frame.add(datePanel);

        JPanel timePanel = new JPanel(new FlowLayout());
        timePanel.add(new JLabel("HH:"));
        JTextField hourField = new JTextField(2);
        timePanel.add(hourField);

        timePanel.add(new JLabel("MM:"));
        JTextField minuteField = new JTextField(2);
        timePanel.add(minuteField);

        timePanel.setBounds(30, 180, 350, 30);
        frame.add(timePanel);

        addButton("Save Trip", 270, 370,
                e -> saveTrip(nameField, locationField, yearField, monthField, dayField, hourField, minuteField,
                        transportTypeComboBox, transportCostField, activityNameField, activityCostField,
                        colorComboBox));

        frame.revalidate();
        frame.repaint();
    }

    // Integrated date and time input validation and handling
    private static void saveTrip(JTextField nameField, JTextField locationField, JTextField yearField,
            JTextField monthField, JTextField dayField, JTextField hourField, JTextField minuteField,
            JComboBox<String> transportTypeComboBox, JTextField transportCostField, JTextField activityNameField,
            JTextField activityCostField, JComboBox<ColoredItem> colorComboBox) {
        Vector<Budget> tripBudgets = new Vector<>();

        String transportType = (String) transportTypeComboBox.getSelectedItem();
        if ("Miscellaneous".equals(transportType)) {
            transportType = JOptionPane.showInputDialog("Enter your transportation type:");
        }

        double transportCost = Double.parseDouble(transportCostField.getText());
        double activityCost = Double.parseDouble(activityCostField.getText());
        Color activityColor = ((ColoredItem) colorComboBox.getSelectedItem()).getColor();

        String date = yearField.getText() + "-" + monthField.getText() + "-" + dayField.getText();
        String time = hourField.getText() + ":" + minuteField.getText();

        // Validate date & time
        if (DateAndTime.isValidDate(date) && DateAndTime.isValidTime(time)) {
            DateAndTime dateTime = new DateAndTime(date, time);
            Transportation transport = new Transportation(transportType, transportCost);
            Activities activities = new Activities(activityNameField.getText(), activityCost, activityColor);

            tripBudgets.add(transport);
            tripBudgets.add(activities);

            campingTrips.add(new CampingTrips(nameField.getText(), locationField.getText(), dateTime, tripBudgets));
            showSavedTripDetail(transport, activities, dateTime);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid date or time format. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Display date & time in saved trip details
    private static void showSavedTripDetail(Transportation transport, Activities activities, DateAndTime dateTime) {
        double totalCost = transport.getCost() + activities.getCost();
        String totalBudgetStr = String.format("Total Budget: RM" + totalCost);
        frame.getContentPane().removeAll();
        addLabel("Saved Trip Detail", 30, 1, 200, 100, headerFont);

        addLabel(totalBudgetStr, 30, 80, 300, 30, textFont);
        addLabel("Transport Type: " + transport.getName(), 30, 120, 300, 30, textFont);
        addLabel("Transport Cost: RM" + transport.getCost(), 30, 160, 300, 30, textFont);
        addLabel("Activity Name: " + activities.getName(), 30, 200, 300, 30, textFont);
        addLabel("Activity Cost: RM" + activities.getCost(), 30, 240, 300, 30, textFont);
        addLabel("Activity Color: ", 30, 280, 300, 30, textFont);

        // Added date & time display
        addLabel("Trip Date: " + dateTime.getDate(), 30, 320, 300, 30, textFont);
        addLabel("Trip Time: " + dateTime.getTime(), 30, 360, 300, 30, textFont);

        JLabel colorDisplay = new JLabel(createColoredDotIcon(activities.getColor()));
        colorDisplay.setBounds(150, 310, 30, 30);
        frame.add(colorDisplay);

        addButton("Back to Main Menu", 30, 400, e -> showMainMenu());

        frame.revalidate();
        frame.repaint();
    }

    // Display date & time in trip list
    private static void showTrips() {
        frame.getContentPane().removeAll();

        addLabel("All Trips", 30, 1, 200, 100, headerFont);

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
            tripsText.append("Date: ").append(trip.getDateTime().getDate()).append("\n");
            tripsText.append("Time: ").append(trip.getDateTime().getTime()).append("\n");

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

        addButton("Back to Main Menu", 30, 360, e -> showMainMenu());

        frame.revalidate();
        frame.repaint();
    }

    private static JTextField addTextField(String labelText, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        frame.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(x, y + 30, width, height);
        frame.add(textField);

        return textField;
    }

    private static JComboBox<String> addComboBox(String labelText, int x, int y, int width, int height,
            String[] options) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        frame.add(label);

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y + 30, width, height);
        frame.add(comboBox);

        return comboBox;
    }

    private static JComboBox<ColoredItem> addColorComboBox(String labelText, int x, int y, int width, int height,
            ColoredItem[] items) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        frame.add(label);

        JComboBox<ColoredItem> comboBox = new JComboBox<>(items);
        comboBox.setRenderer(new ColorfulRenderer());
        comboBox.setBounds(x, y + 30, width, height);
        frame.add(comboBox);

        return comboBox;
    }

    private static void addButton(String buttonText, int x, int y, ActionListener actionListener) {
        JButton button = new JButton(buttonText);
        button.setBounds(x, y, 150, 30);
        button.addActionListener(actionListener);
        frame.add(button);
    }

    private static void addLabel(String labelText, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        frame.add(label);
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
        public Component getListCellRendererComponent(JList<? extends ColoredItem> list, ColoredItem value, int index,
                boolean isSelected, boolean cellHasFocus) {
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
}

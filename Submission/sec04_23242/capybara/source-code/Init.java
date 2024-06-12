import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Init {

    public static void main(String[] args) {
        Vector<CampingTrips> afterSemester = new Vector<>();

        JFrame frame = new JFrame("Camping Trips Planner!");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        JLabel header = new JLabel("Plan your trips!");
        header.setBounds(30, 1, 200, 100);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(header);

        JButton addTripButton = new JButton("Add New Trip");
        addTripButton.setBounds(50, 150, 150, 30);
        frame.add(addTripButton);

        JButton showTripButton = new JButton("Show Trips");
        showTripButton.setBounds(230, 150, 150, 30);
        frame.add(showTripButton);

        addTripButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                header.setText("Add New Trip");
                frame.remove(addTripButton);
                frame.remove(showTripButton);

                JLabel labelName = new JLabel("Trip Title");
                labelName.setBounds(30, 50, 300, 100);
                frame.add(labelName);

                JTextField tripNameField = new JTextField();
                tripNameField.setBounds(30, 110, 150, 30);
                frame.add(tripNameField);

                JLabel labelLocation = new JLabel("Trip Location");
                labelLocation.setBounds(30, 120, 300, 100);
                frame.add(labelLocation);

                JTextField tripLocationField = new JTextField();
                tripLocationField.setBounds(30, 180, 150, 30);
                frame.add(tripLocationField);

                JButton saveButton = new JButton("Save Trip");
                saveButton.setBounds(300, 340, 100, 30);
                frame.add(saveButton);

                saveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String tripName = String.format("Trip Name: %s", tripNameField.getText());
                        String tripLocation = String.format("Trip Location: %s", tripLocationField.getText());

                        afterSemester.add(new CampingTrips(tripName, tripLocation));

                        header.setText("Saved Trip Detail");

                        frame.remove(tripNameField);
                        frame.remove(tripLocationField);
                        frame.remove(saveButton);

                        labelName.setText(tripName);
                        labelLocation.setText(tripLocation);

                        frame.revalidate();
                        frame.repaint();

                    }
                });

                frame.revalidate();
                frame.repaint();
            };
        });

        frame.setVisible(true);

        // Main Inheritance code
        // Vector<Budget> tripBudgets = new Vector<>();

        // JFrame farif = new JFrame("BUdget Camping Trips Planner!");
        // farif.setSize(450, 450);
        // farif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // farif.setLayout(null);
        // farif.setResizable(false);

        // JLabel headarif = new JLabel("Plan your trips!");
        // headarif.setBounds(30, 1, 200, 100);
        // headarif.setFont(new Font("Arial", Font.BOLD, 18));
        // farif.add(headarif);

        // JButton addTripButtonarif = new JButton("Add New Trip");
        // addTripButtonarif.setBounds(50, 150, 150, 30);
        // farif.add(addTripButtonarif);

        // JButton showTripButtonarif = new JButton("Show Trips");
        // showTripButtonarif.setBounds(230, 150, 150, 30);
        // farif.add(showTripButtonarif);

        // addTripButtonarif.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // headarif.setText("Add New Trip");
        // farif.remove(addTripButtonarif);
        // farif.remove(showTripButtonarif);

        // JLabel labelBudget = new JLabel("Total Budget");
        // labelBudget.setBounds(30, 50, 300, 100);
        // farif.add(labelBudget);

        // JTextField budgetField = new JTextField();
        // budgetField.setBounds(30, 110, 150, 30);
        // farif.add(budgetField);

        // JLabel labelActivityName = new JLabel("Activity Name");
        // labelActivityName.setBounds(30, 120, 300, 100);
        // farif.add(labelActivityName);

        // JTextField activityNameField = new JTextField();
        // activityNameField.setBounds(30, 180, 150, 30);
        // farif.add(activityNameField);

        // JLabel labelActivityCost = new JLabel("Activity Cost");
        // labelActivityCost.setBounds(30, 190, 300, 100);
        // farif.add(labelActivityCost);

        // JTextField activityCostField = new JTextField();
        // activityCostField.setBounds(30, 250, 150, 30);
        // farif.add(activityCostField);

        // JLabel labelTransportType = new JLabel("Transport Type");
        // labelTransportType.setBounds(230, 50, 300, 100);
        // farif.add(labelTransportType);

        // String[] transportOptions = { "Car", "Bus", "Train", "Miscellaneous" };
        // JComboBox<String> transportTypeComboBox = new JComboBox<>(transportOptions);
        // transportTypeComboBox.setBounds(230, 110, 150, 30);
        // farif.add(transportTypeComboBox);

        // JLabel labelTransportCost = new JLabel("Transport Cost");
        // labelTransportCost.setBounds(230, 120, 300, 100);
        // farif.add(labelTransportCost);

        // JTextField transportCostField = new JTextField();
        // transportCostField.setBounds(230, 180, 150, 30);
        // farif.add(transportCostField);

        // JButton saveButton = new JButton("Save Trip");
        // saveButton.setBounds(300, 340, 100, 30);
        // farif.add(saveButton);

        // saveButton.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // double budget = Double.parseDouble(budgetField.getText());
        // String activityName = activityNameField.getText();
        // double activityCost = Double.parseDouble(activityCostField.getText());

        // Budget tripBudget = new Budget();
        // tripBudget.setBudget(budget);
        // Activities activities = new Activities();
        // activities.setActivityDetails(activityName, activityCost);
        // activities.addActivityExpense();

        // String transportType = (String) transportTypeComboBox.getSelectedItem();
        // if ("Extra".equals(transportType)) {
        // transportType = JOptionPane.showInputDialog("Enter your transportation
        // type:");
        // }
        // double transportCost = Double.parseDouble(transportCostField.getText());

        // Transportation transport = new Transportation();
        // transport.setTransportDetails(transportType, transportCost);
        // transport.addTransportExpense();

        // tripBudgets.add(tripBudget);
        // tripBudgets.add(activities);
        // tripBudgets.add(transport);

        // headarif.setText("Saved Trip Detail");

        // farif.remove(budgetField);
        // farif.remove(activityNameField);
        // farif.remove(activityCostField);
        // farif.remove(transportTypeComboBox);
        // farif.remove(transportCostField);
        // farif.remove(saveButton);

        // labelBudget.setText("Total Budget: " + budget);
        // labelActivityName.setText("Activity Name: " + activityName);
        // labelActivityCost.setText("Activity Cost: " + activityCost);
        // labelTransportType.setText("Transport Type: " + transportType);
        // labelTransportCost.setText("Transport Cost: " + transportCost);

        // farif.revalidate();
        // farif.repaint();
        // }
        // });

        // farif.revalidate();
        // farif.repaint();
        // }
        // });

        // showTripButtonarif.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // StringBuilder tripsDetails = new StringBuilder();
        // for (Budget budget : tripBudgets) {
        // if (budget instanceof Activities) {
        // tripsDetails.append("Activity:\n");
        // ((Activities) budget).displayBudget();
        // } else if (budget instanceof Transportation) {
        // tripsDetails.append("Transportation:\n");
        // ((Transportation) budget).displayBudget();
        // } else {
        // tripsDetails.append("Budget:\n");
        // budget.displayBudget();
        // }
        // }
        // JOptionPane.showMessageDialog(farif, tripsDetails.toString(), "Trips
        // Details",
        // JOptionPane.INFORMATION_MESSAGE);
        // }
        // });

        // farif.setVisible(true);

    }

}

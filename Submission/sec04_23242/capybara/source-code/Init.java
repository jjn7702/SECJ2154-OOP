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
    }

}

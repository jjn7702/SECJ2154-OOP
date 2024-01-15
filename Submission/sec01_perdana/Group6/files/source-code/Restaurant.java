import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private Menu menu;
    private List<Table> tables;
    private List<Reservation> reservations;
    private String reservationFilePath = "reservations.txt";
    private Scanner scanner;

    public Restaurant() {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        loadReservations();
    }

    public void addMenuItem(FoodItem item) {
        menu.addItem(item);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Menu getMenu() {
        return menu;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public List<Table> getTables() {
        return tables;
    }

    public boolean makeReservation(Table table, LocalDateTime reservationTime) {
        if (isTableAvailable(table, reservationTime)) {
            Reservation reservation = new Reservation(table, reservationTime);
            reservations.add(reservation);
            saveReservations();
            return true;
        }
        return false;
    }

    private boolean isTableAvailable(Table table, LocalDateTime reservationTime) {
        for (Reservation existingReservation : reservations) {
            if (existingReservation.getTable() == table && existingReservation.isAvailable(reservationTime)) {
                return false;  // Table is not available at the specified time
            }
        }
        return true;  // Table is available
    }

    private void saveReservations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reservationFilePath, true))) {
            Reservation latestReservation = reservations.get(reservations.size() - 1);
            writer.write(String.format("%d,%s\n", latestReservation.getTable().getTableNumber(),
                    latestReservation.getReservationTime()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadReservations() {
        try (Scanner scanner = new Scanner(new File(reservationFilePath))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");

                if (parts.length == 2) {
                    try {
                        int tableNumber = Integer.parseInt(parts[0]);
                        LocalDateTime reservationTime = LocalDateTime.parse(parts[1]);
                        Table table = getTableByNumber(tableNumber);

                        if (table != null) {
                            Reservation reservation = new Reservation(table, reservationTime);
                            reservations.add(reservation);
                        }
                    } catch (NumberFormatException | DateTimeParseException e) {
                        System.err.println("Error parsing reservation data: " + e.getMessage());
                        // Handle or log the error as needed
                    }
                } else {
                    System.err.println("Invalid reservation data format: " + String.join(",", parts));
                    // Handle or log the error as needed
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, it's okay for the first run
        }
    }

    private Table getTableByNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }
}

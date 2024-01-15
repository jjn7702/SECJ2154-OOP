public class Table {
    private int tableNumber;
    private Order currentOrder;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void placeOrder(Order order) {
        currentOrder = order;
    }

    public void clearTable() {
        currentOrder = null;
    }
}

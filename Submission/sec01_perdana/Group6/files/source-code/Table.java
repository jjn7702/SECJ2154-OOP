class Table {
    private int tableNumber;
    private Order currentOrder;
    private boolean isReserved;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.isReserved = false;
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

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveTable() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

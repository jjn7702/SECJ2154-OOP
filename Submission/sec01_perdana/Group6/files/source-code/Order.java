import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<FoodItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }
}

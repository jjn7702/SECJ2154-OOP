import java.util.ArrayList;
import java.util.List;

class Menu {
     private List<FoodItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return new ArrayList<>(items);
    }
}

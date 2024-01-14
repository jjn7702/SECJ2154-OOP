import java.util.*;

class Restaurant {
    private Menu menu;
    private List<Table> tables;

    public Restaurant() {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
    }

    public void addMenuItem(FoodItem item) {
        menu.addItem(item);
    }


}
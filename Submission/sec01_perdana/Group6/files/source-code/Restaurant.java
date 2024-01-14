import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Menu menu;
    private List<Table> tables;

    public Restaurant() {
        this.menu = new Menu();
        this.tables = new ArrayList<>();
    }

    public void addMenuItem(FoodItem item) {
        menu.addItem(item);
    }

    public Menu getMenu() {
        return menu;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public List<Table> getTables() {
        return new ArrayList<>(tables);
    }
}

import java.util.Locale.Category;

public class Budget {
    private double limit;
    private double currentExpense;
    private Category category;

    public Budget(double limit, Category category) {
        this.limit = limit;
        this.category = category;
        this.currentExpense = 0.0;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getCurrentExpense() {
        return currentExpense;
    }

    public void setCurrentExpense(double currentExpense) {
        this.currentExpense = currentExpense;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void display() {
        System.out.println("Budget for " + category.getName() + ":>");
        System.out.println("Budget used : " + currentExpense + "/ " + limit);
    }
}

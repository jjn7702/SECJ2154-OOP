public class Product {
    private String name;
    private Category category;

    public Product(String name, Category cat) {
        this.name = name;
        category = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean contains(Product p) {
        if (name.equals(p.getName()) && (category == p.getCategory())) {
            return true;
        } else
            return false;
    }

}

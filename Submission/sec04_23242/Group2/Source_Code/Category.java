public enum Category {
    FRUITS("Fruits"), VEGETABLES("Vegetables"), DAIRY("Dairy"), MEAT("Meat"), BAKERY("Bakery"), BEVERAGES("Beverages"),
    SNACKS("Snacks"), OTHERS("Others");

    private String desc;

    private Category(String s) {
        desc = s;
    }

    public String toString() {
        return desc;
    }

}

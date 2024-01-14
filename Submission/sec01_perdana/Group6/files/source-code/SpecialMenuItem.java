public class SpecialMenuItem extends FoodItem {
    private String specialInstruction;

    public SpecialMenuItem(String name, double price, String specialInstruction) {
        super(name, price);
        this.specialInstruction = specialInstruction;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }
}

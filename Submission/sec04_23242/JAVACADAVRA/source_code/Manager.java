class Manager extends Person {

    public Manager(String name, String gender, int age) {
        super(name, gender, age);
    }

    public String getName() {
        return super.getName();
    }

    public String getInfo() {
        return "\nManager's Details\n" + super.getInfo();
    }
}

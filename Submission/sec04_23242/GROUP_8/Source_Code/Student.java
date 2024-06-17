class Student extends User {
    public Student(String std_ID, String name, String email) {
        super(std_ID, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("ID: " + getUserID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}
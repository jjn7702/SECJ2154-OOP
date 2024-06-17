class Instructor extends User {
    public Instructor(String ins_ID, String name, String email) {
        super(ins_ID, name, email);
    }
    
    public void displayInfo() {
        System.out.println("Instructor Info:");
        System.out.println("ID: " + getUserID());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}
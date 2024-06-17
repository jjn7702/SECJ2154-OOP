abstract class User {
    private String userID;
    private String name;
    private String email;

    public User() { }

    public User(String id, String name, String email) {
        this.userID = id;
        this.name = name;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayInfo() {

    }
}
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean login(String enteredEmail, String enteredPassword) {
        if (this.email.equals(enteredEmail) && this.password.equals(enteredPassword)) {
           return true;
        } else {
            return false;
        }
    }

    public void logout() {
        System.out.println("Logout successful. Goodbye, " + name + "!");
        System.out.println();
    }
}

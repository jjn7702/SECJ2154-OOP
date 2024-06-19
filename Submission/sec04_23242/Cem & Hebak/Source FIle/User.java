import java.util.*;

public abstract class User { // using abstarct
    private String name, contact, identification_Card, email;
    protected Scanner inp = new Scanner(System.in);

    public User(String name, String contact, String identification_Card, String email) {
        this.name = name;
        this.contact = contact;
        this.identification_Card = identification_Card;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdentification_Card() {
        return identification_Card;
    }

    public void setIdentification_Card(String identification_Card) {
        this.identification_Card = identification_Card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Interface
    public void display() {

    }

    public abstract void updateUserInfo();

}
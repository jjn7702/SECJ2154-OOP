class User {
    private String name, contact_Info, Identification_Card, Email;

    public User(String name, String contact_Info, String identification_Card, String email) {
        this.name = name;
        this.contact_Info = contact_Info;
        Identification_Card = identification_Card;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_Info() {
        return contact_Info;
    }

    public void setContact_Info(String contact_Info) {
        this.contact_Info = contact_Info;
    }

    public String getIdentification_Card() {
        return Identification_Card;
    }

    public void setIdentification_Card(String identification_Card) {
        Identification_Card = identification_Card;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public void DisplayUserInfo () {
        System.out.println("Name : " + name);
        System.out.println("Contact :" + contact_Info);
    }
}

public class HajiUmrahApp {
    public static void main(String[] args) {

    }
}
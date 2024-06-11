class User {
    private String name, contact, identification_Card, email;

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

    public String getcontact() {
        return contact;
    }

    public void setcontact(String contact) {
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

    public void DisplayUserInfo() {
        System.out.println("Name : " + name);
        System.out.println("Contact :" + contact);
        System.out.println("Identification Card : " + identification_Card);
        System.out.println("Email: " + email);
    }
}

class Embassy extends User {
    private String locatio, position, staff_number;

    public Embassy(String name, String contact, String identification_Card, String email, String locatio,
            String position, String staff_number) {
        super(name, contact, identification_Card, email);
        this.locatio = locatio;
        this.position = position;
        this.staff_number = staff_number;
    }

    public String getLocatio() {
        return locatio;
    }

    public void setLocatio(String locatio) {
        this.locatio = locatio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaff_number() {
        return staff_number;
    }

    public void setStaff_number(String staff_number) {
        this.staff_number = staff_number;
    }

}

public class HajiUmrahApp {
    public static void main(String[] args) {

    }
}
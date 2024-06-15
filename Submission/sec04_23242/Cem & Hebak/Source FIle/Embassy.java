import java.util.*;

public class Embassy extends User {
    private String location, position, staff_number;
    protected Scanner inp = new Scanner(System.in);

    public Embassy(String name, String contact, String identification_Card, String email, String locatio,
            String position, String staff_number) {
        super(name, contact, identification_Card, email);
        this.location = locatio;
        this.position = position;
        this.staff_number = staff_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocatio(String location) {
        this.location = location;
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

    public void display_Embassy_Info() {
        System.out.println("========== EMBASSY CREDENTIALS ==========");
        super.DisplayUserInfo();
        System.out.println("Location: " + location);
        System.out.println("Position: " + position);
        System.out.println("Staff Number: " + staff_number);
        System.out.println();
    }

    public void update_Embassy_Info() {

        super.updateUserInfo();
        System.out.print("Location: ");
        location = inp.nextLine();
        System.out.print("Position: ");
        position = inp.nextLine();
        System.out.print("Staff Number: ");
        staff_number = inp.nextLine();

        // new credentials
        display_Embassy_Info();
    }

    public void checkVisaApplication() {

    }

    public void updateVisaApplication() {

    }
}
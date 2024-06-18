import java.util.*;

public class Embassy extends User {
    private String location, position, embassy_number;
    protected Scanner inp = new Scanner(System.in);

    public Embassy(String name, String contact, String identification_Card, String email, String locatio,
            String position, String embassy_number) {
        super(name, contact, identification_Card, email);
        this.location = locatio;
        this.position = position;
        this.embassy_number = embassy_number;
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

    public String getEmbassy_numberr() {
        return embassy_number;
    }

    public void setEmbassy_number(String embassy_number) {
        this.embassy_number = embassy_number;
    }

    public void display_Embassy_Info() {
        System.out.println("========== EMBASSY CREDENTIALS ==========");
        super.DisplayUserInfo();
        System.out.println("Location: " + location);
        System.out.println("Position: " + position);
        System.out.println("Embassy Number: " + embassy_number);
        System.out.println();
    }

    public void update_Embassy_Info() {

        super.updateUserInfo();
        System.out.print("Location: ");
        location = inp.nextLine();
        System.out.print("Position: ");
        position = inp.nextLine();
        System.out.print("Embassy Number: ");
        embassy_number = inp.nextLine();

        // new credentialsdsadasdasdas
        display_Embassy_Info();
    }

    public void Visa_Application(Jemaah Umat) {
        int choice, choice2;

        do {
            System.out.println("[1] Check Visa Application");
            System.out.println("[2] Visa Application Approval");
            System.out.print("[3] Exit\nYour Choice: ");
            choice = inp.nextInt();

            if (choice == 1) {
                Umat.display_Jemaah_Info();
            } else if (choice == 2) {
                // 2 approve
                // 1 failed
                // 0 pending
                Umat.display_Jemaah_Info();
                System.out.print("[1] Approve\n[2] Failed\nYour Choice: ");
                choice2 = inp.nextInt();
                Umat.setApproval_from_embassy(choice2);
            }
        } while (choice != 3);

    }
}
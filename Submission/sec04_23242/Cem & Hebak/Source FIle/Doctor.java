import java.util.*;

class Doctor extends User {
    private String hospital, position, doctor_Number;
    protected Scanner inp = new Scanner(System.in);

    // name, contact, identification_Card, email;
    public Doctor(String name, String contact, String identification_Card, String email, String hospital,
            String position, String doctor_Number) {
        super(name, contact, identification_Card, email);
        this.hospital = hospital;
        this.position = position;
        this.doctor_Number = doctor_Number;
        //try from faiz pc visual studio code
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDoctor_Number() {
        return doctor_Number;
    }

    public void setDoctor_Number(String doctor_Number) {
        this.doctor_Number = doctor_Number;
    }

    public void display_Doctor_Info() {
        System.out.println("========== DOCTOR CREDENTIALS ==========");
        super.DisplayUserInfo();
        System.out.println("Hospital: " + hospital);
        System.out.println("Position: " + position);
        System.out.println("Doctor Number: " + doctor_Number);
        System.out.println();
    }

    public void update_Doctor_Info() {

        super.updateUserInfo();
        System.out.print("Hospital: ");
        hospital = inp.nextLine();
        System.out.print("Position: ");
        position = inp.nextLine();
        System.out.print("Doctor Number: ");
        doctor_Number = inp.nextLine();
        // updated info
        display_Doctor_Info();

    }

    public void Check_Medical_Application() {

    }

    public void Update_Medical_Application() {

    }

    public void Update_Prescribe_Medication() {

    }
}
import java.util.Scanner;
import java.util.Vector;

class User {
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
        System.out.println("========== CREDENTIALS ==========");
        System.out.println("Name : " + name);
        System.out.println("Contact :" + contact);
        System.out.println("Identification Card : " + identification_Card);
        System.out.println("Email: " + email);
    }

    public void updateUserInfo() {

        System.out.println("========== UPDATE CREDENTIALS ==========");
        System.out.print("Please enter your credentials: \nName: ");
        name = inp.nextLine();
        System.out.print("Contact :");
        contact = inp.nextLine();
        System.out.print("Identification Card : ");
        identification_Card = inp.nextLine();
        System.out.print("Email: ");
        email = inp.nextLine();

        // new credentials
        // DisplayUserInfo();
    }
}

class Embassy extends User {
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
        super.DisplayUserInfo();
        System.out.println("Location: " + location);
        System.out.println("Position: " + position);
        System.out.println("Staff Number: " + staff_number);
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
        super.DisplayUserInfo();
        System.out.println("Hospital: " + hospital);
        System.out.println("Position: " + position);
        System.out.println("Doctor Number: " + doctor_Number);
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

class Jemaah {
    private String jemaahID;
    private int age;
    private Vector<String> penyakit;

    public Jemaah(String jemaahID, int age) {
        this.jemaahID = jemaahID;
        this.age = age;
        penyakit = new Vector<>();
    }

    public String getJemaahID() {
        return jemaahID;
    }

    public void setJemaahID(String jemaahID) {
        this.jemaahID = jemaahID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

public class HajiUmrahApp {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Embassy pegawai1 = new Embassy("Muhammad Faiz Bin Zakaria", "019-577 3762", "030717-08-0421",
                "zfaiz2345@gmail.com", "Setia Tropika", "Kastam", "030717");
        pegawai1.display_Embassy_Info();
        pegawai1.update_Embassy_Info();

        inp.close();
    }
}
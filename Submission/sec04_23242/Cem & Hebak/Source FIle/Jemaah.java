import java.util.*;

public class Jemaah extends User {
    private String jemaahID;
    private int age;
    private Doctor doctor;
    private Embassy embassy;
    private Vector<String> penyakit;

    public Jemaah(String name, String contact, String identification_Card, String email, String jemaahID, int age,
            Doctor doctor, Embassy embassy) {
        super(name, contact, identification_Card, email);
        this.jemaahID = jemaahID;
        this.age = age;
        this.doctor = doctor;
        this.embassy = embassy;

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

    public void display_Jemaah_Info() {
        System.out.println("========== JEMAAH CREDENTIALS ==========");
        super.DisplayUserInfo();
        System.out.println("Jemaah ID: " + jemaahID);
        System.out.println("Age: " + age);
        doctor.display_Doctor_Info();
        embassy.display_Embassy_Info();
        System.out.println();
    }
}
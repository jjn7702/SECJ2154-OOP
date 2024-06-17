import java.util.*;

public class Jemaah extends User {
    private String jemaahID;
    private int age;
    private int approval_from_doctor = 0;
    private int approval_from_embassy = 0;
    private Doctor doctor;
    private Embassy embassy;
    private Vector<String> penyakit;
    private Vector<String> ubat;
    private Haji_Umrah_Package pakejIbadah;

    public Jemaah(String name, String contact, String identification_Card, String email, String jemaahID, int age,
            Doctor doctor, Embassy embassy) {
        super(name, contact, identification_Card, email);
        this.jemaahID = jemaahID;
        this.age = age;
        this.doctor = doctor;
        this.embassy = embassy;
        penyakit = new Vector<>();
        ubat = new Vector<>();

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

    public void setPenyakit(String disease) {
        penyakit.add(disease);
    }

    public void setUbat(String medicine) {
        ubat.add(medicine);
    }

    public int getApproval_from_doctor() {
        return approval_from_doctor;
    }

    public void setApproval_from_doctor(int approval_from_doctor) {
        this.approval_from_doctor = approval_from_doctor;
    }

    public int getApproval_from_embassy() {
        return approval_from_embassy;
    }

    public void setApproval_from_embassy(int approval_from_embassy) {
        this.approval_from_embassy = approval_from_embassy;
    }

    public void display_Jemaah_Info() {
        System.out.println("========== JEMAAH CREDENTIALS ==========");
        super.DisplayUserInfo();
        System.out.println("Jemaah ID: " + jemaahID);
        System.out.println("Age: " + age);
        String Health = "pending", Visa = "pending", Approval = "pending";

        switch (approval_from_doctor) {
            case 2:
                Health = "Failed";
                break;
            case 1:
                Health = "Approve";
                break;
            case 0:
                Health = "Pending";
                break;
            default:
                break;
        }

        switch (approval_from_embassy) {
            case 2:
                Visa = "Failed";
                break;
            case 1:
                Visa = "Approve";
                break;
            case 0:
                Visa = "Pending";
                break;
            default:
                break;
        }

        if (approval_from_doctor == 1 && approval_from_embassy == 1) {
            Approval = "Approve";
        } else if (approval_from_doctor == 0 || approval_from_embassy == 0) {
            Approval = "Pending";
        } else {
            Approval = "Failed";
        }

        System.out.println("Health: " + Health);
        System.out.println("Visa: " + Visa);
        System.out.println(Approval + " to perform ibadah");

        System.out.printf("\n%10sDisease List\n\n", "");
        if (penyakit.isEmpty()) {
            System.out.println("None");
        } else {

            for (int i = 0; i < penyakit.size(); i++) {
                System.out.println((i + 1) + ")" + penyakit.get(i));
            }
        }

        System.out.printf("%10sPrescription List\n\n", "");
        if (ubat.isEmpty()) {
            System.out.println("None");
        } else {

            for (int i = 0; i < ubat.size(); i++) {
                System.out.println((i + 1) + ")" + ubat.get(i));
            }
        }

        doctor.display_Doctor_Info();
        embassy.display_Embassy_Info();
        System.out.println();
    }

    public void checkKesihatan() {
        doctor.Medical_Application(this);
    }

    public void checkVisa() {
        embassy.Visa_Application(this);
    }

    public void chooseUmrahPackage() {

        System.out.println("Please choose your ibadah package: ");
        System.out.println("1) IFRAD = Haji dahulu dan Umrah kemudian");
        System.out.println("2) QIRAN = Mengerjakan Haji dan Umrah serentak");
        System.out.println("3) TAMATTUK = Umrah dahulu Haji kemudian");
        System.out.println("4) HAJI Sahaja = Mengerjakan Haji sahaja");
        System.out.println("5) UMRAH = Megerjakan Umrah sahaja");
        System.out.println("Sila taip IFRAD, QIRAN, TAMATTUK, HAJI, UMRAH untuk pilih pakej ibadah anda");
        pakejIbadah = Haji_Umrah_Package.valueOf(inp.nextLine().toUpperCase());
        pakejIbadah.Choose_Hotel_Room();
        pakejIbadah.Display_Pakej_Info();
    }

}
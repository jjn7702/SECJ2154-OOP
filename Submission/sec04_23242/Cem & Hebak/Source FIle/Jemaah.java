import java.util.Vector;

public class Jemaah extends User implements userDisplay {
    private String jemaahID;
    private int age;
    private int approval_from_doctor = 0;
    private int approval_from_embassy = 0;
    private Doctor doctor;
    private Embassy embassy;
    private Vector<String> penyakit;
    private Vector<String> ubat;
    private Haji_Umrah_Package pakejIbadah;
    private Pelancongan_Package plgPkg;

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

    public Doctor getDoctor() {
        return doctor;
    }

    public Embassy getEmbassy() {
        return embassy;
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

    // Interface
    public void display() {
        System.out.println("========== JEMAAH CREDENTIALS ==========");
        System.out.println("Name : " + getName());
        System.out.println("Contact :" + getContact());
        System.out.println("Identification Card : " + getIdentification_Card());
        System.out.println("Email: " + getEmail());
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
        if (pakejIbadah != null) {
            pakejIbadah.Display_Pakej_Info();// display ibadah package
        }
        if (plgPkg != null) {
            plgPkg.display_Pelancongan_info();
            // display pelancongan package//
        }

        doctor.displayRingkas();
        embassy.displayRingkas();

        System.out.println();
    }

    public void displayRingkas() {
        System.out.println("========== JEMAAH CREDENTIALS ==========");
        System.out.println("Name : " + getName());
        System.out.println("Contact :" + getContact());
        System.out.println("Identification Card : " + getIdentification_Card());
        System.out.println("Email: " + getEmail());
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
                System.out.println((i + 1) + ") " + penyakit.get(i));
            }
        }

        System.out.printf("%10sPrescription List\n\n", "");
        if (ubat.isEmpty()) {
            System.out.println("None");
        } else {

            for (int i = 0; i < ubat.size(); i++) {
                System.out.println((i + 1) + ") " + ubat.get(i));
            }
        }

        System.out.println();
    }

    public void updateUserInfo() {
        System.out.println("========== UPDATE CREDENTIALS ==========");
        System.out.print("Please enter your credentials: \nName: ");
        setName(inp.nextLine());
        System.out.print("Contact :");
        setContact(inp.nextLine());
        System.out.print("Identification Card : ");
        setIdentification_Card(inp.nextLine());
        System.out.print("Email: ");
        setEmail(inp.nextLine());
    }

    public void chooseUmrahPackage() {

        System.out.println("Please choose your ibadah package: ");
        System.out.println("1) IFRAD = Perform Hajj first Umrah later");
        System.out.println("2) QIRAN = Perform Hajj and Umrah simultaneously");
        System.out.println("3) TAMATTUK = Perform Umrah first Haji later");
        System.out.println("4) HAJI Sahaja = Only Perform Hajj");
        System.out.println("5) UMRAH = Only Perform Umrah");
        System.out.println("Please type [ IFRAD, QIRAN, TAMATTUK, HAJI, UMRAH ] to choose your ibadah package");
        pakejIbadah = Haji_Umrah_Package.valueOf(inp.nextLine().toUpperCase());
        pakejIbadah.Display_Pakej_Info();
    }

    public void add_Pelancongan_Package() {

        int choicePelancongan = 0;
        String vacation;
        System.out.println("Please choose your Vacation Package");
        System.out.println("[1] Turki, Istanbul");
        System.out.println("[2] Riyadh, Damma,");
        System.out.println("[3] Doha, Dubai");
        System.out.println("[4] Abu Dhabi, Sharjah");
        System.out.println("[5] Kuwait City, Manama");
        System.out.println("[1 - 5] Please Enter the number of package you interested");
        choicePelancongan = inp.nextInt();
        inp.nextLine();
        switch (choicePelancongan) {
            case 1:
                vacation = "PACKAGE_1";
                break;
            case 2:
                vacation = "PACKAGE_2";
                break;
            case 3:
                vacation = "PACKAGE_3";
                break;
            case 4:
                vacation = "PACKAGE_4";
                break;
            case 5:
                vacation = "PACKAGE_5";
                break;
            default:
                vacation = "";
                System.out.println("Error!");
                break;
        }
        plgPkg = Pelancongan_Package.valueOf(vacation);
        plgPkg.choose_Hotel_Room();
        plgPkg.display_Pelancongan_info();

        if (pakejIbadah.getFlight().size() != 0) {
            pakejIbadah.getFlight().remove(1);
        }

        // Tanya Faiz Boleh ke add pelancongan tanpa pergi HajiUmrah

    }

}
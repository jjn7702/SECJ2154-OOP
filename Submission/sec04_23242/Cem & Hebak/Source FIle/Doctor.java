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
        // try from faiz pc visual studio code
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

    //Polymorphism
    public void display() {
        System.out.println("========== DOCTOR CREDENTIALS ==========");
        super.display();
        System.out.println("Hospital: " + hospital);
        System.out.println("Position: " + position);
        System.out.println("Doctor Number: " + doctor_Number);
        System.out.println();
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

        System.out.print("Hospital: ");
        hospital = inp.nextLine();
        System.out.print("Position: ");
        position = inp.nextLine();
        System.out.print("Doctor Number: ");
        doctor_Number = inp.nextLine();
        // updated info
        display();

    }

    public void Medical_Application(Jemaah umat) {

        int choice, choice2;

        do {

            System.out.print(
                    "[1] Check Medical Application\n[2] Medical Application Approval\n[3] State Disease\n[4] Prescribe Medication\n[5] Exit\nYour Choice: ");
            choice = inp.nextInt();
            switch (choice) {
                case 1:
                    // display jemaah info
                    umat.display();         //JemaahInfo
                    break;
                case 2:
                    // Medical Application Approval
                    // 2 approve
                    // 1 failed
                    // 0 pending
                    umat.display();         //JemaahInfo
                    System.out.print("[1] Approve\n[2] Failed\nYour Choice: ");
                    int choice4 = inp.nextInt();

                    umat.setApproval_from_doctor(choice4);

                    break;
                case 3:

                    // state disease

                    inp.nextLine();
                    do {

                        System.out.println("Please State the Jemaah Disease:");
                        String input_Penyakit = inp.nextLine();
                        umat.setPenyakit(input_Penyakit);
                        System.out.print("[1] to continue\n[2] to exit\nYour Choice: ");
                        choice2 = inp.nextInt();
                        inp.nextLine();

                    } while (choice2 != 2);
                    break;

                case 4:
                    // prescribe medication
                    inp.nextLine();
                    do {

                        System.out.println("Please State the Jemaah Medicine:");
                        String input_Medicine = inp.nextLine();
                        umat.setUbat(input_Medicine);
                        System.out.println("[1] to continue\n[2] to exit\nYour Choice: ");
                        choice2 = inp.nextInt();
                        inp.nextLine();

                    } while (choice2 != 2);
                    break;

            }

        } while (choice != 5);

    }
}
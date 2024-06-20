import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Vector;

public class HajiUmrahApp {
        public static void main(String[] args) {
                Scanner inp = new Scanner(System.in);
                Vector<Embassy> pegawai = new Vector<>();
                Vector<Doctor> doktor = new Vector<>();
                Vector<Jemaah> jemaah = new Vector<>();
                SecureRandom randomNumberGenerator = new SecureRandom();
                // randomNumberGenerator.nextInt(2);

                Embassy pegawai1 = new Embassy("Muhammad Ali Bin Abu", "019-375 6551", "1",
                                "zilman2345@gmail.com", "Setia Tropika", "Ketua Jabatan Imigresen", "JIM1");
                Embassy pegawai2 = new Embassy("Ahmad Aliff Bin Ali", "012-345 6789", "2",
                                "aliff.ali@gmail.com", "Taman Sri Andalas", "Timbalan Ketua Jabatan Imigresen",
                                "JIM2");

                Doctor doctor1 = new Doctor("Ahmad Zairul Bin Iman", "012-345 6789", "111",
                                "ahmad.ali@gmail.com", "Hospital Universiti Kuala Lumpur",
                                "Head of the Family Physicians",
                                "111");
                // Doctor doctor2 = new Doctor("Siti Nurhaliza Binti Osman", "013-987 6543",
                // "890202-05-5678",
                // "siti.nurhaliza@gmail.com", "Hospital Selayang", "Deputy Head of the Family
                // Physicians",
                // "DOC23456");
                Doctor doctor2 = new Doctor("Siti Nurhaliza Binti Osman", "013-987 6543", "222",
                                "siti.nurhaliza@gmail.com", "Hospital Selayang", "Deputy Head of the Family Physicians",
                                "222");

                pegawai.add(pegawai1);
                pegawai.add(pegawai2);

                doktor.add(doctor1);
                doktor.add(doctor2);

                Jemaah jemaah1 = new Jemaah("Muhammad Faiz Bin Zakaria", "0195773762", "030717080421",
                                "zfaiz2345@gmail.com",
                                "J1", 21, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah2 = new Jemaah("Ahmad Ali Bin Hassan", "0123456789", "950101010101", "ahmad.ali@gmail.com",
                                "J2", 40, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah3 = new Jemaah("Nur Aisyah Binti Mohd", "0139876543", "940202050567",
                                "aisyah.mohd@gmail.com",
                                "J3", 33, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah4 = new Jemaah("Siti Khadijah Binti Ismail", "0172233445", "930303101234",
                                "khadijah.ismail@gmail.com",
                                "J4", 28, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah5 = new Jemaah("Zulhilmi Bin Yusof", "0169987766", "960404020987", "zul.yusof@gmail.com",
                                "J5", 25, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah6 = new Jemaah("Aminah Binti Ali", "0187766554", "920808030404", "aminah.ali@gmail.com",
                                "J6", 29, doctor2, pegawai2);
                Jemaah jemaah7 = new Jemaah("Ahmad Bin Samad", "0194455566", "911111101010", "ahmad.samad@gmail.com",
                                "J7", 36, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah8 = new Jemaah("Nurul Huda Binti Zainal", "0178877799", "931212101011",
                                "nurul.huda@gmail.com",
                                "J8", 31, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah9 = new Jemaah("Azizul Rahman Bin Mahmood", "0143322111", "971213030101",
                                "azizul.rahman@gmail.com",
                                "J9", 24, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));
                Jemaah jemaah10 = new Jemaah("Siti Aminah Binti Abdul Rahman", "0123344556", "990505070707",
                                "siti.aminah@gmail.com",
                                "J10", 27, doktor.get(randomNumberGenerator.nextInt(2)),
                                pegawai.get(randomNumberGenerator.nextInt(2)));

                jemaah.add(jemaah1);
                jemaah.add(jemaah2);
                jemaah.add(jemaah3);
                jemaah.add(jemaah4);
                jemaah.add(jemaah5);
                jemaah.add(jemaah6);
                jemaah.add(jemaah7);
                jemaah.add(jemaah8);
                jemaah.add(jemaah9);
                jemaah.add(jemaah10);

                int choice1 = 0;
                int choice2 = 0;
                int choice3 = 0;
                int choice4 = 0;
                int choice5 = 0;
                String IC, ID;
                do {
                        System.out.print("[1] Log In\n[2] Exit\nYour Choice: ");
                        choice1 = inp.nextInt();
                        if (choice1 == 1) {
                                System.out.print("Who are you?\n[1] Jemaah\n[2] Doctor\n[3] Embassy\nYour choice: ");
                                choice2 = inp.nextInt();
                                inp.nextLine(); // clear buffer
                                switch (choice2) {
                                        case 1: {
                                                System.out.println("[1] Log in as jemaah\n[2] Register new jemaah");
                                                System.out.print("Your choice:"); //(1)
                                                choice3 = inp.nextInt();
                                                inp.nextLine();// clear buffer
                                                switch (choice3) {
                                                        case 1: {
                                                                System.out.println("Enter your credentials");
                                                                System.out.print("Identification Card Number: ");
                                                                IC = inp.nextLine();
                                                                System.out.print("Jemaah ID: ");
                                                                ID = inp.nextLine();
                                                                for (int i = 0; i < jemaah.size(); i++) {
                                                                        if (IC.equals(jemaah.get(i).getIdentification_Card()) && ID.equals(jemaah.get(i).getJemaahID())) {
                                                                                do {
                                                                                        System.out.println("Assalamualaikum " + jemaah.get(i).getName());
                                                                                        System.out.print("[1] Show jemaah info\n[2] Haji and Umrah package\n[3] Pelancongan package\n[4] Exit\nYour choice: ");
                                                                                        choice4 = inp.nextInt();
                                                                                        if (choice4 == 1) {
                                                                                                jemaah.get(i).display();
                                                                                        } else if (choice4 == 2) {
                                                                                                jemaah.get(i).chooseUmrahPackage();
                                                                                        } else if (choice4 == 3) {

                                                                                        }
                                                                                } while (choice4 != 4);

                                                                        }
                                                                }
                                                                break;

                                                        }
                                                        case 2: {// create new jemaah and insert dalam vector
                                                                String name, contact, identification_Card, email,
                                                                                jemaahID;
                                                                int age;
                                                                System.out.println(
                                                                                "========== NEW JEMAAH REGISTRATION ==========");
                                                                System.out.print("Name: ");
                                                                name = inp.nextLine();
                                                                System.out.print("Contact: ");
                                                                contact = inp.nextLine();
                                                                System.out.print("Identification Card : ");
                                                                identification_Card = inp.nextLine();
                                                                System.out.print("Email: ");
                                                                email = inp.nextLine();
                                                                System.out.print("Age: ");
                                                                age = inp.nextInt();
                                                                inp.nextLine();// clear buffer
                                                                jemaahID = "J" + (jemaah.size() + 1);

                                                                Jemaah newJemaah = new Jemaah(name, contact,
                                                                                identification_Card, email, jemaahID,
                                                                                age,
                                                                                doktor.get(randomNumberGenerator
                                                                                                .nextInt(2)),
                                                                                pegawai.get(randomNumberGenerator
                                                                                                .nextInt(2)));
                                                                jemaah.add(newJemaah);
                                                        }
                                                }

                                                break;
                                        }
                                        case 2: {
                                                System.out.println("Enter your credentials");
                                                System.out.print("Identification Card Number: ");
                                                IC = inp.nextLine();
                                                System.out.print("Doctor ID: ");
                                                ID = inp.nextLine();
                                                for (int i = 0; i < doktor.size(); i++) {
                                                        if (IC.equals(doktor.get(i).getIdentification_Card()) && ID.equals(doktor.get(i).getDoctor_Number())) { // check IC and ID sama tak
                                                                do {
                                                                        System.out.println("Hi Dr. " + doktor.get(i).getName());
                                                                        System.out.println("========== Doctor Menu ==========");
                                                                        System.out.println("[1] Show Dr. " + doktor.get(i).getName() + " info");
                                                                        System.out.println("[2] Medical Application Business\n[3] Exit\nYour choice: ");
                                                                        choice3 = inp.nextInt();

                                                                        if (choice3 == 1) {
                                                                                doktor.get(i).display(); // dulu guna
                                                                                                         // dooktor.get(i).display_doctor_info()
                                                                        } else if (choice3 == 2) {
                                                                                Vector<Jemaah> jemaahWithDoctor = new Vector<>();

                                                                                for (int j = 0; j < jemaah
                                                                                                .size(); j++) {
                                                                                        if (jemaah.get(j)
                                                                                                        .getDoctor() == doktor
                                                                                                                        .get(i)) {
                                                                                                // if jemaah ni dengan
                                                                                                // doctor
                                                                                                // ni, dia masuk dalam
                                                                                                // vector
                                                                                                // jemaahwithDoctor
                                                                                                jemaahWithDoctor.add(
                                                                                                                jemaah.get(j));
                                                                                        }

                                                                                }
                                                                                System.out.println(
                                                                                                "========== LIST OF JEMAAH ==========");
                                                                                for (int n = 0; n < jemaahWithDoctor
                                                                                                .size(); n++) { // Jemaah
                                                                                                                // or
                                                                                                                // User
                                                                                                                // kita
                                                                                                                // cuba
                                                                                        System.out.println((n + 1)
                                                                                                        + ") "
                                                                                                        + jemaahWithDoctor
                                                                                                                        .get(n)
                                                                                                                        .getName());

                                                                                        // jemaahtry.display(); // dia akan panggil semua super and subclass display
                                                                                }
                                                                                System.out.println();
                                                                                System.out.print(
                                                                                                "[a] Press 0 for exit\n[b] pick number of jemaah [1-n]\n");
                                                                                choice5 = inp.nextInt();
                                                                                if (choice5 == 0) {
                                                                                        break;
                                                                                } else
                                                                                        doktor.get(i).Medical_Application(
                                                                                                        jemaahWithDoctor.get(
                                                                                                                        choice5 - 1));

                                                                        }

                                                                } while (choice3 != 3);
                                                        } else {

                                                        }

                                                }
                                                break;
                                        }
                                        case 3: {
                                                System.out.println("Enter your credentials");
                                                System.out.print("Identification Card Number: ");
                                                IC = inp.nextLine();
                                                // inp.nextLine(); // clear buffer
                                                System.out.print("Embassy ID: ");
                                                ID = inp.nextLine();
                                                inp.nextLine();

                                                for (int k = 0; k < pegawai.size(); k++) {
                                                        if(IC.equals(pegawai.get(k).getIdentification_Card()) && ID.equals(pegawai.get(k).getEmbassy_numberr())){
                                                                do{
                                                                        System.out.println("Hi Mr. " + pegawai.get(k).getName());
                                                                        System.out.println(
                                                                                        "========== Embassy Menu ==========");
                                                                        System.out.println("[1] Show Embassy "
                                                                                        + pegawai.get(k).getName()
                                                                                        + " info");
                                                                        System.out.println(
                                                                                        "[2] Visa Application Business\n[3] Exit\nYour choice: ");
                                                                        choice3 = inp.nextInt();
                                                                        switch (choice3) {
                                                                                case 1:
                                                                                        pegawai.get(k).display();
                                                                                        break;
                                                                                case 2:
                                                                                        Vector<Jemaah> JemaahWithEmbassy = new Vector<>();
                                                                                        for (int j = 0; j < jemaah.size(); j++) {
                                                                                                if (jemaah.get(j).getEmbassy() == pegawai.get(k)) {
                                                                                                        JemaahWithEmbassy.add(jemaah.get(j));
                                                                                                }
                                                                                        }
                                                                                        System.out.println("========== LIST OF JEMAAH ==========");
                                                                                        for (int j = 0; j < JemaahWithEmbassy.size(); j++) {
                                                                                                System.out.println((j+1) + ") " + JemaahWithEmbassy.get(j).getName());
                                                                                        }
                                                                                        System.out.println();
                                                                                        System.out.print("[a] Press 0 for Exit \n[b] Press number of jemaah [1 - " + JemaahWithEmbassy.size() +"]\n");
                                                                                        choice5 = inp.nextInt();
                                                                                        switch (choice5) {
                                                                                                case 0:
                                                                                                        break;
                                                                                        
                                                                                                default:
                                                                                                        pegawai.get(k).Visa_Application(JemaahWithEmbassy.get(choice5 - 1));;
                                                                                                        break;
                                                                                        }
                                                                                        break;
                                                                                default:
                                                                                        break;
                                                                        }
                                                                }while(choice3 != 3);
                                                        }
                                                }
                                                break;

                                                //Sini Login Embassy
                                        }
                                }
                        }

                        else {
                                break;
                        }

                } while (choice1 != 2);
                inp.close();
        }
}

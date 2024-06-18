import java.util.Scanner;
import java.util.Vector;
import java.security.SecureRandom;

public class HajiUmrahApp {
        public static void main(String[] args) {
                Scanner inp = new Scanner(System.in);
                Vector<Embassy> pegawai = new Vector<>();
                Vector<Doctor> doktor = new Vector<>();
                Vector<Jemaah> jemaah = new Vector<>();
                SecureRandom randomNumberGenerator = new SecureRandom();
                int randomNumber = randomNumberGenerator.nextInt(2);

                Embassy pegawai1 = new Embassy("Muhammad Ali Bin Abu", "019-375 6551", "920102-01-9874",
                                "zilman2345@gmail.com", "Setia Tropika", "Ketua Jabatan Imigresen", "JIM2013");
                Embassy pegawai2 = new Embassy("Ahmad Aliff Bin Ali", "012-345 6789", "920101-01-1234",
                                "aliff.ali@gmail.com", "Taman Sri Andalas", "Timbalan Ketua Jabatan Imigresen",
                                "JIM1223");

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
                                "030717", 21, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah2 = new Jemaah("Ahmad Ali Bin Hassan", "0123456789", "950101010101", "ahmad.ali@gmail.com",
                                "950101", 40, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah3 = new Jemaah("Nur Aisyah Binti Mohd", "0139876543", "940202050567",
                                "aisyah.mohd@gmail.com",
                                "940202", 33, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah4 = new Jemaah("Siti Khadijah Binti Ismail", "0172233445", "930303101234",
                                "khadijah.ismail@gmail.com",
                                "930303", 28, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah5 = new Jemaah("Zulhilmi Bin Yusof", "0169987766", "960404020987", "zul.yusof@gmail.com",
                                "960404", 25, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah6 = new Jemaah("Aminah Binti Ali", "0187766554", "920808030404", "aminah.ali@gmail.com",
                                "920808", 29, doctor2, pegawai2);
                Jemaah jemaah7 = new Jemaah("Ahmad Bin Samad", "0194455566", "911111101010", "ahmad.samad@gmail.com",
                                "911111", 36, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah8 = new Jemaah("Nurul Huda Binti Zainal", "0178877799", "931212101011",
                                "nurul.huda@gmail.com",
                                "931212", 31, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah9 = new Jemaah("Azizul Rahman Bin Mahmood", "0143322111", "971213030101",
                                "azizul.rahman@gmail.com",
                                "971213", 24, doktor.get(randomNumber), pegawai.get(randomNumber));
                Jemaah jemaah10 = new Jemaah("Siti Aminah Binti Abdul Rahman", "0123344556", "990505070707",
                                "siti.aminah@gmail.com",
                                "990505", 27, doktor.get(randomNumber), pegawai.get(randomNumber));

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
                String IC, ID;
                do {
                        System.out.print("[1] Log In\n[2] Exit\nYour Choice: ");
                        choice1 = inp.nextInt();
                        if (choice1 == 1) {
                                System.out.print("Who are you?\n[1] Jemaah\n[2] Doctor\n[3] Embassy\nYour choice: ");
                                choice2 = inp.nextInt();
                                inp.nextLine();
                                switch (choice2) {
                                        case 1: {

                                                break;
                                        }
                                        case 2: {
                                                System.out.println("Enter your credentials");
                                                System.out.print("Identification Card Number: ");
                                                IC = inp.nextLine();
                                                System.out.print("Doctor ID: ");
                                                ID = inp.nextLine();
                                                for (int i = 0; i < doktor.size(); i++) {
                                                        if (IC.equals(doktor.get(i).getIdentification_Card()) && ID
                                                                        .equals(doktor.get(i).getDoctor_Number())) { // check
                                                                // IC
                                                                // and
                                                                // ID
                                                                // sama
                                                                // tak
                                                                do {

                                                                        System.out.println("Hi Dr. "
                                                                                        + doktor.get(i).getName());
                                                                        System.out.println(
                                                                                        "========== Doctor Menu ==========");
                                                                        System.out.println("[1] Show Dr. "
                                                                                        + doktor.get(i).getName()
                                                                                        + " info");
                                                                        System.out.println(
                                                                                        "[2] Medical Application Business\n[3] Exit\nYour choice: ");
                                                                        choice3 = inp.nextInt();

                                                                        if (choice3 == 1) {
                                                                                doktor.get(i).display();                //dulu guna dooktor.get(i).display_doctor_info()
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
                                                                                for (User jemaahtry : jemaahWithDoctor) {
                                                                                        jemaahtry.display();    //dia akan panggil semua super and subclass display
                                                                                }

                                                                                // doktor.get(i).Medical_Application(
                                                                                // jemaah10); camne nak check, the first
                                                                                // jemaah yang ada mohon
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
                                                inp.nextLine(); // clear buffer
                                                System.out.print("Embassy ID: ");
                                                ID = inp.nextLine();
                                                break;
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
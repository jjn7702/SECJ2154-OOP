import java.util.Scanner;
import java.util.Vector;

public class HajiUmrahApp {
        public static void main(String[] args) {
                Scanner inp = new Scanner(System.in);
                Vector<Embassy> pegawai = new Vector<>();
                Vector<Doctor> doktor = new Vector<>();
                Vector<Jemaah> jemaah = new Vector<>();
                Vector<Hotel> hotel = new Vector<>();

                Embassy pegawai1 = new Embassy("Muhammad Ilman Bin Mohd Khairi", "019-577 3762", "030717-08-0421",
                                "zilman2345@gmail.com", "Setia Tropika", "Kastam", "030717");
                Embassy pegawai2 = new Embassy("Ahmad Aliff Bin Ali", "012-345 6789", "920101-01-1234",
                                "aliff.ali@gmail.com", "Taman Sri Andalas", "Imigresen", "920101");
                Embassy pegawai3 = new Embassy("Nur Aisyah Binti Mohd", "013-987 6543", "940202-05-5678",
                                "aisyah.mohd@gmail.com", "Bukit Indah", "Konsulat", "940202");
                Embassy pegawai4 = new Embassy("Siti Khadijah Binti Ismail", "017-223 3445", "950303-10-6789",
                                "khadijah.ismail@gmail.com", "Taman Molek", "Jabatan Luar Negeri", "950303");
                Embassy pegawai5 = new Embassy("Zulhilmi Bin Yusof", "016-998 7766", "960404-02-9876",
                                "zul.yusof@gmail.com", "Nusa Bestari", "Kementerian Pertahanan", "960404");

                Doctor doctor1 = new Doctor("Dr. Ahmad Ali", "012-345 6789", "870101-01-1234",
                                "ahmad.ali@gmail.com", "Hospital Kuala Lumpur", "Cardiologist", "DOC12345");
                Doctor doctor2 = new Doctor("Dr. Siti Nurhaliza", "013-987 6543", "890202-05-5678",
                                "siti.nurhaliza@gmail.com", "Hospital Selayang", "Neurologist", "DOC23456");
                Doctor doctor3 = new Doctor("Dr. Mohd Faizal", "014-223 3445", "910303-10-6789",
                                "mohd.faizal@gmail.com", "Hospital Putrajaya", "Pediatrician", "DOC34567");
                Doctor doctor4 = new Doctor("Dr. Aisyah Ismail", "015-998 7766", "920404-02-9876",
                                "aisyah.ismail@gmail.com", "Hospital Serdang", "Surgeon", "DOC45678");
                Doctor doctor5 = new Doctor("Dr. Zulhilmi Yusof", "016-577 3762", "930505-08-0421",
                                "zul.yusof@gmail.com", "Hospital Ampang", "General Practitioner", "DOC56789");
                // pegawai1.display_Embassy_Info();
                // pegawai1.update_Embassy_Info();

                Hotel hotel1 = new Hotel("Hotel Concorde",
                                "2, Jln Sultan Ismail, Kuala Lumpur, 50250 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur",
                                600);
                Hotel hotel2 = new Hotel("Hotel Istana",
                                "73, Jalan Raja Chulan, 50200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", 500);
                Hotel hotel3 = new Hotel("Shangri-La Hotel",
                                "11, Jalan Sultan Ismail, 50250 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", 700);
                Hotel hotel4 = new Hotel("Traders Hotel",
                                "Kuala Lumpur City Centre, 50088 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur", 650);
                Hotel hotel5 = new Hotel("The Majestic Hotel",
                                "5, Jalan Sultan Hishamuddin, 50000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur",
                                550);
                // concorde.display_Hotel_Info();

                Jemaah jemaah1 = new Jemaah("Muhammad Faiz Bin Zakaria", "0195773762", "030717080421",
                                "zfaiz2345@gmail.com",
                                "030717", 21, doctor1, pegawai1);
                Jemaah jemaah2 = new Jemaah("Ahmad Ali Bin Hassan", "0123456789", "950101010101", "ahmad.ali@gmail.com",
                                "950101", 40, doctor1, pegawai1);
                Jemaah jemaah3 = new Jemaah("Nur Aisyah Binti Mohd", "0139876543", "940202050567",
                                "aisyah.mohd@gmail.com",
                                "940202", 33, doctor2, pegawai2);
                Jemaah jemaah4 = new Jemaah("Siti Khadijah Binti Ismail", "0172233445", "930303101234",
                                "khadijah.ismail@gmail.com",
                                "930303", 28, doctor2, pegawai2);
                Jemaah jemaah5 = new Jemaah("Zulhilmi Bin Yusof", "0169987766", "960404020987", "zul.yusof@gmail.com",
                                "960404", 25, doctor3, pegawai3);
                Jemaah jemaah6 = new Jemaah("Aminah Binti Ali", "0187766554", "920808030404", "aminah.ali@gmail.com",
                                "920808", 29, doctor3, pegawai3);
                Jemaah jemaah7 = new Jemaah("Ahmad Bin Samad", "0194455566", "911111101010", "ahmad.samad@gmail.com",
                                "911111", 36, doctor4, pegawai4);
                Jemaah jemaah8 = new Jemaah("Nurul Huda Binti Zainal", "0178877799", "931212101011",
                                "nurul.huda@gmail.com",
                                "931212", 31, doctor4, pegawai4);
                Jemaah jemaah9 = new Jemaah("Azizul Rahman Bin Mahmood", "0143322111", "971213030101",
                                "azizul.rahman@gmail.com",
                                "971213", 24, doctor5, pegawai5);
                Jemaah jemaah10 = new Jemaah("Siti Aminah Binti Abdul Rahman", "0123344556", "990505070707",
                                "siti.aminah@gmail.com",
                                "990505", 27, doctor5, pegawai5);

                Flight penerbangan1 = new Flight("D23", "14/6/2024", "20/6/2024", "0500", "1300", "Mekah", "Jeddah");
                Flight penerbangan2 = new Flight("A12", "15/6/2024", "21/6/2024", "0600", "1400", "Riyadh", "Dammam");
                Flight penerbangan3 = new Flight("B34", "16/6/2024", "22/6/2024", "0700", "1500", "Doha", "Dubai");
                Flight penerbangan4 = new Flight("C56", "17/6/2024", "23/6/2024", "0800", "1600", "Abu Dhabi",
                                "Sharjah");
                Flight penerbangan5 = new Flight("D78", "18/6/2024", "24/6/2024", "0900", "1700", "Kuwait City",
                                "Manama");
                Flight penerbangan6 = new Flight("E90", "19/6/2024", "25/6/2024", "1000", "1800", "Muscat", "Salalah");
                Flight penerbangan7 = new Flight("F12", "20/6/2024", "26/6/2024", "1100", "1900", "Baghdad", "Basra");
                Flight penerbangan8 = new Flight("G34", "21/6/2024", "27/6/2024", "1200", "2000", "Beirut", "Tripoli");
                Flight penerbangan9 = new Flight("H56", "22/6/2024", "28/6/2024", "1300", "2100", "Amman", "Aqaba");
                Flight penerbangan10 = new Flight("I78", "23/6/2024", "29/6/2024", "1400", "2200", "Cairo",
                                "Alexandria");

                pegawai.add(pegawai1);
                pegawai.add(pegawai2);
                pegawai.add(pegawai3);
                pegawai.add(pegawai4);
                pegawai.add(pegawai5);

                doktor.add(doctor1);
                doktor.add(doctor2);
                doktor.add(doctor3);
                doktor.add(doctor4);
                doktor.add(doctor5);

                hotel.add(hotel1);
                hotel.add(hotel2);
                hotel.add(hotel3);
                hotel.add(hotel4);
                hotel.add(hotel5);

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

                for (int i = 0; i < jemaah.size(); i++) {
                        System.out.println("========== JEMAAH " + (i + 1) + " ==========");
                        jemaah.get(i).display_Jemaah_Info();
                }

                // trying to display Kursus information
                Vector<Kursus> kList = new Vector<>();
                Kursus k1 = new Kursus("0001", "9:00 AM", "12 May 2024", "Dewan Sultan Iskandar", "Ustaz Panji Alam");
                Kursus k2 = new Kursus("0002", "9:00 AM", "12 May 2024", "Dewan Sultan Iskandar", "Ustaz Panji Alam");
                Kursus k3 = new Kursus("0003", "8:00 AM", "22 May 2024", "Dewan Serbaguna Labu Batu 9",
                                "Ustaz Daniyel Don");
                Kursus k4 = new Kursus("0004", "9:00 AM", "25 May 2024", "Dewan Pak Munawir",
                                "Ustaz Zim Zim Ala Kazzim");

                kList.add(k1);
                kList.add(k2);
                kList.add(k3);
                kList.add(k4);

                System.out.printf("%-5s %-8s %-12s %-30s %-15s\n", "ID", "Time", "Date", "Place", "Ustaz");
                for (Kursus k : kList) {
                        k.Display_Kursus_info();
                }

                inp.close();
        }
}
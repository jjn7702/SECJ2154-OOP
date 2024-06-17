import java.util.Scanner;
import java.io.*;

public class ScholarshipApp {
    static Scanner inp = new Scanner(System.in);
    static int countAdmin = 0;
    static int countStudent = 0;

    public static void main(String[] args) throws IOException {
        Administrator ad;
        Student stu;
        System.out.println("---------- WHALE SCHOLARSHIP ----------");
        System.out.println("Are you a Student or an Administrator?");

        System.out.print("[0]\tStudent\n[1]\tAdministrator\n");
        int choice = inp.nextInt();

        if (choice == 0) {
            System.out.println("Register? (Y/N)");
            char rs = inp.next().toUpperCase().charAt(0);

            if (rs == 'Y') {
                registerStudent();
                countStudent++;
            } else if (rs == 'N') {
                stu = signInStudent();
                System.out.println(stu.toString());
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
        if (choice == 1) {
            System.out.println("Register? (Y/N)");
            char rs = inp.next().toUpperCase().charAt(0);

            if (rs == 'Y') {
                registerAdministrator();
                countAdmin++;
            } else if (rs == 'N') {
                ad = signInAdministrator();
                System.out.println(ad.getusername());
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
        inp.close();

        Scholarship mB = new meritBased(3000.00) ;
        Scholarship nB = new needBased(5000.00) ;        
    }

    private static void registerAdministrator() {
        try {
            System.out.println("---------- Personal Information ----------");
            System.out.print("FIRST NAME:\t");
            String fn = inp.next();
            System.out.print("LAST NAME:\t");
            String ln = inp.next();
            System.out.print("CURRENT AGE:\t");
            int age = inp.nextInt();
            inp.nextLine(); // Consume newline
            System.out.print("EMAIL:\t");
            String email = inp.nextLine();
            System.out.print("POSITION:\t");
            String posi = inp.nextLine();

            System.out.println("---------- Address Information ----------");
            System.out.print("STREET:\t");
            String s = inp.nextLine();
            System.out.print("CITY:\t");
            String ci = inp.nextLine();
            System.out.print("STATE:\t");
            String st = inp.nextLine();

            System.out.println("---------- Administrator Information ----------");
            System.out.print("USERNAME:\t");
            String usname = inp.next();
            inp.nextLine(); // Consume newline
            System.out.print("PASSWORD (Suggest to combine alphabet with numbers and symbols):\t");
            String pass = inp.next();
            inp.nextLine(); // Consume newline

            // Write to File
            PrintWriter outFile = new PrintWriter("Admin" + usname + ".txt");
            outFile.printf("%-20s\t%-20s\n", usname, pass);
            outFile.print(fn + "\t" + ln + "\t" + age + "\t" + email + "\n" + s + ", " + ci + ", " + st);
            outFile.close();
            System.out.println("Administrator information saved successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Unable to create or write to the file.");
            e.printStackTrace();
        }
    }

    private static Administrator signInAdministrator() {
        System.out.println("---------- Sign In ----------");
        System.out.print("ENTER YOUR USERNAME:\t");
        String us = inp.next();
        System.out.print("ENTER YOUR PASSWORD:\t");
        String pass = inp.next();
        String fileUsername = "", filePassword = "", fname = "", lname = "", email = "", address = "", street = "",
                cityAndPostalCode = "", state = "";
        int age = 0;

        boolean authenticated = false;

        File file = new File("Submission/sec04_23242/WHALE/source code/Admin" + us + ".txt");
        // Submission/sec04_23242/WHALE/source code/Adminhazim.txt

        try {
            // System.out.print("Inside the file") ;
            Scanner fileScanner = new Scanner(file);

            // Read the username and password from the file
            fileUsername = fileScanner.next();
            filePassword = fileScanner.next();

            // Check if the entered credentials match the stored ones
            if (fileUsername.equals(us) && filePassword.equals(pass)) {
                System.out.println("Login successful!");

                // Read the remaining details
                fname = fileScanner.next();
                lname = fileScanner.next();
                age = fileScanner.nextInt();
                // fileScanner.nextLine(); // Consume the newline character after age
                email = fileScanner.nextLine();

                address = fileScanner.nextLine();

                System.out.println("Full Name: " + fname + " " + lname);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);

                // Split the address by commas
                String[] addressParts = address.split(",");

                // Trim and assign each part to the corresponding variable
                street = addressParts[0].trim();
                cityAndPostalCode = addressParts[1].trim();
                state = addressParts[2].trim();

                System.out.println("Street: " + street);
                System.out.println("City and Postal Code: " + cityAndPostalCode);
                System.out.println("State: " + state);

                fileScanner.close();
            }
            Administrator fd = new Administrator(fname, lname, age, email, null, fileUsername, state, null, null, null);

            return fd;
        } catch (FileNotFoundException e) {
            // If file is not found, continue to next authentication attempt
        }
        return null;
    }

    private static void registerStudent() {
        try {
            System.out.println("---------- Personal Information ----------");
            System.out.print("FIRST NAME:\t");
            String fn = inp.next();
            System.out.print("LAST NAME:\t");
            String ln = inp.next();
            System.out.print("CURRENT AGE:\t");
            int age = inp.nextInt();
            inp.nextLine(); // Consume newline
            System.out.print("EMAIL:\t");
            String email = inp.nextLine();

            System.out.println("---------- Address Information ----------");
            System.out.print("STREET:\t");
            String s = inp.nextLine();
            System.out.print("CITY:\t");
            String ci = inp.nextLine();
            System.out.print("STATE:\t");
            String st = inp.nextLine();

            System.out.println("---------- Student Information ----------");
            System.out.print("USERNAME:\t");
            String usname = inp.next();
            inp.nextLine(); // Consume newline
            System.out.print("PASSWORD (Suggest to combine alphabet with numbers and symbols):\t");
            String pass = inp.next();
            inp.nextLine(); // Consume newline
            System.out.print("MATRIC NUMBER:\t");
            String matricsNu = inp.next();

            // Write to File
            PrintWriter outFile = new PrintWriter("Student" + usname + ".txt");
            outFile.printf("%-20s\t%-20s\n", usname, pass);
            outFile.println(fn + "\t" + ln + "\t" + age + "\t" + email + "\n" + s + ", " + ci + ", " + st);
            outFile.printf("%-20s", matricsNu);
            outFile.close();
            System.out.println("Student information saved successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Unable to create or write to the file.");
            e.printStackTrace();
        }
    }

    private static Student signInStudent() {
        System.out.println("---------- Sign In ----------");
        System.out.print("ENTER YOUR USERNAME:\t");
        String us = inp.next();
        System.out.print("ENTER YOUR PASSWORD:\t");
        String pass = inp.next();
        String fileUsername = "", filePassword = "", fname = "", lname = "", email = "", address = "", street = "",
                cityAndPostalCode = "", state = "", matricsNu = "";
        int age = 0;
        boolean authenticated = false;

        File file = new File("Submission/sec04_23242/WHALE/source code/Student" + us + ".txt");
        // Submission/sec04_23242/WHALE/source code/Adminhazim.txt

        try {
            // System.out.print("Inside the file") ;
            Scanner fileScanner = new Scanner(file);

            // Read the username and password from the file
            fileUsername = fileScanner.next();
            filePassword = fileScanner.next();

            // Check if the entered credentials match the stored ones
            if (fileUsername.equals(us) && filePassword.equals(pass)) {
                System.out.println("Login successful!");

                // Read the remaining details
                fname = fileScanner.next();
                lname = fileScanner.next();
                age = fileScanner.nextInt();
                email = fileScanner.nextLine();

                address = fileScanner.nextLine();
                matricsNu = fileScanner.nextLine();

                System.out.println("Full Name: " + fname + " " + lname);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);

                // Split the address by commas
                String[] addressParts = address.split(",");

                // Trim and assign each part to the corresponding variable
                street = addressParts[0].trim();
                cityAndPostalCode = addressParts[1].trim();
                state = addressParts[2].trim();

                System.out.println("Street: " + street);
                System.out.println("City and Postal Code: " + cityAndPostalCode);
                System.out.println("State: " + state);

                fileScanner.close();

                Student stu = new Student(fname, lname, age, email, null, matricsNu);
                return stu;
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (FileNotFoundException e) {
            // If file is not found, continue to next authentication attempt
            System.out.println("User file not found.");
        }

        // Return null if authentication fails
        return null;
    }

}

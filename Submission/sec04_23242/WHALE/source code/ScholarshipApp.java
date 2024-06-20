import java.util.*;
import java.io.*;

public class ScholarshipApp {
    static Scanner inp = new Scanner(System.in);
    static int countAdmin = 0;
    static Administrator ad = new Administrator();
    static Student stu = new Student() ;

    public static void main(String[] args) throws IOException {
        int sID = 0000;
        Vector<Student> StudList = new Vector<Student>(); // Insert the student that have been registered for
                                                          // scholarship

        do {
            System.out.println("---------- WHALE SCHOLARSHIP ----------");
            System.out.println("Are you a Student or an Administrator?");

            System.out.print("[0]\tStudent\n[1]\tAdministrator\n");
            int choice = inp.nextInt();

            if (choice == 0) {
                System.out.println("Register? (Y/N)");
                char rs = inp.next().toUpperCase().charAt(0);

                if (rs == 'Y') {
                    stu = registerStudent();
                    StudList.add(stu);

                } else if (rs == 'N') {
                    stu = signInStudent(); // Ni function untuk tngok status je
                    int i=0 , j =0 ;

                    if (StudList.size() == 0){
                        StudList.add(stu) ;
                    }

                    for (Student st : StudList) {
                        if(st.equals(stu))
                            break ;
                        i++ ;
                    }

                    System.out.println("[0] Do you want to check the status of your apllication?");
                    System.out.println("[1] Do you want to apply for a scholarship??");
                    int ap = inp.nextInt() ;

                    switch (ap) {
                        case 0: if (StudList.get(i).getScholarship() == null){
                                    System.out.println("Your application is not approved yet. Check again later") ;
                                }
                                else{
                                    System.out.println("Your application has approved. We will display the information") ;
                                    StudList.get(i).displayAllDetails() ;
                                }
                                break ;
                        case 1: applyFromDisplayScholarship(StudList.get(i), sID) ; // Assuming sID is the student ID
                                  break;
                        default:
                            System.out.println("Invalid choice. Please enter 0 or 1") ;
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please enter Y or N.");
                }

                // Call the applyFromDisplayScholarship method
                /*if (choice == 0) { // Assuming choice 0 is for students
                    Student student = signInStudent();
                    if (student != null) {
                        System.out.println("Do you want to apply for a scholarship? (Y/N)");
                        char apply = inp.next().toUpperCase().charAt(0);
                        if (apply == 'Y') {
                            applyFromDisplayScholarship(student, sID); // Assuming sID is the student ID
                        }
                    }
                }*/
            }
            if (choice == 1) {
                System.out.println("Register? (Y/N)");
                char rs = inp.next().toUpperCase().charAt(0);

                if (rs == 'Y') {
                    registerAdministrator();
                    countAdmin++;
                } else if (rs == 'N') {
                    ad = signInAdministrator() ;

                    // ad.getusername() ;
                    if (ad == null)
                        break ;
                } else {
                    System.out.println("Invalid choice. Please enter Y or N.");
                }

                if (StudList.size() > 0) {
                    for (int i=0 ; i<StudList.size(); i++){
                        StudList.get(i).displayAllDetails() ;
                        boolean evs = ad.evaluateStudent(StudList.get(i)) ;

                        if (evs){
                            ad.application.incrementStudent() ;
                        }

                        else{
                        } 
                    }
                }

                System.out.println("do you want to logout? (Y/N)");
                char y = inp.next().toUpperCase().charAt(0);
                if (y == 'Y') {
                    countAdmin--;
                    ad = null;
                }
                else{
                    break ;
                }
                
                if (StudList.isEmpty()) {
                    System.out.println("There is no student applying the scholarship");
                }

            }

        } while (ad != null || StudList.size() > 0);

        displayStudList(StudList);

        inp.close();
    }

    private static void registerAdministrator() {
        boolean validInput = false;
        int age = 0;

        try {
            System.out.println("---------- Personal Information ----------");
            System.out.print("FIRST NAME:\t");
            String fn = inp.next();
            System.out.print("LAST NAME:\t");
            String ln = inp.next();
            while (!validInput) {
                System.out.print("CURRENT AGE:\t");
                try {
                    age = inp.nextInt();
                    inp.nextLine();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    inp.nextLine();
                }
            }
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

        File file = new File("Admin" + us + ".txt");

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

                // Split the address by commas
                String[] addressParts = address.split(",");

                // Trim and assign each part to the corresponding variable
                street = addressParts[0].trim();
                cityAndPostalCode = addressParts[1].trim();
                state = addressParts[2].trim();

                fileScanner.close();
            }
            Administrator fd = new Administrator(fname, lname, age, email, null, fileUsername, state, null, null, null);

            return fd;
            
        } 
        catch (FileNotFoundException e) {
            System.out.println("There is no information about you") ;
            // If file is not found, continue to next authentication attempt
        }

        return null;
    }

    private static Student registerStudent() {
        try {
            String fname = "", lname = "", email = "", address = "", street = "",
                    cityAndPostalCode = "", state = "", matricsNu = "";
            int age = 0;

            System.out.println("---------- Personal Information ----------");
            System.out.print("FIRST NAME:\t");
            fname = inp.next();
            System.out.print("LAST NAME:\t");
            lname = inp.next();
            System.out.print("CURRENT AGE:\t");
            age = inp.nextInt();
            inp.nextLine(); // Consume newline
            System.out.print("EMAIL:\t");
            email = inp.nextLine();

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
            matricsNu = inp.next();

            // Write to File
            PrintWriter outFile = new PrintWriter("Student" + usname + ".txt");
            outFile.printf("%-20s\t%-20s\n", usname, pass);
            outFile.println(fname + "\t" + lname + "\t" + age + "\t" + email + "\n" + s + ", " + ci + ", " + st);
            outFile.printf("%-20s", matricsNu);
            outFile.close();
            System.out.println("Student information saved successfully.");

            Student stu = new Student(fname, lname, age, email, new Address(s, ci, st), matricsNu);
            return stu;
        }

        catch (FileNotFoundException e) {
            System.err.println("Error: Unable to create or write to the file.");
            e.printStackTrace();
        }

        return null;
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

        File file = new File("Student" + us + ".txt");

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

                // Split the address by commas
                String[] addressParts = address.split(",");

                // Trim and assign each part to the corresponding variable
                street = addressParts[0].trim();
                cityAndPostalCode = addressParts[1].trim();
                state = addressParts[2].trim();

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

    private static int applyScholarship(Student st, int sid) {
        sid++;
        String schship = "";
        String sID = String.valueOf(sid);
        Scholarship ip;

        if (schship.equals("meritBased")) {
            ip = new meritBased(sID, 3453);
            st.setScholarship(ip);
        }

        if (schship.equals("needBased")) {
            ip = new needBased(sID, 3453);
            st.setScholarship(ip);
        }

        // Letak diorang isi StudentHistory juga dlm ni

        return sid;
    }

    private static void applyFromDisplayScholarship(Student student, int sid) {
        try {
            System.out.println("Select type of scholarship to apply:");
            System.out.println("[1] Merit Based");
            System.out.println("[2] Need Based");
            int choice = inp.nextInt();
            File file;
            
            if (choice == 1) {
                file = new File("Submission\\sec04_23242\\WHALE\\source code\\meritScholarship.txt");
            } else if (choice == 2) {
                file = new File("Submission\\sec04_23242\\WHALE\\source code\\needScholarshp.txt");
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            Scanner fileScanner = new Scanner(file);
            ArrayList<String> scholarships = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                scholarships.add(fileScanner.nextLine());
            }
            fileScanner.close();

            // Display all scholarships with an index
            for (int i = 0; i < scholarships.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + scholarships.get(i));
            }

            // Ask the student to select a scholarship
            System.out.println("Enter the number of the scholarship you want to apply for:");
            int scholarshipChoice = inp.nextInt() - 1; // Adjust for 0-based index
            if (scholarshipChoice < 0 || scholarshipChoice >= scholarships.size()) {
                System.out.println("Invalid choice.");
                return;
            }

            // Confirm application
            System.out.println("You have selected: " + scholarships.get(scholarshipChoice));
            System.out.println("Do you want to apply for this scholarship? (Y/N)");
            char response = inp.next().toUpperCase().charAt(0);
            if (response == 'Y') {
                sid++; // Assuming Student class has getStudentId method
                applyScholarship(student, sid);
                System.out.println("Application successful.");
            } else {
                System.out.println("Application cancelled.");
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Scholarship file not found.");
        }
    }

    private static void displayStudList(Vector<Student> sop) {
        if (!sop.isEmpty()) {
            for (Student k : sop) {
                k.displayAllDetails();
            }
        }
    }
}

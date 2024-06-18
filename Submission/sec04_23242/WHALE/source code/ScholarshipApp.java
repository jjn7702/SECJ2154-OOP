import java.util.*;
import java.io.*;

public class ScholarshipApp {
    static Scanner inp = new Scanner(System.in) ;
    static int countAdmin = 0;
    static int countStudent = 0;
    static Administrator ad;
    static Student stu;

    public static void main(String[] args) throws IOException { 
        int sID = 0000 ;
        Vector<Student> StudList = new Vector<Student>() ;

        do{
            System.out.println("---------- WHALE SCHOLARSHIP ----------");
            System.out.println("Are you a Student or an Administrator?");

            System.out.print("[0]\tStudent\n[1]\tAdministrator\n") ;
            int choice = inp.nextInt() ;

            if (choice == 0) {
                System.out.println("Register? (Y/N)");
                char rs = inp.next().toUpperCase().charAt(0);

                if (rs == 'Y') {
                    registerStudent();
                    countStudent++;
                    //Panggil Student nak isi dkt sini karu
                
                } else if (rs == 'N') {
                    stu = signInStudent();
                    if(countStudent == 0)
                    sID = applyScholarship(stu, sID) ;
                } 
                else {
                    System.out.println("Invalid choice. Please enter Y or N.");
                }
            }
            if (choice == 1) {
                System.out.println("Register? (Y/N)");
                char rs = inp.next().toUpperCase().charAt(0);

                if (rs == 'Y') {
                    registerAdministrator();
                    countAdmin++;
                } 
                else if (rs == 'N') {
                    ad = signInAdministrator();
                    if(countAdmin == 0)
                        countAdmin++ ;

                    System.out.println(ad.getusername());
                } 
                else {
                    System.out.println("Invalid choice. Please enter Y or N.");
                }
            }

            if(countStudent == 0){
                System.out.println("There is no student applying the scholarship") ;
            }

            if (choice == 1){ // The Administrator work
                if(countStudent>0){
                    for(int i=0 ; i<countStudent ; i++){
                        stu.displayAllDetails() ;
                        boolean evs = ad.evaluateStudent(stu) ;
                        if (evs){
                            StudList.add(stu) ;
                            ad.application.incrementStudent() ;
                        }
                        else{
                        }
                }
            }

                System.out.println("do you want to logout? (Y/N)" ) ;
                char y = inp.next().toUpperCase().charAt(0) ;
                if (y == 'Y'){
                    countAdmin-- ;
                    ad = null ;
                }
            }

            if (choice == 0){
                // Karu nanti nk buat Student isi butiran diti utk scholarship tu, buat dkt sini
            }

        }while (ad != null || countStudent>0) ;
        
        displayStudList(StudList) ;
        
        inp.close() ;
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
        } 
        
        catch (FileNotFoundException e) {
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

                // Split the address by commas
                String[] addressParts = address.split(",");

                // Trim and assign each part to the corresponding variable
                street = addressParts[0].trim();
                cityAndPostalCode = addressParts[1].trim();
                state = addressParts[2].trim();

                fileScanner.close();

                Student stu = new Student(fname, lname, age, email, null, matricsNu);
                return stu;
            } 
            else {
                System.out.println("Invalid username or password.");
            }
        }
        catch (FileNotFoundException e) {
            // If file is not found, continue to next authentication attempt
            System.out.println("User file not found.");
        }

        // Return null if authentication fails
        return null;
    }

    private static int applyScholarship(Student st, int sid){
        Scholarship ip ;
        sid++ ; 
        String schship = "" ;
        String sID = String.valueOf(sid) ;

        if (schship == "meritBased"){
            ip = new meritBased(sID, 3453) ;
        }

        if (schship == "needBased"){
            ip  = new meritBased(sID, 3453) ;
        }

        //Letak Student History juga dlm ni

        return sid ;
    }

    private static void displayStudList(Vector<Student> sop){
        if (!sop.isEmpty()){
            for(Student k :sop){
                k.displayAllDetails() ;
            }
        }
    }
}


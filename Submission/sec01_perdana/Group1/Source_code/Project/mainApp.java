import java.io.FileNotFoundException;
import java.util.*;
import credentials.signUp.*;

public class mainApp {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME");
        System.out.println("Pick your choice:  ");
        System.out.println("1) Sign In" + "\n" + "2) Sign Up");
        int choice = input.nextInt();
        switch (choice){
           
            case 1: 

            case 2:
                SignUp obj = new SignUp();
                obj.process();
                //obj.display();
        }

    }
    
}
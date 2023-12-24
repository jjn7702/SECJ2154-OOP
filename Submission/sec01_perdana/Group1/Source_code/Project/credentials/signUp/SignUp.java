package credentials.signUp;
import java.util.*;
import java.io.*;

public class SignUp {
    public String username, pass;

    public void process() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(new BufferedReader(new FileReader("username.txt")));
        HashMap<String, String> userSignUp = new HashMap<String, String>();

        while (sc.hasNextLine()){
            String username = sc.next();
            String pass = sc.nextLine();
            //sc.useDelimiter(" ");
            userSignUp.put(username, pass);
        }
        
        System.out.println("======SIGN UP======");
        System.out.println("Username: ");
        username = input.nextLine();
        
        System.out.println("Password: ");
        pass = input.nextLine();
        if(userSignUp.containsValue(username)){
            System.out.println("Username Already Existed");
            display();
        } else {
            userSignUp.put(username, pass);
            System.out.println("Sign Up Successful");
            System.out.println(userSignUp);
        }
        }

    public void display(){

        System.out.println("Display method");
    }
    
}
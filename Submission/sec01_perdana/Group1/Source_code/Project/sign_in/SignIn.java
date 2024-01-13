package sign_in;
import java.util.*;
import user.User;

public class SignIn{
    private List<User> users;

    public SignIn(List<User> users) {
        this.users = users;
    }

    public User signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Sign in successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password. Sign in failed.");
        return null;
    }
}

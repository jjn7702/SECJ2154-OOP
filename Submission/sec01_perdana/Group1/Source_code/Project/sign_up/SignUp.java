package sign_up;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import employer.Employer;
import jobseeker.JobSeeker;
import user.User;

public class SignUp {
    private List<User> users;

    public SignUp(List<User> users) {
        this.users = users;
    }

    public void registerUser(User user) {
        users.add(user);
        writeUserToFile(user);
        System.out.println("\n\t\t\t\t\t\tUser registered successfully!");
    }

    private void writeUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserList.txt", true))) {
            //writer.newLine();
            writer.write(user.getUsername());
            writer.newLine();
            writer.write(user.getPassword());
            writer.newLine();

            if (user instanceof JobSeeker) {
                writer.write("JobSeeker");
                writer.newLine();
                writer.write(((JobSeeker) user).getResume());
            } else if (user instanceof Employer) {
                writer.write("Employer");
                writer.newLine();
                writer.write(((Employer) user).getCompany());
                writer.newLine();
            }

            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing user to file: " + e.getMessage());
        }
    }
}

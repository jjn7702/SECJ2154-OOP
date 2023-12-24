import java.io.*;
import java.util.Scanner;
import java.util.Vector;

class User {
   private String userID;
   private String userName;
   private String password;
   private String email;
   private int userRole;

   public User( String id, String name ,String pw, String mail, int roleID){
        userID = id;
        userName = name;
        password = pw;
        email = mail;
        userRole = roleID;
   }

   public User(){}

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getUserRole() {
        return userRole;
    }
    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public static Vector<User> readFromUserFile(int userRoleID) throws FileNotFoundException{
        Vector<User> cust = new Vector<User>();
        Scanner sc = new Scanner(new File("userDatabase.txt"));

        while(sc.hasNext()){
            String id = sc.next();
            String name = sc.next();
            String pw = sc.next();
            String mail = sc.next();
            int roleID = sc.nextInt();

            if(roleID == userRoleID){
                User temp = new User(id, name, pw, mail, roleID);
                cust.add(temp);
            }
        }

        sc.close();

        return cust;

    }

    public static User login(String name, String pw, int roleID) throws FileNotFoundException{
        Vector<User> users = new Vector<User>();
        users = readFromUserFile(roleID);
        for(User cust : users){
            if(cust.getUserName().equals(name) && cust.getPassword().equals(pw)){
                return cust;
            }
        }
        return null;
    }


}

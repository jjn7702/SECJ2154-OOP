import java.io.*;
import java.util.*;

class User extends Menu{
    protected String userID;
    protected String userName;
    protected String password;
    protected String email;
    protected int userRole;
    private Name name;

    public User( String id, String names ,String pw, String mail, int roleID,String fName, String lName){
        userID = id;
        userName = names;
        password = pw;
        email = mail;
        userRole = roleID;
        name = new Name(fName,lName); //composition done
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
    public Name getName(){
        return name;
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

    public static Vector<User> readAllUsers() throws FileNotFoundException{
        Vector<User> cust = new Vector<User>();
        Scanner sc = new Scanner(new File("userDatabase.txt"));
        
        while(sc.hasNext()){
            String id = sc.next();
            String name = sc.next();
            String pw = sc.next();
            String mail = sc.next();
            String fullName = sc.next();
            int roleID = sc.nextInt();
            String[] ary = fullName.split("_");
            String fName = ary[0];
            String lName = ary[1];
            User tempUser = new User(id, name, pw, mail, roleID,fName,lName);
            cust.add(tempUser);
        }
        
        return cust;

    }

    public static Vector<User> readFromUserFile(int userRoleID) throws FileNotFoundException{
        Vector<User> cust = new Vector<User>();
        Scanner sc = new Scanner(new File("userDatabase.txt"));
        
        while(sc.hasNext()){
            String id = sc.next();
            String name = sc.next();
            String pw = sc.next();
            String mail = sc.next();
            String fullName = sc.next();
            int roleID = sc.nextInt();

            if(roleID == userRoleID){
                String[] ary = fullName.split("_");
                String fName = ary[0];
                String lName = ary[1];
                User temp = new User(id, name, pw, mail, roleID,fName,lName);
                cust.add(temp);
            }
        }

        sc.nextLine();
        sc.close();
        
        return cust;

    }

     protected int viewMenu(){
        return 0;
     } //Polymorphism done using abstraction.
}
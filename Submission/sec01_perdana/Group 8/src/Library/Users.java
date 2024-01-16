public class Users extends Menu{
    protected String userID;
    protected String userName;
    protected String password;
    protected String email;
    protected int userRole;
    private Name name;

    public Users(String userID ,String userName , String password, String email, int userRole, String fName, String lName){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        name = new Name(fName,lName);                 //Composition 
    }

    public Users(){}

    public String getUserID(){
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public int getUserRole(){
        return userRole;
    }

    public Name getName(){
        return name;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setUserName(String userName){
            this.userName = userName;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public void setUserRole(int userRole){
        this.userRole = userRole;
    }

    public static Users login(String userName, String password, int roleID) throws FileNotFoundException{
        Vector <Users> users = new Vector<Users>();
        users = readFromUserFile(roleID);


        for(Users usr : users){
            if(usr.getUserName().equals(userName) && usr.getPassword().equals(password)){
                return usr;
            }
        }
        return null;
    }


    public static Vector<Users> readAllUsers() throws FileNotFoundException{
        Vector<Users> usr = new Vector <Users>();

        

    }


}
public class User {
    // protected and private attributes
    protected Address add;
    protected String fName;
    protected String lName;
    private int age;
    private String email;

    public User(){}

    // public attributes
    public User(String fn, String ln, int a, String em, Address add) {
        fName = fn;
        lName = ln;
        age = a;
        email = em;
        this.add = add;
    }

    // public methods
    public String toString() {
        return "";// fName + " " + lName + " " + age + " " + email + " " + add;
    }

    public int getAge() {
        return age;
    }
    
    public String getEmail(){
        return email ;
    }
}
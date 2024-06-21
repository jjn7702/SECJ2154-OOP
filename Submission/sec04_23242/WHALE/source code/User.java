public class User {
    // protected and private attributes
    protected Address add;
    protected String fName;
    protected String lName;
    private int age;
    private String email;

    public User() {
    }

    // public attributes
    public User(String fn, String ln, int a, String em, Address add) {
        fName = fn;
        lName = ln;
        age = a;
        email = em;
        this.add = add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public methods
    public String toString() {
        return "";// fName + " " + lName + " " + age + " " + email + " " + add;
    }

    public Address getAdd() {
        return add;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void display() {
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Address: " + add);
    }
}
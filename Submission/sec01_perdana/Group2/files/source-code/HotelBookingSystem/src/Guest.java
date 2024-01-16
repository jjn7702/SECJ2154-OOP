// Encapsulation: The class encapsulates information about a guest, with private fields.
public class Guest {
    
    // Encapsulation: Private fields to represent the state of a guest.
    private String name;
    private String contactNumber;
    private String email;

    // Constructor: Initializes a Guest object with provided information during object creation.
    public Guest(String name, String contactNumber, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    // Getter methods: Provide access to the private fields, following encapsulation principles.
    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods: Allow modification of private fields, following encapsulation principles.
    public void setName(String newName) {
        this.name = newName;
    }

    public void setContactNumber(String newContactNumber) {
        this.contactNumber = newContactNumber;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
}

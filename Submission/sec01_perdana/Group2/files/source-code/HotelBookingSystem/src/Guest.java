public class Guest {
    private String name;
    private String contactNumber;
    private String email;

    public Guest(String name, String contactNumber, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setContactNumber(String newContactNumber) {
        this.contactNumber = newContactNumber;
    }

	public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", contactNumber='" + getContactNumber() + "'" + ", email='" + getEmail() + "'" + "}";
	}
}

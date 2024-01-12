class Sign {
  
  private String email, gender, username, password;
  private Address address;
  private int phone;

  public Sign (String email, String gender, String username, String password, Address add, int phone) {
    this.email = email;
    this.gender = gender;
    address = add;
    this.username = username;
    this.password = password;
    this.phone = phone;
  }
  
  public String getEmail(){
    return email;
  }

  public String getGender(){
    return gender;
  }

  public Address getAddress(){
    return add;
  } 

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public int getPhone(){
    return phone;
  } 

  public void display() { 
    System.out.println("\nEMAIL: " + email); 
    System.out.println("\nWhat Is Your Gender: " + gender);
    System.out.println("\nGive Your Home Address: " + add);
    System.out.println("\nUSERNAME: " + username); 
    System.out.println("\nPASSWORD: " + password);
    System.out.println("\nGive Your Phone Number: " + phone);
  } 
}

public class SignIn {
  private String username;
  private String password;

  public SignIn (String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  } 

  public void display() {
    System.out.println("\nUSERNAME: " + username); 
    System.out.println("\nPASSWORD: " + password);
    } 
} 


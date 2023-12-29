class SignIn {
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

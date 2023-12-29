class SignUp {
  
  private String email, username, password;
  private int contact_number;

  public SignUp (String email, String username, String password, int contact_number) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.contact_number = contact;
  }

  public String getEmail(){
    return email;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public int getContact_number(){
    return contact;
  } 

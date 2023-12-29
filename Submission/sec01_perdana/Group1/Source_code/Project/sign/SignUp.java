class SignUp {
  
  private String email, gender, username, password;
  private Address add;
  private int phone;

  public SignUp (String email, String gender, String username, String password, Address add, int phone) {
    this.email = email;
    this.gender = gender;
    Address = add;
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

  public Address getAdd(){
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

class Name{
    private String fName;
    private String lName;

    Name(String f, String l){
        fName = f;
        lName = l;
    }

    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }

    public void setfName(String f){
        fName = f;
    }

    public void setlName(String l){
        lName = l;
    }
}
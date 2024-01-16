public class Person {
    private Name name;
    private String phoneNum;

    public Person(Name name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Name getName() {
        return name;
    }

    public String getPhoneNum() {
	        return phoneNum;
    }

}
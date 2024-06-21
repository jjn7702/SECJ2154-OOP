
/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
public class RegularUser extends User {
    final int NUM_OF_REC = 3;
    final String TYPE = "Regular User";

    public RegularUser(String id, String name){
        super(id,name);
    }

    public String getUserType(){
        return TYPE;
    }

    public int getNumOfRec(){
        return NUM_OF_REC;
    }

    public void displayInfo(){
        System.out.println("Name :"+super.getName());
        System.out.println("Regular User can only get "+NUM_OF_REC+" recommendation movie for each section.\n");
    }
}

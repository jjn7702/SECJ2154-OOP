package project;

/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
public class PremiumUser extends User{
    final int NUM_OF_REC = 5;
    final String TYPE = "Premium User";
    private double monthlyFee;

    public PremiumUser(String id, String name,double monthlyFee){
        super(id,name);
        this.monthlyFee = monthlyFee;
    }

    public String getUserType(){
        return TYPE;
    }

    public int getNumOfRec(){
        return NUM_OF_REC;
    }

    public double getMonthlyFee(){
        return monthlyFee;
    }

    public void displayInfo(){
        System.out.println("Name :"+super.getName()+", is a premium user.");
        System.out.printf("Monthly Fee: RM %.2f\n",this.getMonthlyFee());
        System.out.println("Premium User can get "+NUM_OF_REC+" recommendation movie for each section.\n");
    }
}

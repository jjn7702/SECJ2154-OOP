package Library;
import java.util.*;
public class DeleteAllData implements IOOperation{
    public void oper(Database database,User user){

        System.out.println("\nAre you sure you want to delete all data?\n 1. Continue\n 2. Main Menu");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n==1){
            database.deleteAllData();
            System.out.println("All data deleted successfully");
        }
        else{
            user.menu(database, user);
        }


        s.close();



    }
}

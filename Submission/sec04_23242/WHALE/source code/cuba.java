import java.util.*;
import java.io.* ;

public class cuba{
    public static void main(String[] args) {

        String p = "pppp" ;

        boolean w = openFileApro(p) ;

        System.out.println(w) ;
    }

    private static boolean openFileApro(String fy){
        try {
            Scanner sc = new Scanner(new File("ApprovedStudent.txt")) ;
            while(sc.hasNextLine()){
                String op = sc.nextLine() ;

                if (op.contains(fy)){
                    return true ;
                }

                else{

                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("There is no information about you");
            // If file is not found, continue to next authentication attempt
            System.err.println("Error: Unable to create or write to the file.");
            e.printStackTrace() ;
        }

        return false ;
    }
}
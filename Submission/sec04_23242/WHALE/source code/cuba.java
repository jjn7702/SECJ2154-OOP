import java.util.*;

public class cuba{
    public static void main(String[] args) {
        Scanner inp = new Scanner (System.in) ;
        System.out.println("[0] Do you want to check the status of your apllication?");
        System.out.println("[1] Do you want to apply for a scholarship?");
        int ap ;

                    try {
                        ap = inp.nextInt() ;
                        switch(ap){
                            case 0 : System.out.println("dssd") ;
                                    break ;
                            case 1 : System.out.println("sfjkf") ;
                        }
                    }
                      catch (InputMismatchException e) {
                        System.out.println("Invalid Input. Please Enter a Number!");
                        inp.nextLine();
                    }
    }
}
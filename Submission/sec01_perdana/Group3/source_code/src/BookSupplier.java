import java.util.Scanner;

public class BookSupplier extends User {
    private String supplierID;

    public BookSupplier(){}

    public BookSupplier(String id, String name ,String pw, String mail, int roleID){
        super(id, name, pw, mail, roleID);
        supplierID = id;
    }

    public String getSupplierID() {
        return supplierID;
    }


    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public static int viewSupplierMenu(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║          Supplier Menu        ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ 1. View All Orders            ║");
            System.out.println("║ 2. Order Approval             ║");
            System.out.println("║ 3. Exit                       ║");
            System.out.println("╚═══════════════════════════════╝");

            System.out.print("\n\n Enter the option (1-3) : ");
            option = sc.nextInt();

            if(option < 1 || option > 3){
                System.out.println("Invalid option entered. Please enter a number between 1 and 7. Try Again :)");
            }

        }while(option < 1 || option > 3);
        return option;
    }



}

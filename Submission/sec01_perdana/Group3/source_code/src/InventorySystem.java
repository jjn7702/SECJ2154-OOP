import java.io.*;
import java.util.*;

public class InventorySystem {

    public static void main(String[] args) throws IOException {
        //Testing with association - Sar
        Admin ad = new Admin();
        
        //creating a temporary Book object to be used as a connection for association.
        Admin.manageBookOperation(new Book(),4,1);
        //ad.viewMenu();

        //create temporary customer
        // Customer customer = new Customer();
        // customer.viewMenu();
    }

    public static void header(){
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*     Welcome to Kedai Buku Kamal!       *");
        System.out.println("*  Your One-Stop Bookstore Experience :) *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
    }
    
}
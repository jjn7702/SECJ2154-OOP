import java.io.*;
import java.util.*;

public class InventorySystem {

    public static void main(String[] args) throws IOException {
        //Testing with association - Sar
        Book b = new Book(); //create a dummy or temporary Book object, to send vector value into Admin or user u trying to create.
        Admin ad = new Admin("s","s","s","s",1,"","",b.getBooksfromFile());
        
        //creating a temporary Book object to be used as a connection for association.
        Admin.manageBookOperation(new Book(),4,1);
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
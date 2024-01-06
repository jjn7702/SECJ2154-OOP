import java.io.*;
import java.util.*;

public class Report {
    
    private Vector<OrderManagement> orderList;

    Report(Vector<OrderManagement> orderList){
        this.orderList = orderList;
    }

    Report(){
        orderList = new Vector<OrderManagement>();
    }

    public void generateReport(int roleID) throws FileNotFoundException{
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        InventorySystem.header();
        Scanner sc = new Scanner(System.in);
        OrderManagement orders = new OrderManagement();
        orderList = orders.getOrderFromFile(roleID);
        if(orderList.size() == 0){
            System.out.println("No Order Found.\nPress any key to continue..");
            return;
        }
        System.out.println(
            "╔═══════════════════════════════════════════════════════╗");
        System.out.println(
            "║               REPORT KEDAI BUKU KAMAL                 ║");
        System.out.println(
            "╠═══════════════════════════════════════════════════════╣");
        System.out.println(
            "║                  TOP 10 BOOKS SOLD                    ║");
        System.out.println(
            "║-------------------------------------------------------║");
        System.out.printf(
            "║%-8s | %-30s  | %-10s║\n", "Book ID", "Title", "Quantity");
        System.out.println(
            "║-------------------------------------------------------║");
    
        double totalAmount = 0;
        double totalAmountOrder = 0;

        Vector<String> bookId = new Vector<String>();
        Vector<String> bookTitles = new Vector<String>();
        Vector<Integer> bookQuantities = new Vector<Integer>();

        
        String status = "";
        int j= 0;
        for (OrderManagement order : orderList) {
            Book book = order.getBookInfo();
            String title = book.getTitle().replaceAll("_", " ");
            int quantity = order.getQuantityOrder();
            String id = book.getBookID();
            String st = order.getOrderStatus();
            
            int index = bookTitles.indexOf(title);
            int min = 0;
            if(order.getOrderStatus().equals("Approved")){
                totalAmountOrder += order.getTotalAmount();
            }else if(order.getOrderStatus().equals("Completed")){
                totalAmount += order.getTotalAmount();
            }
            if (index == -1) {
                if(st.equals("Rejected") || st.equals("Pending")){

                }else{
                    bookId.add(id);
                    bookTitles.add(title);
                    bookQuantities.add(quantity);
                }

            } else {
                if(st.equals("Rejected") || st.equals("Pending")){

                }else{
                    bookQuantities.set(index, bookQuantities.get(index) + quantity);
                }

            }
        }
        for (int i = 0; i < bookQuantities.size() - 1; i++) {
            for (int k = i + 1; k < bookQuantities.size(); k++) {
                if (bookQuantities.get(i) < bookQuantities.get(k)) {
                    int tempQuantity = bookQuantities.get(i);
                    bookQuantities.set(i, bookQuantities.get(k));
                    bookQuantities.set(k, tempQuantity);
        
                    String tempTitle = bookTitles.get(i);
                    bookTitles.set(i, bookTitles.get(k));
                    bookTitles.set(k, tempTitle);
        
                    String tempId = bookId.get(i);
                    bookId.set(i, bookId.get(k));
                    bookId.set(k, tempId);
                }
            }
        }
        
        // Display the top 10 books
        int n = Math.min(bookQuantities.size(), 10);
        System.out.println("║-------------------------------------------------------║");
        for (int i = 0; i < n; i++) {
            String id = bookId.get(i);
            String t = bookTitles.get(i);
            int quantity = bookQuantities.get(i);
        
            Book book = new Book();
            Vector<Book> books = new Vector<Book>();
            Book bk = new Book();
            
            books = bk.getBooksfromFile();
        
            for (Book b : books) { // double checking with title
                if (b.getTitle().replaceAll("_", " ").equalsIgnoreCase(t.replaceAll("_", " "))) {
                    book = b;
                    break;
                }
            }
            if (book != null) {
                System.out.printf("║%-8s | %-31s | %-10d║\n", id, t, quantity);
            }
        }
        if(totalAmount > totalAmountOrder){
            status = "Profit";
        }else{
            status = "Loss";
        }
        double totalProfit = totalAmount - totalAmountOrder;
        System.out.println("║-------------------------------------------------------║");
        System.out.printf("║%-31sRM%.2f%16s\n", "Total Amount Gained  (RM):", totalAmount,"║");
        System.out.println("║-------------------------------------------------------║");
        System.out.printf("║%-31sRM%.2f%17s\n", "Total Amount Ordered (RM):", totalAmountOrder,"║");
        System.out.println("║-------------------------------------------------------║");
        System.out.printf("║%25s%5s%25s\n", "Status:", status,"║");
        System.out.printf("║%25sRM%2.2f%22s\n", "Total "+ status+": ", totalProfit,"║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.print("Press any key to continue...");
        sc.nextLine();
    }

}

import java.io.FileNotFoundException;
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
        Scanner sc = new Scanner(System.in);
        System.out.println(
            "╔═══════════════════════════════════════════════════════╗");
        System.out.println(
            "║           REPORT KEDAI BUKU KAMAL                     ║");
        System.out.println(
            "╠═══════════════════════════════════════════════════════╣");
        System.out.println(
            "║          TOP 10 BOOKS SOLD                            ║");
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
        Vector<String> sortId = new Vector<String>();
        Vector<Integer> sortQuantity = new Vector<Integer>();
        Vector<String> sortBook = new Vector<String>();
        OrderManagement orders = new OrderManagement();
        orderList = orders.getOrderFromFile(roleID);
        
        String status = "";
        int j= 0;
        for (OrderManagement order : orderList) {
            Book book = order.getBookInfo();
            String title = book.getTitle().replaceAll("_", " ");
            int quantity = order.getQuantityOrder();
            String id = book.getBookID();
            
            int index = bookTitles.indexOf(title);
            int min = 0;
            if(order.getOrderStatus().equals("Approved")){
                totalAmountOrder += order.getTotalAmount();
                // System.out.println("Order id"+order.getOrderID()+"Total Ammount" + order.getTotalAmount());
            }else if(order.getOrderStatus().equals("Completed")){
                totalAmount += order.getTotalAmount();
            }
            if (index == -1) { //adding books in order to avoid duplicate book title to be shown in invoice.
                bookId.add(id);
                bookTitles.add(title);
                bookQuantities.add(quantity);
            } else {
                bookQuantities.set(index, bookQuantities.get(index) + quantity);
            }
        }
        // int min = 0;
        //  for (int i = 0; i < bookTitles.size(); i++) {
        //     if(bookQuantities.get(i) > min){
        //         min = bookQuantities.get(i);
        //         sortBook.add(min);
        //     }
        // }

            // Collections.sort(bookQuantities,Collections.reverseOrder());
        double min =0;
        for (int i = 0; i < bookTitles.size(); i++) {
            if (bookQuantities.get(i) > min) {
                min = bookQuantities.get(i);
                sortId.add(bookId.get(i));
                sortQuantity.add(bookQuantities.get(i));
                sortBook.add(bookTitles.get(i));
            } else {
                sortId.insertElementAt(bookId.get(i),i-1);
                sortQuantity.insertElementAt(bookQuantities.get(i),i-1);
                sortBook.insertElementAt(bookTitles.get(i),i-1);
            }
        }
        // String temp1 = "";
        int temp2 = bookQuantities.get(bookQuantities.size()-1); //2nd last element
        sortQuantity.remove(bookQuantities.size()-2);
        sortQuantity.add(0,temp2);

        String temp3 = bookTitles.get(bookTitles.size()-1); //2nd last element
        sortBook.remove(bookTitles.size()-2);
        sortBook.add(0,temp3);

        String temp4 = bookId.get(bookId.size()-1); //2nd last element
        sortId.remove(bookId.size()-2);
        sortId.add(0,temp4);

        // System.out.println("Bookquantity"+sortQuantity);
        for (int i = bookTitles.size() - 1; i >= 0; i--) {
            String id = sortId.get(i);
            String t = sortBook.get(i);
            int quantity = sortQuantity.get(i);
            Book book =  new Book();
            Vector<Book> books = new Vector<Book>();
            Book bk = new Book();
            
            books = bk.getBooksfromFile();
        
            for (Book b : books) { //double checking with title
                if (b.getTitle().replaceAll("_", " ").toUpperCase().equals(t.replaceAll("_", " ").toUpperCase())) {
                    book = b;
                    break;
                }
            }
            if (book != null) {
                System.out.printf("║%-8s | %-31s | %-10d║\n", id, t,quantity);
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
        System.out.printf("║%-31sRM%.2f%15s\n", "Total Amount Ordered (RM):", totalAmountOrder,"║");
        System.out.println("║-------------------------------------------------------║");
        System.out.printf("║%25s%5s%26s\n", "Status:", status,"║");
        System.out.printf("║%25sRM%2.2f%20s\n", "Total "+ status+": ", totalProfit,"║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        sc.nextLine();
    }
}

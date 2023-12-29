import java.util.*;

public class OrderManagement {
    private String orderID;
    private Vector<Book> bookInfo;
    private String orderStatus;
    private double totalAmount;
    private User user;
    private String orderDate;
    private Report report;

    public OrderManagement(String orderID, Vector<Book> bookInfo, String orderStatus, User user, double totalAmount, String orderDate, Report report){
        this.orderID = orderID;
        this.bookInfo = bookInfo;
        this.orderStatus = orderStatus;
        this.user = user;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.report = report;
    }

    public String getOrderID(){
        return orderID;
    }

    public String getOrderStatus(){
        return orderStatus;
    }   

    public double getTotalAmount(){
        return totalAmount;
    }

    public String getOrderDate(){
        return orderDate;
    }

    public void setOrderID(String orderID){
        this.orderID = orderID;
    }
    //typo
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }

    //typo
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public void generateInvoice(){

    }

    public void calculateTotalAmount(){

    }

    public User getUser(){
        return user;
    }

    public Vector<Book> getBookInfo(){
        return bookInfo;
        
    }

    public static void getAllCustomerOrder(){
        
    }
}
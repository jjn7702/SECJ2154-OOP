package Library;

public class Order {
    private Book book;
    private User user;
    private double price;
    private int quantity;

    public Order(Book book, User user, double price, int quantity) {
        this.book = book;
        this.user = user;
        this.price = price;
        this.quantity = quantity;
    }

    public Order(){
        
    }

    public Book getBook() {
        return this.book;
    }

    public User getUser() {
        return this.user;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return "Book name : " + book.getTitle() + "\n" + "User name : " + user.getName() + "\n" + "Price : " + String.valueOf(price) + "\n" + "Quantity : " + String.valueOf(quantity) + "\n";
    }

    public String toString2(){
        return book.getTitle() + "<N/>" + user.getName() + "<N/>" + String.valueOf(price) + "<N/>" + String.valueOf(quantity);
    }

}
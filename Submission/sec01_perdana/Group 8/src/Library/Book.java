package Library;
public class Book {
    
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String status;
    private int qty;
    private double price;
    private int brwCoppies;


    public Book(){
    };

    public Book(String title, String author, String publisher, String isbn, String status, int qty, double price, int brwCoppies) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.status = status;
        this.qty = qty;
        this.price = price;
        this.brwCoppies = brwCoppies;
    }

    public String toString(){
        String text = "Book Name : " + this.title + "\n" +
                      "Author : " + this.author + "\n" +
                      "Publisher : " + this.publisher + "\n" +
                      "ISBN : " + this.isbn + "\n" +
                      "Quantity : " + String.valueOf(qty) + "\n" +
                      "Price : " + String.valueOf(price) + "\n" +
                      "Borrowed Copies : " + String.valueOf(brwCoppies)+ "\n";

        return text;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return this.publisher;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getIsbn(){
        return this.isbn;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    public int getQty(){
        return this.qty;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setBrwCoppies(int brwCoppies){
        this.brwCoppies = brwCoppies;
    }

    public int getBrwCoppies(){
        return this.brwCoppies;
    }

    public String toString2(){
        String text = title + "<N/>" + author + "<N/>" + publisher + "<N/>" + isbn + "<N/>" + String.valueOf(qty) + "<N/>" + String.valueOf(price) + "<N/>" + String.valueOf(brwCoppies);

        return text;
    }

   


}

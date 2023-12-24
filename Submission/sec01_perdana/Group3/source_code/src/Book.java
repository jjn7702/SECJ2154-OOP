public class Book {
    private String bookID;
    private String title;
    private String mainAuthor;
    private int genre;
    private int quantityInStock;


    public Book(String id, String titleBook, String author, int genreCat, int stock){
        bookID = id;
        title = titleBook;
        mainAuthor = author;
        genre = genreCat;
        quantityInStock = stock;
    }


    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMainAuthor() {
        return mainAuthor;
    }
    public void setMainAuthor(String mainAuthor) {
        this.mainAuthor = mainAuthor;
    }
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayBook(int role){
        String genreStr ="";
        switch (genre) {
            case 1:
                genreStr = "Romance";
                break;
            case 2:
                genreStr = "Mystery";
                break;
            case 3:
                genreStr = "Fantasy";
                break;
            case 4:
                genreStr = "Comedy";
                break;
            case 5:
                genreStr = "Thriller";
                break;
            default:
                break;
        }
        String title = getTitle().replaceAll("_", " ");
        String author = getMainAuthor().replaceAll("_", " ");
        if(role ==1){
            System.out.printf("║%-8s║%-30s║%-30s║%-22s║%-24d║%n", getBookID(), title, author, genreStr, getQuantityInStock());
        }else{
            System.out.printf("║%-8s║%-30s║%-30s║%-22s║%n", getBookID(), title, author, genreStr);

        }
    }
}

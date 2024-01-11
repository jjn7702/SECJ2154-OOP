public class Book {
    private String title;
    private String genre;
    private String ISBN;
    private Fiction fiction;
    private NonFiction nonFiction;
    private Catalog catalog;

    // Constructors, getters, and setters

    public Book(String title, String genre, String ISBN, Fiction fiction, NonFiction nonFiction, Catalog catalog){
        this.title = title;
        this.genre = genre;
        this.ISBN = ISBN;
        this.fiction = fiction;
        this.nonFiction = nonFiction;
        this.catalog = catalog;
    }

    public Catalog geCatalog(){
        return catalog;
    }

    public class Fiction extends Book {
        public Fiction(String title, String genre, String ISBN, Catalog catalog) {
            super(title, genre, ISBN, fiction, nonFiction, catalog);
        }
    }

    public class NonFiction extends Book /*implements Discount*/ {
        //private double discountRate;
    
        public NonFiction(String title, String genre, String ISBN, Catalog catalog, double discountRate) {
            super(title, genre, ISBN, fiction, nonFiction, catalog);
            //this.discountRate = discountRate;
        }
    
       
        /*public double getDiscount() {
            return discountRate;
        }*/

    }

}


interface User{
public String getMatricID();

}

class Book{ // stores or get book data 
protected String genre;
protected String ref;
protected double pages;
protected String publisher;
protected String author;
protected String title;

    public Book(String genre, String ref, double pages, String publisher , String author, String title){
        this.genre = genre;
        this.ref = ref;
        this.pages = pages;
        this.publisher = publisher;
        this.author = author;
        this.title = title;
    }
}

class admin extends Book{ // add or remove book

    public admin(String genre, String ref, double pages, String publisher , String author, String title){
        super(genre, ref, pages, publisher, author, title);
        
    }
}


class faculty extends Book{ // contains specific books

    public faculty(String genre, String ref, double pages, String publisher , String author, String title){
        super(genre, ref, pages, publisher, author, title);
        
    }
}


class UG implements User{ 

private String MatricID;

public UG(String MatricID){
    this.MatricID = MatricID;
}

    public String getMatricID(){
        return MatricID;
    }
}


class PG implements User{

private String MatricID;

public PG(String MatricID){
    this.MatricID = MatricID;
}
    public String getMatricID(){
        return MatricID;
    }
}


class others {

}




public class BookRecommend{
    public static void main(String[] args) {
    }
}
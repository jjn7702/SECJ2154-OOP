//FARAH SYAHIRAH BINTI NOOR JA'AFAR (A23CS3008)

package farah;

import java.util.Vector;

public class Director {
    private String name;
    private int year;
    private Vector<Movie> movies = new Vector<Movie>();

    public Director(String name, int year){
        this.name = name;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public int getYear(){
        return year;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public Vector <Movie> getMovie(){
        return movies;
    }

    public String displayInfo(){
        return getName() + " (" + getYear() + ") " ;
    }
}

//FARAH SYAHIRAH BINTI NOOR JA'AFAR (A23CS3008)
import java.util.Vector;

public class MovieType {
    private String type;
    private Vector<Movie> movies = new Vector<Movie>();

    public MovieType(String type){
        this.type = type;
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public Vector<Movie> getMovies(){
        return movies;
    }

    public String getType(){
        return type;
    }
}

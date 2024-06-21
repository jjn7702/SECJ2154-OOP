
/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
import java.util.Vector;

public class User {
    private String id, name;
    private Vector<Rating> ratings = new Vector<Rating>();
    private Vector<Movie> watched = new Vector<Movie>();

    protected User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addRating(String type,Movie movie, int rating, String comment) {
        if(type=="RegularRating"){
            ratings.add(new RegularRating(this,movie,rating,comment));
        }else{
            ratings.add(new AnonymousRating(movie,rating,comment));
        }
        
        String id = "R"+(Math.random()*100)+(ratings.size()-1);
        ratings.lastElement().setId(id);
    }

    public void editRating(Rating rating,int rate,String comment){
        rating.setRating(rate);
        rating.setComment(comment);
    }

    public Vector<Rating> getRating() {
        return ratings;
    }

    public void deleteRating(int ratingIndex){
        ratings.remove(ratingIndex);
    }

    public void watched(Movie movie) {
        watched.add(movie);
        movie.watchedBy(this);
    }

    public Vector<Movie> getWatchedMovie() {
        return watched;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return "";
    };

    public void displayInfo() {

    };

    public int getNumOfRec(){
        return 0;
    }
}

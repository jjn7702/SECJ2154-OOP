//FARAH SYAHIRAH BINTI NOOR JA'AFAR (A23CS3008)

package farah;

import java.util.Vector;

import project.Rating;

public class Movie {
    private String id, title;
    private Director director;
    private Vector <Rating> ratings = new Vector<Rating>();
    private Vector <MovieType> movieTypes = new Vector<MovieType>();
    private Vector <User> watchedBy = new Vector<User>();

    public Movie (String id, String title, Director director, Vector<MovieType> movieTypes){
        this.id = id;
        this.title = title;
        this.director = director;
        this.movieTypes = movieTypes;
    }

    public String getTitle(){
        return title;
    }

    public void addRating(Rating rating){
        ratings.add(rating); 
    }

    public Vector <Rating> getRatings(){
        return ratings;
    }

    public Director getDirector(){
        return director;
    }

    public Vector <MovieType> getMovieTypes(){
        return movieTypes;
    }

    public void watchedBy(User user){
        watchedBy.add(user);
    }

    public int numOfView(){
        return this.watchedBy.size();
    }

    //since each movie will have many ratings from viewers, we calculate the average ratings
    public double calcOverallRating(){
        double total = 0;
        for (Rating r : ratings) {
            total += r.getRating();
        }
        if (ratings.size() == 0) {
            return 0;
        } else {
            return total / ratings.size();
        }
    }

    public void displayInfo(){
        System.out.printf("%-9s: %-30s\n", "Title", this.getTitle());
        System.out.printf("%-9s: %-30s\n", "Direct By", this.getDirector().displayInfo());
        System.out.printf("%-9s: %.1f (%1d view)\n", "Ratings", calcOverallRating(), numOfView());
        System.out.print("Movie Types: ");
        for (int i = 0; i < movieTypes.size(); i++) {
            MovieType m = movieTypes.get(i);
            if (i % 3 == 0) {
                System.out.printf("\n             %-15s ", m.getType());
            } else {
                System.out.printf("%-15s ", m.getType());
            }
        }
        System.out.println("\n");
    }

}

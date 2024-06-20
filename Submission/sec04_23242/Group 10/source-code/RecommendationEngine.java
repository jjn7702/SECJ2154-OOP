
/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */

import java.util.Vector;

public class RecommendationEngine {
    private User user;

    public RecommendationEngine(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void displayMostRatedMovies() {
        // get the 3 highest rating, and their Movie Types
        int[] highestRating = new int[3];
        Vector<Movie> highestRatedMovies = new Vector<Movie>();

        for (Rating r : user.getRating()) {
            if (r.getRating() > highestRating[0]) {
                highestRating[0] = r.getRating();
                if (highestRatedMovies.isEmpty()) {
                    highestRatedMovies.add(r.getMovie());
                } else {
                    highestRatedMovies.set(0, r.getMovie());
                }
            } else if (r.getRating() > highestRating[1]) {
                highestRating[1] = r.getRating();
                if (highestRatedMovies.size() <= 1) {
                    highestRatedMovies.add(r.getMovie());
                } else {
                    highestRatedMovies.set(1, r.getMovie());
                }
            } else if (r.getRating() > highestRating[2]) {
                highestRating[2] = r.getRating();
                if (highestRatedMovies.size() <= 2) {
                    highestRatedMovies.add(r.getMovie());
                } else {
                    highestRatedMovies.set(2, r.getMovie());
                }
            }
        }

        // get the highestRatedMovies MovieTypes and find the most repeated MovieType
        Vector<MovieType> movieTypes = new Vector<MovieType>();
        Vector<Integer> numOfMovieTypes = new Vector<Integer>();
        int highestNumber = 0;
        for (Movie m : highestRatedMovies) {
            for (MovieType mt : m.getMovieTypes()) {
                if (!movieTypes.contains(mt)) {
                    movieTypes.add(mt);
                    numOfMovieTypes.add(1);
                    if (highestNumber < 1) {
                        highestNumber = 1;
                    }
                } else {
                    int index = movieTypes.indexOf(mt);
                    int totalNum = numOfMovieTypes.get(index) + 1;
                    numOfMovieTypes.set(index, totalNum);
                    if (highestNumber < totalNum) {
                        highestNumber = totalNum;
                    }
                }
            }
        }
        int mostRepeatedMovieType_Index = numOfMovieTypes.indexOf(highestNumber);
        MovieType movieType = movieTypes.get(mostRepeatedMovieType_Index);

        System.out.println("===========================================");
        System.out.println("You might interest with these movie:");
        System.out.println("-------------------------------------------");

        Vector<Movie> movies = movieType.getMovies();
        for (int i = 0; i < user.getNumOfRec(); i++) {
            movies.get(i).displayInfo();
            System.out.println("-------------------------------------------");
            if (i == movies.size())
                break;
        }
        System.out.println("Top movie types you have watched and rated: "+movieType.getType()+" with total of "+ highestNumber+ " reaction");
        System.out.println("===========================================\n");
    }

    public void displayRecByFavDirect() {
        // get User watched list, and find the most watched movie director repeated in
        // the movie list
        Vector<Director> directors = new Vector<Director>();
        Vector<Integer> numRepeated = new Vector<Integer>();
        int highestNumber = 0;
        for (Movie d : user.getWatchedMovie()) {
            if (!directors.contains(d.getDirector())) {
                directors.add(d.getDirector());
                numRepeated.add(1);
                if (highestNumber < 1) {
                    highestNumber = 1;
                }
            } else {
                int index = directors.indexOf(d.getDirector());
                int totalNum = numRepeated.get(index) + 1;
                numRepeated.set(index, totalNum);
                if (highestNumber < totalNum) {
                    highestNumber = totalNum;
                }
            }
        }
        int mostRepeatedDirector_index = numRepeated.indexOf(highestNumber);
        Director director = directors.get(mostRepeatedDirector_index);

        System.out.println("===========================================");
        System.out.println("From Favourite Director");
        System.out.println("-------------------------------------------");
        Vector<Movie> mVector = director.getMovie();
        for (int i = 0; i < user.getNumOfRec(); i++) {
            Movie m = mVector.get(i);
            m.displayInfo();
            System.out.println("-------------------------------------------");
            if (i == mVector.size())
                break;
        }
        System.out.println("You have watched "+highestNumber+" movies from "+director.getName());
        System.out.println("===========================================\n");
    }
}

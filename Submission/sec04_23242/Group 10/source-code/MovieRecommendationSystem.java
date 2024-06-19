/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
import java.util.Scanner;
import java.util.Vector;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Generate Data
        Vector<MovieType> mT = new Vector<MovieType>();
        Vector<Director> dr = new Vector<Director>();
        Vector<Movie> mv = new Vector<Movie>();

        String[] mTString = { "Action", "Adventure", "Comedy", "Drama", "Horror", "Sci-Fi", "Fantasy", "Romance",
                "Thriller", "Mystery", "Crime", "Western", "Musical", "Animation", "Documentary", "Biographical",
                "Family", "War", "Historical", "Sport" };
        String[] drString = { "Steven Spielberg", "Martin Scorsese", "Christopher Nolan", "Quentin Tarentino",
                "Kathryn Bigelow" };
        int[] drInt = { 53, 57, 26, 32, 43 };
        String[][] mvString = {
                { "Jaws", "E.T. the Extra-Terrestrial", "Jyrassuc Park", "Schundler's List", "Saving Private Ryan" },
                { "Taxi Driver", "Raging Bull", "Goodfellas", "The Departed", "The Irishman" },
                { "Momento", "The Dark Knight", "Inception", "Interstellar", "Dunkirk" },
                { "Reservoir Dogs", "Pulp Fiction", "Kill Bill:Volume 1", "Inglourious Basterds",
                        "Once Upon a Time in Hollywood" },
                { "Near Dark", "Point Break", "The Hurt Locker", "Zero Dark Thirty", "Detroit" } };
        for (String m : mTString) {
            mT.add(new MovieType(m));
        }
        for (int i = 0; i < drString.length; i++) {
            dr.add(new Director(drString[i], drInt[i]));
        }
        for (int i = 0; i < mvString.length; i++) {
            for (int j = 0; j < mvString[i].length; j++) {
                Vector<MovieType> mvt = new Vector<MovieType>();
                mvt.add(mT.get((int) (Math.random() * (20))));
                mvt.add(mT.get((int) (Math.random() * (20))));
                mvt.add(mT.get((int) (Math.random() * (20))));
                mvt.add(mT.get((int) (Math.random() * (20))));
                mvt.add(mT.get((int) (Math.random() * (20))));
                mvt.add(mT.get((int) (Math.random() * (20))));
                mv.add(new Movie("M" + i + j, mvString[i][j], dr.get(i), mvt));
            }
        }

        User u1 = new PremiumUser("U01", "Vennise", 17.50);
        u1.watched(mv.get(0));
        u1.watched(mv.get(1));
        u1.watched(mv.get(1));
        u1.watched(mv.get(2));
        u1.watched(mv.get(2));
        u1.watched(mv.get(2));
        u1.watched(mv.get(7));
        u1.watched(mv.get(8));
        u1.watched(mv.get(11));
        u1.watched(mv.get(12));
        u1.watched(mv.get(11));
        u1.watched(mv.get(13));
        u1.watched(mv.get(14));
        u1.watched(mv.get(15));
        u1.watched(mv.get(15));
        u1.watched(mv.get(20));

        //input rating with Anonymous
        System.out.println("Enter movie index :");
        int movieIndex=in.nextInt();
        System.out.println("Rate the movie from 0-5 :");
        int rate=in.nextInt();
        System.out.println("Comment :");
        String comment=in.next();
        u1.addRating("AnonymousRating", mv.get(movieIndex), rate, comment);

        u1.addRating("Regular Rating", mv.get(0), 4, "Good");
        u1.addRating("RegularRating", mv.get(1), 3, "Good");
        u1.addRating("AnonymousRating", mv.get(2), 1, "Good");
        u1.addRating("AnonymousRating", mv.get(7), 3, "Good");
        u1.addRating("AnonymousRating", mv.get(8), 2, "Good");
        u1.addRating("RegularRating", mv.get(12), 4, "Good");
        u1.addRating("RegularRating", mv.get(11), 4, "Good");
        u1.addRating("AnonymousRating", mv.get(14), 1, "Good");
        u1.addRating("AnonymousRating", mv.get(15), 3, "Good");
        u1.addRating("AnonymousRating", mv.get(15), 2, "Good");
        u1.addRating("RegularRating", mv.get(8), 4, "Good");
        u1.addRating("RegularRating", mv.get(11), 4, "Good");

        RecommendationEngine re1 = new RecommendationEngine(u1);
        u1.displayInfo();
        re1.displayRecByFavDirect();
        re1.displayMostRatedMovies();
    }
}

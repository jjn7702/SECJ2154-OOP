*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
import java.util.Scanner;
import java.util.Vector;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        //Generate Data
        Vector<MovieType> mT = new Vector<MovieType>();
        Vector<Director> dr = new Vector<Director>();
        Vector<Movie> mv = new Vector<Movie>();

        String[] mTString = { "Action", "Adventure", "Comedy", "Drama", "Horror", "Sci-Fi", "Fantasy", "Romance",
                "Thriller", "Mystery", "Crime", "Western", "Musical", "Animation", "Documentary", "Biographical",
                "Family", "War", "Historical", "Sport" };
        String[] drString = { "Steven Spielberg", "Martin Scorsese" };
        int[] drInt = { 53, 57, 26, 32, 43 };
        String[][] mvString = {
                { "Jaws", "E.T. the Extra-Terrestrial", "Jyrassuc Park", "Schundler's List", "Saving Private Ryan" },
                { "Taxi Driver", "Raging Bull", "Goodfellas", "The Departed", "The Irishman" }};
        for (String m : mTString) {
            mT.add(new MovieType(m));
        }
        for (int i = 0; i < drString.length; i++) {
            dr.add(new Director(drString[i], drInt[i]));
        }

        //Create list of Movie
        Vector<MovieType> mvt = new Vector<MovieType>();

        mvt.add(mT.get(1));
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mv.add(new Movie("M001",mvString[0][0],dr.get(0),mvt));
        
        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mvt.add(mT.get(4));
        mv.add(new Movie("M002",mvString[0][1],dr.get(0),mvt));

        mvt.clear();
        mvt.add(mT.get(1));
        mvt.add(mT.get(5));
        mv.add(new Movie("M003",mvString[0][2],dr.get(0),mvt));

        mvt.clear();
        mvt.add(mT.get(5));
        mvt.add(mT.get(2));
        mvt.add(mT.get(1));
        mv.add(new Movie("M004",mvString[0][3],dr.get(0),mvt));

        mvt.clear();
        mvt.add(mT.get(4));
        mvt.add(mT.get(11));
        mvt.add(mT.get(12));
        mvt.add(mT.get(2));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mv.add(new Movie("M005",mvString[0][4],dr.get(0),mvt));

        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(12));
        mvt.add(mT.get(1));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mvt.add(mT.get(16));
        mv.add(new Movie("M101",mvString[1][0],dr.get(1),mvt));

        mvt.clear();
        mvt.add(mT.get(4));
        mvt.add(mT.get(12));
        mvt.add(mT.get(15));
        mvt.add(mT.get(14));
        mvt.add(mT.get(18));
        mv.add(new Movie("M102",mvString[1][1],dr.get(1),mvt));

        mvt.clear();
        mvt.add(mT.get(12));
        mvt.add(mT.get(16));
        mvt.add(mT.get(13));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mvt.add(mT.get(19));
        mv.add(new Movie("M103",mvString[1][2],dr.get(1),mvt));

        mvt.clear();
        mvt.add(mT.get(11));
        mvt.add(mT.get(14));
        mvt.add(mT.get(13));
        mvt.add(mT.get(19));
        mvt.add(mT.get(5));
        mvt.add(mT.get(4));
        mv.add(new Movie("M104",mvString[1][3],dr.get(1),mvt));

        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mvt.add(mT.get(1));
        mvt.add(mT.get(5));
        mvt.add(mT.get(19));
        mvt.add(mT.get(16));
        mv.add(new Movie("M105",mvString[1][4],dr.get(1),mvt));

        User u1 = new PremiumUser("U01", "Vennise", 17.50);
        u1.watched(mv.get(0));
        u1.watched(mv.get(1));
        u1.watched(mv.get(1));

        u1.addRating("Regular Rating", mv.get(0), 4, "Good");
        u1.addRating("RegularRating", mv.get(1), 3, "Good");
        u1.addRating("RegularRating", mv.get(1), 4, "Good");

        RecommendationEngine re1 = new RecommendationEngine(u1);
        u1.displayInfo();
        re1.displayRecByFavDirect();
        re1.displayMostRatedMovies();
    }

    public void addRating(User user,Vector<Movie> movie){
        Scanner in = new Scanner(System.in);
        //input rating with Anonymous
        System.out.print("Enter movie index :");
        int movieIndex=in.nextInt();
        System.out.print("Rate the movie from 0-5 :");
        int rate=in.nextInt();
        System.out.print("Comment :");
        String comment=in.next();

        user.addRating("AnonymousRating", movie.get(movieIndex), rate, comment);
        in.close();
    }
}

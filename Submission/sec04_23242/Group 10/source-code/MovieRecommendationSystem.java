/*
 * Name: Vennise Ngoh Yan Leng
 * Matric ID: B23CS8032
 */
import java.util.Scanner;
import java.util.Vector;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        // ----------------- GENERATE DATA -----------------------
        Vector<MovieType> mT = new Vector<MovieType>();
        Vector<Director> dr = new Vector<Director>();
        Vector<Movie> mv = new Vector<Movie>();

        String[] mTString = { "Action", "Adventure", "Comedy", "Drama", "Horror", "Sci-Fi", "Fantasy", "Romance",
                "Thriller", "Mystery", "Crime", "Western", "Musical", "Animation", "Documentary", "Biographical",
                "Family", "War", "Historical", "Sport" };
        String[] drString = { "Steven Spielberg", "Martin Scorsese" };
        int[] drInt = { 53, 57 };
        String[][] mvString = {
                { "Jaws", "E.T. the Extra-Terrestrial", "Jyrassuc Park", "Schundler's List", "Saving Private Ryan" },
                { "Taxi Driver", "Raging Bull", "Goodfellas", "The Departed", "The Irishman" } };
        for (String m : mTString) {
            mT.add(new MovieType(m));
        }
        for (int i = 0; i < drString.length; i++) {
            dr.add(new Director(drString[i], drInt[i]));
        }

        Vector<MovieType> mvt = new Vector<MovieType>();

        mvt.add(mT.get(1));
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mv.add(new Movie("M001", mvString[0][0], dr.get(0), mvt));

        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mvt.add(mT.get(4));
        mv.add(new Movie("M002", mvString[0][1], dr.get(0), mvt));

        mvt.clear();
        mvt.add(mT.get(1));
        mvt.add(mT.get(5));
        mv.add(new Movie("M003", mvString[0][2], dr.get(0), mvt));

        mvt.clear();
        mvt.add(mT.get(5));
        mvt.add(mT.get(2));
        mvt.add(mT.get(1));
        mv.add(new Movie("M004", mvString[0][3], dr.get(0), mvt));

        mvt.clear();
        mvt.add(mT.get(4));
        mvt.add(mT.get(11));
        mvt.add(mT.get(12));
        mvt.add(mT.get(2));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mv.add(new Movie("M005", mvString[0][4], dr.get(0), mvt));

        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(12));
        mvt.add(mT.get(1));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mvt.add(mT.get(16));
        mv.add(new Movie("M101", mvString[1][0], dr.get(1), mvt));

        mvt.clear();
        mvt.add(mT.get(4));
        mvt.add(mT.get(12));
        mvt.add(mT.get(15));
        mvt.add(mT.get(14));
        mvt.add(mT.get(18));
        mv.add(new Movie("M102", mvString[1][1], dr.get(1), mvt));

        mvt.clear();
        mvt.add(mT.get(12));
        mvt.add(mT.get(16));
        mvt.add(mT.get(13));
        mvt.add(mT.get(14));
        mvt.add(mT.get(15));
        mvt.add(mT.get(19));
        mv.add(new Movie("M103", mvString[1][2], dr.get(1), mvt));

        mvt.clear();
        mvt.add(mT.get(11));
        mvt.add(mT.get(14));
        mvt.add(mT.get(13));
        mvt.add(mT.get(19));
        mvt.add(mT.get(5));
        mvt.add(mT.get(4));
        mv.add(new Movie("M104", mvString[1][3], dr.get(1), mvt));

        mvt.clear();
        mvt.add(mT.get(2));
        mvt.add(mT.get(3));
        mvt.add(mT.get(1));
        mvt.add(mT.get(5));
        mvt.add(mT.get(19));
        mvt.add(mT.get(16));
        mv.add(new Movie("M105", mvString[1][4], dr.get(1), mvt));

        User u1 = new PremiumUser("U01", "Vennise", 17.50);
        u1.watched(mv.get(0));
        u1.watched(mv.get(1));
        u1.watched(mv.get(1));

        u1.addRating("Regular Rating", mv.get(0), 4, "First time comment");
        u1.addRating("RegularRating", mv.get(1), 3, "Good can be better");
        u1.addRating("RegularRating", mv.get(1), 4, "Good");

        User u2 = new RegularUser("U02", "Farah");
        u2.watched(mv.get(6));
        u2.watched(mv.get(8));
        u2.watched(mv.get(9));

        u2.addRating("Regular Rating", mv.get(6), 2, "Ok");
        u2.addRating("Regular Rating", mv.get(8), 3, "Moderate only");
        u2.addRating("Regular Rating", mv.get(9), 4, "Very goood");

        Input input = new Input();
        Scanner in = new Scanner(System.in);

        // ----------------- OUTPUT START -----------------------
        System.out.println("\nWELCOME FOR USING OUR MOVIE RECOMMANDATION SYSTEM");
        String systemLoop = "Y";
        while (systemLoop == "Y") {
            // Select User
            User user = new User("", "");
            System.out.println("");
            System.out.println("Here is the user info:");
            u1.displayInfo();
            u2.displayInfo();
            System.out.print("Which user you wanted to test?(1 or 2):");
            int userInt = in.nextInt();
            while (userInt != 1 && userInt != 2) {
                System.out.println("Invalid input.");
                System.out.print("Which user you wanted to test?(1 or 2):");
                userInt = in.nextInt();
            }
            if (userInt == 1) {
                user = u1;
            } else {
                user = u2;
            }

            int c = 1;
            while (c > 1 || c < 3) {
                // Choose action
                System.out.println("");
                System.out.println("Enter 1 to rate movie");
                System.out.println("Enter 2 to add watced movie");
                System.out.println("Enter 3 to show most rated movies");
                System.out.println("Enter 4 to exit");
                System.out.print("Choose your action for user " + user.getName() + ": ");
                c = in.nextInt();
                while (c < 1 || c > 4) {
                    System.out.println("Invalid input");
                    System.out.print("Choose your action for user " + user.getName() + ": ");
                    c = in.nextInt();
                }
                // Make Action
                switch (c) {
                    case 1:
                        input.addRating(user, mv);
                        break;
                    case 2:
                        input.addWatched(user, mv);
                        break;
                    case 3:
                        user.displayInfo();
                        RecommendationEngine re = new RecommendationEngine(user);
                        re.displayMostRatedMovies();
                        re.displayRecByFavDirect();
                        break;
                    default:
                        System.out.println("Exit update mode.");
                        break;
                }
            }
            systemLoop = input.loopSystem();
        }
        System.out.println("\nThankyou for using Movie Recommandation System");
        in.close();
    }

}

class Input {

    public String loopSystem() {
        Scanner in = new Scanner(System.in);
        System.out.print("Continue using this system? (Y/N):");
        String select = in.next().toUpperCase();

        while (!(select.equals("Y") || select.equals("N"))) {
            System.out.println("Invalid input.");
            System.out.print("Continue using this system? (Y/N):");
            select = in.next().toUpperCase();
        }
        in.close();
        return select;
    }

    public void addRating(User user, Vector<Movie> movie) {
        Scanner in = new Scanner(System.in);
        // input rating with Anonymous
        System.out.print("Enter movie index :");
        int movieIndex = in.nextInt();
        System.out.print("Rate the movie from 0-4 :");
        int rate = in.nextInt();
        System.out.print("Comment :");
        String comment = in.nextLine();
        System.out.print("Do you want to hide your name?(Y/N):");
        String select = in.next().toUpperCase();

        while (!(select.equals("Y") || select.equals("N"))) {
            System.out.println("Invalid input");
            System.out.print("Do you want to hide your name?(Y/N):");
            select = in.next().toUpperCase();
        }
        if (select.equals("Y")) {
            user.addRating("AnonymousRating", movie.get(movieIndex), rate, comment);
            System.out.println("Vennise has added a rating:");
            user.getRating().lastElement().displayInfo();
        } else {
            user.addRating("RegularRating", movie.get(movieIndex), rate, comment);
            System.out.println("Vennise has added a rating:");
            user.getRating().lastElement().displayInfo();
        }

        in.close();
    }

    public void addWatched(User user, Vector<Movie> movie) {
        Scanner in = new Scanner(System.in);
        System.out.println(user.getName() + " has watched a movie.");
        this.listMovie(movie);
        System.out.print("Enter new watched movie index (example:1):");
        int movieIndex = in.nextInt();
        System.out.print("Do you want to rate the movie? (Y/N):");
        String select = in.next().toUpperCase();

        while (!(select.equals("Y") || select.equals("N"))) {
            System.out.println("Invalid input");
            System.out.print("Do you want to rate the movie? (Y/N):");
            select = in.next().toUpperCase();
        }

        user.watched(movie.get(movieIndex));
        if (select.equals("Y")) {
            this.addRating(user, movie, movieIndex);
        }

        in.close();
    }

    public void listMovie(Vector<Movie> movie) {
        System.out.println("List of Movie: ");
        for (int i = 0; i < movie.size(); i++) {
            System.out.println(i + ". " + movie.get(i).getTitle());
        }
        System.out.println("");
    }

    public void addRating(User user, Vector<Movie> movie, int index) {
        Scanner in = new Scanner(System.in);
        System.out.println("Rating for movie index: " + index);
        System.out.print("Rate the movie from 0-4 :");
        int rate = in.nextInt();
        System.out.print("Comment :");
        String comment = in.nextLine();
        System.out.print("Do you want to hide your name?(Y/N):");
        String select = in.next().toUpperCase();

        while (!(select.equals("Y") || select.equals("N"))) {
            System.out.println("Invalid input");
            System.out.print("Do you want to hide your name?(Y/N):");
            select = in.next().toUpperCase();
        }
        if (select.equals("Y")) {
            user.addRating("AnonymousRating", movie.get(index), rate, comment);
            System.out.println("Vennise has added a rating:");
            user.getRating().lastElement().displayInfo();
        } else {
            user.addRating("RegularRating", movie.get(index), rate, comment);
            System.out.println("Vennise has added a rating:");
            user.getRating().lastElement().displayInfo();
        }

        in.close();
    }
}

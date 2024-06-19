
public class AnonymousRating extends Rating implements AnonymousUser{
    
    public AnonymousRating(Movie movie, int rating, String comment){
        super(ANONYMOUS_USER,movie,rating,comment);
    }

    public User getUser(){
        return ANONYMOUS_USER;
    }
}



public class RegularRating extends Rating {
    
    public RegularRating(User user,Movie movie, int rating, String comment){
        super(user,movie,rating,comment);
    }

    public User getUser(){
        return super.getUser();
    }
}

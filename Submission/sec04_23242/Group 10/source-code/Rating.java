//Matrix:A23CS5045
//Name:TEE JUN WEI

public class Rating {
    private String id;
    private Movie movie;
    private User user;
    private int rating;
    private String comment;

    protected Rating(User user, Movie movie, int rating, String comment){
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.comment = comment;
        this.movie.addRating(this);
    }

    public Movie getMovie(){
        return movie;
    }

    public User getUser(){
        return user;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setRating(int rating){
        if(rating <= 0){
            this.rating = 1;
        }else if (rating >= 4){
            this.rating = 4;
        }else{
            this.rating = rating;
        }
    }

    public int getRating(){
        return rating;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getComment(){
        return comment;
    }

    public void displayInfo(){
        System.out.printf("%s rated %s: %d\n",this.getUser().getName(),this.getMovie().getTitle(),this.getRating());
        System.out.println(this.getComment());
    }
}

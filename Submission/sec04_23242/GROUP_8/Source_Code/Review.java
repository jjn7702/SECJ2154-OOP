public class Review {
    private String reviewID;
    private String comments;
    private int rating; // Rating out of 5

    public Review(String reviewID, String comments, int rating) {
        this.reviewID = reviewID;
        this.comments = comments;
        this.rating = rating;
    }

    public String getReviewID() {
        return reviewID;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    public void setReviewID(String rID) {
        reviewID = rID;
    }

    public void setComment(String c) {
        comments = c;
    }

    public void setRating(int r) {
        rating = r;
    }
}

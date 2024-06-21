public class Review {
    private String reviewID;
    private String comments;
    private int rating; // Rating out of 5

    public Review(String reviewID, String comments, int rating, Report report) {
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

    public void setComment(String comments) {
        this.comments = comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

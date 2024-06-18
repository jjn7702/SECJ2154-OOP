class Review {
    private String reviewerName;
    private String feedback;

    public Review(String reviewerName, String feedback) {
        this.reviewerName = reviewerName;
        this.feedback = feedback;
    }

    public String getReviewName() {
        return reviewerName;
    }

    public String getFeedback() {
        return feedback;
    }

    public String toString() {
        return "Reviewer Name : " + reviewerName + "\n    Feedback : " + feedback;
    }
    

}
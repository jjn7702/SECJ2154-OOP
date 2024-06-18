class Review {
    private String reviewerName;
    private String feedback;
    private Report report;

    public Review(String reviewerName, String feedback, Report report) {
        this.reviewerName = reviewerName;
        this.feedback = feedback;
        this.report = report;
    }

    public String getReviewName() {
        return reviewerName;
    }

    public String getFeedback() {
        return feedback;
    }

    public Report getReport() {
        return report;
    }
}
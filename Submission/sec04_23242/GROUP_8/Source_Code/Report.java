public class Report {
    private String reportID;
    private String title;
    private String content;
    private String submissionDate;
    private Review review;

    public Report(String reportID, String title, String content, String submissionDate) {
        this.reportID = reportID;
        this.title = title;
        this.content = content;
        this.submissionDate = submissionDate;
    }

    public String getReportID() {
        return reportID;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setReportID(String rID) {
        reportID = rID;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setContent(String c) {
        content = c;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review r) {
        review = r;
    }
}

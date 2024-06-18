import java.util.ArrayList;
import java.util.List;

class Report {
    private String reportID;
    private String content;
    private Project project;
    private List<Review> reviews;

    

    public Report(String reportID, String content, Project project) {
        this.reportID = reportID;
        this.content = content;
        this.project = project;
        this.reviews = new ArrayList<>();

    }

    public String getReportID() {
        return reportID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public Project getProject() {
        return project;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String toString() {
        return "Report ID: " + reportID + "\nContent: " + content + "\nReviews: " + reviews.size();
    }
}
class Report {
    private String reportID;
    private String content;
    private Project project;
    

    public Report(String reportID, String content, Project project) {
        this.reportID = reportID;
        this.content = content;
        this.project = project;
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
}
class TrainingSession {
    private String date;
    private int hour, min;
    private double duration;
    private String desc;
    private String venue;
    // private Coach coach;


    public TrainingSession(String date, int hour, int min, double duration, String desc, String venue) {
        this.date = date;
        this.hour = hour;
        this.min = min;
        this.duration = duration;
        this.desc = desc;
        this.venue = venue;
        // coach = c; 
    }

    public String displayDetails() {
        String details = "Date :" + date + "\nTime : " + hour + ":" + min + "\nDuration : " + duration + " minutes\n"
                + "Training Description: " + desc
                + "\nVenue: " + venue ;
        return details;
    }
}

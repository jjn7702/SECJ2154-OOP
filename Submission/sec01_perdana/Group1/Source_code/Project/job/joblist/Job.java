class Job {
    private String title, description;
    private double pay;
    Company company;

    public Job(String title, double pay){
        this.title = title;
        this.pay = pay;
    }

    String getTitle(){return title;}
    double getPay(){return pay;}
    String getDescription(){return description;}

}

abstract class Scholarship {
    public String scholarsID ;
    protected int id = 0000 ;
    public String type ;
    private double cgp ;

    public Scholarship(String type, double c){
        this.type = type ;
        cgp = c ;
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;

    public void setID(String id){
        scholarsID = id ;
    }
    public double getCgp(){
        return cgp ;
    }
}


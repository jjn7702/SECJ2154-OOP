abstract class Scholarship implements ScholarshipRequirement{
    public String type ;
    private double cgp ;

    public Scholarship(){
        
    }

    public Scholarship(String type, double c){
        this.type = type ;
        cgp = c ;
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;

    public double getCgp(){
        return cgp ;
    }
}


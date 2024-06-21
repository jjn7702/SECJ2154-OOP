abstract class Scholarship implements ScholarshipRequirement{
    public String type ;
    private double cgp ;
    private double allowance ;
    private double threshold ;
    public Scholarship(){
        
    }

    public Scholarship(String type, double c, double all, double th){
        this.type = type ;
        allowance = all ;
        cgp = c ;
        threshold = th;
    }

    public double getAllowance(){
        return allowance ;
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;

    public String getType(){
        return type ;
    }

    public double getCgp(){
        return cgp ;
    }
    
    public double getThres(){
        return threshold ;
    }
}


class needBased extends Scholarship{
    private double allowance ;
    private double threshold ;

    public needBased(double all, String st, double cg, double th){
        super(st, cg) ;
        allowance = all ;
        threshold = th;
    }

    public boolean isEligible(Student st){
        if (st.getThreshold() >= ScholarshipRequirement.threshold){
            return true ;
        }
        else
            return false ;
    }

    public double getAllowance(){
        return allowance ;
    }
    
    public double getThres(){
        return threshold ;
    }

    public void display(){
        System.out.println("Scholarship Details:");
        System.out.println("Type: " + type);
        System.out.println("CGPA: " + getCgp());
        System.out.println("Family Threshold: " + threshold);
        System.out.println("Allowance: " + allowance);
    }
}
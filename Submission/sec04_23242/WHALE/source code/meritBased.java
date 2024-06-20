class meritBased extends Scholarship{
    private double allowance ;

    public meritBased(double all, String st, double cg){
        super(st, cg) ;
        allowance = all ;
    }

    public boolean isEligible(Student st){
        if (st.getCgpa() >= ScholarshipRequirement.minCGPA){
            id++ ;
            scholarsID = String.valueOf(id) ;
            return true ;
        }
        else
            return false ;
    }

    public double getAllowance(){
        return allowance ;
    }

    public void display(){
        
    }
}
class meritBased extends Scholarship{
    private double allowance ;

    public meritBased(String sid, double all){
        super(sid) ;
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
class needBased extends Scholarship{
    private double allowance ;

    public needBased(String sid, double all){
        super(sid) ;
        allowance = all ;
    }

    public boolean isEligible(Student st){
        if (st.getCgpa() >= ScholarshipRequirement.threshold)
            return true ;
        else
            return false ;
    }

    public double getAllowance(){
        return allowance ;
    }

    public void display(){
        
    }
}
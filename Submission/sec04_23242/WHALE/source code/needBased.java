class needBased extends Scholarship{
    private double allowance ;

    public needBased(String sid, double all){
        super(sid) ;
        allowance = all ;
    }

    public boolean isEligible(Student st){
        if (st.getThreshold() >= ScholarshipRequirement.threshold){
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
        System.out.println("Scholarship ID: " + scholarsID);
        System.out.println("Allowance: " + allowance);
    }
}
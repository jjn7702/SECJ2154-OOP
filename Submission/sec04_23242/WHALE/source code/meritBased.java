class meritBased extends Scholarship{
    private double allowance ;

    public meritBased(){
        
    }

    public meritBased(double all, String st, double cg){
        super(st, cg) ;
        allowance = all ;
    }

    public boolean isEligible(Student st){
        if (st.getCgpa() >= ScholarshipRequirement.minCGPA){
            return true ;
        }
        else
            return false ;
    }

    public double getAllowance(){
        return allowance ;
    }

    public void display() {
        System.out.println("Scholarship Details:");
        System.out.println("Type: " + type);
        System.out.println("CGPA: " + getCgp());
        System.out.println("Allowance: $" + allowance);
    }
}
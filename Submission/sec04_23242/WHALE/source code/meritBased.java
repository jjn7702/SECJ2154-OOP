class meritBased extends Scholarship{

    public meritBased(){

    }

    public meritBased(double all, String st, double cg, double th){
        super(st, cg, all, th) ;
    }

    public boolean isEligible(Student st){
        if (st.getCgpa() >= ScholarshipRequirement.minCGPA){
            return true ;
        }
        else
            return false ;
    }

    public void display() {
        System.out.println("Scholarship Details:");
        System.out.println("Type: " + type);
        System.out.println("CGPA: " + getCgp());
        System.out.println("Allowance: RM" + getAllowance());
    }

    public String toString(){
        return "Type: " + type + "\nCGPA: " + getCgp() + "\nAllowance: " + getAllowance() ;
    }
}
class needBased extends Scholarship{

    public needBased(){

    }

    public needBased(double all, String st, double cg, double th){
        super(st, cg, all, th) ;
    }

    public boolean isEligible(Student st){
        if (st.getThreshold() >= ScholarshipRequirement.threshold){
            return true ;
        }
        else
            return false ;
    }


    public void display(){
        System.out.println("Scholarship Details:");
        System.out.println("Type: " + type);
        System.out.println("CGPA: " + getCgp());
        System.out.println("Family Threshold: " + getThres());
        System.out.println("Allowance: " + getAllowance());
    }

    public String toString(){
        return "Type: " + type + "\nCGPA: " + getCgp() + "\nAllowance: " + getAllowance() + "\nFamily Threshold: " + getThres() ;
    }
}
abstract class Scholarship {
    public String scholarsID ;

    public Scholarship(){
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;
}

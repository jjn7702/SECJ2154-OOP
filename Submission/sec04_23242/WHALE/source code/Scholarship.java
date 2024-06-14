abstract class Scholarship {
    public String scholarsID ;

    public Scholarship(String sid){
        scholarsID = sid ;
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;
}

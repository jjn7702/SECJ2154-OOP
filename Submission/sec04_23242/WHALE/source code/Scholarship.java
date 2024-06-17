abstract class Scholarship {
    public String scholarsID ;
    protected int id = 0000 ;

    public Scholarship(String sid){
        scholarsID = sid ;
    }

    public abstract boolean isEligible(Student st) ;
    public abstract void display() ;
}

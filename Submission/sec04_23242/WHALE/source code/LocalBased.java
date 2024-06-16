public class LocalBased extends Scholarship {
    private double allowance;

    public LocalBased(String sId, double all) {
        super(sId);
        this.allowance = all;
    }

    public double getAllowance() {
        return allowance;
    }
    
}
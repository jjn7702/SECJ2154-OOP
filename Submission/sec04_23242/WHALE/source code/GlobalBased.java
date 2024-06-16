public class GlobalBased extends Scholarship {
    private double allowance;

    public GlobalBased(String sId, double all) {
        super(sId);
        this.allowance = all;
    }

    public double getAllowance() {
        return allowance;
    }

}
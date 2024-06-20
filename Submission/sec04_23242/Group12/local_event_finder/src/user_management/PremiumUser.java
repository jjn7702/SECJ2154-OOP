package user_management;

public class PremiumUser extends User {
    private boolean premiumFeaturesEnabled;

    public PremiumUser(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        this.premiumFeaturesEnabled = true;
    }

    public boolean hasPremiumFeatures() {
        return premiumFeaturesEnabled;
    }
}

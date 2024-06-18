public class Report {
    private Users user;
    private double exchangeRate; // change currency rate

    public Report(Users user, double exchangeRate) {
        this.user = user;
        this.exchangeRate = exchangeRate;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
        for (Account account : user.getAccounts()) {
            account.setRate(exchangeRate);
        }
    }

    public void displayAccountBalancesAndTransactions() {
        for (Account account : user.getAccounts()) {
            account.displayBudget();
            System.out.println(account.getTransactionDetails());
        }
    }

    public void displayAllInfo() {
        System.out.println("\nUser Information:");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println();

        for (Account account : user.getAccounts()) {
            System.out.println("Account Information:");
            System.out.println("ID: " + account.getId());
            System.out.println("Name: " + account.getName());
            System.out.println("Balance: " + account.getBalance() * exchangeRate);
            System.out.println();

            System.out.println("Budget Information:");
            account.displayBudget();
            System.out.println();

            System.out.println("Saving Information:");
            for (Saving saving : account.getSavings()) {
                System.out.println("ID: " + saving.getId());
                System.out.println("Name: " + saving.getName());
                System.out.println("Target Amount: " + saving.getTargetAmount());
                System.out.println("Current Amount: " + saving.getCurrentAmount());
                System.out.println("Target Date: " + saving.getTargetDate());
                System.out.println();
            }

            System.out.println("Transaction Information:");
            System.out.println(account.getTransactionDetails());
            System.out.println();
        }
    }
}

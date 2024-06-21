import java.util.Scanner;

public class Report {
    private Users user;

    public Report(Users user) {
        this.user = user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



    public void displayAccountBalancesAndTransactions() {
        Scanner e = new Scanner(System.in);
        PauseScreen s = new PauseScreen();
        for (Account account : user.getAccounts()) {
            //account.displayBudget();
            account.getTransactionDetails();
            s.pauseScreen(e);
        }
    }

    public void displayAllInfo() {
        Scanner e = new Scanner(System.in);
        PauseScreen s = new PauseScreen();
        System.out.printf("%50s\n",".________________.");
        System.out.printf("%50s\n","|User Information|");
        System.out.printf("%30s%s\n", "<",
                "===================================>");
        System.out.printf("%30s%-15s%-20s|\n","|", "User ID", "User Name");
        System.out.printf("%30s%-15s%-20s|\n","|", user.getId(), user.getName());
        System.out.printf("%30s%s\n", "<",
                "====================================>");
        
        System.out.println();

        for (Account account : user.getAccounts()) {
            System.out.printf("%53s\n",".___________________.");
            System.out.printf("%53s\n","|Account Information|");
            System.out.printf("%30s%s\n", "<",
                    "=======================================================>");

            System.out.printf("%30s%-15s%-20s%-20s|\n","|", "Account ID", "Account Name", "Account Balance");
            System.out.printf("%30s%-15d%-20s%-20.2f|\n","|", account.getId(), account.getName(), account.getBalance());
            System.out.printf("%30s%s\n\n", "<", "========================================================>");
            
            System.out.printf("%52s\n",".__________________.");
            System.out.printf("%52s\n","|Budget Information|");
            account.displayBudget();
            System.out.println();
            System.out.printf("%52s\n",".__________________.");
            System.out.printf("%52s\n","|Saving Information|");
            System.out.printf("%30s%s\n","<", "======================================================================================>");
            System.out.printf("%30s%-15s%-20s%-20s%-20s%-11s|\n", "|","Saving ID", "Saving Name", "Target Amount",
                    "Current Amount", "Target Date");
            for (Saving saving : account.getSavings()) {
                System.out.printf("%30s%-15d%-20s%-20.2f%-20.2f%-11s|\n", "|", saving.getId(), saving.getName(),
                        saving.getTargetAmount(), saving.getCurrentAmount(), saving.getTargetDate());
            }
            System.out.printf("%30s%s\n\n", "<",
                    "======================================================================================>");

            System.out.printf("%57s\n",      "._______________________.");
            System.out.printf("%33s%s\n", "|","Transaction Information|");
            account.getTransactionDetails();
            System.out.println("\n");
            s.pauseScreen(e);

        }
    }
}

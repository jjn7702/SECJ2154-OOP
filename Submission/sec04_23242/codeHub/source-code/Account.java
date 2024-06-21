import java.util.*;
import java.sql.Date;


class Account {
    private int id;
    private String name;
    private double balance;
    private Bank bank;
    private Vector<Transaction> transactions;
    private Vector<Budget> budgets;
    private Vector<Saving> savings;
    Scanner scanner = new Scanner(System.in);


    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.transactions = new Vector<>();
        this.budgets = new Vector<>();
        this.savings = new Vector<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public Vector<Transaction> getTransactions() {
        return transactions;
    }

    public Vector<Budget> getBudgets() {
        return budgets;
    }

    public Vector<Saving> getSavings() {
        return savings;
    }
    
    // association to bank class
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        balance -= amount;
    }

    public void addTransaction(int id, String name, double balance, Date date, Category category) {
        Transaction obj = new Transaction(id, name, balance, date, category);
        transactions.add(obj);
        obj.setCategory(category);    
    }

    public void addBudget(double limit, Category category) {
        budgets.add(new Budget(limit, category));
    }

    public void removeBudget(Budget budget) {
        budgets.remove(budget);
    }

    public void addSaving(Saving s) {
        savings.add(s);
    }

    public Budget getBudgetByCategory(Category category) {
        for (Budget budget : budgets) {
            if (budget.getCategory().getId() == category.getId()) {
                return budget;
            }
        }
        return null;
    }
    
    public String getTransactionDetails() {
        StringBuilder details = new StringBuilder(
                "Account ID: " + id + ", Name: " + name + ", Balance: RM" + balance + "\n");
        for (Transaction transaction : transactions) {
            details.append(transaction.getDetails()).append("\n");
        }
        return details.toString();
    }

    public void displayBudget() {
        for (Budget budget : budgets) {
            budget.display();
            System.out.println();
        }
    }

    public void displayInfo() {
        System.out.printf("%-15s%-15s%-5s\n" , "Account ID", "Name", "Balance");
        System.out.printf("%-15s%-15s%-5.2f\n", id,name,balance);
    }
    public void addBank(Bank bank){
        this.bank = bank;
    }
}


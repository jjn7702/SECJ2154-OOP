import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.sql.Date;


public class Main {
    public static void main(String[] args) throws IOException{

        Report report = new Report(null, 1.0); // rate set to be 1.0
        Vector<Category> categories = new Vector<>(); // Store category

        Scanner inp = new Scanner(new File("bank.txt"));
        //Scanner trans = new Scanner(new File("Account.txt"));

    
        Bank bank1 = null;
        Users user1 = null;

        while (inp.hasNextLine()) {
            String line = inp.nextLine();
            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String bankName = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];
                bank1 = new Bank(bankName);
                user1 = new Users(id, name);
                report.setUser(user1);
            }
        }

        /*while (trans.hasNextLine()) {
            String line = inp.nextLine();
            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String bankName = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];
                bank1 = new Bank(bankName);
                user1 = new Users(id, name);
                report.setUser(user1);
            }
        }*/
        //trans.close();





        
        inp.close();

        // Create category instance 
        categories.add(new ShoppingCategory(1));    
        categories.add(new FoodCategory(2));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addAccount(scanner, bank1, user1);
                    break;
                case 2:
                    depositMoney(scanner, user1);
                    break;
                case 3:
                    withdrawMoney(scanner, user1);
                    break;
                case 4:
                    changeCurrency(scanner, report);
                    break;
                case 5:
                    report.displayAccountBalancesAndTransactions();
                    break;
                case 6:
                    addBudget(scanner, user1, categories);
                    break;
                case 7:
                    addSaving(scanner, user1);
                    break;
                case 8:
                    addTransaction(scanner, user1, categories);
                    break;
                case 9:
                    report.displayAllInfo();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    
    }

    private static void printMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Change Currency");
        System.out.println("5. Display Account Balances and Transactions");
        System.out.println("6. Add Budget");
        System.out.println("7. Add Saving");
        System.out.println("8. Add Transaction");
        System.out.println("9. Display All Information");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addAccount(Scanner scanner, Bank bank, Users user) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        Account account = new Account(user.getAccounts().size() + 1, accountName, balance);
        account.addBank(bank);
        user.addAccount(account);
        System.out.println("Account added successfully.");
        account.displayInfo();
        
    }

    private static void depositMoney(Scanner scanner, Users user) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        try {
            Account account = findAccountById(user.getAccounts(), accountId);
            account.deposit(amount);
            System.out.println("Money deposited successfully.");
            Date d = new Date(System.currentTimeMillis());
            account.addTransaction(account.getTransactions().size() + 1, "DEPOSIT", amount, d,new Deposit(accountId) );
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void withdrawMoney(Scanner scanner, Users user) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        try {
            Account account = findAccountById(user.getAccounts(), accountId);
            account.withdraw(amount);
            System.out.println("Money withdrawn successfully.");
            Date d = new Date(System.currentTimeMillis());
            System.out.println("PRESS 1 FOR SHOPPING");
            System.out.println("PRESS 2 FOR FOOD");
            int cater = scanner.nextInt();

            scanner.nextLine();


            if(cater == 1){
                
                System.out.print("Enter Shopping name:");
                String Shop = scanner.nextLine();
                ShoppingCategory s = new ShoppingCategory(accountId);
                account.addTransaction(account.getTransactions().size() + 1, Shop, amount, d,s );
            }
            else if(cater == 2){
                System.out.print("Enter Food name:");
                String Food = scanner.nextLine();
                FoodCategory s = new FoodCategory(accountId);

                account.addTransaction(account.getTransactions().size() + 1,Food, amount, d,s );
            }
            else{
                System.out.println("NOT VALID");
            }
            System.out.println("Money withdrawn successfully.");
        } catch (AccountNotFoundException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        PauseScreen s= new PauseScreen();
        s.pauseScreen(scanner);
        s.ClearScreen();
    }

    private static void changeCurrency(Scanner scanner, Report moneyExchange) {
        System.out.print("Enter new exchange rate (1 USD to target currency): ");
        double exchangeRate = scanner.nextDouble();
        moneyExchange.setExchangeRate(exchangeRate);
        System.out.println("Exchange rate updated successfully.");
    }

    private static void addBudget(Scanner scanner, Users user, Vector<Category> categories) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter budget limit: ");
        double limit = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Choose category: ");
        for (Category category : categories) {
            System.out.println(category.getId() + ". " + category.getName());
        }
        int categoryId = scanner.nextInt();

        try {
            Account account = findAccountById(user.getAccounts(), accountId);
            Category category = findCategoryById(categories, categoryId);

            //check only one budget for a category if want to make a new one will be reset
            Budget existingBudget = account.getBudgetByCategory(category);
            if (existingBudget != null) {
                System.out.println("A budget already exists for the category " + category.getName() + ".");
                System.out.print("Do you want to delete the existing budget and set a new one? (yes/no): ");
                scanner.nextLine(); // consume newline
                String confirm = scanner.nextLine();
                if (!confirm.equalsIgnoreCase("yes")) {
                    System.out.println("Budget setting cancelled.");
                    return;
                } else {
                    account.removeBudget(existingBudget);
                }
            }

            
            account.addBudget(limit, category);
            System.out.println("Budget added successfully.");
        } catch (AccountNotFoundException | CategoryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addSaving(Scanner scanner, Users user) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter saving goal name: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();
        System.out.print("Enter target amount: ");
        double targetAmount = scanner.nextDouble();
        System.out.print("Enter current amount: ");
        double currentAmount = scanner.nextDouble();
        System.out.print("Enter target date (in milliseconds): ");
        long targetDateMillis = scanner.nextLong();
        Date targetDate = new Date(targetDateMillis);

        try {
            Account account = findAccountById(user.getAccounts(), accountId);
            Saving saving = new Saving(user.getAccounts().size() + 1, name, targetAmount,currentAmount, targetDate);
            //composition
            account.addSaving(saving);
            System.out.println("Saving goal added successfully.");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addTransaction(Scanner scanner, Users user, Vector<Category> categories) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter transaction description: ");
        String description = scanner.nextLine();
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Choose category: ");
        for (Category category : categories) {
            System.out.println(category.getId() + ". " + category.getName());
        }
        int categoryId = scanner.nextInt();

        try {
            Account account = findAccountById(user.getAccounts(), accountId);
            Category category = findCategoryById(categories, categoryId);
            Budget budget = account.getBudgetByCategory(category);

            // if the transaction amount is more than the budget need confirmation to exceed the budget
            if (budget != null && budget.getCurrentExpense() + amount > budget.getLimit()) {
                System.out.println(
                        "This transaction exceeds the budget limit for the category " + category.getName() + ".");
                System.out.print("Do you want to proceed? (yes/no): ");
                scanner.nextLine(); // consume newline
                String confirm = scanner.nextLine();
                if (!confirm.equalsIgnoreCase("yes")) {
                    System.out.println("Transaction cancelled.");
                    return;
                }
            }
            if (account.getBalance() >= amount) {

            Date d = new Date(System.currentTimeMillis());
            
            account.addTransaction(account.getTransactions().size() + 1, description, amount,d, category);
            
                account.withdraw(amount);
            }
            else {
                throw new InsufficientFundsException("Insufficient funds for this transaction.");
            }
            if (budget != null) {
                budget.setCurrentExpense(budget.getCurrentExpense() + amount);
            }
            System.out.println("Transaction added successfully.");
        } catch (AccountNotFoundException | InsufficientFundsException | CategoryNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Account findAccountById(Vector<Account> accounts, int id) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account with ID " + id + " not found.");
    }

    private static Category findCategoryById(Vector<Category> categories, int id) throws CategoryNotFoundException {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new CategoryNotFoundException("Category with ID " + id + " not found.");
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}

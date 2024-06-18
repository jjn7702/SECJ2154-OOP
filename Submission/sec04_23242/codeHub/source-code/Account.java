import java.util.Vector;

class Account {
    private int id;
    private String name;
    private double balance;
    private Vector <Transaction> TransactionList = new Vector<>();
    private Budget budget;
    private Saving saving;

    public Account(int id,String name,double balance,Budget budget,Saving saving){
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.budget = budget;
        this.saving = saving;
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
    public Vector<Transaction> getTransaction(){
        return TransactionList;
    }
    public Budget getBudjet(){
        return budget; }
    
    public Saving getSaving(){
        return saving;
    }

    
}


package banking.domain;

public abstract class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
      public double getBalance()
    {
        return this.balance;
    }
     void setBalance(double newBalance)
    {
        newBalance=this.balance;
    }
    void deposit(double amount) {
        balance += amount;
        setBalance(balance);
    }
    void withdraw(double amount) throws OverdraftException {
        balance-=amount;
    }
}

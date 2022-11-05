package banking.domain;

public abstract class Account {
    public double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws OverdraftException;

    public abstract double getBalance();

    public abstract void setBalance(double newBalance);
}

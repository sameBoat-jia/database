package banking.domain;

public abstract class Account {
    static double balance = 0;

    public Account() {
    }

    public static double getBalance()
    {
        return balance;
    }

    public abstract void setBalance(double balance);

    public Account(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws OverdraftException;
}

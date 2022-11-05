package test3;

public class SavingsAccount extends Account{
    public double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }


    @Override
    public void deposit(double amount) {
        this.balance+=amount;
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        this.balance-=amount;
        if (balance<0)
        {
            throw new OverdraftException();
        }
    }
}

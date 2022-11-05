package banking.domain;

public class SavingAccount extends Account{
    //interestRate代表利率
    public double interestRate;

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if (amount <=balance) {
            balance-=amount;
            System.out.println("你取了" +amount+
                    "元");
        }else {
            throw new OverdraftException();
        }
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(double newBalance) {
        this.balance=newBalance;
    }
}

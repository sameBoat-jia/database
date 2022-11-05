package banking.domain;

public class CheckingAccount extends Account{
    public boolean canOverdraft;
    public double maxOverdraft;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, boolean canOverdraft, double maxOverdraft) {
        super(balance);
        this.canOverdraft = canOverdraft;
        this.maxOverdraft = maxOverdraft;
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        System.out.println("存了" +amount+
                "元，余额为" + balance+
                "元");
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if(balance>=amount+maxOverdraft)
        {
            if(balance>=amount)
            {
                balance-=amount;
            } else if (canOverdraft) {
                balance-=amount-maxOverdraft;
            } else if (!canOverdraft) {
                throw new OverdraftException();
            }
        } else  {
            throw new OverdraftException();
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double newBalance) {
            balance=newBalance;
    }
}

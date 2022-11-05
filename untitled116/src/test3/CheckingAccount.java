package test3;

public class CheckingAccount extends Account {

    boolean canOverdraft;
    double maxOverdraft;

    public CheckingAccount(double balance, boolean canOverdraft, double maxOverdraft) {
        super(balance);
        this.canOverdraft = canOverdraft;
        this.maxOverdraft = maxOverdraft;
    }

    @Override
    public void deposit(double amount) {
this.balance+=balance;
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if (amount<=(this.balance+maxOverdraft))
        {
            if (amount<=this.balance)
            {
                balance-=amount;
            }else if (canOverdraft)
            {
                System.out.println("透支开始");
                maxOverdraft+=balance-amount;
                balance=0;
            }else {
                throw new OverdraftException();
            }
        }
    }
}
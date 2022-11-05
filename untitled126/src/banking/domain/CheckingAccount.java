package banking.domain;

import sun.nio.ch.SelectorImpl;

public class CheckingAccount extends Account{
    private boolean canOverdraft;
    private double maxOverdraft;

    double balance=getBalance();
    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, boolean canOverdraft, double maxOverdraft) {
        super(balance);
        this.canOverdraft = canOverdraft;
        this.maxOverdraft = maxOverdraft;
    }


/*
    if<余额+透支额
    如果余额>取款
    balance-=amount
    else if 可以透支
    balance=0；maxoverdraft=maxouvedraft+balance-amount
    else throw


 */
    @Override
    void withdraw(double amount) throws OverdraftException {
        if (amount<=getBalance()+maxOverdraft)
        {
            if (amount<=getBalance())
            {
               balance-=amount;
            }else if (canOverdraft)
            {
                balance=0;
                maxOverdraft-=balance-amount;
            }
        }else throw new OverdraftException();
    }
}

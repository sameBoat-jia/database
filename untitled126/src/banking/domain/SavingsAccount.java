package banking.domain;

public class SavingsAccount extends Account {
    private double interestRate;//利率

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;

    }

}

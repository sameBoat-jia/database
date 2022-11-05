package banking.domain;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String firstName;
   public String lastName;
 ArrayList<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts=new ArrayList<>();
    }
    public String getName()
    {
        return firstName+" "+lastName;
    }
    public void addAccount(Account account)
    {
        accounts.add(account);
    }
    public Account getAccount(int account_index)
    {
        return accounts.get(account_index);
    }
    public int getNumOfAccounts(Account account)
    {
        return accounts.indexOf(account);
    }
    public ArrayList<Account>getAccounts()
    {
        return accounts;
    }
}

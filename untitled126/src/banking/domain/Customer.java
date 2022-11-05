package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
      String firstName;
      String lastName;
      List<Account>accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<Account>();

    }
    public String getName()
    {
        return firstName+" "+lastName;
    }
    public void addAccount(Account account)
    {
        this.accounts.add(account);
    }
    public Account getAccount(int account_index)
    {
           return this.accounts.get(account_index);
    }
    public int getNumOfAccounts()
    {
        return this.accounts.size();
    }
    public List<Account> getAccounts()
    {
        return this.accounts;
    }
}

package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    ArrayList<Customer> customers;

    public Bank() {
        customers=new ArrayList<>();
    }
    public void addCustomer(String firstName,String lastName)
    {
        customers.add(new Customer(firstName,lastName));
    }
    public Customer getCustomer(int customer_index)
    {
        return customers.get(customer_index);
    }
    public int getNumOfCustomers()
    {
        return customers.size();
    }
    public ArrayList<Customer>getCustomers()
    {
        return customers;
    }
}

package banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
     List<Customer>customers;

    public Bank() {
        customers=new ArrayList<Customer>();
    }

    public Bank(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomer(String firstName,String lastName)
    {
        this.customers.add(new Customer(firstName,lastName));
    }

    public Customer getCustomer(int customer_index)
    {
        return this.customers.get(customer_index);
    }
    public int getNumOfCustomers()
    {
        return this.customers.size();
    }
    public List<Customer>getCustomers()
    {
        return this.customers;
    }
}

package banking.reports;

import banking.domain.Account;
import banking.domain.Bank;
import banking.domain.Customer;

public class CustomerReport {
    public static void generateReport(Bank bank){
        System.out.println("CUSTOMERS REPORT");
        for (Customer cu: bank.getCustomers()
             ) {
            System.out.println("=================================");
            System.out.println("储户姓名:"+cu.getName());
            for (Account ac:cu.getAccounts()
                 ) {
                System.out.println(ac.getClass().getCanonicalName().substring(15)+":当前余额是￥"+ac.getBalance());
            }
            System.out.println();
        }
    }
}

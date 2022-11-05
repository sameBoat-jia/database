package banking.domain;

public class CustomerReport extends Bank{
    public static void generateReport(Bank bank)
    {

        for (Customer customer :
                bank.getCustomers()) {
            System.out.println("name:"+customer.getName());
            for (Account acc :
                    customer.getAccounts()) {
                System.out.println("balance:"+acc.getBalance());
            }
            System.out.println();
            System.out.println();
        }
    }
}

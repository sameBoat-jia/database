package javatest.two;

public class Employee extends StaffMember{
    public String sociaISN;
    public double payRate;

    public Employee(String name, String address, String phone, String sociaISN, double payRate) {
        super(name, address, phone);
        this.sociaISN = sociaISN;
        this.payRate = payRate;
    }

    @Override
    public double pay() {
        return payRate;
    }
}

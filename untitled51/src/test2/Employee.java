package test2;

public class Employee extends StaffMember{
    //socialSN社会安全号
    String socialSN;
    //payRate基本工资
    double payRate;

    public Employee(String socialSN, double payRate) {
        this.socialSN = socialSN;
        this.payRate = payRate;
    }

    public Employee(String name, String address, String phone, String socialSN, double payRate) {
        super(name, address, phone);
        this.socialSN = socialSN;
        this.payRate = payRate;
    }

    @Override
    public double pay() {
        return payRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "socialSN='" + socialSN + '\'' +
                ", payRate=" + payRate +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

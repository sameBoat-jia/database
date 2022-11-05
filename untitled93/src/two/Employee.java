package two;

public class Employee extends StaffMember{
    String socialSN;
    double payRate;

    public Employee(String name, String address, String phone, String socialSN, double payRate) {
        super(name, address, phone);
        this.socialSN = socialSN;
        this.payRate = payRate;
    }

    @Override
    public double pay() {
        return this.payRate;
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

package test2;

public class Employee extends StaffMember {
    public String socialSN;
    public double payRate;

    public Employee(String name, String address, String phone, String socialSN, double payRate) {
        super(name, address, phone);
        this.socialSN = socialSN;
        this.payRate = payRate;
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

    @Override
    public double pay() {
        return payRate;
    }
}

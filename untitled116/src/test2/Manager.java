package test2;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, String address, String phone, String socialSN, double payRate, double bonus) {
        super(name, address, phone, socialSN, payRate);
        this.bonus = bonus;
    }

    @Override
    public double pay() {
        return bonus+payRate;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", socialSN='" + socialSN + '\'' +
                ", payRate=" + payRate +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

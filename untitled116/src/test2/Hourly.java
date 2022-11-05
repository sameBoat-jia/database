package test2;

public class Hourly extends Employee{
    public double houre;

    public Hourly(String name, String address, String phone, String socialSN, double payRate, double houre) {
        super(name, address, phone, socialSN, payRate);
        this.houre = houre;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "houre=" + houre +
                ", socialSN='" + socialSN + '\'' +
                ", payRate=" + payRate +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public double pay() {
        return houre*payRate;
    }
}

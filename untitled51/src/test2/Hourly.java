package test2;

public class Hourly extends Employee{
    int hoursWorked;

    public Hourly(String socialSN, double payRate, int hoursWorked) {
        super(socialSN, payRate);
        this.hoursWorked = hoursWorked;
    }

    public Hourly(String name, String address, String phone, String socialSN, double payRate, int hoursWorked) {
        super(name, address, phone, socialSN, payRate);
        this.hoursWorked = hoursWorked;
    }

    public void addHours(int hour){
        hoursWorked+=hour;
    }

    @Override
    public double pay() {
        return this.hoursWorked*payRate;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "hoursWorked=" + hoursWorked +
                ", socialSN='" + socialSN + '\'' +
                ", payRate=" + payRate +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

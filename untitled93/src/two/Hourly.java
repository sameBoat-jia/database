package two;

public class Hourly extends Employee{
    int hoursWorked=0;

    public Hourly(String name, String address, String phone, String socialSN, double payRate) {
        super(name, address, phone, socialSN, payRate);
    }

    @Override
    public double pay() {
        return super.pay();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void addHours(int hour)
    {
        hoursWorked+=hour;
    }
}

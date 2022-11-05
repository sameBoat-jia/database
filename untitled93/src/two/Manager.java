package two;

public class Manager extends Employee{
    double bonus;

    public Manager(String name, String address, String phone, String socialSN, double payRate, double bonus) {
        super(name, address, phone, socialSN, payRate);
        this.bonus = bonus;
    }
public void awardBonus(double bonus)
{
    this.bonus+=bonus;
}
    @Override
    public double pay() {
        return super.pay();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

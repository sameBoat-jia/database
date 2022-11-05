package javatest.two;

public class Manager extends Employee{
    //bonus代表红利
    //awardbonus增加红利
    double bonus;
    public void awardBonus(double bonus)
    {
        this.bonus+=bonus;
    }

//    public Manager(String name, String address, String phone, String sociaISN, double payRate, double bonus) {
//        super(name, address, phone, sociaISN, payRate);
//        this.bonus = bonus;
//    }

    public Manager(String name, String address, String phone, String sociaISN, double payRate, double bonus) {
        super(name, address, phone, sociaISN, payRate);
        this.bonus = bonus;
    }

    @Override
    public double pay() {
        return payRate+bonus;
    }
}

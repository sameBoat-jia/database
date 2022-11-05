package test2;

public class Manager extends Employee{
    double bonus;

    @Override
    public double pay() {
        return bonus+payRate;
    }

    public void awardBonus(double bonus){
        this.bonus=bonus;
    }

    public Manager(String socialSN, double payRate, double bonus) {
        super(socialSN, payRate);
        this.bonus = bonus;
    }

    public Manager(String name, String address, String phone, String socialSN, double payRate, double bonus) {
        super(name, address, phone, socialSN, payRate);
        this.bonus = bonus;
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

//    public Manager(double bonus) {
//        this.bonus = bonus;
//    }
}

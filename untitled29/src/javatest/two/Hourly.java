package javatest.two;

public class Hourly extends Employee{
//    public double bonus;
        public int hourWorked;

    public Hourly(String name, String address, String phone, String sociaISN, double payRate, int hourWorked) {
        super(name, address, phone, sociaISN, payRate);
        this.hourWorked = hourWorked;
    }
 public void addHours(int hours)
 {
      this.hourWorked+=hours;
 }
    @Override
    public double pay() {
        return payRate*hourWorked;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "hourWorked=" + hourWorked +
                ", sociaISN='" + sociaISN + '\'' +
                ", payRate=" + payRate +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

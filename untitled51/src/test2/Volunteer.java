package test2;

public class Volunteer extends StaffMember{
    @Override
    public String toString() {
        return "Volunteer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public double pay() {
        return 0;
    }

    public Volunteer() {
    }

    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }
}

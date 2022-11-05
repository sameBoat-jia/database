package test2;

public class Volunteer extends StaffMember{
    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

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
}

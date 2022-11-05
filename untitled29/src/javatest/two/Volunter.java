package javatest.two;

public class Volunter extends StaffMember{
    public Volunter(String name, String address, String phone) {
        super(name, address, phone);
    }

    @Override
    public double pay() {
        return 0;
    }

    @Override
    public String toString() {
        return "Volunter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

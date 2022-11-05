package javatest.two;

public abstract class StaffMember {
    public String name;
    public String address;
    public String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public abstract double pay();

    @Override
    public String toString() {
        return "StaffMember{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

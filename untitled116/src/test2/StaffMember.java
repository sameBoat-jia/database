package test2;

public abstract class StaffMember {
    String name;
    String address;
    String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public abstract double pay();
}

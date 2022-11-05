package test2;

public class Staff {
    public static StaffMember[]staffMembers;
    public Staff(){
        staffMembers=new StaffMember[6];
        Manager No1=new Manager("Sam","123 Main Line","555-0469","123-45-6789",2423.07,500);
        Employee No2=new Employee("Peter","456 Off Line","555-0101","987-65-4321",1246.15);
        Employee No3 = new Employee("Mary","789 Off Rocker","555-0690","010-20-3040",1169.23);
        Hourly No4=new Hourly("Cliff","678 Fifth Ave.","555-0000","958-47-3625",10.55,40);
        Volunteer No5=new Volunteer("Al","987 Suds Ave.","555-8374");
        Volunteer No6=new Volunteer("Gus","321 Off Line","555-7282");
        staffMembers[0]=No1;
        staffMembers[1]=No2;
        staffMembers[2]=No3;
        staffMembers[3]=No4;
        staffMembers[4]=No5;
        staffMembers[5]=No6;
    }
    public static void payDetail(){
        for (StaffMember staffmenber :
                staffMembers) {
            System.out.println(staffmenber.toString());
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        new Staff();
        payDetail();
    }
}

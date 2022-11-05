package test2;

public class Staff {
    public static StaffMember[] staffList;

    public Staff() {
        staffList = new StaffMember[6];
        Manager No1=new Manager("Sam","123 Main Line","555-0469","123-45-6789",2423.07,500);
        Employee No2=new Employee("Peter","456 Off Line","555-0101","987-65-4321",1246.15);
        Employee No3 = new Employee("Mary","789 Off Rocker","555-0690","010-20-3040",1169.23);
        Hourly No4=new Hourly("Cliff","678 Fifth Ave.","555-0000","958-47-3625",10.55,40);
        Volunteer No5=new Volunteer("Al","987 Suds Ave.","555-8374");
        Volunteer No6=new Volunteer("Gus","321 Off Line","555-7282");
        staffList[0]=No1;
        staffList[1]=No2;
        staffList[2]=No3;
        staffList[3]=No4;
        staffList[4]=No5;
        staffList[5]=No6;
    }

    public static void payDetail() {
        for (StaffMember st:staffList
        ) {
            System.out.print(st.toString());
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Staff staff = new Staff();
        payDetail();
    }
}


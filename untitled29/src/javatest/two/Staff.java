package javatest.two;

import javax.jws.soap.SOAPBinding;

public class Staff {
    public static void payDetail(StaffMember obj)
    {
        System.out.println(obj.toString());
    }
    public static void main(String[] args) {
        StaffMember[] staffList = new StaffMember[6];
        //注意double类型不加引号
        staffList[0]=new Manager("sam","123 Main Line","555-0469","123-45-6789",2423.07,500);
        staffList[1] = new Employee("Peter","456 Off Line","555-0101","987-65-4321",1246.15);
        staffList[2] = new Employee("Mary","789 Off Rocker","555-0690","010-20-3040",1169.23);
        staffList[3] = new Hourly("Cliff","678 Fifth Ave","555-0000","958-47-3625",10.55,40);
        staffList[4] = new Volunter("Al","987 Suds Ave","555-8374");
        staffList[5] = new Volunter("Gus","321 Off Line","555-7282");
        for (int i = 0; i < staffList.length; i++) {
            payDetail(staffList[i]);
        }
    }
}

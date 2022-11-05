package databast;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {
        Service service=new Service();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---欢迎使用学生管理系统---");
        System.out.println("1-添加学生");
        System.out.println("2-删除学生");
        System.out.println("3-展示全部学生信息");
        System.out.println("4-查询学生");
        System.out.println("5-修改学生信息");
        System.out.println("6-退出系统");
        String cmd=scanner.nextLine();
        switch (cmd)
        {
            case "1":service.addStudent();break;
            case "2":service.delStudent();break;
            case "3":service.showAll();break;
            case "4":service.quary();break;
            case "5":service.modify();break;
            case "6":
                System.out.println("谢谢使用");
                System.exit(0);
        }
    }
}

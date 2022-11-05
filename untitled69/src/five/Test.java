package five;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Operation operation = new Operation();
//        System.out.println("修改前");
//        operation.getStudent(20212399);
//        operation.updateCourse(20212399,"stu");
//        System.out.println("将Sname的值修改为stu：");
//        operation.getStudent(20212399);
//        operation.getStudent(1234);
//        operation.deletStudent(1);
//        System.out.println("删除成功");
//        operation.getStudent(1);
        Student student=new Student();
        Scanner scanner = new Scanner(System.in);
        int Sno=scanner.nextInt();
        scanner.nextLine();
        String Sname=scanner.nextLine();
        String Ssex=scanner.nextLine();
        String Sbirth=scanner.nextLine();
        String Sclass=scanner.nextLine();
        String Sphone =scanner.nextLine();
        String Smail=scanner.nextLine();
        student.setSsex(Ssex);
        student.setSno(Sno);
        student.setSname(Sname);
        student.setSphone(Sphone);
        student.setSmail(Smail);
        student.setSclass(Sclass);
        student.setSbirth(Sbirth);
        operation.insertStudent(student);
//        System.out.println("ok");
//        operation.getStudent(2020);
//        int Sno=scanner.nextInt();
//        scanner.nextLine();
//        String Sname=scanner.nextLine();
//        operation.updateCourse(1,"stu");
//        System.out.println("ok");
    }
}

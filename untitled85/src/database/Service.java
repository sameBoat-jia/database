package database;

import java.sql.SQLException;
import java.util.Scanner;

public class Service implements dao{
    @Override
    public void addStudent() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生的id");
        int id=scanner.nextInt();
        System.out.println("请输入学生的姓名：");
        String name=scanner.next();
    }

    @Override
    public void delStudent() throws ClassNotFoundException, SQLException {

    }

    @Override
    public void showAll() throws ClassNotFoundException, SQLException {

    }

    @Override
    public void quary() throws ClassNotFoundException, SQLException {

    }

    @Override
    public void modify() throws ClassNotFoundException, SQLException {

    }
}

package dataBase_test;

import java.sql.*;
import java.util.Scanner;

public class Service implements dao {
    getter_setter getter_sette = new getter_setter();

    @Override
    public void addStudent() throws ClassNotFoundException, SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生id:");
            int id = scanner.nextInt();
            System.out.println("请输入学生姓名:");
            String name = scanner.next();
            String sql = "INSERT INTO aaa values(" + id + ",'" + name + "')";
            Connection connection = JdbcMysql.getConnec();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delStudent() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除学生的id");
        int delId = scanner.nextInt();
        try {
            Connection connection = JdbcMysql.getConnec();
            Statement statement = connection.createStatement();
            String sql = "delete from aaa where id=" + delId;
            statement.executeUpdate(sql);
            System.out.println("已删除");
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showAll() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = JdbcMysql.getConnec();
            Statement statement = connection.createStatement();
            String sql = "select *from aaa;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID:" + id);
                System.out.println("名字:" + name);
                System.out.println("==========================");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void quary() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = JdbcMysql.getConnec();
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要查询的ID");
            int qid = scanner.nextInt();
            String sql = "select *from aaa where id=" + qid + "";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID:" + id);
                System.out.println("名字：" + name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void modify() throws ClassNotFoundException, SQLException {
        try {
            Connection connection = JdbcMysql.getConnec();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入修改前的学生的id");
            int id1 = scanner.nextInt();
            System.out.println("请输入修改后的学生的id");
            int id2 = scanner.nextInt();
            System.out.println("请输入修改后的学生的姓名");
            String name2 = scanner.next();
            Statement statement = connection.createStatement();
            String sql = "UPDATE aaa SET id = " + id2 + ",name = '" + name2 + "' WHERE id = " + id1 + ";";
            statement.executeUpdate(sql);
            System.out.println("修改成功");
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

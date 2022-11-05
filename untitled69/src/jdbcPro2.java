import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.Scanner;
 
public class jdbcPro2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.println("---欢迎使用学生管理系统---");
            System.out.println("1-添加学生");
            System.out.println("2-删除学生");
            System.out.println("3-展示全部学生信息");
            System.out.println("4-查询学生");
            System.out.println("5-修改学生信息");
            System.out.println("6-退出系统");
            System.out.println("请输入指令:");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    delStudent();
                    break;
                case "3":
                    showAll();
                    break;
                case "4":
                    quary();
                    break;
                case "5":
                    modify();
                    break;
                case "6":
                    System.out.println("谢谢使用");
                    System.exit(0);
                    Connection connection = null;
                    Statement statement = null;
                    ResultSet set = null;
                    try {
                        //1.加载数据库驱动
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        //2.通过DriverManager获取数据库连接
                        //"jdbc:mysql://localhost:3306/aaa?user=root&password=card1366"
                        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
                        String dbName = "root"; //数据库账号
                        String dbPass = "card1366"; //数据库密码
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aaa?user=root&password=card1366");
                        //3.通过Connection对象获取Statement对象
                        statement = connection.createStatement();
                    } catch (ClassNotFoundException e) {
                        System.out.println("错误提示:数据库驱动加载失败");
                        e.printStackTrace();
                    } catch (SQLException e) {
                        System.out.println("错误提示:数据库操作失败");
                        e.printStackTrace();
                    } finally {
                        if (set != null) {
                            try {
                                set.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        if (statement != null) {
                            try {
                                statement.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            }
        }
    }
 
    public static void addStudent() throws ClassNotFoundException, SQLException {
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
        //数据库的用户名和密码
        String user = "root";
        String password = "card1366";
        //注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生id:");
        int id = scanner.nextInt();
        System.out.println("请输入学生姓名:");
        String name = scanner.next();
 
        //打开链接--连接mysql
        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();
 
        String sql = "INSERT INTO aaa values("+id+",'"+name+"')";
        //执行sql语句
        statement.executeUpdate(sql);
 
        System.out.println("添加成功");
        connection.close();
 
    }
    public static void delStudent() throws ClassNotFoundException, SQLException {
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
        //数据库的用户名和密码
        String user = "root";
        String password = "card1366";
        //注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("连接数据库中……");
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除学生的id");
        int delId = scanner.nextInt();
 
        //打开链接
        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();
 
        String sql = "delete from aaa where id = " +delId+"";
 
        statement.executeUpdate(sql);
 
        System.out.println("删除成功");
        connection.close();
 
    }
    public static void showAll() throws ClassNotFoundException, SQLException{
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
        //数据库的用户名和密码
        String user = "root";
        String password = "card1366";
        //注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //打开链接
        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();
        //定义sql语句
        String sql = "SELECT * FROM aaa;";
 
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("ID:" + id);
            System.out.println("名字:" + name);
            System.out.println("==============");
        }
    }
    public static void quary() throws ClassNotFoundException, SQLException{
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
        //数据库的用户名和密码
        String user = "root";
        String password = "card1366";
        //注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //打开链接
        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的ID");
        int qid = scanner.nextInt();
        //定义sql语句
        String sql = "SELECT * FROM aaa.aaa where id =" + qid +"";
 
        //statement.executeUpdate(sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("ID:" + id);
            System.out.println("名字:" + name);
        }
    }
    public static void modify() throws ClassNotFoundException, SQLException{
        //数据库地址
        String dburl = "jdbc:mysql://localhost:3306/aaa?useSSL=false&characterEncoding=utf-8";
        //数据库的用户名和密码
        String user = "root";
        String password = "card1366";
        //注册jdbc驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("连接数据库中……");
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入修改前的学生id:");
        int id1 = scanner.nextInt();
 
        System.out.println("请输入修改后的学生id:");
        int id2 = scanner.nextInt();
        System.out.println("请输入修改后学生姓名:");
        String name2 = scanner.next();
 
        //打开链接--连接mysql
        Connection connection = DriverManager.getConnection(dburl, user, password);
        Statement statement = connection.createStatement();
 
        String sql = "UPDATE aaa SET id = "+id2+",name = '"+name2+"' WHERE id = "+id1+";";
        //执行sql语句
        statement.executeUpdate(sql);
 
        System.out.println("修改成功");
        connection.close();
    }
}
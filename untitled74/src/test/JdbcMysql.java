package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysql {
    static String userName="root";
    static String passWord="card2366";
    static String url="jdbc:mysql://127.0.0.1:3306/java_test";
    static String driver="com.mysql.cj.jdbc.Driver";
    public static Connection getConnection()throws Exception{
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,userName,passWord);

        }catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}

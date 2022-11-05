package five;

import jdk.nashorn.internal.runtime.ECMAException;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysql {
    static String userName = "root";
    static String passWord = "card1366";
    static String url = "jdbc:mysql://127.0.0.1:3306/java_test";
    static String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection getConnec() throws Exception {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}

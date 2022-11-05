package databast;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysql {
    public static Connection getConnec() throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aaa?user=root&password=card1366");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}

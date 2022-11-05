import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysql {
    public static Connection getConnec()throws Exception
    {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_test","root","card1366");

        }catch (Exception e)
        {
            e.printStackTrace();
            throw e;//throw e 是抛出异常，会中断程序，后面的代码都不执行了
        }return connection;
    }
}

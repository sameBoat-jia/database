package four;

import java.sql.*;

public class SendTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;
    public void insert()throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
        connection=(Connection) DriverManager.getConnection(url);
        sql="insert into sample(sample_time,sample_data)values(?,?);";
    }
}

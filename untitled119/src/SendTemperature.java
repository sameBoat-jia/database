import java.sql.*;
import java.util.Random;

public class SendTemperature extends Thread{

    /*
   String url="jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
     */
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    boolean resultInsert;
    public void insert()throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        connection= DriverManager.getConnection(url);
        sql="insert into sample(sample_time,sample_data)values(?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1,new Timestamp(new java.util.Date().getTime()));
        preparedStatement.setDouble(2, 15+10*Math.random());
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                this.insert();
                sleep(10000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

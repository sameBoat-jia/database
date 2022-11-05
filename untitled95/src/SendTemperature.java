import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class SendTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;
    public void insert()throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
        Timestamp t=new Timestamp(new Date().getTime());
        BigDecimal b=BigDecimal.valueOf(15+10*Math.random());
        connection=(Connection) DriverManager.getConnection(url);
        sql="";
        preparedStatement=connection.prepareStatement("insert into sample(sample_time,sample_data)values('"+t+"' ,'"+b+"');");
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while (true)
        {
            try{
                insert();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

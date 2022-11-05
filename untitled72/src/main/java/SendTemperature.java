import java.sql.*;
import java.util.Date;
public class SendTemperature extends Thread{
    private String url="";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet resultSet;
    Boolean resultInsert;
    public void insert()throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
        connection=(Connection) DriverManager.getConnection(url);
        sql="insert ";
        preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
        //setTimestample日期和时间都获取
        preparedStatement.setTimestamp(1,new Timestamp(new Date().getTime()));
        preparedStatement.setDouble(1,Double.valueOf(15+10*Math.random()));
        System.out.println(preparedStatement.toString());
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }
    public void run(){
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

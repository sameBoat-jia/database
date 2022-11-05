import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class ShowTemperature extends Thread{
    private String url;
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet resultSet;
    ArrayList<Double>temperatures=new ArrayList<>();
    public ArrayList<Double> getTemperatures(int time)throws SQLException{
        temperatures.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        connection=(Connection) DriverManager.getConnection(url);
        sql="";
        preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
        resultSet =preparedStatement.executeQuery();
        Boolean bool=resultSet.next();

    }
}

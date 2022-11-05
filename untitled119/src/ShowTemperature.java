import java.sql.*;
import java.util.ArrayList;

public class ShowTemperature extends Thread{

    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet res;
    ArrayList<Double>temperatures=new ArrayList<>();
    public ArrayList<Double>getTemperaturesByTime(int time)throws SQLException {
        temperatures.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        connection = DriverManager.getConnection(url);
        sql = "select * from sample order by sample_time desc limit " + time;
        preparedStatement = connection.prepareStatement(sql);
        res = preparedStatement.executeQuery();
        Boolean bool = res.next();
        if (!bool) {
            return null;
        }
        while (bool) {
            temperatures.add(res.getDouble(2));
            bool = res.next();
        }
        preparedStatement.close();
        connection.close();
        if (temperatures.size() == time)
            return temperatures;
        else {
            System.out.println("数据量不足");
            return null;
        }

    }
    public double getAverageTemperatureBy60()
        throws SQLException{
        double result=0;
        ArrayList<Double>results=getTemperaturesByTime(6);
        if (results==null)
        {
            System.out.println("数据库记录不足六条");
            return  -2;
        }
    }
}

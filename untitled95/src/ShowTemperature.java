import java.sql.*;
import java.util.ArrayList;



public class ShowTemperature extends Thread{
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    ArrayList<Double>temperature=new ArrayList<>();
    public ArrayList<Double>getTemperatureByTime(int time)throws SQLException
    {
        temperature.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_exp?user=root&password=card1366");
        preparedStatement=connection.prepareStatement("select *from sample order by sample_time desc limit "+time+";");
//preparedStatement=connection.prepareStatement("select * from sample order by sample_time desc limit " + time);

        res=preparedStatement.executeQuery();
        Boolean bool=res.next();
        if (!bool)
        {
            return null;
        }
        while (bool)
        {
            //获取数据表第二列数据值
            temperature.add(Double.valueOf(res.getString(2)));
            bool=res.next();
        }
        preparedStatement.close();
        connection.close();
        if (temperature.size()==time)
        {
            return temperature;
        }
        else {
            System.out.println("数据量不足");
            return null;
        }

    }
    public double getAverageTemperatureBy60() throws SQLException {
        double result = 0;
        ArrayList<Double> results = getTemperatureByTime(6);
        if (results == null) {
            System.out.println("数据库记录不足六条,无法提取平均温度");
            return -2;
        }
        for (double data : results) {
            result += data;
        }
        result = result / (double) results.size();
        System.out.println("一分钟的平均温度" + result);
        return result;
    }


    public void run() {
        int k = 0;
        while (true) {
            try {
                System.out.println("实时温度是" + this.getTemperatureByTime(1).get(0).doubleValue());
                k++;
                sleep(10000);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            if (k % 6 == 0) {
                k = 0;
                try {
                    this.getAverageTemperatureBy60();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}

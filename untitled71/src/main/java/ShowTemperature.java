import java.sql.*;
import java.util.ArrayList;

public class ShowTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet resultSet;
    ArrayList<Double>temperatures=new ArrayList<>();
    public ArrayList<Double> getTemperaturesByTime(int time)throws SQLException
    {
        temperatures.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        connection=(Connection) DriverManager.getConnection(url);
        sql="select *from sample order by sample_time desc limit "+time;
        preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();    //查询并返回sql对象
        Boolean bool= resultSet.next();
        //有记录返回true并把记录内容存入到对应的对象中 如果没有返回false。
                if (!bool){
                    return null;
                }
        while (bool){
            temperatures.add(Double.parseDouble(resultSet.getString(2)));
            bool=resultSet.next();
        }
        preparedStatement.close();;
        connection.close();
        if (temperatures.size() == time) {

            return temperatures;
        }
        else {
            System.out.println("数据量不足");
            return null;
        }
    }
    public double getAverageTemperatureBy60()throws SQLException{
        double result=0;
        ArrayList<Double>results=getTemperaturesByTime(6);
        if(results==null){
            System.out.println("数据库记录不足六条，无法提取平均温度");
            return -2;
        }
        for (double data :
                results) {
            result+=data;
        }
        result=result/(double) results.size();
        System.out.println("平均温度是："+result);
        return result;
    }

    @Override
    public void run() {
        int k=0;
        while (true){
            try {
                System.out.println("实时温度是："+this.getTemperaturesByTime(1).get(0).doubleValue());
                k++;
                sleep(10000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            if (k%6==0){
                k=0;
                try {
                    this.getAverageTemperatureBy60();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

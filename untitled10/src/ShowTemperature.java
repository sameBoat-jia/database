import java.sql.*;
import java.util.ArrayList;

public class ShowTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/springboot_test1?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    ArrayList<Double> temperature=new ArrayList<>();
    public ArrayList<Double> getTemperatureByTime(int time) throws SQLException {
        //clear方法：删除动态数组中的所有元素
        temperature.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        //System.out.println("showTemperature........");
        connection= (Connection) DriverManager.getConnection(url);
        sql="select * from sample order by sample_time desc limit "+time;
        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
        res=preparedStatement.executeQuery();
        Boolean bool=res.next();
        if(!bool){
            return null;
        }
        while(bool){
            //用Double.parseDouble()是把括号里面内容变成double类型的。
            //其中括号中的参数必须是String类型，否则转换会报错
            temperature.add(Double.parseDouble(res.getString(2)));
            bool=res.next();
        }
        preparedStatement.close();
        connection.close();
        if(temperature.size()==time) {
            return temperature;
        }
        else {
            System.out.println("数据量不足！");
            return null;
        }
    }
    public double getAverageTemperatureBy60() throws SQLException {
        double result=0;
        ArrayList<Double> results=getTemperatureByTime(6);
        if(results==null){
            System.out.println("数据库记录不足六条,无法提取平均温度");
            return -2;
        }
        for (double data:results){
            result+=data;
        }
        result=result/(double) results.size();
        System.out.println("一分钟的平均温度"+result);
        return result;
    }

    @Override
    public void run() {
        int k=0;
        while (true){
            try {
                System.out.println("实时温度是"+this.getTemperatureByTime(1).get(0).doubleValue());
                k++;
                sleep(10000);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            if(k%6==0){
                k=0;
                try {
                    this.getAverageTemperatureBy60();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }


        }



    }
}

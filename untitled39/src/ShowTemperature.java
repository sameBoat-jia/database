//import java.sql.*;
//import java.util.ArrayList;
//
//public class ShowTemperature extends Thread{
//    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
//    private String sql;
//    private PreparedStatement preparedStatement;
//    private Connection connection;
//    ResultSet res;
//    ArrayList<Double>temperature=new ArrayList<>();
//    public ArrayList<Double>getTemperatureByTime(int time)throws SQLException{
//        temperature.clear();
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch (ClassNotFoundException e){
//            e.printStackTrace();
//            return null;
//        }
//        connection=(Connection) DriverManager.getConnection(url);
//        //limit检索前limit行
//        sql="select*from sample order by sample_time desc limit"+time;
//        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
//
////        executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
//        res=preparedStatement.executeQuery();
//        Boolean bool=res.next();
//        if (!bool){
//            return null;
//        }
//        while(bool){
//            temperature.add(Double.parseDouble(res.getString(2)));
//                    bool=res.next();
//        }
//        preparedStatement.close();
//        connection.close();
//        if (temperature.size()==time){
//            return temperature;
//        }
//        else{
//            System.out.println("数据量不足");
//            return null;
//        }
//    }
//    public double getAverageTemperatureBy60() throws SQLException {
//        double result=0;
//        ArrayList<Double> results=getTemperatureByTime(6);
//        if(results==null){
//            System.out.println("数据库记录不足六条,无法提取平均温度");
//            return -2;
//        }
//        for (double data:results){
//            result+=data;
//        }
//        result=result/(double) results.size();
//        System.out.println("一分钟的平均温度"+result);
//        return result;
//    }
//}
import java.sql.*;
import java.util.ArrayList;

/**
 *每10秒钟在console上显示一次实时温度，每1分钟在console上显示最近1分钟的平均温度
 */
public class ShowTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    ArrayList<Double> temperature=new ArrayList<>();
    public ArrayList<Double> getTemperatureByTime(int time) throws SQLException {
        temperature.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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

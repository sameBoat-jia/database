import java.sql.*;

public class SendTemperature extends Thread {
    private String url = "jdbc:mysql://localhost:3306/springboot_test1?user=liuqinghua&password=zxcvbnm&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    //connection 打开与数据源连接
    private Connection connection;
    //resultset 存放从数据库里取出的结果集的对象
    ResultSet res;
    boolean resultInsert;
    public  void insert()throws SQLException{
        try{
            // Class.forName要求JVM查找并加载指定的类
            Class.forName(("com.mysql.jdbc.Driver"));
        }catch (ClassNotFoundException e){
            //e.printStackTrace();在命令行打印异常信息在程序中出错的位置及原因。
            e.printStackTrace();
            return;
        }
        //System.out.println("sendTeperture.......");
        connection=(Connection) DriverManager.getConnection(url);
        sql="insert into sample(sample_time,sample_data)values(?,?);";
        preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1,new Timestamp(new Date().getTime()));

    }
}

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

/**
 * 模拟温度传感器，每10秒钟向数据库发送一个温度值，要求温度值在20±5℃范围内随机变化
 */
public class SendTemperature extends Thread {
    private String url = "jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;

    public void insert() throws SQLException {
        try {
            //2.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        //3.获取数据库连接对象
        connection = (Connection) DriverManager.getConnection(url);
//       4定义sql语句
        sql = "insert into sample(sample_time,sample_data)values(?,?);";

        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        //setTimestamp包括日期+时间
        preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
        preparedStatement.setBigDecimal(2, BigDecimal.valueOf(15 + 10 * Math.random()));
        System.out.println(preparedStatement.toString());
        //只要执行select就返回true
        resultInsert = preparedStatement.execute();
        //8.释放资源
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.insert();

                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class SendTemperature extends Thread{
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet resultSet;
    boolean resultInsert;
    public void insert()throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
        preparedStatement=connection.prepareStatement("insert into sample(sample_time,sample_data)values (?,?)      ");
        preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
        preparedStatement.setBigDecimal(2, BigDecimal.valueOf(15+10*Math.random()));
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                this.insert();
                sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
        }
        }
    }
}

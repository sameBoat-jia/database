import java.sql.*;
import java.util.ArrayList;

public class ShowTemperature extends Thread {
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet resultSet;
    ArrayList<Double> temperature = new ArrayList<>();

    public ArrayList<Double> getTemperatureByTime(int time) throws SQLException {
        temperature.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8")    ;

    }
}

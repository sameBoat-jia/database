import java.sql.Connection;
import java.sql.PreparedStatement;

public class ShowTemperature extends Thread{
    private String url="jdbc:mysql://localhost:3306/springboot_test1?user=liuqinghua&password=zxcvbnm&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    boolean resultInsert;
}

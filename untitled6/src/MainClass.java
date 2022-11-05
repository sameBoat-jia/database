import java.util.Timer;

public class MainClass {
    public static String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    public static String URL = "jdbc:mariadb://localhost:3306:/test";
    public static String USER = "root";
    public static String PASS = "123456";

    public static void main(String[] args) {
        Timer myTimer = new Timer();
        myTimer.schedule(new MyTimerTask(JDBC_DRIVER, URL, USER, PASS), 0, 10000);
        myTimer.schedule(new MyTimerTask1(),0,60000);
    }
}

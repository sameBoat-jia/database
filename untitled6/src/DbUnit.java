import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DbUnit {
    public static double[] score = new double[6];
    public static int size = 0;

    public void add(String jdbc_driver, String url, String user, String pass) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        //插入语句
        double tem = new Random().nextDouble() * 10 + 15;
        tem = new BigDecimal(tem).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        String sql = "INSERT INTO Temperature VALUES(default," + tem + ")";
        if (size < 6) {
            score[size] = tem;
            size++;
        } else {
            for (int i = 0; i < score.length - 1; i++) {
                score[i] = score[i + 1];
            }
            score[score.length - 1] = tem;
        }
        try {
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "\n 传递成功" : "\n 传递失败");
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println("时间: " + date + ", 温度 :" + tem + " 摄氏度 " );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(conn, stmt);
        }
    }

    public void query() {
        double sum = 0;
        if (size < 6) {
            return;
        } else {
            for (int i = 0; i < score.length ; i++) {
                sum += score[i];
                System.out.println(score[i]);
            }
            double avg = new BigDecimal(sum/6).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println("时间: " + date);
            System.out.println("最近一分钟温度的平均值为 " + avg);
        }
    }


    public void release(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return;
        }
    }
}

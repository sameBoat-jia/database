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
        //对小数格式化输出
        //BigDecimal创建一个具有参数所指定整数值的对象
        tem = new BigDecimal(tem).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        //sql语句
        String sql = "INSERT INTO Temperature Values(default," + tem + ")";
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
            //forName () 是取得 Class 对象引用的一种方法
            Class.forName(jdbc_driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            //st.executeUpdate返回更新影响的行数 SQL查询更新了多少行
            //如果为0, 表示不返回任何内容的 SQL 语句
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "\n传递成功" : "\n传递失败");
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println("时间:" + date + ",温度：" + tem + "摄氏度");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void query() {
        double sum = 0;
        if (size <6) {
            return;
        } else {
            for (int i = 0; i < score.length; i++) {
                sum += score[i];
                System.out.println(score[i]);
            }
            double avg=new BigDecimal(sum/6 ).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println("时间: " + date);
            System.out.println("最近一分钟温度的平均值为 " + avg);
        }
    }
}


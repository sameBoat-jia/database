//import javax.annotation.Resource;
//import java.math.BigDecimal;
//import java.sql.*;
//import java.util.Date;
//
//public class SendTemperature extends Thread{
//    private PreparedStatement preparedStatement;
//    private Connection connection;
//    ResultSet resultSet;
//    boolean resultInsert;
//    public void insert()throws SQLException
//    {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        BigDecimal bigDecimal=BigDecimal.valueOf(15+10*Math.random());
//        connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_exp?user=root&password=card1366");
//        preparedStatement=connection.prepareStatement("insert into sample(sample_time,sample_data)values ('"+timestamp+"' ,'"+bigDecimal+"')");
//        resultInsert=preparedStatement.execute();
//        preparedStatement.close();
//        connection.close();
//    }
//
//    @Override
//    public void run() {
//        while (true)
//        {
//            try {
//                insert();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;

public class SendTemperature extends Thread {
    private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8";
    private String sql;
    private PreparedStatement preparedStatement;
    private Connection connection;
    ResultSet res;
    boolean resultInsert;
    public void insert() throws ClassNotFoundException,SQLException {
//        try {
////            Timestamp id=new Timestamp(new Date().getTime());
////            BigDecimal num=BigDecimal.valueOf(15+10*Math.random());
//            int sample_time=1;
//            int sample_data=2;
//            Connection connection=JdbcMysql.getConnec();
//            Statement statement=connection.createStatement();
////            String sql="insert into sample values ('"+sample_time+"','"+sample_data+"')";
//            String sql="insert into sample values(1,2);";
//            statement.executeUpdate(sql);
//            connection.close();e
//        }catch (Exception e)
//        {
//            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//
//            throw new RuntimeException(e);
//        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return ;
        }
        //System.out.println("sendTeperture.......");
        Timestamp t=new Timestamp(new Date().getTime());
        BigDecimal b=BigDecimal.valueOf(15+10*Math.random());
        connection= (Connection) DriverManager.getConnection(url);
        sql="insert into sample(sample_time,sample_data)values('"+t+"' ,'"+b+"');";

        preparedStatement= (PreparedStatement) connection.prepareStatement(sql);
//        preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
//        preparedStatement.setBigDecimal(2, BigDecimal.valueOf(15+10*Math.random()));
        System.out.println(preparedStatement.toString());
        resultInsert=preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void run() {
        while(true){
            try {
                this.insert();
                sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

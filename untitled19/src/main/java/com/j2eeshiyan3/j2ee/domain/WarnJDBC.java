package com.j2eeshiyan3.j2ee.domain;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class WarnJDBC{
    int count = 0;
    Connection conn = null;

    public WarnJDBC(Connection connection) {
        this.count = 0;
        this.conn = connection;
    }
    public void alert(){
        try {
            // 注册 JDBC 驱动
            Connection conn = null;
            Statement stmt = null;
            final ResultSet[] rs = {null};
            Date date = new Date();
            final float[] template = {0};
            final Date[] times = {new Date()};

            Class.forName("org.mariadb.jdbc.Driver");
            // 打开链接
            conn = this.conn;
            // 执行查询
            stmt = conn.createStatement();
            Timer executeSchedule = new Timer();
            Statement finalStmt = stmt;
            executeSchedule.schedule(new TimerTask() {
                @Override
                public void run() {
                    float tp = (float) (Math.random() * 10 + 15);
                    BigDecimal tp1 = new BigDecimal(tp);
                    double tp2 = tp1.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    try {
                        long time = date.getTime();
                        rs[0] = finalStmt.executeQuery("select sample_time,sample_data from sample where date_sub(now(),interval 1 minute) < sample_time");
                        while (rs[0].next()) {
                            // 通过字段检索
                            times[0] = rs[0].getTime("sample_time");
                            template[0] = rs[0].getFloat("sample_data");
                            if (template[0] < 18 || template[0] > 22) {
                                count += 1;
                                //System.out.print("超过了 [18℃, 22℃]: " + templates);
                            }
                        }
                        if (count == 10) {
                            System.out.print(times[0] +"templates_avg超过了 [18℃, 22℃]长达1分钟");
                            System.out.print("\n");
                        }
                        count = 0;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }, 0, 6 * 1000);
            //jdbc当中的修改
//            stmt.executeUpdate("insert into sample(sample_time,sample_data) values(now()," + num + ")");
//            stmt.close();
//            conn.close();
        } catch (SQLException | ClassNotFoundException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        }
    }
}
